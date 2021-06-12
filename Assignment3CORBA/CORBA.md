### Distributed application in Java using CORBA

#### Creation of a hashing server using Java and CORBA

##### Requirements: Java 8 (OpenJDK or Oracle)

###### Add JAVA_HOME and its binary to path (I needed to uninstall JDK 11 to run the program)

#### Crate an IDL file which will define the interface (Hasher.idl)
```console
idlj -fall Hasher.idl
```

Module HasherApp translates to 
```java
package HasherApp;
```

Interface translates to 
```java
public interface Hasher;
```

#### Steps to run:

#### In first terminal:
##### Alternatively, you can use the runServer.sh file (Do not move the file).
1. Start the ORB server (Run first in terminal, before running bash files)
```console
orbd -ORBInitialPort 1050 -ORBInitialHost localhost&
```

2. Change to the src directory
```console
cd DistributedComputingLab/Java-CORBA/src/
```

3. Compile the java code
```console
javac hasherServer/HasherServer.java -Xlint:unchecked
```

4. Run the server 
```console
java hasherServer.HasherServer -ORBInitialPort 1050 -ORBInitialHost localhost&
```

#### In second terminal:
##### Alternatively, use the runClient.sh file

1. Compile the client
```console
javac client/HasherClient.java -Xlint:unchecked
```

2. Run the client
```console 
java client.HasherClient -ORBInitialPort 1050 -ORBInitialHost localhost
```

3. Follow the prompts

For more info, see [here](https://docs.oracle.com/javase/7/docs/technotes/guides/idl/tutorial/GSIDL.html)
