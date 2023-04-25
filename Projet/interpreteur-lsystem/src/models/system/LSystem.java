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

	/**
	 * Instancie un objet LSystem
	 * @param developpement une liste de Symbole représentant l'axiome d'un lsystem
	 * @param angle angle des rotations
	 * @param longueur longueur d'une ligne de tracé pour F et f
	 */
	public LSystem(LinkedList<Symbole> developpement, double angle,int longueur){
		this.developpement = developpement;
		this.angle = angle;
		this.niveauGeneration=0;
		this.longueur=longueur;
		this.initialisationRegles(this.angle,this.longueur);
	}

	/**
	 * Initialise les règles en créant les objets contenant l'information de réécriture et de dessin
	 * @param angle angle des rotations
	 * @param longueur longueur de F et f (d'avancement)
	 */
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

	/**
	 * Réinitialise les règles
	 */
	public void initialisationRegles(){
		this.initialisationRegles(this.angle,this.longueur);
	}

	/**
	 * Créer une instance de LSystem à partir d'une liste de Symboles
	 * @param developpement liste de Symboles
	 */
	public LSystem(LinkedList<Symbole> developpement){
		this(developpement,ANGLE_DFT,LONGUEUR_DFT);
	}
	/**
	 * Créer une instance de LSystem de base
	 */
	public LSystem(){
		this(new LinkedList<>(),ANGLE_DFT,LONGUEUR_DFT);
	}



	/**
	 * Change le niveau de génération
	 * @param niveauGeneration entier de niveau de génération
	 */
	public void setNiveauGeneration(int niveauGeneration) {
		this.niveauGeneration = niveauGeneration;
	}

	/**
	 * Renvoie l'axiome
	 * @return liste de Symboles décrivant l'axiome
	 */
	public LinkedList<Symbole> getDeveloppement() {
		return developpement;
	}

	/**
	 * Renvoie l'angle des rotations
	 * @return l'angle de rotation
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * Renvoie les Symboles utiles du lsystem
	 * @return une table de hachage où la clé est le caractère d'un symbole et la valeur une instance de Symbole
	 */
	public HashMap<Character, Symbole> getRegles() {
		return regles;
	}

	/**
	 * Renvoie une représentation des Symboles et de leurs réécritures
	 * @return un affichage en String des règles de réécritures
	 */
	public String representationRegles(){
		StringBuilder rep= new StringBuilder("Règles :\n");
		for(Map.Entry<Character, Symbole> couple : this.regles.entrySet()){
			rep.append(couple.getValue().evolutionRepresentation()).append("  /  ");
		}
		return rep.toString();
	}

	/**
	 * Renvoie le niveau de génération
	 * @return le niveau de génération
	 */
	public int getNiveauGeneration() {
		return niveauGeneration;
	}

	/**
	 * Modifie l'angle de rotation
	 * @param angle angle de rotation voulu
	 */
	public void setAngle(double angle) {
		this.angle = angle;
		TournerSensHoraire tournerSensHoraire = new TournerSensHoraire(angle);
		TournerSensTrigo tournerSensTrigo = new TournerSensTrigo(-angle);
		this.regles.put(tournerSensHoraire.getRepresentation(), tournerSensHoraire);
		this.regles.put(tournerSensTrigo.getRepresentation(), tournerSensTrigo);

	}

	/**
	 * Modifie la longueur de trait
	 * @param longueur longueur de trait voulu
	 */
	public void setLongueur(int longueur) {
		this.longueur = longueur;
		Avancer avancer=new Avancer(longueur);
		DessinerAvancer dessinerAvancer =new DessinerAvancer(longueur);
		this.regles.put(dessinerAvancer.getRepresentation(), dessinerAvancer);
		this.regles.put(avancer.getRepresentation(), avancer);

	}


	/**
	 * Ajoute un symbole aux règles
	 * @param character Caractère du symbole à ajouter
	 */
	public void ajoutSymbole(Character character) {
		Symbole nouveauSymbole = new Symbole(character);

		this.regles.put(character, nouveauSymbole);

	}

	/**
	 * Change la règle d'un Symbole par un autre Symbole
	 * @param charSymbQuiDoitChanger caractère du symbole pour qui la règle doit changer
	 * @param charSymbAAjouter caractère du symbole qui deviendra la nouvelle évolution du symbole qui change
	 */
	public void changerRegleSymbole(Character charSymbQuiDoitChanger, Character charSymbAAjouter) {
		if(!this.regles.containsKey(charSymbAAjouter)) {
			this.ajoutSymbole(charSymbAAjouter);

		}
		if(!this.regles.containsKey(charSymbQuiDoitChanger)) {
			this.ajoutSymbole(charSymbQuiDoitChanger);

		}


		this.regles.get(charSymbQuiDoitChanger).setEvolution(this.regles.get(charSymbAAjouter));
	}

	/**
	 * Change la règle d'un Symbole en lui ajoutant des symboles à sa précédente règle
	 * @param charSymbQuiDoitChanger caractère du symbole pour qui l'on doit ajouter un symbole à la règle
	 * @param charSymbAAjouter caractère du symbole qui deviendra la suite de l'évolution du symbole qui change
	 */
	public void ajoutRegleSymbole(Character charSymbQuiDoitChanger, Character charSymbAAjouter) {
		Symbole s1=this.regles.get(charSymbAAjouter);
		if(s1==null){
			s1=new Symbole(charSymbAAjouter);
			this.regles.put(charSymbAAjouter,s1);
		}
		Symbole s2=this.regles.get(charSymbQuiDoitChanger);
		s2.addEvolution(s1);
	}

	/**
	 * Renvoie la représentation du développement
	 * @return La représentation du développement
	 */
	public String toString() {
		StringBuilder chaine= new StringBuilder("\n::");
		for (Symbole symbole : this.developpement) {
			chaine.append(symbole.toString()).append(" ");
		}
		return chaine+"::";
	}


	/**
	 * Applique l'évolution du développement à un niveau donné
	 * @param n Niveau voulu
	 */
	public void affecterNextGenToDev(int n) {
		this.niveauGeneration+=n;
		this.developpement=this.nextGeneration(n);
		fireChangement();
	}

	/**
	 * Renvoie l'évolution de l'axiome à un niveau donné
	 * @param n Niveau voulu
	 * @return Évolution du développement
	 */
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

	/**
	 * Renvoie la représentation d'une évolution : l'ancien état et le nouvel état.
	 * @param n Niveau voulu
	 * @return La représentation avant / après
	 */
	public String representationNext(int n) {
		StringBuilder chaine= new StringBuilder("::");
		for(Symbole symbole : this.nextGeneration(n)) {
			chaine.append(symbole.toString()).append(" ");
		}

		return this.getNiveauGeneration()+this.toString()+"\n"+this.developpement.size()+" symboles\n\n"+ (this.getNiveauGeneration()+n)+"\n"+chaine+"::\n"+this.nextGeneration(n).size()+" symboles";
	}


	/**
	 * Renvoie les instructions de chaque symbole du déeloppement
	 * @param tortue Tortue qui comprends les instructions
	 */
	public void dessiner(Tortue tortue)  {

		//LinkedList<Symbole> symboles = new LinkedList<>(this.developpement);
		for(Symbole s:this.developpement){
			s.seDessiner(tortue);
		}


	}

	/**
	 * Modifie l'axiome
	 * @param developpement liste de Symbole
	 */
	public void setDeveloppement(LinkedList<Symbole> developpement) {
		this.developpement = developpement;
	}

	/**
	 * Modifie l'axiome en convertissant un String en liste de Symbole
	 * @param string représentation d'un axiome
	 */
	public void setDeveloppement(String string){
		this.developpement=this.stringEnLinkedList(string);
	}

	/**
	 * Renvoie la représentation en String d'un axiome
	 * @return un String représentant l'axiome
	 */
	public String developpementEnString(){
		StringBuilder representation= new StringBuilder();
		for (Symbole symbole:this.developpement
		) {
			representation.append(symbole.getRepresentation());
		}
		return representation.toString();
	}

	/**
	 * Renvoie la liste de symbole correspondant à l'axiome entré sous forme de String
	 * @param axiome String représentant un axiome
	 * @return La liste de symbole correspondante
	 */
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


	/**
	 * Affiche une représentation et affecte le changement d'axiome
	 * @param n le Niveau de réécriture voulue
	 */
	public void repEtSuivant(int n){
		System.out.println(this.representationNext(n));
		this.affecterNextGenToDev(n);
	}
}
