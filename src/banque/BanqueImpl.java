package banque;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

@SuppressWarnings("serial")

public class BanqueImpl extends UnicastRemoteObject implements Banque {
  private Hashtable<String, Compte> clients;

  public BanqueImpl(Hashtable<String, Compte> clients) throws RemoteException { 
	  super(); 
	  this.clients = clients;
  }
  public void verser(String noCompte, double somme) throws RemoteException {
	  clients.get(noCompte).verser(somme); 
  }
  public void retirer(String noCompte, double somme) throws RemoteException {
	  clients.get(noCompte).retirer(somme); 
  }
  public Position consulter(String noCompte) throws RemoteException {
	  return clients.get(noCompte).getPosition(); 
  }
}
