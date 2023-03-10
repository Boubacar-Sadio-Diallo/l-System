package alphabet;
import java.util.LinkedList;


public abstract class Mouvement extends MembreAlpha {
	protected int valeur;
	protected boolean tourne;
	public Mouvement(Character representation, LinkedList<MembreAlpha> evolution ,int valeur) {
		super(representation,evolution);
		this.valeur=valeur;
		this.dessine=false;
		this.tourne=false;
	}
	public boolean isTourne() {
		return tourne;
	}

	public Mouvement(Character representation, int valeur) {
		super(representation);
		this.valeur=valeur;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur( int valeur) {
		this.valeur = valeur;
	}
	
	
}
