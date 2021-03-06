package serverPackage;

import java.rmi.*;
import java.rmi.registry.*;
import serverPackage.*;

public class HashServer {
	public static void main(String[] args) {
		try {
			Hasher stub = new HasherRemote();
			LocateRegistry.createRegistry(5000);
			Naming.rebind("rmi://127.0.0.1:5000/hash", stub);
		}
		catch(Exception E) {
			System.out.println(E);
		}
	}
}
