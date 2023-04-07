package models.alphabet;
import java.util.LinkedList;


public abstract class Mouvement extends Symbole {
	protected double valeur;
	protected boolean tourne;
	public Mouvement(Character representation, LinkedList<Symbole> evolution , double valeur) {
		super(representation,evolution);
		this.valeur=valeur;
		//this.tourne=false;
	}
	/*public boolean isTourne() {
		return tourne;
	}*/

	public Mouvement(Character representation, double valeur) {
		super(representation);
		this.valeur=valeur;
	}



	public double getValeur() {
		return valeur;
	}
	public void setValeur( double valeur) {
		this.valeur = valeur;
	}

	
}
