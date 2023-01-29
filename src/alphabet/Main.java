package alphabet;
import java.util.LinkedList;
public class Main {

	public static void main(String[] args) {
		
		MembreAlpha effe = new MembreAlpha('A');
		//System.out.println(effe);
		//System.out.println(effe.getEvolution());
		LinkedList<MembreAlpha> evoluerTest=new LinkedList<MembreAlpha>();
		evoluerTest.add(effe);
		MembreAlpha ava = new Avancer('B',evoluerTest,4);
		//System.out.println(ava);
		//System.out.println(ava.getEvolution());
		//MembreAlpha zed =new MembreAlpha('Z');
		//MembreAlpha be =new MembreAlpha()
		LinkedList<MembreAlpha> testGene = new LinkedList<MembreAlpha>();
		testGene.add(effe);
		LinkedList<MembreAlpha> AutreevoluerTest=new LinkedList<MembreAlpha>();
		AutreevoluerTest.add(effe);
		AutreevoluerTest.add(ava);
		effe.setEvolution(AutreevoluerTest);
		Generation generat=new Generation(testGene);
		for(int i=0;i<360;i++) {
			
			System.out.println(generat.representationNext());
			System.out.println(Generation.getCountGen());
			generat = generat.nextGeneration();
			
		}
		

	}

}
