/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package l.system.project;

import fr.system.models.ReglesDeProduction;
import fr.system.views.LeftPanel;
import fr.system.views.RightPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ANTOINE
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel conteneur = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        panelGauche.setBackground(Color.WHITE);
        
        conteneur.add(new LeftPanel());
        conteneur.add(new RightPanel());
        frame.add(conteneur);
               
        createJFrame(frame, "lindenmayer system - project", 850, 600);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle("Convertisseur".toUpperCase());
//        frame.setLocationRelativeTo(null);
//        frame.setSize(1366, 768);
//        frame.setVisible(true);
//        Map<String, String> regles = new HashMap<>();
//        regles.put("A", "AB");
//        regles.put("B", "A");
//
//        ReglesDeProduction lsystem = new ReglesDeProduction("A", regles);
//        System.out.println(lsystem.afficher(30));
    }

    private static void createJFrame(JFrame frame, String title, int minimumSizeWidth, int minimumSizeHeight) {

        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(minimumSizeWidth, minimumSizeHeight));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle(title.toUpperCase());

    }

}
