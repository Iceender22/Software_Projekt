package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/* 
 *  TODO:
 *  TODO:
 */

public class snakeBoard extends JPanel implements ActionListener {

	// Board Breite
	private final int b_width = 300;
	// Board Höhe
	private final int b_height = 300;
	// Größe der Frucht und der Segmente der Schlange
	private final int dot_size = 10;
	// Max Anzahl Punkte auf Board - (Höhe * Breite)/(Dot_size * Dot_size)
	private final int max_dots = 900;
	// Position der Frucht
	private final int rand_pos = 29;
	// Game speed - Schwierigkeitsgrade evtl
	private final int delay = 140;

	// x Koordinaten Pos. Snake
	private final int x[] = new int[max_dots];
	// y Koordinaten Pos. Snake
	private final int y[] = new int[max_dots];

	// Länge der Snake
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
	// Bild Körper Punkte
	private Image punkt;
	// Bild Frucht
	private Image frucht;
	// Timer für Tickspeed
	private Timer timer;

	// Board laden
	public snakeBoard() {

		initBoard();
	}

	// Erstelle Board
	public void initBoard() {

		// Tastatur eingabe tracken
		addKeyListener(new TAdapter());
		setBackground(Color.BLACK);
		//set
		setFocusable(true);

		// Größe Board
		setPreferredSize(new Dimension(b_width, b_height));
		loadImages();
		startGame();
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		doDrawing(g);
	}

	// Drawing Methode
	public void doDrawing(Graphics g) {

		// Im Spiel
		if (inGame) {

			// Spawne Frucht
			g.drawImage(frucht, frucht_x, frucht_y, this);

			// Spawnen der Schlange
			for (int i = 0; i < dots; i++) {

				// Nur einen Kopf Spawnen
				// Sonst Körper verlängern
				if (i == 0) {

					g.drawImage(kopf, x[i], y[i], this);
				} else {

					g.drawImage(punkt, x[i], y[i], this);
				}
			}

			Toolkit.getDefaultToolkit().sync();
		} else {

			gameOver(g);
		}
	}

	// Bilder für das Spiel
	private void loadImages() {

		// Kopf der Snake
		ImageIcon iik = new ImageIcon("res/kopf.png");
		kopf = iik.getImage();
		// Körper der Snake
		ImageIcon iip = new ImageIcon("res/körper.png");
		punkt = iip.getImage();
		// Frucht
		ImageIcon iif = new ImageIcon("res/frucht.png");
		frucht = iif.getImage();
	}

	// Erstellung Snake, Spielfeld und Frucht (Start Timer)
	private void startGame() {

		// Start Länge der Snake
		dots = 3;

		//
		for (int z = 0; z < dots; z++) {
			x[z] = 50 - z * 10;
			y[z] = 50;
		}

		// Methode zur Random Pos. der Frucht
		locateFruit();

		// Timer starten?
		timer = new Timer(delay, this);
		timer.start();
	}

	// Methode zur Random Pos. der Frucht
	private void locateFruit() {

		// Position für X Koordinate
		int r = (int) (Math.random() * rand_pos);
		frucht_x = ((r * dot_size));

		// Position für Y Koordinate
		r = (int) (Math.random() * rand_pos);
		frucht_y = ((r * dot_size));
	}

	// Essen der Frucht und wachsen der Snake
	private void eatFruit() {

		// Pos. der Frucht mit Pos. Kopf abgleichen
		if ((x[0] == frucht_x) && (y[0] == frucht_y)) {

			// Körper wächst
			dots++;
			// neue Frucht spawnen
			locateFruit();
		}
	}

	// Bewegung der Snake
	private void move() {

		// Bei Bewegung vor, Länge -1; Länge Körper bleibt so konst.
		for (int i = dots; i > 0; i--) {

			x[i] = x[(i - 1)];
			y[i] = y[(i - 1)];
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

		if (left) {

			x[0] -= dot_size;
		}
	}

	// Kollision mit Körper = Game Over
	public void kollision() {

		for (int i = dots; i > 0; i--) {

			/*
			 * Beschreibung: Erst ab Körperlänge 4 möglich das Schlange sich frisst
			 * Beschreibung: Position Kopf (x,y) mit einem Punkt des Körpers (x[i],y[i])
			 * vergleichen
			 */
			if ((i > 4) && (x[0] == x[i] && (y[0] == y[i]))) {

				inGame = false;
			}
		}

		// Game Endet wenn Board Rand getroffen wird
		if (y[0] >= b_width) {

			inGame = false;
		}
		if (y[0] < 0) {

			inGame = false;
		}
		if (x[0] >= b_width) {

			inGame = false;
		}
		if (x[0] < 0) {

			inGame = false;
		}

		// Timer stoppen
		if (!inGame) {

			timer.stop();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (inGame) {

			eatFruit();
			kollision();
			move();
		}
		
		repaint();
	}

	// Game Over Screen
	public void gameOver(Graphics g) {

		String msg = "Game Over!";
		// String anpassen
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);

		g.setColor(Color.WHITE);
		g.setFont(small);
		g.drawString(msg, (b_width - metr.stringWidth(msg)) / 2, b_height / 2);
	}

	// Key Listener selbst beschreiben
	private class TAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			// Linke Pfeiltaste gedrückt
			if ((key == KeyEvent.VK_LEFT) && (!right)) {

				left = true;
				up = false;
				down = false;
			}
			// Rechtee Pfeiltaste gedrückt
			if ((key == KeyEvent.VK_RIGHT) && (!left)) {

				right = true;
				up = false;
				down = false;
			}
			// Hoch Pfeiltaste gedrückt
			if ((key == KeyEvent.VK_UP) && (!down)) {

				up = true;
				right = false;
				left = false;
			}
			// Runter Pfeiltaste gedrückt
			if ((key == KeyEvent.VK_DOWN) && (!up)) {

				down = true;
				right = false;
				left = false;
			}
		}
	}
}
