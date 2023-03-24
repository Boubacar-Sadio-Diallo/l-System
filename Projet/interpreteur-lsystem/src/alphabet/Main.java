package alphabet;
import java.util.LinkedList;
//import tortue.Tortue;
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
		/*Generation generat=new Generation(testGene);
		for(int i=0;i<3;i++) {
			System.out.println(generat.representationNext()+"\n");
			System.out.println(Generation.getCountGen());
			generat = generat.nextGeneration();
			
		}*/
		LSystem lsystem = new LSystem(AutreevoluerTest,45);
		System.out.println(lsystem.getRegles());
		System.out.println(lsystem.getRegles().get('F').getEvolution());
		/*lsystem.ajoutRegleSymbole('F','F');
		lsystem.ajoutRegleSymbole('F','F');
		System.out.println(lsystem.getRegles().get('F').getEvolution());
		System.out.println(lsystem.getRegles());
		System.out.println(lsystem.representationRegles());*/
		System.out.println(lsystem.representationRegles());
		lsystem.changerRegleSymbole('F','f');
		System.out.println(lsystem.representationRegles());
		System.out.println(lsystem.getRegles());
		lsystem.changerRegleSymbole('F','B');
		System.out.println(lsystem.representationRegles());
		System.out.println(lsystem.getRegles());
		System.out.println(lsystem.getRegles().get('F').getEvolution());
		System.out.println(lsystem.getRegles());
		lsystem.ajoutRegleSymbole('F','A');
		System.out.println(lsystem.representationRegles());
		System.out.println(lsystem.getRegles());
		System.out.println(lsystem.getRegles().get('F').getEvolution());
		System.out.println(lsystem.representationRegles());
		System.out.println(lsystem.getRegles().containsKey('F'));
		/*for(int i=0;i<3;i++) {
			System.out.println(lsystem.representationNext()+"\n");
			lsystem.affecterNextGenToDev();
		}
		System.out.println("\n\n ----------------------------------------------------- \n\n");*/
		/*System.out.println(lsystem.affecterRepresenter(10000));
		System.out.println(lsystem.affecterRepresenter());
		
		double nombre =4.4;
		System.out.println("\n"+nombre);
		System.out.println((float) nombre);
		System.out.println((int) nombre);*/
	}

}

