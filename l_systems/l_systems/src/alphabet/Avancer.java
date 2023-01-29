package alphabet;

public class Avancer extends MembreAlpha{
	private int valeur;
	private static final int VALEUR_BASE=5;
	private static final char REPRESENTATION_BASE='F';
	
	public Avancer(int valeur, char representation) {
		super(representation);
		this.valeur = valeur;
	}
	public Avancer(int valeur) {
		this(valeur,REPRESENTATION_BASE);
	}
	public Avancer() {
		this(VALEUR_BASE,REPRESENTATION_BASE);
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

}