package alphabet;
import java.util.LinkedList;

public class Generation {
	public LinkedList<MembreAlpha> base;
	
	public Generation(LinkedList<MembreAlpha> base) {
		this.base=base;
	}
	public Generation nextGeneration() {
		LinkedList<MembreAlpha> prochain = new LinkedList<MembreAlpha>();
		for(MembreAlpha membre : this.base) {
			prochain.addAll(membre.getEvolution());
		}
		Generation genSuiv=new Generation(prochain);
		return genSuiv;
	}
	
	
	@Override
	public String toString() {
		String chaine="[";
		for (MembreAlpha symbole : this.base) {
			chaine+=symbole.toString()+" ";
		}
		return chaine+"]";
	}
	
	public String representationNext() {
		String chaine="[";
		for(MembreAlpha symbole : this.nextGeneration().getBase()) {
			chaine+=symbole.toString()+" ";
		}
		return this.toString()+"\n"+ chaine+"]";
	}
	public LinkedList<MembreAlpha> getBase() {
		return base;
	}
	public void setBase(LinkedList<MembreAlpha> base) {
		this.base = base;
	}
}
