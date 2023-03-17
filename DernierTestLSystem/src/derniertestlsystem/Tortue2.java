/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derniertestlsystem;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author ANTOINE
 */
public class Tortue2 extends JPanel {

    private int len;
    private double angle;
//    private Model model;
    private List<AffineTransform> stack = new ArrayList<>();

    public Tortue2() {
        this.len = 100;
        this.angle = Math.toRadians(25);
        this.stack = new ArrayList<>();
//        this.model = new Model();
    }

//    public Tortue2(int len, double angle, Model model) {
//        this.len = len;
//        this.angle = angle;
//        this.model = model;
//        this.stack = new ArrayList<>();
//    }
    

    public void turtle(Graphics2D g2d, String axiome) {
        g2d.setStroke(new BasicStroke(1));
        AffineTransform oldTransform = g2d.getTransform();
        for (int i = 0; i < axiome.length(); i++) {
            char current = axiome.charAt(i);
            switch (current) {
                case 'F':
                    g2d.drawLine(0, 0, 0, -len);
                    g2d.translate(0, -len);
                    break;
                case '+':
                    g2d.rotate(angle);
                    break;
                case '-':
                    g2d.rotate(-angle);
                    break;
                case '[':
                    stack.add(g2d.getTransform());
                    break;
                case ']':
                    g2d.setTransform(stack.remove(stack.size() - 1));
                    break;
                default:
                    break;
            }
        }
        g2d.setTransform(oldTransform);
    }

}
