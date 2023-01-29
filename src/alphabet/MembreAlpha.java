package alphabet;
import java.util.LinkedList;

public class MembreAlpha {
	protected char representation;
	protected LinkedList<MembreAlpha> evolution;

	public MembreAlpha(char representation, LinkedList<MembreAlpha> evolution) {
		this.representation = representation;
		this.evolution=evolution;
	}
	public MembreAlpha(char representation) {
		this.representation = representation;
		this.evolution=new LinkedList<MembreAlpha>();
		this.evolution.add(this);
	}

	public char getRepresentation() {
		return representation;
	}

	public void setRepresentation(char representation) {
		this.representation = representation;
	}
	

	public LinkedList<MembreAlpha> getEvolution() {
		return evolution;
	}

	public void setEvolution (LinkedList<MembreAlpha> evolution) {
		this.evolution = evolution;
	}

	@Override
	public String toString() {
		return ""+this.getRepresentation();
	}


	
	
}