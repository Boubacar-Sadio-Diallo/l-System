/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import models.system.LSystem;
import tortue.Point;
import tortue.Tortue;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

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
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Tortue tortue= new Tortue(g2d);
        tortue.setPosition(new Point(200,200));
        lSystem.dessiner(tortue);
    }

}
