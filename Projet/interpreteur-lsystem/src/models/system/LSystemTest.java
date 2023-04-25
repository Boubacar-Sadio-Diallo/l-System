package models.system;

import models.alphabet.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LSystemTest  {



    @Test
    void setAngle()  {
        LSystem lSystem = new LSystem();
        lSystem.setAngle(80);
        assertEquals(80,lSystem.getAngle());
        TournerSensHoraire tsh = (TournerSensHoraire) lSystem.getRegles().get('-');
        assertEquals(80,tsh.getValeur());
        TournerSensTrigo tst = (TournerSensTrigo) lSystem.getRegles().get('+');
        assertEquals(-80,tst.getValeur());

    }


    @Test
    void ajoutSymbole(){
        LSystem lSystem=new LSystem();
        lSystem.ajoutSymbole('h');
        assertTrue(lSystem.getRegles().containsKey('h'));
        assertEquals('h',lSystem.getRegles().get('h').getRepresentation());
        LinkedList<Symbole> linkedList=new LinkedList<>();
        linkedList.add(lSystem.getRegles().get('h'));
        assertEquals(linkedList,lSystem.getRegles().get('h').getEvolution());
    }

    @Test
    void changerRegleSymbole() {
        LSystem lSystem=new LSystem();
        LinkedList<Symbole> linkedList=new LinkedList<>();
        linkedList.add(lSystem.getRegles().get('-'));
        lSystem.changerRegleSymbole('+','-');
        assertEquals(linkedList,lSystem.getRegles().get('+').getEvolution());
        linkedList=new LinkedList<>();
        linkedList.add(new Symbole('T'));
        lSystem.changerRegleSymbole('+','T');
        assertEquals(linkedList,lSystem.getRegles().get('+').getEvolution());
    }

    @Test
    void ajoutRegleSymbole() {
        LSystem lSystem=new LSystem();
        LinkedList<Symbole> linkedList=new LinkedList<>();
        linkedList.add(lSystem.getRegles().get('+'));
        linkedList.add(lSystem.getRegles().get('-'));
        lSystem.ajoutRegleSymbole('+','-');
        assertEquals(linkedList,lSystem.getRegles().get('+').getEvolution());
        linkedList.add(new Symbole('T'));
        lSystem.ajoutRegleSymbole('+','T');
        assertEquals(linkedList,lSystem.getRegles().get('+').getEvolution());
    }

    @Test
    void nextGeneration() {
        LSystem lSystem = new LSystem();
        lSystem.setDeveloppement("F");
        LinkedList<Symbole> axiome= lSystem.getDeveloppement();
        assertEquals(axiome,lSystem.nextGeneration());

        lSystem=new LSystem();
        lSystem.setDeveloppement("F");
        lSystem.changerRegleSymbole('F','f');
        assertNotEquals(axiome,lSystem.nextGeneration());
        axiome= new LinkedList<>();
        axiome.add(new Symbole('f'));
        assertEquals(axiome,lSystem.nextGeneration());

        lSystem=new LSystem();
        lSystem.setDeveloppement("F");
        axiome= lSystem.getDeveloppement();
        assertEquals(axiome,lSystem.nextGeneration(11));
        assertEquals(axiome,lSystem.nextGeneration(22));

        lSystem=new LSystem();
        lSystem.setDeveloppement("F");
        lSystem.ajoutRegleSymbole('F','f');
        assertNotEquals(axiome,lSystem.nextGeneration(11));
        assertNotEquals(axiome,lSystem.nextGeneration(22));
        axiome=new LinkedList<>();
        DessinerAvancer s = new DessinerAvancer('F');
        s.addEvolution(new Avancer('f'));
        axiome.add(s);
        for (int i = 0; i <11 ; i++) {
            axiome.add(new Symbole('f'));
        }
        String repAxiome="";
        for (Symbole symbole : axiome){
            repAxiome+=symbole.getRepresentation();
        }
        String repNext="";
        for (Symbole symbole : lSystem.nextGeneration(11)){
            repNext+=symbole.getRepresentation();
        }
        assertEquals(repAxiome,repNext);




    }

    @Test
    void affecterNextGenToDev() {
    }


    @Test
    void affecterRepresenter() {
    }


    @Test
    void dessiner() {
    }

    @Test
    void setDeveloppement() {
    }


    @Test
    void developpementEnString() {
    }

    @Test
    void stringEnLinkedList() {
    }

    @Test
    void repEtSuivant() {
    }

}