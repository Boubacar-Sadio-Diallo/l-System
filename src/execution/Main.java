/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package execution;

import models.system.LSystem;
import views.PrincipalViewGUI;


/**
 *
 * @author ANTOINE
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LSystem lSystem=new LSystem();
        new PrincipalViewGUI(lSystem);

    }



}
