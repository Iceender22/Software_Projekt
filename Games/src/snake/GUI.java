package snake;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI {

	JFrame fenster;
	JButton home, reset;
	
	static int state = 0;
	
	public GUI() {
		
		fenster = new JFrame();
		fenster.setSize(800, 600);
		fenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenster.setLocationRelativeTo(null);
		fenster.setResizable(false);
		fenster.setLayout(new FlowLayout());
		fenster.setTitle("Snake");
		
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

		fenster.add(new snakeBoard());
		fenster.add(reset);
		fenster.add(home);
		
		
		fenster.setVisible(true);
	}
}
