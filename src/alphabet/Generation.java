package alphabet;
import java.util.LinkedList;

public class Generation {
	public LinkedList<MembreAlpha> base;
	
	public Generation(LinkedList<MembreAlpha> base) {
		this.base=base;
	}
	public LinkedList<MembreAlpha> nextGeneration() {
		LinkedList<MembreAlpha> prochain = new LinkedList<MembreAlpha>();
		for(MembreAlpha membre : this.base) {
			prochain.addAll(membre.evolution.getDevient());
		}
		return prochain;
	}
}
