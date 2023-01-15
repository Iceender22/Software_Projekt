package game;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/* 
 *  TODO:
 *  TODO:
 */

public class boardSnake extends JPanel implements ActionListener {

	// Board Breite
	private final int b_width = 300;
	// Board H�he
	private final int b_height = 300;
	// Gr��e der Frucht und der Segmente der Schlange
	private final int dot_size = 10;
	// Max Anzahl Punkte auf Board - (H�he * Breite)/(Dot_size * Dot_size)
	private final int max_dots = 900;
	// Position der Frucht
	private final int rand_pos = 49;
	// Game speed - Schwierigkeitsgrade evtl
	private final int delay = 140;

	// x Koordinaten Pos. Snake
	private final int x[] = new int[max_dots];
	// y Koordinaten Pos. Snake
	private final int y[] = new int[max_dots];
	
	// L�nge der Snake
	private int dots;
	// Koordinaten der Frucht
	private int frucht_x;
	private int frucht_y;
	
	// Bewegung
	private boolean up = false;
	private boolean right = true;
	private boolean down = false;
	private boolean left = false;
	
	// Spiel start
	private boolean inGame = true;
	
	// Bild Kopf
	private Image kopf;
	// Bild K�rper Punkte
	private Image punkt;
	// Bild Frucht
	private Image frucht;
	// Timer?
	private Timer timer;
	
	// Bilder f�r das Spiel
	private void loadImages() {
		
		// Kopf der Snake
		ImageIcon iik = new ImageIcon("src/resources/kopf.png");
		kopf = iik.getImage();
		// K�rper der Snake
		ImageIcon iip = new ImageIcon("src/resources/k�rper.png");
		punkt = iip.getImage();
		// Frucht
		ImageIcon iif = new ImageIcon("src/resources/frucht.png");
		frucht = iif.getImage();
	}
	
	// Erstellung Snake, Spielfeld und Frucht (Start Timer)
	private void stratGame() {
		
		// Start L�nge der Snake
		dots = 3;
		
		//
		for (int z = 0; z < dots; z++) {
			x[z] = 50 - z * 10;
			y[z] = 50;
		}
		
		// Methode zur Random Pos. der Frucht
		locateFruit();
		
		//Timer starten?
		timer = new Timer(delay, this);
		timer.start();
	}
	
	// Methode zur Random Pos. der Frucht
	private void locateFruit() {
		
	}
	
	// Essen der Frucht und wachsen der Snake
	private void eatFruit() {
		
		// Pos. der Frucht mit Pos. Kopf abgleichen
		if ((x[0] == frucht_x) && (y[0] == frucht_y)) {
			
			// K�rper w�chst
			dots++;
			// neue Frucht spawnen
			locateFruit();
		}
	}
	
	// Bewegung der Snake
	private void move() {
		
		// Bei Bewegung vor, L�nge -1; L�nge K�rper bleibt so konst.
		for (int z = dots; z > 0; z--) {
			
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}
		
		// Bewegungs Richtung
		if (up) {
			
			y[0] -= dot_size;
		}
		
		if (right) {
			
			x[0] += dot_size;
		}
		
		if (down) {
			
			y[0] += dot_size;
		}
		
		if(left) {
		
			x[0] -= dot_size;
		}
	}
}
