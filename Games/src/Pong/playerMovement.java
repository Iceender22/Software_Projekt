package Pong;

import java.util.Timer;
import java.util.TimerTask;

public class playerMovement {

	Timer timer;
	
	public playerMovement() {
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				// Player 1
				if (variablen.moveup == true) {
					
					if (variablen.p1y >= 20) {
						
						variablen.p1y -= 2;
					}
				} else if (variablen.movedown == true) {
					
					if (variablen.p1y <= variablen.screenheight - 200) {
						
						variablen.p1y += 2;
					}
				}
				
				// Player 2
				if (variablen.moveup2 == true) {
					
					if (variablen.p2y >= 20) {
						
						variablen.p2y -= 2;
					}
				} else if (variablen.movedown2 == true) {
					
					if (variablen.p2y <= variablen.screenheight - 200) {
						
						variablen.p2y += 2;
					}
				}
			}
		// Aktualisierungsrate
		}, 0, 6);
	}

}
