package client;

import hasherServer.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

import HasherApp.Hasher;
import HasherApp.HasherHelper;

import java.util.Scanner;

import org.omg.CORBA.*;

public class HasherClient {
	static Hasher hasherImpl;
	public static void main(String[] args) {
		String data = null;
		Scanner s1 = new Scanner(System.in);
		System.out.print("Enter the string to be hashed: ");
		data = s1.nextLine();
		s1.close();
		try {		
			// create and initialize the ORB
			ORB orb = ORB.init(args, null);
					
			// get the root naming context
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			
			// Use NamingContextExt instead of NamingContext. This is 
	        // part of the Interoperable naming Service.  
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			
			// Resolve the Object reference in naming
			String name = "Hasher";
			hasherImpl = HasherHelper.narrow(ncRef.resolve_str(name));
			
//			System.out.println("Obtained handle on server Object: "+hasherImpl);
			String hashedString = hasherImpl.hashTheString(data);
			System.out.println("\n\nThe hash of <"+data+"> is "+hashedString);
		}
		catch (Exception e) {
			System.out.println("Error: "+ e);
			e.printStackTrace();
		}

	}

}


//For more info, see: https://docs.oracle.com/javase/7/docs/technotes/guides/idl/tutorial/GSapp.html 