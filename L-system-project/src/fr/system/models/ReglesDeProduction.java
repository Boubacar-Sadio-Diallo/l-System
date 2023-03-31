/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.system.models;

import java.util.Map;

/**
 *
 * @author ANTOINE
 */
public class ReglesDeProduction {

    private String axiome;
    private Map<String, String> regles;

    public ReglesDeProduction() {
        super();
    }
    

    public ReglesDeProduction(String axiome, Map<String, String> regles) {
        this.axiome = axiome;
        this.regles = regles;
    }

    public String generer(int nombreIterations) {
        String resultat = this.getAxiome();
        for (int i = 0; i < nombreIterations; i++) {
            String nouveauResultat = "";
            for (int j = 0; j < resultat.length(); j++) {
                String caractere = String.valueOf(resultat.charAt(j));
                String regle = this.getRegles().get(caractere);
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

    public String afficher(int nombreGenerations) {
        int i = 0;
        String result = "";
        while (i < nombreGenerations) {
            result += "Génération " + i + " : " + generer(i) + "\n";
            i += 1;
        }
        return result;
    }
    
   

    public String getAxiome() {
        return axiome;
    }

    public void setAxiome(String axiome) {
        this.axiome = axiome;
    }

    public Map<String, String> getRegles() {
        return regles;
    }

    public void setRegles(Map<String, String> regles) {
        this.regles = regles;
    }

    @Override
    public String toString() {
        return this.axiome + "" + this.regles;
    }

}
