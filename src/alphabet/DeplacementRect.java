package alphabet;
import java.util.LinkedList;


public abstract class DeplacementRect extends MembreAlpha {
	protected double valeur;
	protected boolean dessine;
	public DeplacementRect(Character representation, LinkedList<MembreAlpha> evolution ,double valeur) {
		super(representation,evolution);
		this.valeur=valeur;
		this.dessine=false;
	}
	public DeplacementRect(Character representation, double valeur) {
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
