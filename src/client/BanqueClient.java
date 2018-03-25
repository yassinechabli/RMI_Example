package client;

//import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;

import banque.Banque;

public class BanqueClient {
	public static void main(String[] args) {
		try {
			
			/*System.setProperty("java.security.policy", "policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			*/
			
			// 1- Retrouver le registre RMI
			Registry reg = LocateRegistry.getRegistry("localhost",1099);
			// 2- Acces à l'OD
			Banque b = (Banque) reg.lookup("MaBanque"); 
			
			// a la place de 1 et 2 on peut directememt faire 
			//Banque b = (Banque) Naming.lookup("rmi://localhost:1099/MaBanque");

			String id1="12345";
			b.verser(id1, 1000.00);
			b.retirer(id1, 500.00);
			System.out.println(id1+" - "+ b.consulter(id1)); 
			
		} catch (RemoteException e) { e.printStackTrace(); } 
		catch (NotBoundException e) { e.printStackTrace(); }
		// catch (MalformedURLException e) { e.printStackTrace(); } // utile si on utilise la classe Naming
	 }
}
