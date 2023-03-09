package tortue;
import alphabet.*;

/*public class Tortue {
	
	
	
	public Tortue(double abscisse, double ordonnee, double angle) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.angle = angle;
		this.dessine = false;
	}	
	
	public Tortue(double angle) {
		this(ABSCISSE_DFT,ORDONNEE_DFT,angle);
	}
	public Tortue() {
		this(ANGLE_DFT);
	}
	public void dessinAutorisation(MembreAlpha lettre) {
		this.dessine=lettre.isDessine();
	}
	public void avancer(Mouvement lettre) {
		this.dessinAutorisation(lettre);
		if(this.dessine) {
			double abscisseAvant=this.abscisse;
			double ordoAvant=this.ordonnee;
			this.abscisse=this.abscisse+lettre.getValeur()*Math.cos(Math.toRadians(this.angle));
			this.ordonnee=this.ordonnee+lettre.getValeur()*Math.sin(Math.toRadians(this.angle));
			this.dessine(abscisseAvant,this.abscisse,ordoAvant,this.ordonnee);
		} else 
			return;
	}
	public void dessine(double x1,double x2, double y1,double y2) {
		//appel dessin pour la vue
		return;
	}
	public void tourner(Mouvement lettre) {
		if(lettre.isTourne())
			this.angle+=lettre.getValeur();
		else
			return;
	}
	
	//Le symbole doit implémenter la fonction seDessiner(Tortue t) abstarct void t.avancerentracant() 
	
}*/

public abstract class Tortue{
	public double abscisse, ordonnee, angle;
	public boolean dessine;
	private static final double ABSCISSE_DFT=0.0, ORDONNEE_DFT=0.0, ANGLE_DFT=0;
	public Tortue(double abscisse, double ordonnee, double angle) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.angle = angle;
		this.dessine = false;
	}
	public Tortue(double angle) {
		this(ABSCISSE_DFT,ORDONNEE_DFT,angle);
	}
	public Tortue() {
		this(ANGLE_DFT);
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
