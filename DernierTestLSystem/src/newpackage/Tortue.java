/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author ANTOINE
 */
import newpackage.LSystemGenerator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Tortue extends JPanel {

    private double x;
    private double y;
    private double angle;
    private Graphics2D g2d;

    public Tortue() {
        x = 0;
        y = 0;
        angle = 0;
        JFrame frame = new JFrame("Tortue");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        g2d.translate(centerX, centerY);
        Map<Character, String> regles = new HashMap<>();
        regles.put('F', "F[-F][+F]F[-F][+F]F");
        LSystemGenerator lsg = new LSystemGenerator("F", regles, 5);
        String instructions = lsg.generate(10);
        setAngle(25);
//        drawTree(instructions, 100, 45);
    }

    public void drawLine(double x1, double y1, double x2, double y2) {
        g2d.draw(new Line2D.Double(x1, y1, x2, y2));
    }

    public void move(double distance) {
        double newX = x + distance * Math.cos(Math.toRadians(angle));
        double newY = y + distance * Math.sin(Math.toRadians(angle));
        drawLine(x, y, newX, newY);
        x = newX;
        y = newY;
    }

    public void turn(double angle) {
        this.angle += angle;
    }

    public void setColor(Color color) {
        g2d.setColor(color);
    }

    /*public void drawTree(String instructions, double distance, double angle) {
    Stack<Branch> stack = new Stack<>();
    Branch current = new Branch(x, y, angle, null);

    for (char c : instructions.toCharArray()) {
        switch (c) {
            case 'F':
                if (current.getParent != null && !current.grown) {
                    current.grown = true;
                    current.endX = x + distance * Math.cos(Math.toRadians(angle));
                    current.endY = y + distance * Math.sin(Math.toRadians(angle));
                    drawLine(current.startX, current.startY, current.endX, current.endY);
                    current = new Branch(current.endX, current.endY, angle, current);
                }
                else {
                    move(distance);
                }
                break;
            case '+':
                turn(angle);
                break;
            case '-':
                turn(-angle);
                break;
            case '[':
                stack.push(current);
                break;
            case ']':
                current = stack.pop();
                break;
            default:
                break;
        }
    }
}*/


    public void setAngle(double angle) {
        this.angle = angle;
    }

    public static void main(String[] args) {
        Tortue tortue = new Tortue();
    }
}

