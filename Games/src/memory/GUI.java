package memory;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {

	JFrame fenster;
	JPanel panel;
	JButton reset, home;
	
	JButton[] karten;
	
	public GUI() {
	
		fenster = new JFrame();
		fenster.setSize(800, 600);
		fenster.setTitle("Memory");
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setLocationRelativeTo(null);
		fenster.setResizable(false);
		
		karten = new JButton[64];
		for (int i = 0; i < 64; i++) {
			karten[i] = new JButton();
			karten[i].addActionListener(new ButtonListener(karten));
		}
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(8, 8));
		for (JButton button : karten) {
			panel.add(button);
		}
		
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
				fenster.dispose();
				new GUI();
			}
		});
						
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

		panel.setVisible(true);
		
		fenster.add(panel);
		//panel.add(reset);
		//panel.add(home);
		
		fenster.setVisible(true);
	}
}
