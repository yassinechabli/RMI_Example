package banque;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")

public class Position implements Serializable {
  private double solde;
  private Date dateDerniereOperation;

  public Position(double solde, Date dateDerniereOperation){
    this.solde = solde;
    this.dateDerniereOperation = dateDerniereOperation;
  }

	public double getSolde() {
		return solde;
	}
	
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public Date getDateDerniereOperation() {
		return dateDerniereOperation;
	}
	
	public void setDateDerniereOperation(Date dateDerniereOperation) {
		this.dateDerniereOperation = dateDerniereOperation;
	}
	@Override
	public String toString(){
		return "Position au " + getDateDerniereOperation() + ": " + getSolde() +"DHs";
	}
	
 }