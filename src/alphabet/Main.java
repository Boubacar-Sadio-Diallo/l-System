package alphabet;
import java.util.LinkedList;
import tortue.Tortue;
public class Main {

	public static void main(String[] args) {
		
		MembreAlpha effe = new MembreAlpha('A');
		//System.out.println(effe);
		//System.out.println(effe.getEvolution());
		LinkedList<MembreAlpha> evoluerTest=new LinkedList<MembreAlpha>();
		evoluerTest.add(effe);
		Avancer ava = new Avancer('B',evoluerTest,4);
		//System.out.println(ava);
		TournerSensTrigo plus = new TournerSensTrigo('+',90); 
		//System.out.println(ava.getEvolution());
		//MembreAlpha zed =new MembreAlpha('Z');
		//MembreAlpha be =new MembreAlpha()
		LinkedList<MembreAlpha> testGene = new LinkedList<MembreAlpha>();
		testGene.add(effe);
		testGene.add(plus);
		LinkedList<MembreAlpha> AutreevoluerTest=new LinkedList<MembreAlpha>();
		AutreevoluerTest.add(effe);
		AutreevoluerTest.add(ava);
		effe.setEvolution(AutreevoluerTest);
		Generation generat=new Generation(testGene);
		for(int i=0;i<3;i++) {
			System.out.println(generat.representationNext()+"\n");
			System.out.println(Generation.getCountGen());
			generat = generat.nextGeneration();
			
		}
		double x =4.4;
		System.out.println(x);
		System.out.println((int)x);
		

	}

}
