package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Draw extends JLabel{
	
	static int p1points = 0, p2points = 0;
	static int ballx = 200, bally = 300;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, variablen.screenwidth, variablen.screenheight);
		
		g.setColor(Color.WHITE);
		
		for (int i = 0; i <= 30; i++) {
			
			g.fillRect(variablen.screenwidth / 2 - 5, i * 20, 10, 10);
		}
		
		g.fillRect(variablen.p1x, variablen.p1y, 25, 150);
		g.fillRect(variablen.p2x, variablen.p2y, 25, 150);
		
		g.setFont(variablen.font);
		g.drawString("" + p1points, variablen.screenwidth / 2 - 95, 75);
		g.drawString("" + p2points, variablen.screenwidth / 2 + 50, 75);
		
		g.fillRect(ballx, bally, 20, 20);
		
		repaint();
	}
}
