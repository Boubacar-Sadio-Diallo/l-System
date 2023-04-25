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

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String exemple1String;
    @SuppressWarnings("unused")
	private String exemple2String;
    @SuppressWarnings("unused")
	private String exemple3String;
    @SuppressWarnings("unused")
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
        this.setExemple5String(exemple5String);
        this.setExemple6String(exemple6String);
        
         formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "lindenmayer system".toUpperCase(),
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 22),
                Color.BLUE));

    }

	public String getExemple6String() {
		return exemple6String;
	}

	public void setExemple6String(String exemple6String) {
		this.exemple6String = exemple6String;
	}

	public String getExemple5String() {
		return exemple5String;
	}

	public void setExemple5String(String exemple5String) {
		this.exemple5String = exemple5String;
	}

	public JButton getExemple1() {
		return exemple1;
	}

	public void setExemple1(JButton exemple1) {
		this.exemple1 = exemple1;
	}

	public JButton getExemple2() {
		return exemple2;
	}

	public void setExemple2(JButton exemple2) {
		this.exemple2 = exemple2;
	}

	public JButton getExemple3() {
		return exemple3;
	}

	public void setExemple3(JButton exemple3) {
		this.exemple3 = exemple3;
	}

	public JButton getExemple4() {
		return exemple4;
	}

	public void setExemple4(JButton exemple4) {
		this.exemple4 = exemple4;
	}

	public JButton getExemple5() {
		return exemple5;
	}

	public void setExemple5(JButton exemple5) {
		this.exemple5 = exemple5;
	}

	public JButton getExemple6() {
		return exemple6;
	}

	public void setExemple6(JButton exemple6) {
		this.exemple6 = exemple6;
	}

}

