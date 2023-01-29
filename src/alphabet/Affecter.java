package alphabet;

public abstract class Affecter extends MembreAlpha {
	protected int valeur;
	public Affecter(char representation, Evolution evolution ,int valeur) {
		super(representation,evolution);
		this.valeur=valeur;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	
}
