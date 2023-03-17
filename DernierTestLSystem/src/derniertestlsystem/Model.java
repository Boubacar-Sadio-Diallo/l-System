/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derniertestlsystem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ANTOINE
 */
public class Model {

    private String axiome;
    private Map<Character, String> regles;

    public Model() {
        this("F", new HashMap<>());
    }

    public Model(String axiome, Map<Character, String> regles) {
        this.axiome = axiome;
        this.regles = regles;
    }
    
    public void addRegle(Character axiome, String remplacement){
        this.regles.put(axiome, remplacement);
    }

    public String getAxiome() {
        return axiome;
    }

    public void setAxiome(String axiome) {
        this.axiome = axiome;
    }

    public Map<Character, String> getRegles() {
        return regles;
    }

    public void setRegles(Map<Character, String> regles) {
        this.regles = regles;
    }

}
