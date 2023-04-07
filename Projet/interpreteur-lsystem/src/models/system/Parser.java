package models.system; /**
 * /**
 * Classe qui sert à parser une string
 * Parser = analyser 
 * La classe possede une methode d'anaylse isValid() qui dit si la string est assez cohérente pour etre desinnée
 * La classe possède une méthode d'analyse parse() qui converti la string, si elle est coherente en array de lines
 */


import java.util.regex.Pattern;

/**
 * @author diallo2210
 *
 */
public class Parser {
	public String chaine;
	//private double longueur;
	private String angle;
	private String longueur;
	private String iteration;
	private String rules;
	private String charAutorise = "+-[]FfAZERTYUIOPQSDGHJKLMWXCVBNazertyuiopqsdghjklmwxcvbn";
	private String axiomeAutorises = "";
	//public static final double DOUBLE_DFT=45;
	public Parser(String chaine, String angle, String longueur,String iteration, String rules) {

		this.chaine = chaine;
		this.longueur = longueur;
		this.angle = angle;
		this.iteration=iteration;
		this.rules=rules;
	}
	public Parser(){
		this("","","","","");
	}
	/**
	 * Add Axiom to CharAutorise
	 * @return
	 */
	public void addAxiomtoAutorisedChar(String getAxiom ) {
		charAutorise += getAxiom;
		axiomeAutorises += getAxiom; 
	}
	public boolean isValid() {
	
		if(!islexical() || !isSyntaxic()) {
			//
			//System.out.println("la règle est mal ecrite!!!");
			return false;
		
	}
		if(!isAngleCorrect()){
			//System.out.println("Angle incorrect");
			return false;
		}
		if(!isLongueurCorrect()){
			//System.out.println("Angle incorrect");
			return false;
		}
		if(!isIterationCorrect()){
			//System.out.println("Angle incorrect");
			return false;
		}
		if(!isRulesValid()){
			return false;
		}
			System.out.println("tout bien écrit");
		return true;
	}
	public boolean islexical() {
		int cpt = 0;
		for(int i = 0;i<chaine.length();i++) {
			String c = "";
			c = c + (chaine.charAt(i));
			if(!charAutorise.contains(c)){
				System.out.println("Caractère non autorisés");
				return false;
			}
			c = "";
			if (chaine.charAt(i) == '[') {
				cpt++;
			}
			if(chaine.charAt(i) == ']') {
				cpt--;
			}
		}
			if(cpt!=0) {
				System.out.println("Il manque un crochet");
				return false;
			}
			
			return true;
			
		}
	public boolean isSyntaxic() {
		for(int i = 0; i < chaine.length();i++) {
			if(chaine.charAt(i) == '[') {
				if(i+1 <= chaine.length()-1) {
					if(chaine.charAt(i+1) == ']') {
						System.out.println("Interdit");
						return false;
					}
				}
				
				if(i+1 <= chaine.length()-1) {
					if(chaine.charAt(i+1) == '[') {
						//je parcours le reste
						for(int j=i+2; j<chaine.length();j++) {
							if(chaine.charAt(j) == ']') {
								if(j+1<=chaine.length()-1) {
									if(chaine.charAt(j+1) == ']') {
										System.out.println("double crochets");
										return false;
									}
								}
							}
						}
						
					}
				}
				//si on a plus de fermente, je retourne false
				
				int compteurCrochetFerment = 0;
				for(int k=i; k<chaine.length();k++) {
					if(chaine.charAt(k) == ']') {
						compteurCrochetFerment = compteurCrochetFerment + 1;
					}
				}
				if(compteurCrochetFerment == 0) {
					System.out.println("");
					return false;
				}
			}
			//regarde si un c est suivi d'un de 0 ou 1 ou 2
			if(chaine.charAt(i) == 'C') {
				if(chaine.charAt(i+1) == '0' || chaine.charAt(i+1) =='1' || chaine.charAt(i+1) =='2') {
					
				}else {
					System.out.println("Mauvaise couleur");
					return false;
				}
			}
		}
		return true;
	}
	public boolean isAngleCorrect(){
		if(!Pattern.compile("(^\\-[0-9]+|^[0-9]+)(.[0-9]+)?$").matcher(this.angle).find()){
			return false;
		}
		return true;
	}

	public boolean isANumberValid(String chaine){
		if(!Pattern.compile("^[0-9]+$").matcher(chaine).find()){
			return false;
		}
		return true;
	}
	public boolean isLongueurCorrect(){return this.isANumberValid(this.longueur);}
	public boolean isIterationCorrect(){return this.isANumberValid(this.iteration);}

	public boolean isRulesValid(){
		if(!Pattern.compile("^[a-zA-Z\\+\\-\\[\\]]=[a-zA-Z\\+\\-\\[\\]]+").matcher(this.rules).find()){
			return false;
		}
		return true;
	}


	

		
	
}


