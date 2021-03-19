#### Assignment 1 (B): Java Socket communication using UDP.

##### A quotes sending server application using JAVA UDP sockets.
#### Required files: 
	1. A server file
	2. A client file
	3. A text file containing quotes
	
#### 1. Server file:
	A file which contains Server class, with a Datagram socket, ArrayList containing quotes, and a randomizer as attributes.
	Function to read quotes from file, select a random quote from the list, and a service function to handle the requests from client.
	We use DatagramPacket to create a UDP request and response.
	First, receive request from the client, write a random quote to the response and send response through socket.send() to address taken from request.getAddress(). 
	

#### 2. Client file:
	A file which simply requests a quote from the server.
	We create a DatagramSocket instance (called soc), and create a DatagramPacket instance called request with one byte buffer, ip address and port no. of server.
	It sends the request to that ip address and port, receives the response (again a DatagramPacket instance) and prints the quote.
	

1.	Run Java TCP server
	```bash
	java UDPServer.java quotesFile.txt <port no.>
	```
	Enter the port no. to make the server listen. Make sure the quotesFile is in the same directory as Server.java
	  
2. 	Run Java TCP client
	To run:
	```bash
		java UDPClient.java <hostname (typically localhost)> <port no. (Same as Server)>
	```
	
3. 	Now the server and client are talking unless the client inputs "Exit".