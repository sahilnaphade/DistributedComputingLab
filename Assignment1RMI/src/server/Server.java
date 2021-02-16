package server;

import java.rmi.Naming;

import areaClassImplementation.AreaClassImpl;

public class Server {

	public static void main(String[] args) {
		try{  
			AreaClassImpl stub = new AreaClassImpl();  
			Naming.rebind("rmi://localhost:8080/test", stub);  
		}catch(Exception e){
			System.out.println(e);
		}  
	}

}
