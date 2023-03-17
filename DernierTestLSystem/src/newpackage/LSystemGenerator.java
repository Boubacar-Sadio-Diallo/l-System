/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author ANTOINE
 */
import java.util.*;

public class LSystemGenerator {

    private String axiom;
    private Map<Character, String> rules;
    private int iterations;

    public LSystemGenerator(String axiom, Map<Character, String> rules, int iterations) {
        this.axiom = axiom;
        this.rules = rules;
        this.iterations = iterations;
        rules = new HashMap<Character, String>();
    }

    public String generate(int nombreIterations) {
        String resultat = this.getAxiom();
        for (int i = 0; i < nombreIterations; i++) {
            String nouveauResultat = "";
            for (int j = 0; j < resultat.length(); j++) {
                String caractere = String.valueOf(resultat.charAt(j));
                String regle = this.getRules().get(caractere);
                if (regle != null) {
                    nouveauResultat += regle;
                } else {
                    nouveauResultat += caractere;
                }
            }
            resultat = nouveauResultat;
        }
        return resultat;
    }

    public void addRule(char symbol, String replacement) {
        rules.put(symbol, replacement);
    }

    public String getAxiom() {
        return axiom;
    }

    public void setAxiom(String axiom) {
        this.axiom = axiom;
    }

    public Map<Character, String> getRules() {
        return rules;
    }

    public void setRules(Map<Character, String> rules) {
        this.rules = rules;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

}
