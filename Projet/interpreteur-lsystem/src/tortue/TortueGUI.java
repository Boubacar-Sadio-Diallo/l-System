package tortue;

import alphabet.LSystem;

import javax.swing.*;
import java.awt.*;

public class TortueGUI extends JFrame {
    /*private static final int WIDTH = 400;
    private static final int HEIGHT = 400;*/
    private LSystem modele;
    private Vue vue;
    public TortueGUI(LSystem modele){
        super("dessin");
        this.modele=modele;
        this.vue=new Vue(this.modele);
        this.add(this.vue, BorderLayout.CENTER);
        JButton suivant = new JButton("Génération suivante");
        this.add(suivant, BorderLayout.NORTH);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
