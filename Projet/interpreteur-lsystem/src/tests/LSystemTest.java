package tests;

import models.alphabet.*;
import models.system.LSystem;
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
        assertEquals(axiome,lSystem.nextGeneration(1));

        lSystem=new LSystem();
        lSystem.setDeveloppement("F");
        lSystem.changerRegleSymbole('F','f');
        assertNotEquals(axiome,lSystem.nextGeneration(1));
        axiome= new LinkedList<>();
        axiome.add(new Symbole('f'));
        assertEquals(axiome,lSystem.nextGeneration(1));

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
        axiome.add(lSystem.getRegles().get('F'));
        for (int i = 0; i <11 ; i++) {
            axiome.add(lSystem.getRegles().get('f'));
        }
        assertEquals(axiome,lSystem.nextGeneration(11));




    }

    @Test
    void affecterNextGenToDev() {
        LSystem lSystem = new LSystem();
        lSystem.setDeveloppement("F");
        lSystem.affecterNextGenToDev(1);
        assertEquals(1,lSystem.getNiveauGeneration());
        LinkedList<Symbole> axiome = new LinkedList<>();
        axiome.add(lSystem.getRegles().get('F'));
        assertEquals(axiome,lSystem.getDeveloppement());

        lSystem=new LSystem();
        lSystem.setDeveloppement("F");
        lSystem.ajoutRegleSymbole('F','f');
        lSystem.affecterNextGenToDev(11);
        assertNotEquals(axiome,lSystem.getDeveloppement());
        axiome=new LinkedList<>();
        axiome.add(lSystem.getRegles().get('F'));
        for (int i = 0; i <11 ; i++) {
            axiome.add(lSystem.getRegles().get('f'));
        }
        assertEquals(axiome,lSystem.getDeveloppement());


    }



    @Test
    void setDeveloppement() {
        LSystem lSystem = new LSystem();
        lSystem.setDeveloppement("F");
        LinkedList<Symbole> test = new LinkedList<>();
        test.add(lSystem.getRegles().get('F'));
        assertEquals(test,lSystem.getDeveloppement());
        lSystem = new LSystem();
        test=new LinkedList<>();
        String stringTest="Test+|-&Ff";
        lSystem.setDeveloppement(stringTest);
        char[] stringTestCharTab= stringTest.toCharArray();
        for(char c : stringTestCharTab){
            test.add(lSystem.getRegles().get(c));
        }
        assertEquals(test,lSystem.getDeveloppement());
    }


    @Test
    void developpementEnString() {
        LSystem lSystem = new LSystem();
        LinkedList<Symbole> axiome = new LinkedList<>();
        axiome.add(lSystem.getRegles().get('F'));
        lSystem.setDeveloppement(axiome);
        assertEquals("F",lSystem.developpementEnString());
        axiome.add(lSystem.getRegles().get('f'));
        axiome.add(lSystem.getRegles().get('-'));
        lSystem.setDeveloppement(axiome);
        assertEquals("Ff-",lSystem.developpementEnString());

    }

    @Test
    void stringEnLinkedList() {
        LSystem lSystem = new LSystem();
        String string = "Ff+-|&<>^";
        LinkedList<Symbole> test=new LinkedList<>();
        char[] stringCharTab= string.toCharArray();
        for(char c : stringCharTab){
            test.add(lSystem.getRegles().get(c));
        }
        assertEquals(test,lSystem.stringEnLinkedList(string));
        string="ABCabc";
        test=new LinkedList<>();
        stringCharTab= string.toCharArray();
        for(char c : stringCharTab){
            test.add(new Symbole(c));
        }
        assertEquals(test,lSystem.stringEnLinkedList(string));

    }



}