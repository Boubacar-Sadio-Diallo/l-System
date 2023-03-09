package alphabet;
import java.util.HashMap;
import java.util.LinkedList;
public class LSystem {
	
	private LinkedList<MembreAlpha> developpement;
	private double angle;
	private HashMap<Character,MembreAlpha> regles;
	private int niveau;

	public LSystem(LinkedList<MembreAlpha> developpement, double angle){
		this.developpement = developpement;
		this.angle = angle;
		this.niveau=0;
		DessinerAvancer dessinerAvancer = new DessinerAvancer();
		Avancer avancer =new Avancer();
		RestaurerPosition restaturerPosition = new RestaurerPosition();
		SauverPosition sauverPosition = new SauverPosition();
		TournerSensHoraire tournerSensHoraire = new TournerSensHoraire();
		tournerSensHoraire.setValeur(angle);
		TournerSensTrigo tournerSensTrigo = new TournerSensTrigo();
		tournerSensTrigo.setValeur(angle);
		this.regles.put(dessinerAvancer.getRepresentation(), dessinerAvancer);
		this.regles.put(avancer.getRepresentation(), avancer);
		this.regles.put(restaturerPosition.getRepresentation(), restaturerPosition);
		this.regles.put(sauverPosition.getRepresentation(), sauverPosition);
		this.regles.put(tournerSensHoraire.getRepresentation(), tournerSensHoraire);
		this.regles.put(tournerSensTrigo.getRepresentation(), tournerSensTrigo);
	}

	public LinkedList<MembreAlpha> getDeveloppement() {
		return developpement;
	}

	public double getAngle() {
		return angle;
	}

	public HashMap<Character, MembreAlpha> getRegles() {
		return regles;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public void setRegles(HashMap<Character, MembreAlpha> regles) {
		this.regles = regles;
	}
	public LinkedList<MembreAlpha> nextGeneration() {
		LinkedList<MembreAlpha> prochain = new LinkedList<MembreAlpha>();
		for(MembreAlpha membre : this.developpement) {
			prochain.addAll(membre.getEvolution());
		}
		return prochain;
	}

	public void affecterNextGenToDev() {
		this.developpement=this.nextGeneration();
	}
	
	public void ajoutSymbole(Character character) {
		MembreAlpha nouveauSymbole = new MembreAlpha(character);
		this.regles.put(nouveauSymbole.getRepresentation(), nouveauSymbole);
	}
	public void changerRegleSymbole(Character charSymbQuiDoitChanger, Character charSymbAAjouter) {
		if(!this.regles.containsKey(charSymbAAjouter)) {
			this.ajoutSymbole(charSymbAAjouter);
		}
		this.regles.get(charSymbQuiDoitChanger).setEvolution(this.regles.get(charSymbAAjouter));
	}
	public void ajoutRegleSymbole(Character charSymbQuiDoitChanger, Character charSymbAAjouter) {
		if(!this.regles.containsKey(charSymbAAjouter)) {
			this.ajoutSymbole(charSymbAAjouter);
		}
		this.regles.get(charSymbQuiDoitChanger).addEvolution(this.regles.get(charSymbAAjouter));
	}
	public String toString() {
		String chaine="::";
		for (MembreAlpha symbole : this.developpement) {
			chaine+=symbole.toString()+" ";
		}
		return chaine+"::";
	}
	
	public String representationNext() {
		String chaine="::";
		for(MembreAlpha symbole : this.nextGeneration()) {
			chaine+=symbole.toString()+" ";
		}
		//countGene++;
		return this.toString()+"\n"+ chaine+"::";
	}
	
	
	

}
