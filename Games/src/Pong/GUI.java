package Pong;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import HomeScreen.MainHome;


public class GUI {

	JFrame fenster;
	JButton reset, home;
	Draw draw;
	
	public GUI() {
		
		fenster = new JFrame();
		fenster.setSize(800, 725);
		fenster.setTitle("Pong");
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setLayout(null);
		fenster.setLocationRelativeTo(null);
		fenster.setResizable(false);
		
		fenster.addKeyListener(new ActionHandler());
		// Fenster nach Tastatur eingabe immernoch im Fokus
		fenster.requestFocus();
		
		// Spielfeld
		draw = new Draw();
		draw.setBounds(0, 0, 800, 575);
		draw.setVisible(true);
		
		// Spiel neu starten
		reset = new JButton("Reset");
		reset.setBounds(550, 600, 100, 40);
		reset.setVisible(true);
		reset.setBackground(new Color(51, 102, 153));
		reset.setForeground(Color.WHITE);
		reset.setFocusPainted(false);
		reset.addActionListener(new ActionListener() {
									
			@Override
			public void actionPerformed(ActionEvent e) {
										
				// eigenes Event Handling
				fenster.dispose();
				new GUI();
			}
		});
								
		home = new JButton("Home");
		home.setBounds(675, 600, 100, 40);
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
				
		fenster.add(draw);
		//fenster.add(reset);
		//fenster.add(home);
				
		fenster.setVisible(true);
	}
}
