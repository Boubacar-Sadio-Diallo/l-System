package alphabet;

public class Tourner extends MembreAlpha {
	private int valeur;
	private static final char REPRESENTATION_BASE='+';
	private static final int VALEUR_BASE=90;
	
	public Tourner(int valeur, char representation)  {
		super(representation);
		this.valeur = valeur;
	}
	public Tourner(int valeur) {
		this(valeur,REPRESENTATION_BASE);
	}
	public Tourner() {
		this(VALEUR_BASE,REPRESENTATION_BASE);
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

}