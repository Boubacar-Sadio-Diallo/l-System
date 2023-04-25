/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import models.alphabet.Symbole;
import models.system.LSystem;
import models.system.Parser;
import tortue.Point;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**
 *
 * @author ANTOINE
 */
public class LeftPanel extends JPanel implements ActionListener {

    private static final int WIDTH_EDITFIELD = 310;
    private static final int HEIGHT_EDITFIELD = 30;

    private final JTextField txtAxiome;
    private final JTextField txtAngle;
    private final JTextArea txtRegles;
    private final JTextField txtNombreIterations;
    private final JTextField txtLongueur;

    private final JButton btnSubmit;
    private final JButton btnReset;

    JPanel panelForm;
    JPanel panelContents;
    JPanel btnGroupPanel;
    GridBagConstraints gbc;

    private LSystem lsystem;
    //Parser parser;

    public LeftPanel(LSystem lsystem) {
        this("Axiome:", "Angle:", "Règles:", "Itération(s):", "Longueur:", "Dessiner", "Reinitialiser", WIDTH_EDITFIELD, HEIGHT_EDITFIELD, lsystem);
    }

    public LeftPanel(String axiomeString, String angleString, String reglesString, String nombreIterationsString, String longueurString, String submitString, String resetString, int widthJTextField, int heightJtextField,LSystem lsystem) {
        /*DEBUT INITIALISATION*/
        // Initialisation des variables
        this.lsystem=lsystem;

        // Initialisation des JPanels
        this.panelForm = new JPanel();
        this.panelContents = new JPanel();
        this.btnGroupPanel = new JPanel();

        // Ajout..............
        this.panelForm.setLayout(new BorderLayout());
        this.panelContents.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        // Initialisation des JLabels
        JLabel labelAxiome = new JLabel(axiomeString);
        JLabel labelAngle = new JLabel(angleString);
        JLabel labelRegles = new JLabel(reglesString);
        JLabel labelNombreIterations = new JLabel(nombreIterationsString);
        JLabel labelLongueur = new JLabel(longueurString);

        // Initialisation des JTextFields et modification de leurs dimensions.
        this.txtAxiome = new JTextField(null);
        this.txtAxiome.setPreferredSize(new Dimension(widthJTextField, heightJtextField));
        this.txtAngle = new JTextField(null);
        this.txtAngle.setPreferredSize(new Dimension(widthJTextField, heightJtextField));
        this.txtRegles = new JTextArea("");
        this.txtRegles.setPreferredSize(new Dimension(widthJTextField, 150));
        this.txtNombreIterations = new JTextField(null);
        this.txtNombreIterations.setPreferredSize(new Dimension(widthJTextField, heightJtextField));
        this.txtLongueur = new JTextField(null);
        this.txtLongueur.setPreferredSize(new Dimension(widthJTextField, heightJtextField));

        // Initialisation des JButtons
        this.btnSubmit = new JButton(submitString);
        this.btnReset = new JButton(resetString);

        this.btnSubmit.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnSubmit.doClick();
                }
            }
        });

        /* FIN INITIALISATION */
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Ajout des JLabels dans le panelContents
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelContents.add(labelAxiome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelContents.add(labelAngle, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelContents.add(labelRegles, gbc);
        this.txtRegles.setBorder(BorderFactory.createLineBorder(Color.gray));

        gbc.gridx = 0;
        gbc.gridy = 4;
        panelContents.add(labelNombreIterations, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panelContents.add(labelLongueur, gbc);

        // Ajout des JTextFields dans le panelContents
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelContents.add(this.txtAxiome, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panelContents.add(this.txtAngle, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panelContents.add(this.txtRegles, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panelContents.add(this.txtNombreIterations, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panelContents.add(this.txtLongueur, gbc);

        // Ajout des événements (actions) aux boutons
        this.btnSubmit.addActionListener(this);
        this.btnReset.addActionListener(this);

        // Ajout des deux dans le btnGroupPanel (ce panel regroupe les deux boutons sur une seule ligne)
        this.btnGroupPanel.add(btnSubmit);
        this.btnGroupPanel.add(btnReset);

        // Ajout du btnGroupPanel qui contient les deux boutons dans le panelContents
        gbc.gridx = 1;
        gbc.gridy = 6;
        panelContents.add(this.btnGroupPanel, gbc);

        // Je fais un espace top de 30pixels du btnGroupPanel par rapport au panelContents
        btnGroupPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        panelForm.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "lindenmayer system".toUpperCase(),
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 22),
                Color.BLUE));
        panelForm.setPreferredSize(new Dimension(500, 1000));

        panelContents.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
//        panelContents.setBorder(BorderFactory.createLineBorder(Color.RED));

        panelForm.add(this.panelContents, BorderLayout.PAGE_START);
        this.add(panelForm);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(this.btnReset)) {
            this.resetJTextField();
            this.lsystem.setDeveloppement(new LinkedList<Symbole>());
        } else if (event.getSource().equals(this.btnSubmit)) {
            String chaineAxiome=this.txtAxiome.getText();
            String chaineAngle = this.txtAngle.getText();
            String chaineLongueur = this.txtLongueur.getText();
            String chaineIteration = this.txtNombreIterations.getText();
            String chaineRules=this.txtRegles.getText();
            Parser parser=new Parser(chaineAxiome,chaineAngle,chaineLongueur,chaineIteration,chaineRules);

            if(parser.isValid()) {
                this.lsystem.setNiveauGeneration(0);
                this.lsystem.setDeveloppement(this.txtAxiome.getText());
                this.lsystem.setAngle(Double.parseDouble(this.txtAngle.getText()));
                this.lsystem.setLongueur(Integer.parseInt(this.txtLongueur.getText()));
                String[] chaqueRegle= chaineRules.split("\n");
                for(String a : chaqueRegle){
                        if(a.length()!=0){
                            this.lsystem.changerRegleSymbole(a.charAt(0),a.charAt(2));
                        }
                        if(a.length()>3){
                            for(int i=3;i<a.length();i++) {
                                this.lsystem.ajoutRegleSymbole(a.charAt(0), a.charAt(i));
                            }
                        }
                }
//                this.lsystem.setPosDep(new Point(getWidth(),getWidth(),0));
                //System.out.println(this.lsystem.representationRegles());
                this.lsystem.repEtSuivant(Integer.parseInt(chaineIteration));
                StringSelection textToCopy=new StringSelection(this.lsystem.developpementEnString());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(textToCopy,null);
                JOptionPane.showMessageDialog(null,"Copié !","Nouvel axiome disponible",JOptionPane.INFORMATION_MESSAGE);




            } else if (!parser.islexical()){
                JOptionPane.showMessageDialog(null,"Caractère employé non authorisé","Axiome",JOptionPane.ERROR_MESSAGE);
            } else if (!parser.isSyntaxic()) {
                JOptionPane.showMessageDialog(null, "Synthaxe incorrecte","Axiome", JOptionPane.ERROR_MESSAGE);
            } else if (!parser.isAngleCorrect()){
                JOptionPane.showMessageDialog(null, "Angle saisi incorrect", "Angle", JOptionPane.ERROR_MESSAGE);
            } else if (!parser.isLongueurCorrect()){
                JOptionPane.showMessageDialog(null, "Longueur saisie incorrecte", "Longueur", JOptionPane.ERROR_MESSAGE);
            }else if (!parser.isIterationCorrect()){
                JOptionPane.showMessageDialog(null, "Itération saisie incorrecte", "Itération", JOptionPane.ERROR_MESSAGE);
            }else if (!parser.isRulesValid()){
            JOptionPane.showMessageDialog(null, "Règles saisies incorrectement", "Règles", JOptionPane.ERROR_MESSAGE);
            }else if (!parser.isValid()){
                JOptionPane.showMessageDialog(null, "Erreur", "Global", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    // Cette methode permet de reinitialiser les champs
    private void resetJTextField() {
        this.txtAxiome.setText(null);
        this.txtAngle.setText(null);
        this.txtRegles.setText(null);
        this.txtNombreIterations.setText(null);
        this.txtLongueur.setText(null);
    }

}
