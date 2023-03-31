/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author antoine222
 */
public class ExamplePanel extends JPanel {

    private String exemple1String;
    private String exemple2String;
    private String exemple3String;
    private String exemple4String;
    private String exemple5String;
    private String exemple6String;

    private JPanel formPanel;
    private JButton exemple1;
    private JButton exemple2;
    private JButton exemple3;
    private JButton exemple4;
    private JButton exemple5;
    private JButton exemple6;

    public ExamplePanel() {
        this("Exemple1", "Exemple2", "Exemple3", "Exemple4", "Exemple5", "Exemple6");
    }

    public ExamplePanel(String exemple1String, String exemple2String, String exemple3String, String exemple4String, String exemple5String, String exemple6String) {
        this.exemple1String = exemple1String;
        this.exemple2String = exemple2String;
        this.exemple3String = exemple3String;
        this.exemple4String = exemple4String;
        this.exemple5String = exemple5String;
        this.exemple6String = exemple6String;
        
         formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "lindenmayer system".toUpperCase(),
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 22),
                Color.BLUE));

    }

}
