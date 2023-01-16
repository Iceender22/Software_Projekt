package tictactoe;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI {

	JFrame fenster;
	Draw draw;
	JButton reset;
	
	static JButton btn[] = new JButton[9];
	static int state[] = new int [9];
	static int player = 0;
	static int gewinner = 0;
	
	public GUI() {
		
		// Fenster erstellen
		fenster = new JFrame();
		fenster.setSize(800, 600);
		fenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenster.setLocationRelativeTo(null);
		fenster.setResizable(false);
		fenster.setTitle("Tic Tac Toe");
		
		// Button sind Felder, ) Stück in Schleife generieren
		for(int i = 0; i < btn.length; i++) {
			
			btn[i] = new JButton();
			btn[i].setVisible(true);
			btn[i].addActionListener(new ActionHandler());
			// Button unsichtbar
			btn[i].setFocusPainted(false);
			// Inhalt unsichtbar
			btn[i].setContentAreaFilled(false);
			// Keine Umrandung
			btn[i].setBorder(null);
			
			fenster.add(btn[i]);
		}
		
		ButtonPlatzierung.btnPlace();
		
		// Spiel neu starten
		reset = new JButton();
		reset.setBounds(675, 500, 100, 40);
		reset.setVisible(true);
		reset.setBackground(new Color(51, 102, 153));
		reset.setForeground(Color.WHITE);
		reset.setFocusPainted(false);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// eigenes Event Handling
				Funktion.reset();
			}
		});
		
		// Objekt zum Zeichnen erstellen
		draw = new Draw();
		draw.setBounds(0, 0, 800, 600);
		draw.setVisible(true);
		
		fenster.add(reset);
		fenster.add(draw);
		
		fenster.setVisible(true);
	}

}
