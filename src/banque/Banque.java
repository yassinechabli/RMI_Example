package banque;
import java.rmi.*;

public interface Banque extends Remote {

  //Effectuer un virement
  public void verser(String noCompte, double somme) throws RemoteException;

  //Retirer de l’argent
  public void retirer(String noCompte, double somme) throws RemoteException;

  //Consulter le compte (le solde et la date de la dernière opération)
  public Position consulter(String noCompte) throws RemoteException;
}

