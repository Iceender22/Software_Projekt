package tictactoe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Draw extends JLabel{

	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponents(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		/*
		 * Beschreibung: Gitter Zeichnen
		 * 
		 */
		
		// Gitter Farbe
		g.setColor(Color.BLACK);
		
		// Vertikale Linien
		g.drawLine(325, 50, 325, 500);
		g.drawLine(475, 50, 475, 500);
		
		// Horizontale Linien
		g.drawLine(175, 200, 625, 200);
		g.drawLine(175, 350, 625, 350);
		
		// Spieler Anzeigen
		g.setColor(Color.BLACK);
		
		// Welcher Spieler ist an der Reihe
		if(GUI.player == 0) {
			
			g.drawString("Spieler 1: X", 25, 50);
		} else if(GUI.player == 1) {
			
			g.drawString("Spieler 2: O", 25, 50);
		}
		
		// Draw Gewinner
		if(GUI.gewinner == 1) {
			
			g.drawString("Gewinner ist Spieler 1: X", 25, 100);
		} else if(GUI.gewinner == 2) {
			
			g.drawString("Gewinner ist Spieler 2: O", 25, 100);
		}
		
		/*
		 * Beschreibung: Buttons zeichnen X oder O
		 *
		 */
		
		// Button 0
		if(GUI.state[0] == 1) {
			
			g.drawImage(ImageLoader.imgX, 175, 50, 150, 150, null);
		} else if(GUI.state[0] == 2) {
			
			g.drawImage(ImageLoader.imgO, 175, 50, 150, 150, null);
		}
		
		// Button 1
		if(GUI.state[1] == 1) {
					
			g.drawImage(ImageLoader.imgX, 325, 50, 150, 150, null);
		} else if(GUI.state[1] == 2) {
					
			g.drawImage(ImageLoader.imgO, 325, 50, 150, 150, null);
		}
		
		// Button 2
		if(GUI.state[2] == 1) {
			
			g.drawImage(ImageLoader.imgX, 475, 50, 150, 150, null);
		} else if(GUI.state[2] == 2) {
			
			g.drawImage(ImageLoader.imgO, 475, 50, 150, 150, null);
		}
		
		// Button 3
		if(GUI.state[3] == 1) {
			
			g.drawImage(ImageLoader.imgX, 175, 200, 150, 150, null);
		} else if(GUI.state[3] == 2) {
			
			g.drawImage(ImageLoader.imgO, 175, 200, 150, 150, null);
		}
		
		// Button 4
		if(GUI.state[4] == 1) {
			
			g.drawImage(ImageLoader.imgX, 325, 200, 150, 150, null);
		} else if(GUI.state[4] == 2) {
			
			g.drawImage(ImageLoader.imgO, 325, 200, 150, 150, null);
		}
		
		// Button 5
		if(GUI.state[5] == 1) {
			
			g.drawImage(ImageLoader.imgX, 475, 200, 150, 150, null);
		} else if(GUI.state[5] == 2) {
			
			g.drawImage(ImageLoader.imgO, 475, 200, 150, 150, null);
		}
		
		// Button 6
		if(GUI.state[6] == 1) {
			
			g.drawImage(ImageLoader.imgX, 175, 350, 150, 150, null);
		} else if(GUI.state[6] == 2) {
			
			g.drawImage(ImageLoader.imgO, 175, 350, 150, 150, null);
		}
		
		// Button 7
		if(GUI.state[7] == 1) {
			
			g.drawImage(ImageLoader.imgX, 325, 350, 150, 150, null);
		} else if(GUI.state[7] == 2) {
			
			g.drawImage(ImageLoader.imgO, 325, 350, 150, 150, null);
		}
		
		// Button 8
		if(GUI.state[8] == 1) {
			
			g.drawImage(ImageLoader.imgX, 475, 350, 150, 150, null);
		} else if(GUI.state[8] == 2) {
			
			g.drawImage(ImageLoader.imgO, 475, 350, 150, 150, null);
		}
		
		// Aktualisieren
		repaint();
	}
}
