package alphabet;
import java.util.LinkedList;

public class Evolution {
	
	//private MembreAlpha membre;
	
	private LinkedList<MembreAlpha> devient=new LinkedList<MembreAlpha>();
	
	public Evolution(/*MembreAlpha membre,*/ LinkedList<MembreAlpha> devient) {
		//this.membre = membre;
		this.devient = devient;
	}
	
/*	public Evolution(MembreAlpha membre) {
		this.membre=membre;
		this.devient.add(this.membre);
	}*/
	
	/*public MembreAlpha getMembre() {
		return membre;
	}

	public void setMembre(MembreAlpha membre) {
		this.membre = membre;
	}*/

	public LinkedList<MembreAlpha> getDevient() {
		return devient;
	}

	public void setDevient(LinkedList<MembreAlpha> devient) {
		this.devient = devient;
	}

	@Override
	public String toString() {
		String chaine="[";
		for (MembreAlpha symbole : this.devient) {
			chaine+=symbole.toString()+" ";
		}
		return chaine+"]";
	}
	
	
}
