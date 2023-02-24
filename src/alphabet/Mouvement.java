package alphabet;
import java.util.LinkedList;


public abstract class Mouvement extends MembreAlpha {
	protected double valeur;
	protected boolean tourne;
	public Mouvement(Character representation, LinkedList<MembreAlpha> evolution ,double valeur) {
		super(representation,evolution);
		this.valeur=valeur;
		this.dessine=false;
		this.tourne=false;
	}
	public boolean isTourne() {
		return tourne;
	}

	public Mouvement(Character representation, double valeur) {
		super(representation);
		this.valeur=valeur;
	}
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	
}
