package Pong;

import java.util.Timer;
import java.util.TimerTask;

public class collision {

	Timer timer;
	
	public collision() {
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				// Oberer Rand
				if (Draw.bally + 50 >= variablen.screenheight) {
					
					variablen.balldiry = -1;
				}
				
				// Unterer Rand
				if (Draw.bally <= 0) {
					
					variablen.balldiry = 1;
				}
				
				// Tor rechts
				if (Draw.ballx + 20 >= variablen.screenwidth) {
					
					// Ball zur Mitte weil Tor
					Draw.ballx = variablen.screenwidth / 2 - 10;
					Draw.bally = variablen.screenheight / 2 - 10;
					
					// Richtung Ball ändern
					variablen.balldirx = -1;
					Draw.p1points += 1;
				}
				
				// Tor links
				if (Draw.ballx <= 0) {
					
					// Ball zur Mitte weil Tor
					Draw.ballx = variablen.screenwidth / 2 - 10;
					Draw.bally = variablen.screenheight / 2 - 10;
					
					// Richtung Ball ändern
					variablen.balldirx = 1;
					Draw.p2points += 1;
				}
				
				// Player 1 Collision
				if (Draw.ballx < variablen.p1x + 25 && Draw.ballx > variablen.p1x && Draw.bally - 20 <= variablen.p1y + 150 && Draw.bally >= variablen.p1y) {
					
					variablen.balldirx = 1;
				}
				
				// Player 2 Collision
				if (Draw.ballx < variablen.p2x && Draw.ballx > variablen.p2x - 20 && Draw.bally - 20 <= variablen.p2y + 150 && Draw.bally >= variablen.p2y) {
					
					variablen.balldirx = -1;
				}
			}
		}, 0, 4);
	}

}
