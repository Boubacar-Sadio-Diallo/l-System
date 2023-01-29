package alphabet;

public class MembreAlpha {
	private char representation;

	public MembreAlpha(char representation) {
		this.representation = representation;
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