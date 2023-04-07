/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author ANTOINE
 */
public class RightPanel extends JLabel {

    public RightPanel() {
        
        
        JLabel label = new JLabel("Mon panneau droit");
        this.add(label);
        
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(1200, 1000));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
    }

}
