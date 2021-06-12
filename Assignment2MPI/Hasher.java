  /*
   * Author of revised version: Franklyn Pinedo
   * Author of new revised version: David Walker
   *
   * Adapted from Source Code in C of Tutorial/User's Guide for MPI by
   * Peter Pacheco.
   */

  import mpi.* ;
  import java.util.*;
  import java.rmi.RemoteException;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
import java.rmi.server.UnicastRemoteObject;
 
  class Hasher {
    static public void main(String[] args) throws MPIException {
      Scanner s1 = new Scanner(System.in);

      MPI.Init(args) ;
      int my_rank; // Rank of process
      int source;  // Rank of sender
      int dest;    // Rank of receiver 
      int tag=50;  // Tag for messages	
      int myrank = MPI.COMM_WORLD.Rank() ;
      int      p = MPI.COMM_WORLD.Size() ;

	if(myrank == 0){

			String myhost = MPI.Get_processor_name();
			String[] s = {
					new String("Assignment 2"),
					new String("CL-IX"),
					new String("MPI Using JAVA"),
					new String("43141_Sahil_Naphade"),
			};
	      	for (int i = 1; i < p; i++) {
	      		System.out.println("Sent process "+i+" the message = "+s[i]+"\n");
	      		MPI.COMM_WORLD.Send(s[i].toCharArray(), 0, s[i].length(), MPI.CHAR, i, 100);
			}
	      	
	      	System.out.println("Sent the message");
	}

      else if(myrank != 0){
    	  char [] rmessage = new char[60];
    	  String hashedString = null;
	        MPI.COMM_WORLD.Recv(rmessage, 0, rmessage.length, MPI.CHAR, 0, 100);
	        System.out.println("Process <"+myrank+"> received : " + new String(rmessage));
	        try{
	        	MessageDigest md = MessageDigest.getInstance("SHA-256");
	        	byte[] array = md.digest(rmessage.toString().getBytes(StandardCharsets.UTF_8));
	        	BigInteger number =  new BigInteger(1, array);
	        	StringBuilder hexString = new StringBuilder(number.toString(16));
	        	hashedString = new String("[" + new String(rmessage)+ "] : " + hexString.toString() + "\n");
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        }
	        
	        System.out.println("Proc <"+myrank+"> hashed - "+hashedString);     
     }
     MPI.Finalize();
    }
  }
