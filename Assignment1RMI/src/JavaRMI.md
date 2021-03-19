### Assignment 1 (B): Develop a distributed application using Java RMI

#### P.S.: Develop a hashing server (A server which hashes the data sent to it) using Java RMI

##### Requirements: 
	1. Java rmic
	2. jdk 1.8+ (jdk11 preferred)

#### How to run:
	1. Compile all the files in client as well as server
		in src folder:
		```bash
		javac serverPackage/* clientPackage/*
		```
	2. Start the rmiregistry
		```bash
		rmiregistry
		```
		It will not give any output
	3. Run server
		```bash
		java serverPackage.HashServer
		```
	4. Run client
		```bash
		java clientPackage.Client1
		```