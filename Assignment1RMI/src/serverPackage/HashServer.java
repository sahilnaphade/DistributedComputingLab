package serverPackage;

import java.rmi.*;
import serverPackage.*;

public class HashServer {
	public static void main(String[] args) {
		try {
			Hasher stub = new HasherRemote();
			Naming.rebind("rmi://127.0.0.1:5000/hash", stub);
		}
		catch(Exception E) {
			System.out.println(E);
		}
	}
}
