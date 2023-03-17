
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class LSystem extends JPanel {

    private static final long serialVersionUID = 1L;
    private Map<Character, String> rules;
    private String axiom;
    private int len;
    private double angle;
    private String sentence;
    private List<AffineTransform> stack = new ArrayList<>();
    private int width = 400;
    private int height = 400;

    public LSystem() {
        this.axiom = "F";
        this.len = 100;
        this.angle = Math.toRadians(25);
        this.sentence = axiom;
        this.stack = new ArrayList<>();
        this.rules = new HashMap<>();
        rules.put('F', "FF+[+F-F-F]-[-F+F+F]");
        initComponents();
        JFrame frame = new JFrame("L-System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.BLACK);
        g2d.translate(width / 2, height);
        turtle(g2d);
    }

    private void generate() {
        len *= 0.5;
        StringBuilder nextSentence = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char current = sentence.charAt(i);
            boolean found = false;
            for (Map.Entry<Character, String> entry : rules.entrySet()) {
                if (current == entry.getKey()) {
                    found = true;
                    nextSentence.append(entry.getValue());
                    break;
                }
            }
            if (!found) {
                nextSentence.append(current);
            }
        }
        sentence = nextSentence.toString();
        repaint();
    }

    private void turtle(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(1));
        AffineTransform oldTransform = g2d.getTransform();
        for (int i = 0; i < sentence.length(); i++) {
            char current = sentence.charAt(i);
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

    private void initComponents() {
        JButton generateButton = new JButton("Generer");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generate();
            }
        });
        add(generateButton);
    }

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main(String[] args) {
        new LSystem();
    }
}
