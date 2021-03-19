package serverPackage;

import java.io.*;
import java.util.*;
import java.net.*;
//import serverPackage.ClientHandler;


public class TCPServer {
	public static void main(String[] args) throws IOException {
		Scanner scn1 = new Scanner(System.in);// To converse with the client
		String receivedData = "", dataToTransmit = "";
		System.out.print("Enter the port no. on which you wish to start server: ");
		int portNo = scn1.nextInt();// To accept the port number to start the server
		ServerSocket ss = new ServerSocket(portNo); // Create a server socket with the said port no
		System.out.println("Server waiting on port no. " + portNo);
		Socket s = ss.accept();
		DataInputStream dis = new DataInputStream(s.getInputStream());// DataInputStream object with the concerned socket to accept the message from client
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());// DataOutputStream object with the concerned socket to send the message to client
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(!receivedData.equals("Exit")) {
			receivedData = dis.readUTF(); // Accept message from Client
			System.out.println("Client: " + receivedData);	// print
			System.out.print("Enter your response: ");	// Write the message in UTF format to send to client
			dataToTransmit = br.readLine();
			dos.writeUTF(dataToTransmit); // Send the message
			dos.flush();
		}
//		Close the connections and streams
		dis.close();
		dos.close();
		s.close();
		ss.close();
		scn1.close();
	}
}
