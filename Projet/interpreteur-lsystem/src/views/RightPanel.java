/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import models.alphabet.Symbole;
import models.system.LSystem;
import tortue.Point;
import tortue.Tortue;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.util.Queue;

/**
 *
 * @author ANTOINE
 */
public class RightPanel extends JLabel {
    private LSystem lSystem;
    public RightPanel(LSystem lSystem) {
        this.lSystem=lSystem;
        
        JLabel label = new JLabel("Mon panneau droit");
        this.add(label);
        
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(1200, 1000));
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Tortue tortue = new Tortue(g2d);
        //tortue.setPosition(new Point(200,800,0));
        lSystem.dessiner(tortue);
        /*for(Symbole s:lSystem.getDeveloppement()){
            s.seDessiner(tortue);
        }*/
    }


}


