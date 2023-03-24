package tortue;

import alphabet.LSystem;

import javax.swing.*;
import java.awt.*;

public class Vue extends JPanel {
    private static final int WIDTH=400;
    private static final int HEIGHT=400;
    private LSystem modele;
    public Vue(LSystem modele){
        this.modele=modele;
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }
    public Vue(){
        this(new LSystem());
    }

    public void paintContent(Graphics2D g2d){
        super.paintComponent(g2d);
    }
}
