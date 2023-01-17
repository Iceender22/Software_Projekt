package tictactoe;

import java.util.Timer;
import java.util.TimerTask;

public class Winner {

	Timer timer;
	
	public Winner() {
	
		// Timer für regelmäßige Kontrollen
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				
				if(GUI.gewinner == 0) {
					
					/*
					 * Beschreibung: Prüfen ob Spieler 1 gewinnt
					 * 
					 */
					
					// Reihe 1 Horizontal
					if(GUI.state[0] == 1 && GUI.state[1] == 1 && GUI.state[2] == 1) {
						
						GUI.gewinner = 1;
					
					// Reihe 2 Horizontal
					} else if(GUI.state[3] == 1 && GUI.state[4] == 1 && GUI.state[5] == 1) {
						
						GUI.gewinner = 1;
						
					// Reihe 3 Horizontal
					} else if(GUI.state[6] == 1 && GUI.state[7] == 1 && GUI.state[8] == 1) {
						
						GUI.gewinner = 1;
						
					// Reihe 1 Vertikal
					} else if(GUI.state[0] == 1 && GUI.state[3] == 1 && GUI.state[6] == 1) {
						
						GUI.gewinner = 1;
						
					// Reihe 2 Vertikal
					} else if(GUI.state[1] == 1 && GUI.state[4] == 1 && GUI.state[7] == 1) {
						
						GUI.gewinner = 1;
						
					// Reihe 3 Vertikal
					} else if(GUI.state[2] == 1 && GUI.state[5] == 1 && GUI.state[8] == 1) {
						
						GUI.gewinner = 1;
						
					// Diagonal o. Links -> u. Rechts
					} else if(GUI.state[0] == 1 && GUI.state[4] == 1 && GUI.state[8] == 1) {
						
						GUI.gewinner = 1;
						
					// Diagonal u. Links -> o. Rechts
					} else if(GUI.state[6] == 1 && GUI.state[4] == 1 && GUI.state[2] == 1) {
						
						GUI.gewinner = 1;
					}
					
					////////////////////////////////////////////////////////////////////////
					
					/*
					 * Beschreibung: Prüfen ob Spieler 2 gewinnt
					 * 
					 */
					
					// Reihe 1 Horizontal
					if(GUI.state[0] == 2 && GUI.state[1] == 2 && GUI.state[2] == 2) {
						
						GUI.gewinner = 2;
					
					// Reihe 2 Horizontal
					} else if(GUI.state[3] == 2 && GUI.state[4] == 2 && GUI.state[5] == 2) {
						
						GUI.gewinner = 2;
						
					// Reihe 3 Horizontal
					} else if(GUI.state[6] == 2 && GUI.state[7] == 2 && GUI.state[8] == 2) {
						
						GUI.gewinner = 2;
						
					// Reihe 1 Vertikal
					} else if(GUI.state[0] == 2 && GUI.state[3] == 2 && GUI.state[6] == 2) {
						
						GUI.gewinner = 2;
						
					// Reihe 2 Vertikal
					} else if(GUI.state[1] == 2 && GUI.state[4] == 2 && GUI.state[7] == 2) {
						
						GUI.gewinner = 2;
						
					// Reihe 3 Vertikal
					} else if(GUI.state[2] == 2 && GUI.state[5] == 2 && GUI.state[8] == 2) {
						
						GUI.gewinner = 2;
						
					// Diagonal o. Links -> u. Rechts
					} else if(GUI.state[0] == 2 && GUI.state[4] == 2 && GUI.state[8] == 2) {
						
						GUI.gewinner = 2;
						
					// Diagonal u. Links -> o. Rechts
					} else if(GUI.state[6] == 2 && GUI.state[4] == 2 && GUI.state[2] == 2) {
						
						GUI.gewinner = 2;
					}
				}
			}
		}, 0, 150);
	}

}
