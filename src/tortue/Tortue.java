package tortue;
import alphabet.*;

public class Tortue {
	
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
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public HashMap<Character,MembreAlpha> alphabetMap;
	
	
	public Tortue(HashMap<Character,MembreAlpha> alphabetMap) {
		this();
		this.alphabetMap=alphabetMap;
	}
	

	public Tortue(ArrayList<MembreAlpha> alphabet) {
		this();
		HashMap<Character,MembreAlpha> alphabetMap2= new HashMap<Character,MembreAlpha>();
		for (MembreAlpha alpha : alphabet) {
			alphabetMap2.put(alpha.getRepresentation(),alpha);
		}
		this.alphabetMap=alphabetMap2;
	}


	public Tortue() {
		this.abscisse=0.0;
		this.ordonnee=0.0;
		this.angle=90;
		this.dessine=false;
		ArrayList<MembreAlpha> alphabet= new ArrayList<MembreAlpha>();
		Avancer avancer = new Avancer();
		DessinerAvancer dessinerAvancer =new DessinerAvancer();
		MembreAlpha membrealpha1=new MembreAlpha('A');
		MembreAlpha membrealpha2=new MembreAlpha('B');
		SauverPosition sauver = new SauverPosition();
		RestaurerPosition restaurer = new RestaurerPosition();
		TournerSensTrigo tournerTrigo = new TournerSensTrigo();
		TournerSensHoraire tournerHoraire = new TournerSensHoraire();
		alphabet.add(avancer);
		alphabet.add(dessinerAvancer);
		alphabet.add(membrealpha1);
		alphabet.add(membrealpha2);
		alphabet.add(sauver);
		alphabet.add(restaurer);
		alphabet.add(tournerTrigo);
		alphabet.add(tournerHoraire);
		HashMap<Character,MembreAlpha> alphabetMap2= new HashMap<Character,MembreAlpha>();
		for (MembreAlpha alpha : alphabet) {
			alphabetMap2.put(alpha.getRepresentation(),alpha);
		}
		this.alphabetMap=alphabetMap2;
	}
	
	public double getAbscisse() {
		return abscisse;
	}
	public void setAbscisse(double abscisse) {
		this.abscisse = abscisse;
	}
	public double getOrdonnee() {
		return ordonnee;
	}
	public void setOrdonnee(double ordonnee) {
		this.ordonnee = ordonnee;
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public boolean isDessine() {
		return dessine;
	}
	public void setDessine(boolean dessine) {
		this.dessine = dessine;
	}
	public HashMap<Character, MembreAlpha> getAlphabetMap() {
		return alphabetMap;
	}
	public void setAlphabetMap(HashMap<Character, MembreAlpha> alphabetMap) {
		this.alphabetMap = alphabetMap;
	}
	public void getCoordonnees() {
		System.out.prdoubleln("("+this.getAbscisse()+","+this.getOrdonnee()+")");
	}
	public void setCoordonnees(double abscisse, double ordonnee) {
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
	}
	
	/*
	public void avancer() {
		
	}
*/
