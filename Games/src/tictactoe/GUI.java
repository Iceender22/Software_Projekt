package tictactoe;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI {

	JFrame fenster;
	Draw draw;
	JButton reset, home;
	
	static JButton btn[] = new JButton[9];
	static int state[] = new int [9];
	static int player = 0;
	static int gewinner = 0;
	
	public GUI() {
		
		// Fenster erstellen
		fenster = new JFrame();
		fenster.setSize(800, 600);
		// TODO: Beim Closen über X soll Homescreen sich öffnen
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		reset = new JButton("Reset");
		reset.setBounds(550, 500, 100, 40);
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
		
		// Zurück zum Homescreen
		home = new JButton("Home");
		home.setBounds(675, 500, 100, 40);
		home.setVisible(true);
		home.setBackground(Color.RED);
		home.setForeground(Color.WHITE);
		home.setFocusPainted(false);
		home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// eigenes Event Handling
				fenster.dispose();
				new HomeScreen.GUI();
			}
		});
		
		// Objekt zum Zeichnen erstellen
		draw = new Draw();
		draw.setBounds(0, 0, 800, 600);
		draw.setVisible(true);
		
		fenster.add(reset);
		fenster.add(home);
		fenster.add(draw);
		
		fenster.setVisible(true);
	}

}
