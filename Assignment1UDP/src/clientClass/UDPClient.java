package clientClass;

import java.io.*;
import java.net.*;

public class UDPClient {
	
	public static void main(String[] args) throws Exception {
		if(args.length < 2) {
			System.out.println("Syntax: java Client <hostname> <port>");
			return;
		}
		String hostname = args[0];
		int port = Integer.parseInt(args[1]);
		
		try {
			InetAddress ip = InetAddress.getByName(hostname);
			DatagramSocket soc = new DatagramSocket();
			while(true) {
				DatagramPacket request = new DatagramPacket(new byte[1], 1, ip, port);
				soc.send(request);
				
				byte[] buffer = new byte[512];
				DatagramPacket response = new DatagramPacket(buffer, buffer.length);
				soc.receive(response);
				
				String quote = new String(buffer, 0, response.getLength());
				System.out.println(quote);
				System.out.println();
				Thread.sleep(10000);
				soc.close();
			}
		}
		catch(SocketTimeoutException ste) {
			System.out.println("Socket Timeout: " + ste.getMessage());
		}
		catch(IOException ioe) {
			System.out.println("IO Exception: " + ioe.getMessage());
		}
		catch(InterruptedException ie) {
			System.out.println("Interrup exception: " + ie.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
