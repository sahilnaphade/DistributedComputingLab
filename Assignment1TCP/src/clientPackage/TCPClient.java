package clientPackage;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;

class TCPClient {
	public static void main(String[] args) throws Exception{
		Integer portNo;	// To accept the port number to connect the client
		Scanner scn1 = new Scanner(System.in);	// To converse with the server
		String toSend = "", recieved = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // To read the lines in a buffer to send
		
		System.out.print("Enter the port no on which you want to connect: ");
		portNo = scn1.nextInt();	// Accept port no.
		Socket s = new Socket("localhost", portNo);	// Create a socket with the selected host and port
		
		DataInputStream dis = new DataInputStream(s.getInputStream());	// DataInputStream object with the concerned socket to accept the message from server
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());	// DataOutputStream object with the concerned socket to send the message to server
		// Run while the client does not send "Exit		
		while(!toSend.equals("Exit")) {
			System.out.print("Enter your message: ");	// Accept message from Client
			toSend = br.readLine();	
			dos.writeUTF(toSend); // Write the message in UTF format to send to server
			dos.flush();	// Clear the dos for further communication
			recieved = dis.readUTF();	// receive the response from the server
			System.out.println("Server: " + recieved);	// print the response
		}
		// Close all of open sockets, scanner and stream objects
		dos.close();
		dis.close();
		s.close();
		scn1.close();
	}
}
