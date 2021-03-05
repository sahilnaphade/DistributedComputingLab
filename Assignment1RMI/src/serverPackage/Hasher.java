package serverPackage;

import java.rmi.*;
import java.security.NoSuchAlgorithmException;

public interface Hasher extends Remote{
	public String createHash(String data, int choice) throws RemoteException, NoSuchAlgorithmException;
}
