package alphabet;

import java.util.LinkedList;

public class SauverPosition extends MembreAlpha{
	
	private static final char REPRESENTATION_BASE='[';
	
	public SauverPosition(char representation, LinkedList<MembreAlpha> evolution) {
		super(representation,evolution);
	}
	public SauverPosition(char representation) {
		super(representation);
	}
	public SauverPosition() {
		this(REPRESENTATION_BASE);
	}

}
