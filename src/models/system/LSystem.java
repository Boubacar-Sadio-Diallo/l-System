package models.system;
import models.alphabet.*;
import util.AbstractModeleEcoutable;
import tortue.Tortue;

import java.util.*;

public class LSystem extends AbstractModeleEcoutable {

	private LinkedList<Symbole> developpement;
	private double angle;
	private HashMap<Character, Symbole> regles;
	private int niveauGeneration;
	public static final int ANGLE_DFT=90;


	public LSystem(LinkedList<Symbole> developpement, double angle){
		this.developpement = developpement;
		this.angle = angle;
		this.niveauGeneration=0;
		DessinerAvancer dessinerAvancer = new DessinerAvancer();
		Avancer avancer =new Avancer();
		RestaurerPosition restaturerPosition = new RestaurerPosition();
		SauverPosition sauverPosition = new SauverPosition();
		TournerSensHoraire tournerSensHoraire = new TournerSensHoraire();
		tournerSensHoraire.setValeur(angle);
		TournerSensTrigo tournerSensTrigo = new TournerSensTrigo();
		tournerSensTrigo.setValeur(-angle);
		this.regles  = new HashMap<Character, Symbole>();
		this.regles.put(dessinerAvancer.getRepresentation(), dessinerAvancer);
		this.regles.put(avancer.getRepresentation(), avancer);
		this.regles.put(restaturerPosition.getRepresentation(), restaturerPosition);
		this.regles.put(sauverPosition.getRepresentation(), sauverPosition);
		this.regles.put(tournerSensHoraire.getRepresentation(), tournerSensHoraire);
		this.regles.put(tournerSensTrigo.getRepresentation(), tournerSensTrigo);
	}

	public LSystem(LinkedList<Symbole> developpement){
		this(developpement,ANGLE_DFT);
	}

	public LSystem(){
		this(new LinkedList<Symbole>(),ANGLE_DFT);
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
		TournerSensHoraire tournerSensHoraire = new TournerSensHoraire();
		tournerSensHoraire.setValeur(angle);
		TournerSensTrigo tournerSensTrigo = new TournerSensTrigo();
		tournerSensTrigo.setValeur(-angle);
		this.regles.put(tournerSensHoraire.getRepresentation(), tournerSensHoraire);
		this.regles.put(tournerSensTrigo.getRepresentation(), tournerSensTrigo);

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

	/*public void ajoutRegleSymbole(Character charSymbQuiDoitChanger, Character charSymbAAjouter) {
        if (!this.regles.containsKey(charSymbAAjouter)) {
            //System.out.println("donc contient");
            this.ajoutSymbole(charSymbAAjouter);
            try {
                //	System.out.println(this.regles);
                this.regles.get(charSymbQuiDoitChanger).addEvolution(this.regles.get(charSymbAAjouter).getClass().getConstructor(MembreAlpha.class).newInstance(this.regles.get(charSymbAAjouter)));
                //System.out.println("eh la");
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }


        } else if (charSymbAAjouter!='+'&&charSymbAAjouter!='-'&&charSymbAAjouter!=']'&&charSymbAAjouter!='['&&charSymbAAjouter!='f'&&charSymbAAjouter!='F') {
            try {
                //	System.out.println(this.regles);
                this.regles.get(charSymbQuiDoitChanger).addEvolution(this.regles.get(charSymbAAjouter).getClass().getConstructor(MembreAlpha.class).newInstance(this.regles.get(charSymbAAjouter)));
                //System.out.println("eh la");
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }

        } else {
            //System.out.println("donc contient pas");
            try {
            //	System.out.println(this.regles);
                this.regles.get(charSymbQuiDoitChanger).addEvolution(this.regles.get(charSymbAAjouter).getClass().newInstance());
                //System.out.println("eh la");
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }*/
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

	public LinkedList<Symbole> nextGeneration() {
		LinkedList<Symbole> prochain = new LinkedList<Symbole>();
		for(Symbole membre : this.developpement) {
			prochain.addAll(membre.getEvolution());
		}
		return prochain;
	}

	public void affecterNextGenToDev() {
		this.developpement=this.nextGeneration();
		this.niveauGeneration+=1;
	}

	public String representationNext() {
		String chaine="::";
		for(Symbole symbole : this.nextGeneration()) {
			chaine+=symbole.toString()+" ";
		}

		return this.getniveauGeneration()+this.toString()+"\n"+ (this.getniveauGeneration()+1)+"\n"+chaine+"::";
	}


	public void affecterNextGenToDev(int n) {
		this.nextGeneration(n);
		this.niveauGeneration+=n;
		this.developpement=nextGeneration(n);
	}

	public LinkedList<Symbole> nextGeneration(int n) {
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

		return this.getniveauGeneration()+this.toString()+"\n"+ (this.getniveauGeneration()+n)+"\n"+chaine+"::\n"+this.nextGeneration(n).size();
	}

	public String affecterRepresenter(int n) {
		this.affecterNextGenToDev(n);
		this.fireChangement();
		return this.representationNext(n);
	}

	public String affecterRepresenter(){
		this.affecterRepresenter();
		this.fireChangement();
		return this.representationNext();
	}


	public void dessiner(Tortue tortue) {
        /*Iterator<Symbole> it = this.developpement.iterator();
		while(it.hasNext()){
			Symbole s = it.next();
			s.seDessiner(tortue);
			it.remove();
		}*/
		ListIterator<Symbole> it = this.developpement.listIterator();
		while(it.hasNext()){
			Symbole s = it.next();
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

	public void repEtSuivant(){
		System.out.println(this.representationNext()+"\n");
		this.affecterRepresenter();
	}

	public void repEtSuivant(int n){
		System.out.println(this.representationNext(n));
		this.affecterRepresenter(n);
	}
}
