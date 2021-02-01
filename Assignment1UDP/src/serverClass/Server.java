package serverClass;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author itsnasa
 * 1. Declare a class Server with a DatagramSocket instance, list of quotes and random.
 * 2. Server constructor which sets socket as per port and random.
 * 3. A function to create list of quotes.
 * 4. A function to return one random quote.
 * 5. A service function which will accept a request, and send a quote.
 * 5. A main function which will call the service function.
 */

public class Server {
	private DatagramSocket socket;
	private List <String> listOfQuotes = new ArrayList <String>();
	private Random random;
	
	public Server(int port) throws SocketException {
		socket = new DatagramSocket(port);
		random = new Random();
	}
	
	private String getRandomQuote() {
		int randomIndex = random.nextInt(listOfQuotes.size());
		String randomQuote = listOfQuotes.get(randomIndex);
		return randomQuote;
	}
	
	private void loadQuotesFromFile(String quoteFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(quoteFile));
		String aQuote;
		while((aQuote = br.readLine()) != null) {
			listOfQuotes.add(aQuote);
		}
		br.close();
	}
	
	private void service() throws IOException {
		while(true) {
			DatagramPacket request = new DatagramPacket(new byte[1], 1);
			socket.receive(request);
			String quote = getRandomQuote();
			byte[] buffer = quote.getBytes();
			InetAddress clientAddress = request.getAddress();
			int clientPort = request.getPort();
			DatagramPacket response = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
			socket.send(response);
		}
	}
	
	public static void main(String[] args) {	
		if(args.length < 2) {
			System.out.println("Syntax: java Server <file> <port>");
		}
		
		String quoteFile = args[0];
		int port = Integer.parseInt(args[1]);
		
		try {
			Server s1 = new Server(port);
			s1.loadQuotesFromFile(quoteFile);
			s1.service();
		}
		catch(SocketException se) {
			System.out.println("Socket Exception: " + se.getMessage());
		}
		catch(IOException io) {
			System.out.println("IO Exception: " + io.getMessage());
		}
		
	}

}
