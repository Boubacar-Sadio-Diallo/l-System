package alphabet;

public class Main {

	public static void main(String[] args) {
		
		MembreAlpha effe = new MembreAlpha('F');
		System.out.println(effe);
		System.out.println(effe.getEvolution());
		MembreAlpha ava = new Avancer('A',new Evolution(effe),4);
		System.out.println(ava);
		System.out.println(ava.getEvolution());
		

	}

}
