package alphabet;
import java.util.ArrayList;

public class Evolution {
	private MembreAlpha membre;
	private ArrayList<MembreAlpha> devient=new ArrayList<MembreAlpha>();
	public Evolution(MembreAlpha membre, ArrayList<MembreAlpha> devient) {
		this.membre = membre;
		this.devient = devient;
	}
	public Evolution(MembreAlpha membre) {
		this.membre=membre;
		this.devient.add(this.membre);
	}
	
	
}
