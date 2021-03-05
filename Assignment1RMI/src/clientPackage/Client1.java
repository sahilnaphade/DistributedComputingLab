package clientPackage;

import java.rmi.*;
import java.util.*;
import serverPackage.Hasher;

public class Client1 {

	public static void main(String[] args) {
		try {
			int choice;
			String data;
			Scanner s = new Scanner(System.in);
			Hasher stub = (Hasher) Naming.lookup("rmi://127.0.0.1:5000/hash");
			
			System.out.print("Enter the choice of algorithm:\n1 for SHA-256\n2 for SHA-512\n3 for MD5\nYour choice :: ");
			choice = s.nextInt();
			System.out.print("Enter the string to be hashed : ");
			data = s.nextLine();
			
			System.out.println(stub.createHash(data, choice));			
		}
		catch(Exception E) {
			E.printStackTrace();
		}

	}

}
