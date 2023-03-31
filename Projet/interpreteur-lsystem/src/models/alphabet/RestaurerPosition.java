package models.alphabet;

import java.util.LinkedList;

public class RestaurerPosition extends MembreAlpha{
	
	private static final Character REPRESENTATION_BASE=']';
	
	public RestaurerPosition(Character representation, LinkedList<MembreAlpha> evolution) {
		super(representation,evolution);
	}
	public RestaurerPosition(Character representation) {
		super(representation);
	}
	public RestaurerPosition() {
		this(REPRESENTATION_BASE);
	}

}