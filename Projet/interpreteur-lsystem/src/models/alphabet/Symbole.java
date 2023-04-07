package models.alphabet;
import java.util.LinkedList;
import tortue.*;

public class Symbole implements Dessin{
	protected Character representation;
	protected LinkedList<Symbole> evolution;
	protected boolean dessine;

	public Symbole(Character representation, LinkedList<Symbole> evolution) {
		this.representation = representation;
		this.evolution=evolution;
		this.dessine=false;
	}
	public Symbole(Character representation) {
		this(representation,new LinkedList<Symbole>());
		this.evolution.add(this);
	}
	public Symbole(Symbole membre) {
		this.representation = membre.representation;
		this.evolution=membre.evolution;
		this.dessine=membre.dessine;
	}

	public Character getRepresentation() {
		return representation;
	}

	public void setRepresentation(Character representation) {
		this.representation = representation;
	}
	

	public boolean isDessine() {
		return dessine;
	}
	public void setDessine(boolean dessine) {
		this.dessine = dessine;
	}
	public LinkedList<Symbole> getEvolution() {
		return evolution;
	}

	public void setEvolution (LinkedList<Symbole> evolution) {
		this.evolution = evolution;
	}
	public void setEvolution (Symbole membreEvolution) {
		LinkedList<Symbole> evolution2 = new LinkedList<Symbole>();
		evolution2.add(membreEvolution);
		this.evolution=evolution2;
	}
	public void addEvolution(Symbole membreEvolution) {
		this.evolution.add(membreEvolution);
	}
	@Override
	public void seDessiner(Tortue tortue) {
		tortue.stay();
	}
	

	@Override
	public String toString() {
		return ""+this.getRepresentation();

	}
	public String evolutionRepresentation(){
		String rep=""+this.getRepresentation()+"=";
		for (Symbole membre:this.evolution){
			rep+=membre.getRepresentation();
		}
		return rep;
	}



	
	
}