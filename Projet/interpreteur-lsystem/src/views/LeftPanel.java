/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import models.system.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author ANTOINE
 */
public class LeftPanel extends JPanel implements ActionListener {

    private String axiomeString;
    private String angleString;
    private String reglesString;
    private String nombreIterationsString;
    private String longueurString;
    private String submitString;
    private String resetString;
    private int widthJTextField;
    private int heightJtextField;

    private static final int WIDTH_JTEXTFIELD = 310;
    private static final int HEIGHT_JTEXTFIELD = 30;

    private JLabel labelAxiome;
    private JLabel labelAngle;
    private JLabel labelRegles;
    private JLabel labelNombreIterations;
    private JLabel labelLongueur;

    private JTextField txtAxiome;
    private JTextField txtAngle;
    private JTextArea txtRegles;
    private JTextField txtNombreIterations;
    private JTextField txtLongueur;

    private JButton btnSubmit;
    private JButton btnReset;

    JPanel panelForm;
    JPanel panelContents;
    JPanel btnGroupPanel;
    GridBagConstraints gbc;

    LSystem reglesProd = new LSystem();
    Parser parser;

    public LeftPanel() {
        this("Axiome:", "Angle:", "Règles:", "Itération(s):", "Longueur:", "Dessiner", "Reinitialiser", WIDTH_JTEXTFIELD, HEIGHT_JTEXTFIELD);
    }

    public LeftPanel(String axiomeString, String angleString, String reglesString, String nombreIterationsString, String longueurString, String submitString, String resetString, int widthJTextField, int heightJtextField) {

        /*DEBUT INITIALISATION*/
        // Initialisation des variables
        this.axiomeString = axiomeString;
        this.angleString = angleString;
        this.reglesString = reglesString;
        this.nombreIterationsString = nombreIterationsString;
        this.longueurString = longueurString;
        this.submitString = submitString;
        this.resetString = resetString;
        this.widthJTextField = widthJTextField;
        this.heightJtextField = heightJtextField;

        // Initialisation des JPanels
        this.panelForm = new JPanel();
        this.panelContents = new JPanel();
        this.btnGroupPanel = new JPanel();

        // Ajout..............
        this.panelForm.setLayout(new BorderLayout());
        this.panelContents.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        // Initialisation des JLabels
        this.labelAxiome = new JLabel(this.axiomeString);
        this.labelAngle = new JLabel(this.angleString);
        this.labelRegles = new JLabel(this.reglesString);
        this.labelNombreIterations = new JLabel(this.nombreIterationsString);
        this.labelLongueur = new JLabel(this.longueurString);

        // Initialisation des JTextFields et modification de leurs dimensions.
        this.txtAxiome = new JTextField();
        this.txtAxiome.setPreferredSize(new Dimension(this.widthJTextField, this.heightJtextField));
        this.txtAngle = new JTextField();
        this.txtAngle.setPreferredSize(new Dimension(this.widthJTextField, this.heightJtextField));
        this.txtRegles = new JTextArea();
        this.txtRegles.setPreferredSize(new Dimension(this.widthJTextField, 50));
        this.txtNombreIterations = new JTextField();
        this.txtNombreIterations.setPreferredSize(new Dimension(this.widthJTextField, this.heightJtextField));
        this.txtLongueur = new JTextField();
        this.txtLongueur.setPreferredSize(new Dimension(this.widthJTextField, this.heightJtextField));

        // Initialisation des JButtons
        this.btnSubmit = new JButton(this.submitString);
        this.btnReset = new JButton(this.resetString);

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
        panelContents.add(this.labelAxiome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelContents.add(this.labelAngle, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelContents.add(this.labelRegles, gbc);
        this.txtRegles.setBorder(BorderFactory.createLineBorder(Color.gray));

        gbc.gridx = 0;
        gbc.gridy = 4;
        panelContents.add(this.labelNombreIterations, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panelContents.add(this.labelLongueur, gbc);

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

        // Ajout des evenements(actions) aux boutons
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
        } else if (event.getSource().equals(this.btnSubmit)) {
            String chaineAxiome=this.txtAxiome.getText();
            String chaineAngle = this.txtAngle.getText();
            parser=new Parser(chaineAxiome,chaineAngle);
            if(parser.isValid()) {
                reglesProd.setDeveloppement(this.txtAxiome.getText());
                reglesProd.setAngle(Double.parseDouble(this.txtAngle.getText()));
            } else if (!parser.islexical()){
                JOptionPane.showMessageDialog(null,"Caractère employé non authorisé","Axiome",JOptionPane.ERROR_MESSAGE);
            } else if (!parser.isSyntaxic()) {
                JOptionPane.showMessageDialog(null, "Synthaxe incorrecte","Axiome", JOptionPane.ERROR_MESSAGE);
            } else if (!parser.isAngleCorrect()){
                JOptionPane.showMessageDialog(null, "Angle saisi incorrect", "Angle", JOptionPane.ERROR_MESSAGE);
            } else if (!parser.isValid()){
                JOptionPane.showMessageDialog(null, "Synthaxe incorrecte", "Global", JOptionPane.ERROR_MESSAGE);
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
