package serveur;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.Hashtable;

import banque.BanqueImpl;
import banque.Compte;

public class BanqueServeur {
	public static void main(String[] args) {
	Hashtable<String,Compte> clients = initComptesClients();
		try {
			
			// Mise en place d’un registre RMI
			Registry reg = LocateRegistry.createRegistry(1099); 
			
			// Mise en place du Security Manager 	
			/*	System.setProperty("java.security.policy", "policy");
				if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}*/
			
			BanqueImpl obj = new BanqueImpl(clients);
					
			reg.bind("MaBanque", obj);
			
			// on peut aussi utiliser la classe Naming
			// Naming.bind("rmi://localhost:1099/MaBanque", obj); 
			
			System.out.println("OD 'Banque' est enregistre");
			
		} catch (RemoteException e) { 
			e.printStackTrace();
		} catch (Exception e) { 
			e.printStackTrace(); 
		}  
	}
	private static Hashtable<String,Compte> initComptesClients(){
		// Ces Comptes normalement doivent être lu d'une BD
		Hashtable<String,Compte> clients = new Hashtable<String,Compte>();
		Compte cpt1 = new Compte("12345", 5000);
		clients.put("12345", cpt1);
		Compte cpt2 = new Compte("67890", 1000);
		clients.put("67890", cpt2);
		return clients;
	}
}
