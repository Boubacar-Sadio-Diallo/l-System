package alphabet;
import java.util.LinkedList;
public class Main {

	public static void main(String[] args) {
		
		MembreAlpha effe = new MembreAlpha('F');
		//System.out.println(effe);
		//System.out.println(effe.getEvolution());
		LinkedList<MembreAlpha> evoluerTest=new LinkedList<MembreAlpha>();
		evoluerTest.add(effe);
		MembreAlpha ava = new Avancer('A',evoluerTest,4);
		//System.out.println(ava);
		//System.out.println(ava.getEvolution());
		//MembreAlpha zed =new MembreAlpha('Z');
		//MembreAlpha be =new MembreAlpha()
		LinkedList<MembreAlpha> testGene = new LinkedList<MembreAlpha>();
		testGene.add(effe);
		testGene.add(ava);
		LinkedList<MembreAlpha> AutreevoluerTest=new LinkedList<MembreAlpha>();
		AutreevoluerTest.add(ava);
		AutreevoluerTest.add(ava);
		AutreevoluerTest.add(effe);
		AutreevoluerTest.add(ava);
		effe.setEvolution(AutreevoluerTest);
		Generation generat=new Generation(testGene);
		for(int i=0;i<6;i++) {
			
			System.out.println(generat.representationNext());
			generat = generat.nextGeneration();
		}
		

	}

}
