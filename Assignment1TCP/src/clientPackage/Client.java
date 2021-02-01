package clientPackage;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;

class Client {
	public static void main(String[] args) throws Exception{
		Integer portNo;
		Scanner scn1 = new Scanner(System.in);
		String toSend = "", recieved = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter the port no on which you want to connect: ");
		portNo = scn1.nextInt();
		Socket s = new Socket("localhost", portNo);
		
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		
		while(!toSend.equals("Exit")) {
			System.out.print("Enter your message: ");
			toSend = br.readLine();
			dos.writeUTF(toSend);
			dos.flush();
			recieved = dis.readUTF();
			System.out.println("Server: " + recieved);
		}
		dos.close();
		dis.close();
		s.close();
		scn1.close();
	}
}
