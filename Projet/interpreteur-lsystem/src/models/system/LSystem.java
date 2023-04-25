package models.system;

import models.alphabet.*;
import tortue.Tortue;
import util.AbstractModeleEcoutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Maris Damien
 * Classe représentant un LSystem
 */
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
	public void initialisationRegles(double angle,int longueur){

		DessinerAvancer dessinerAvancer = new DessinerAvancer(longueur);
		Avancer avancer =new Avancer(longueur);

		RestaurerPosition restaturerPosition = new RestaurerPosition();
		SauverPosition sauverPosition = new SauverPosition();

		TournerSensHoraire tournerSensHoraire = new TournerSensHoraire(angle);
		TournerSensTrigo tournerSensTrigo = new TournerSensTrigo(-angle);

		DemiTour demiTour = new DemiTour();
		Nord nord = new Nord();
		Est est = new Est();
		Sud sud = new Sud();
		Ouest ouest = new Ouest();

		this.regles  = new HashMap<>();

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
	public void initialisationRegles(){
		this.initialisationRegles(this.angle,this.longueur);
	}

	public LSystem(LinkedList<Symbole> developpement){
		this(developpement,ANGLE_DFT,LONGUEUR_DFT);
	}

	public LSystem(){
		this(new LinkedList<>(),ANGLE_DFT,LONGUEUR_DFT);
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
		StringBuilder rep= new StringBuilder("Règles :\n");
		for(Map.Entry<Character, Symbole> couple : this.regles.entrySet()){
			rep.append(couple.getValue().evolutionRepresentation()).append("  /  ");
		}
		return rep.toString();
	}

	public int getniveauGeneration() {
		return niveauGeneration;
	}

	public void setAngle(double angle) {
		this.angle = angle;
		TournerSensHoraire tournerSensHoraire = new TournerSensHoraire(angle);
		TournerSensTrigo tournerSensTrigo = new TournerSensTrigo(-angle);
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

		this.regles.put(character, nouveauSymbole);

	}

	public void changerRegleSymbole(Character charSymbQuiDoitChanger, Character charSymbAAjouter) {
		if(!this.regles.containsKey(charSymbAAjouter)) {
			this.ajoutSymbole(charSymbAAjouter);

		}
		if(!this.regles.containsKey(charSymbQuiDoitChanger)) {
			this.ajoutSymbole(charSymbQuiDoitChanger);

		}


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
		StringBuilder chaine= new StringBuilder("\n::");
		for (Symbole symbole : this.developpement) {
			chaine.append(symbole.toString()).append(" ");
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
		LinkedList<Symbole> prochain = new LinkedList<>();
		LinkedList<Symbole> copy = new LinkedList<>(this.developpement);
		for(int i=0;i<n;i++) {
			prochain=new LinkedList<>();
			for(Symbole membre : copy) {
				prochain.addAll(membre.getEvolution());
			}
			copy=prochain;
		}
		return prochain;
	}

	public String representationNext(int n) {
		StringBuilder chaine= new StringBuilder("::");
		for(Symbole symbole : this.nextGeneration(n)) {
			chaine.append(symbole.toString()).append(" ");
		}

		return this.getniveauGeneration()+this.toString()+"\n"+this.developpement.size()+" symboles\n\n"+ (this.getniveauGeneration()+n)+"\n"+chaine+"::\n"+this.nextGeneration(n).size()+" symboles";
	}

	public void affecterRepresenter(int n) {
		this.affecterNextGenToDev(n);
		this.fireChangement();
		//this.representationNext(n);
	}




	public void dessiner(Tortue tortue)  {

		ArrayList<Symbole> symboles = new ArrayList<>(this.developpement);
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
		StringBuilder representation= new StringBuilder();
		for (Symbole symbole:this.developpement
		) {
			representation.append(symbole.getRepresentation());
		}
		return representation.toString();
	}

	public LinkedList<Symbole> stringEnLinkedList(String axiome){
		LinkedList<Symbole> listeSymboles = new LinkedList<>();
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
