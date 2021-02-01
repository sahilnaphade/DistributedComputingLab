package serverPackage;

import java.io.*;
import java.util.*;
import java.net.*;
//import serverPackage.ClientHandler;


public class Server {
	public static void main(String[] args) throws IOException {
		Scanner scn1 = new Scanner(System.in);
		String receivedData = "", dataToTransmit = "";
		System.out.print("Enter the port no. on which you wish to start server: ");
		int portNo = scn1.nextInt();
		ServerSocket ss = new ServerSocket(portNo);
		System.out.println("Server waiting on port no. " + portNo);
		Socket s = ss.accept();
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(!receivedData.equals("Exit")) {
			receivedData = dis.readUTF();
			System.out.println("Client: " + receivedData);
			System.out.print("Enter your response: ");
			dataToTransmit = br.readLine();
			dos.writeUTF(dataToTransmit);
			dos.flush();
		}
		dis.close();
		dos.close();
		s.close();
		ss.close();
		scn1.close();
	}
}
