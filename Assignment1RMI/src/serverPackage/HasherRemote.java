package serverPackage;

import java.rmi.RemoteException;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
import java.rmi.server.UnicastRemoteObject;

public class HasherRemote extends UnicastRemoteObject implements Hasher {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8508008262435800508L;
	
	HasherRemote() throws RemoteException {
		super();
	}
	@Override
	/**
	 * @param data String to be hashed
	 * @param choice Choice of the hash-function (1 for SHA-256, 2 for SHA-512, 3 for MD5) 
	 */
	public String createHash(String data, int choice) throws RemoteException, NoSuchAlgorithmException {
		// get the message digest and initialise it with the algorithm
		System.out.println("Server received the data : " + data);
		MessageDigest md = null;
		switch(choice) {
			case 1:
				md = MessageDigest.getInstance("SHA-256");
				break;
			case 2:
				md = MessageDigest.getInstance("SHA-512");
				break;
			case 3:
				md = MessageDigest.getInstance("MD5");
				break;
		}
		
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
		
		String HashedString = new String(data + ":" + hexString.toString());
		return HashedString;
	}

}
