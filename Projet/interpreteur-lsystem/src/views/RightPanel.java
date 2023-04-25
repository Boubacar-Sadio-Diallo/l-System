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
 *
 * @author ANTOINE
 */
public class RightPanel extends JLabel {
    private LSystem lSystem;
    public RightPanel(LSystem lSystem) {
        this.lSystem=lSystem;


        /*JLabel label = new JLabel("Mon panneau droit");
        this.add(label);*/

        //this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(1200, 950));
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        
    }
    protected void paintComponent(Graphics g2d) {
        super.paintComponent(g2d);
//        g2d.setColor(Color.black);
        StringBuilder plusAgreable= new StringBuilder();
        int i = 0;
        int j=0;
        for (char c: lSystem.developpementEnString().toCharArray()) {
            plusAgreable.append(c);
            if(i%150==0 && i>1){
                g2d.drawString(String.valueOf(plusAgreable),10,10+j);
                plusAgreable =new StringBuilder();
                j+=10;
            }
            i++;
        }

        Tortue tortue = new Tortue(g2d);
        tortue.setPosition(new Point(getWidth()/2,getHeight()/2, tortue.getAngle()));
        lSystem.dessiner(tortue);
        //Graphics2D g2d = (Graphics2D) g;

        //tortue.setPosition(new Point(200,800,0));

        /*for(Symbole s:lSystem.getDeveloppement()){
            s.seDessiner(tortue);
        }*/
    }


}


