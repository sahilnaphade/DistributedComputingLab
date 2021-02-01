package clientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.*;

class Client {
	public static void main(String[] args) {
		Integer portNo;
		Scanner scn1 = new Scanner(System.in);
		String toSend;
		try {
			System.out.println("Enter the port no on which you want to connect: ");
			portNo = scn1.nextInt();
			InetAddress ip = InetAddress.getByName("localhost");
			Socket s = new Socket(ip, portNo);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			while(true) {
				System.out.println(dis.readUTF());
				toSend = scn1.nextLine();
				dos.writeUTF(toSend);
				if(toSend.equals("Exit")) {
					System.out.println("Closing the connection: " + s);
					s.close();
					System.out.println("Connection closed");
					break;
				}
				else {
					String receivedData = dis.readUTF();
					System.out.println(receivedData);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		scn1.close();
	}
}
