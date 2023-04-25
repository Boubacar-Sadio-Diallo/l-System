package models.system;

import models.alphabet.*;
import tortue.Tortue;
import util.AbstractModeleEcoutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LSystem extends AbstractModeleEcoutable {

	private LinkedList<Symbole> developpement;
	private double angle;
	private HashMap<Character, Symbole> regles;
	private int niveauGeneration,longueur;
	public static final double ANGLE_DFT=90;
	public static final int LONGUEUR_DFT=10;


	public LSystem(LinkedList<Symbole> developpement, double angle,int longueur){
		this.developpement = developpement;
		this.angle = angle;
		this.niveauGeneration=0;
		this.longueur=longueur;
		this.initialisationRegles(this.angle,this.longueur);
	}
	private void initialisationRegles(double angle,int longueur){

		DessinerAvancer dessinerAvancer = new DessinerAvancer(longueur);
		Avancer avancer =new Avancer(longueur);

		RestaurerPosition restaturerPosition = new RestaurerPosition();
		SauverPosition sauverPosition = new SauverPosition();

		TournerSensHoraire tournerSensHoraire = new TournerSensHoraire(angle);
		TournerSensTrigo tournerSensTrigo = new TournerSensTrigo(angle);

		DemiTour demiTour = new DemiTour();
		Nord nord = new Nord();
		Est est = new Est();
		Sud sud = new Sud();
		Ouest ouest = new Ouest();

		this.regles  = new HashMap<Character, Symbole>();

		this.regles.put(dessinerAvancer.getRepresentation(), dessinerAvancer);
		this.regles.put(avancer.getRepresentation(), avancer);

		this.regles.put(restaturerPosition.getRepresentation(), restaturerPosition);
		this.regles.put(sauverPosition.getRepresentation(), sauverPosition);

		this.regles.put(tournerSensHoraire.getRepresentation(), tournerSensHoraire);
		this.regles.put(tournerSensTrigo.getRepresentation(), tournerSensTrigo);

		this.regles.put(demiTour.getRepresentation(),demiTour);
		this.regles.put(nord.getRepresentation(),nord);
		this.regles.put(est.getRepresentation(),est);
		this.regles.put(sud.getRepresentation(),sud);
		this.regles.put(ouest.getRepresentation(),ouest);
	}

	public LSystem(LinkedList<Symbole> developpement){
		this(developpement,ANGLE_DFT,LONGUEUR_DFT);
	}

	public LSystem(){
		this(new LinkedList<Symbole>(),ANGLE_DFT,LONGUEUR_DFT);
	}

	public int getNiveauGeneration() {
		return niveauGeneration;
	}

	public void setNiveauGeneration(int niveauGeneration) {
		this.niveauGeneration = niveauGeneration;
	}

	public LinkedList<Symbole> getDeveloppement() {
		return developpement;
	}

	public double getAngle() {
		return angle;
	}

	public HashMap<Character, Symbole> getRegles() {
		return regles;
	}

	public String representationRegles(){
		String rep="Règles :\n";
		for(Map.Entry<Character, Symbole> couple : this.regles.entrySet()){
			rep+=couple.getValue().evolutionRepresentation()+"  /  ";
		}
		return rep;
	}

	public int getniveauGeneration() {
		return niveauGeneration;
	}

	public void setAngle(double angle) {
		this.angle = angle;
		TournerSensHoraire tournerSensHoraire = new TournerSensHoraire(angle);
		TournerSensTrigo tournerSensTrigo = new TournerSensTrigo(angle);
		this.regles.put(tournerSensHoraire.getRepresentation(), tournerSensHoraire);
		this.regles.put(tournerSensTrigo.getRepresentation(), tournerSensTrigo);

	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
		Avancer avancer=new Avancer(longueur);
		DessinerAvancer dessinerAvancer =new DessinerAvancer(longueur);
		this.regles.put(dessinerAvancer.getRepresentation(), dessinerAvancer);
		this.regles.put(avancer.getRepresentation(), avancer);

	}

	public void setRegles(HashMap<Character, Symbole> regles) {
		this.regles = regles;
	}


	public void ajoutSymbole(Character character) {
		Symbole nouveauSymbole = new Symbole(character);
		//System.out.println("création bonne");
		this.regles.put(character, nouveauSymbole);
		//System.out.println(this.regles);
	}

	public void changerRegleSymbole(Character charSymbQuiDoitChanger, Character charSymbAAjouter) {
		if(!this.regles.containsKey(charSymbAAjouter)) {
			this.ajoutSymbole(charSymbAAjouter);
			//System.out.println("fait");
		}
		if(!this.regles.containsKey(charSymbQuiDoitChanger)) {
			this.ajoutSymbole(charSymbQuiDoitChanger);
			//System.out.println("fait");
		}
		//this.regles.put(charSymbQuiDoitChanger,this.regles.get(charSymbQuiDoitChanger).setEvolution(this.regles.get(charSymbAAjouter)));
		System.out.println(this.regles.get(charSymbAAjouter));
		this.regles.get(charSymbQuiDoitChanger).setEvolution(this.regles.get(charSymbAAjouter));
	}


	public void ajoutRegleSymbole(Character charSymbQuiDoitChanger, Character charSymbAAjouter) {
		Symbole s1=this.regles.get(charSymbAAjouter);
		if(s1==null){
			s1=new Symbole(charSymbAAjouter);
			this.regles.put(charSymbAAjouter,s1);
		}
		Symbole s2=this.regles.get(charSymbQuiDoitChanger);
		s2.addEvolution(s1);
	}

	public String toString() {
		String chaine="\n::";
		for (Symbole symbole : this.developpement) {
			chaine+=symbole.toString()+" ";
		}
		return chaine+"::";
	}





	public void affecterNextGenToDev(int n) {
		this.niveauGeneration+=n;
		this.developpement=this.nextGeneration(n);
	}

	public LinkedList<Symbole> nextGeneration(int n) {
		if(n==0){
			return this.developpement;
		}
		LinkedList<Symbole> prochain = new LinkedList<Symbole>();
		LinkedList<Symbole> copy = new LinkedList<Symbole>();
		copy.addAll(this.developpement);
		for(int i=0;i<n;i++) {
			prochain=new LinkedList<Symbole>();
			for(Symbole membre : copy) {
				prochain.addAll(membre.getEvolution());
			}
			copy=prochain;
		}
		return prochain;
	}

	public String representationNext(int n) {
		String chaine="::";
		for(Symbole symbole : this.nextGeneration(n)) {
			chaine+=symbole.toString()+" ";
		}

		return this.getniveauGeneration()+this.toString()+"\n"+this.developpement.size()+" symboles\n"+ (this.getniveauGeneration()+n)+"\n"+chaine+"::\n"+this.nextGeneration(n).size()+" symboles";
	}

	public String affecterRepresenter(int n) {
		this.affecterNextGenToDev(n);
		this.fireChangement();
		return this.representationNext(n);
	}




	public void dessiner(Tortue tortue)  {
        /*Iterator<Symbole> it = this.developpement.iterator();
		while(it.hasNext()){
			Symbole s = it.next();
			s.seDessiner(tortue);
			it.remove();
		}*/
        /*ListIterator<Symbole> it = this.developpement.listIterator();
		while(it.hasNext()){
			Symbole s = it.next();
			s.seDessiner(tortue);
		}*/
		ArrayList<Symbole> symboles = new ArrayList<Symbole>(this.developpement);
		for(Symbole s:symboles){
			s.seDessiner(tortue);
		}


	}

	public void setDeveloppement(LinkedList<Symbole> developpement) {
		this.developpement = developpement;
	}

	public void setDeveloppement(String string){
		this.developpement=this.stringEnLinkedList(string);
	}

	public String developpementEnString(){
		String representation="";
		for (Symbole symbole:this.developpement
		) {
			representation+=symbole.getRepresentation();
		}
		return representation;
	}

	public LinkedList<Symbole> stringEnLinkedList(String axiome){
		LinkedList<Symbole> listeSymboles = new LinkedList<Symbole>();
		for (int i=0;i<axiome.length();i++){
			Character c= axiome.charAt(i);
			Symbole s;
			if(regles.containsKey(c)){
				s=this.regles.get(c);
			} else {
				s=new Symbole(c);
				this.regles.put(c,s);
			}
			listeSymboles.add(s);
		}
		return listeSymboles;
	}



	public void repEtSuivant(int n){
		System.out.println(this.representationNext(n));
		this.affecterRepresenter(n);
	}
}
