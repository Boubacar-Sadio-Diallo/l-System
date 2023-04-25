/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package execution;

import models.system.LSystem;
import views.PrincipalViewGUI;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author ANTOINE
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("unused")
	public static void main(String[] args) {
        LSystem lSystem=new LSystem();
        PrincipalViewGUI principalView =new PrincipalViewGUI(lSystem);
              
        
        
    }

    @SuppressWarnings("unused")
	private static void createJFrame(JFrame frame, String title, int minimumSizeWidth, int minimumSizeHeight) {

        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(minimumSizeWidth, minimumSizeHeight));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle(title.toUpperCase());

    }

}

