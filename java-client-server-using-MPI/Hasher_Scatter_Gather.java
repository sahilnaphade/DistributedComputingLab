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
 
  class Hasher_Scatter_Gather {
    static public void main(String[] args) throws MPIException {

      MPI.Init(args) ;
      int myrank = MPI.COMM_WORLD.Rank() ;
      int      p = MPI.COMM_WORLD.Size() ;
	  int root = 0;
	  char[] sendbuf = new char[p];
	  char[] recvbuf = new char[p];
	  
	  if(myrank == root){
		  String myhost = MPI.Get_processor_name();
		
		  sendbuf[0] = 'S';
		  sendbuf[1] = 'A';
		  sendbuf[2] = 'H';
		  sendbuf[3] = 'I';
		  sendbuf[4] = 'L';
		  for (int i = 0; i < p; i++) {
			  System.out.println("Process "+i+" the message = "+sendbuf[i]+"\n");
		  }		
		}
	  
	  	MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.CHAR, recvbuf, 0, 1, MPI.CHAR, root);
			
			recvbuf[0] = (char) (recvbuf[0] + 1);
	    	System.out.println("Proc <"+myrank+"> got next - "+recvbuf[0]);    

	    MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.CHAR, sendbuf, 0, 1, MPI.CHAR, root);
	    if(myrank == root) {
			for(int i = 0; i < p; i++) {
				System.out.println(sendbuf[i]);
			}
		}
     MPI.Finalize();
    }
  }


//   OUTPUT:
//   itsnasa  Nasa-Rig  ~  DistributedComputingLab  java-client-server-using-MPI   main  9✔  2+  $  bash run_SG.sh 
//   MPJ Express (0.44) is started in the multicore configuration
//   Process 0 the message = S
//   Process 1 the message = A
//   Process 2 the message = H
//   Process 3 the message = I
//   Process 4 the message = L
//   Proc <2> got next - I
//   Proc <0> got next - T
//   Proc <1> got next - B
//   Proc <3> got next - J
//   Proc <4> got next - M
//   T
//   B
//   I
//   J
//   M
  