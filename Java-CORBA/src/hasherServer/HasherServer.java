package hasherServer;

import HasherApp.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.*;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;



class HasherImplementation extends HasherPOA {
	ORB orb;
	
	public void setORB(ORB orb_val) {
		this.orb = orb_val;
	}

	@Override
	public String hashTheString(String data) {
		MessageDigest md = null;
		System.out.println("Obtained string: "+data);
		System.out.println("Server is hashing the string!!!");
		try {
			md = MessageDigest.getInstance("SHA-512");
			
			// Create byte array of the input string
			byte[] array = md.digest(data.getBytes(StandardCharsets.UTF_8));
			
			// Convert the byte array into signum representation
			BigInteger number = new BigInteger(1, array);
			
			// Convert the signum representation to its Hex value
			StringBuilder hexString = new StringBuilder(number.toString(16));
			
			// Padding with leading zeroes
			while(hexString.length() < 32) {
				hexString.insert(0, '0');
			}
			
			String HashedString = new String(" : " + hexString.toString());
			return HashedString;

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}

public class HasherServer {

	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args, null);
			
			// get reference to rootpoa & activate the POAManager
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
				
			// create servant and register it with the ORB
			HasherImplementation hImpl = new HasherImplementation();
			hImpl.setORB(orb);
			
			// get object reference from the servant
		    org.omg.CORBA.Object ref = rootpoa.servant_to_reference(hImpl);
		    Hasher href = HasherHelper.narrow(ref);
		    
		    //get root naming context
		    org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		    
		    // Use NamingContextExt which is part of the Interoperable
		    // Naming Service (INS) specification.
		    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		    
		    String name = "Hasher";
		    NameComponent path[] = ncRef.to_name(name);
		    ncRef.rebind(path, href);
		    
		    System.out.println("Hasher server is ready and waiting ....");
		    
		    orb.run();	
		}
		catch(Exception e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
		System.out.println("HasherServer exiting ... ");
	}

}


// For more info see: https://docs.oracle.com/javase/7/docs/technotes/guides/idl/tutorial/GSserver.html
