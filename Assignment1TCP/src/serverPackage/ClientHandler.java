package serverPackage;

import java.net.*;
import java.io.*;
import java.util.*;
/**
 * 
 * @author Sahil Naphade 
 */
public class ClientHandler extends Thread{
	final DataInputStream dis;
	final DataOutputStream dos;
	Scanner scn = new Scanner(System.in);
	final Socket s;
	
	public ClientHandler(DataInputStream dis, DataOutputStream dos, Socket s) {
		this.dis = dis;
		this.dos = dos;
		this.s = s;
	}
	
	public void run() {
		String receivedData;
		String dataToTransmit;
		
		// Try sending greetings text		
		try {
			dos.writeUTF("Hello there! How are you?\n Enter Exit to diconnect");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// If successful and received data, start conversation.		
		while(true) {
			try {
				receivedData = dis.readUTF();
				if(receivedData.equals("Exit")) {
					System.out.println("Client "+this.s+" is exiting!");
					this.s.close();
					System.out.println("Connection closed!!");
					break;
				}
				else {
					System.out.println(receivedData);
					dataToTransmit = scn.nextLine();
					dos.writeUTF(dataToTransmit);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		// In the end, close all resources
		try {
			this.dis.close();
			this.dos.close();
			scn.close();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
}
