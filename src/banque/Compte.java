package banque;

import java.util.Date;

public class Compte {
	  private Position position;
	  private String noCompte;
	  
	  public Compte(String reference, double solde) {
		this.noCompte = reference;  
		position = new Position(solde, new Date());  
	  }
	  public void verser(double somme) { 
	    position.setSolde(position.getSolde()+somme); 
	    position.setDateDerniereOperation(new Date()); 
	  }
	  public void retirer(double somme) { 
		position.setSolde(position.getSolde()-somme); 
		position.setDateDerniereOperation(new Date());
	  }
	  public Position getPosition() { 
		  return position; 
	  }
	public String getNoCompte() {
		return noCompte;
	}
	  
}

