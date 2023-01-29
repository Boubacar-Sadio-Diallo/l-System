package alphabet;

public class MembreAlpha {
	private char representation;
	private Evolution evolution;

	public MembreAlpha(char representation, Evolution evolution) {
		this.representation = representation;
		this.evolution=evolution;
	}

	public char getRepresentation() {
		return representation;
	}

	public void setRepresentation(char representation) {
		this.representation = representation;
	}

	@Override
	public String toString() {
		return ""+this.getRepresentation();
	}
	
	
}