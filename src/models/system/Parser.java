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
 *Classe permettant de décider si la saisie est correcte
 */
public class Parser {
	public String chaine;
	//private double longueur;
	private String angle;
	private String longueur;
	private String iteration;
	private String rules;
	private String charAutorise = "+-[]FfAZERTYUIOPQSDGHJKLMWXCVBNazertyuiopqsdghjklmwxcvbn|^<>&";
	private String axiomeAutorises = "";
	//public static final double DOUBLE_DFT=45;

	/**
	 * Créer une instance de Parser
	 * @param chaine axiome du lsystem
	 * @param angle angle du lsystem
	 * @param longueur longueur pour le lsystem
	 * @param iteration niveau de réécriture
	 * @param rules règles du lsystem
	 */
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
	 * Décide si toutes les saisies sont correctement entrées
	 * @return true si toutes les saisies sont correctes, false sinon
	 */
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

		if(isRulesValid()==false){
			return false;
		}
			//System.out.println("tout bien écrit");
		return true;
	}

	/**
	 * Décide si les caractères sont des caractères autorisés
	 * @return true si les caractères saisis sont dans la liste des caractères autorisés, false sinon
	 */
	public boolean islexical() {
		int cpt = 0;
		//On regarde dans une liste prédéfinie si les caractères sont contenus dedans
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

	/**
	 * Décide si les crochets sont bien utilisés s'il y en a
	 * @return true si bien écrit, false sinon
	 */
	public boolean isSyntaxic() {
		for(int i = 0; i < chaine.length();i++) {
			if(chaine.charAt(i) == '[') {
				if(i+1 <= chaine.length()-1) {
					if(chaine.charAt(i+1) == ']') {
						System.out.println("Interdit");
						return false;
					}
				}

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
		}
		return true;
	}

	/**
	 * Décide si la saisie de l'angle est correcte
	 * @return true si la saisie de l'angle est correcte, false sinon
	 */
	public boolean isAngleCorrect(){
		if(!Pattern.compile("(^\\-[0-9]+|^[0-9]+)(.[0-9]+)?$").matcher(this.angle).find()){
			return false;
		}
		return true;
	}

	/**
	 * Décide si la saisie d'un nombre entier naturel est correcte
	 * @param chaine Le String à tester
	 * @return true si chaine est un nombre entier naturel, false sinon
	 */
	public boolean isANumberValid(String chaine){
		if(!Pattern.compile("^[0-9]+$").matcher(chaine).find()){
			return false;
		}
		return true;
	}
	/**
	 * Décide si la saisie de la longueur est correcte
	 * @return true si la saisie est un nombre entier naturel, false sinon
	 */
	public boolean isLongueurCorrect(){return this.isANumberValid(this.longueur);}
	/**
	 * Décide si la saisie du nombre d'itérations est correcte
	 * @return true si la saisie est un nombre entier naturel, false sinon
	 */
	public boolean isIterationCorrect(){return this.isANumberValid(this.iteration);}

	/**
	 * Décide si les règles ont été bien saisies
	 * @return true si la saisie est correcte, false sinon
	 */
	public boolean isRulesValid(){
		if(this.rules.isEmpty()){
			return true;
		}
		if(!Pattern.compile("^[a-zA-Z\\+\\-\\[\\]\\|\\^\\<\\>\\&]=[a-zA-Z\\+\\-\\[\\]\\|\\^\\<\\>\\&]+").matcher(this.rules).find()){
			return false;
		}
		return true;
	}






}


