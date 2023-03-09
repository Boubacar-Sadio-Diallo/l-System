package alphabet;
import java.util.LinkedList;

public class MembreAlpha {
	protected Character representation;
	protected LinkedList<MembreAlpha> evolution;
	protected boolean dessine;

	public MembreAlpha(Character representation, LinkedList<MembreAlpha> evolution) {
		this.representation = representation;
		this.evolution=evolution;
		this.dessine=false;
	}
	public MembreAlpha(Character representation) {
		this(representation,new LinkedList<MembreAlpha>());
		this.evolution.add(this);
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
	public LinkedList<MembreAlpha> getEvolution() {
		return evolution;
	}

	public void setEvolution (LinkedList<MembreAlpha> evolution) {
		this.evolution = evolution;
	}
	public void setEvolution (MembreAlpha membreEvolution) {
		LinkedList<MembreAlpha> evolution2 = new LinkedList<MembreAlpha>();
		this.evolution=evolution2;
	}
	public void addEvolution(MembreAlpha membreEvolution) {
		this.evolution.add(membreEvolution);
	}
	

	@Override
	public String toString() {
		return ""+this.getRepresentation();
	}


	
	
}