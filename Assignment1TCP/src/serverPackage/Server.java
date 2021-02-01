package serverPackage;

import java.io.*;
import java.util.*;
import java.net.*;
//import serverPackage.ClientHandler;


public class Server {
	public static void main(String[] args) throws IOException {
		Scanner scn1 = new Scanner(System.in);
		String receivedData, dataToTransmit;
		System.out.print("Enter the port no. on which you wish to start server: ");
		int portNo = scn1.nextInt();
		
		ServerSocket ss = new ServerSocket(portNo);
		System.out.println("Server waiting on port no. " + portNo);
		Socket s = null;
		while(true) {
			try {
				s = ss.accept();
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				receivedData = dis.readUTF();
				if(receivedData.equals("Exit")) {
					System.out.println("Client "+ s +" is exiting!");
					s.close();
					System.out.println("Connection closed!!");
					break;
				}
				else {
					System.out.println(receivedData);
					dataToTransmit = scn1.nextLine();
					dos.writeUTF(dataToTransmit);
				}
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
			ss.close();
			scn1.close();
		}
	}
}
