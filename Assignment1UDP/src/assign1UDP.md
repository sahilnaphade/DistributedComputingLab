### Assignment 1 (B): Socket programming using UDP
#### Required files: 
	1. Server file
	2. Client file
	3. File containing quotes
#### 1. Server file:
	A file which contains Server class, with a Datagram socket, ArrayList containing quotes, and a randomizer as attributes.
	Function to read quotes from file, select a random quote from the list, and a service function to handle the requests from client.
	We use DatagramPacket to create a UDP request and response.
	First, receive request from the client, write a random quote to the response and send response through socket.send() to address taken from request.getAddress().
	To run: 
	```bash
	java Server.java quotesFile.txt <port no.>
	```

#### 2. Client file:
	A file which simply requests a quote from the server.
	We create a DatagramSocket instance (called soc), and create a DatagramPacket instance called request with one byte buffer, ip address and port no. of server.
	It sends the request to that ip address and port, receives the response (again a DatagramPacket instance) and prints the quote.
	To run:
	```bash
	java Client.java <hostname (typically localhost)> <port no. (Same as Server)>
