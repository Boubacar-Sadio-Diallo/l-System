/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import models.system.LSystem;
import tortue.Point;
import tortue.Tortue;

import javax.swing.*;
import java.awt.*;

/**
 * Partie graphique de dessin
 * @author ANTOINE
 */
public class RightPanel extends JLabel {
    private LSystem lSystem;
    public RightPanel(LSystem lSystem) {
        this.lSystem=lSystem;

        this.setPreferredSize(new Dimension(1000, 950));
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        
    }
    protected void paintComponent(Graphics g2d) {
        super.paintComponent(g2d);

        g2d.setColor(Color.black);
        Tortue tortue = new Tortue(g2d);
        tortue.setPosition(new Point(getWidth()/2,getHeight()/2, tortue.getAngle()));
        lSystem.dessiner(tortue);

    }


}


