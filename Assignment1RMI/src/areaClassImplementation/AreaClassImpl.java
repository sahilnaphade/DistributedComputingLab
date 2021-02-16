package areaClassImplementation;

import areaClassImplementation.AreaClassInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AreaClassImpl extends UnicastRemoteObject implements AreaClassInterface{
	private static final long serialVersionUID = 1L;

	public AreaClassImpl() throws RemoteException {
		super();
	}

	@Override
	public double findArea(int code, int length) throws RemoteException {
		switch(code) {
			case 1: 
				return length*length;
			case 2: 
				return 3.14*length; 
		}
		
		return 0;
	}

	@Override
	public double findArea(int code, int height, int width) throws RemoteException {
		switch(code) {
			case 1: return height * width;
			case 2: return 0.5*height*width;
		}
		return 0;
	}

}
