package alphabet;

public class MembreAlpha {
	protected char representation;
	protected Evolution evolution;

	public MembreAlpha(char representation, Evolution evolution) {
		this.representation = representation;
		this.evolution=evolution;
	}
	public MembreAlpha(char representation) {
		this.representation = representation;
		this.evolution=new Evolution(this);
	}

	public char getRepresentation() {
		return representation;
	}

	public void setRepresentation(char representation) {
		this.representation = representation;
	}
	

	public Evolution getEvolution() {
		return evolution;
	}

	public void setEvolution(Evolution evolution) {
		this.evolution = evolution;
	}

	@Override
	public String toString() {
		return ""+this.getRepresentation();
	}


	
	
}