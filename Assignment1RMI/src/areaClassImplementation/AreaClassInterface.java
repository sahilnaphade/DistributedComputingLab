package areaClassImplementation;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AreaClassInterface extends Remote {
	public double findArea(int code, int length) throws RemoteException;
	public double findArea(int code, int height, int width) throws RemoteException;

}
