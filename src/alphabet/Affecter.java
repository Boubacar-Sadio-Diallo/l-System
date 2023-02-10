package alphabet;
import java.util.LinkedList;


public abstract class Affecter extends MembreAlpha {
	protected double valeur;
	protected boolean dessine;
	public Affecter(Character representation, LinkedList<MembreAlpha> evolution ,double valeur) {
		super(representation,evolution);
		this.valeur=valeur;
		this.dessine=false;
	}
	public Affecter(Character representation, double valeur) {
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
