package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*
		 * Beschreibung: Event Handling der Buttons wenn es noch keinen Gewinner gibt
		 * Beschreibung: Wechsel der Spieler nach jeden Zug
		 * Beschreibung: Zeichen setzen je nach Spieler
		 * 
		 */
		
		if(GUI.gewinner == 0) {
			
			// Button 0
			if(e.getSource() == GUI.btn[0]) {
				
				if(GUI.state[0] == 0 && GUI.player == 0) {
					
					GUI.state[0] = 1;
					GUI.player = 1;
				} else if(GUI.state[0] == 0 && GUI.player == 1) {
					
					GUI.state[0] = 2;
					GUI.player = 0;
				}
				
			// Button 1
			} else if(e.getSource() == GUI.btn[1]) {
				
				if(GUI.state[1] == 0 && GUI.player == 0) {
					
					GUI.state[1] = 1;
					GUI.player = 1;
				} else if(GUI.state[1] == 0 && GUI.player == 1) {
					
					GUI.state[1] = 2;
					GUI.player = 0;
				}
				
			// Button 2
			} else if(e.getSource() == GUI.btn[2]) {
				
				if(GUI.state[2] == 0 && GUI.player == 0) {
					
					GUI.state[2] = 1;
					GUI.player = 1;
				} else if(GUI.state[2] == 0 && GUI.player == 1) {
					
					GUI.state[2] = 2;
					GUI.player = 0;
				}
				
			// Button 3
			} else if(e.getSource() == GUI.btn[3]) {
				
				if(GUI.state[3] == 0 && GUI.player == 0) {
					
					GUI.state[3] = 1;
					GUI.player = 1;
				} else if(GUI.state[3] == 0 && GUI.player == 1) {
					
					GUI.state[3] = 2;
					GUI.player = 0;
				}
				
			// Button 4
			} else if(e.getSource() == GUI.btn[4]) {
				
				if(GUI.state[4] == 0 && GUI.player == 0) {
					
					GUI.state[4] = 1;
					GUI.player = 1;
				} else if(GUI.state[4] == 0 && GUI.player == 1) {
					
					GUI.state[4] = 2;
					GUI.player = 0;
				}
				
			// Button 5
			} else if(e.getSource() == GUI.btn[5]) {
				
				if(GUI.state[5] == 0 && GUI.player == 0) {
					
					GUI.state[5] = 1;
					GUI.player = 1;
				} else if(GUI.state[5] == 0 && GUI.player == 1) {
					
					GUI.state[5] = 2;
					GUI.player = 0;
				}
				
			// Button 6
			} else if(e.getSource() == GUI.btn[6]) {
				
				if(GUI.state[6] == 0 && GUI.player == 0) {
					
					GUI.state[6] = 1;
					GUI.player = 1;
				} else if(GUI.state[6] == 0 && GUI.player == 1) {
					
					GUI.state[6] = 2;
					GUI.player = 0;
				}
				
			// Button 7
			} else if(e.getSource() == GUI.btn[7]) {
				
				if(GUI.state[7] == 0 && GUI.player == 0) {
					
					GUI.state[7] = 1;
					GUI.player = 1;
				} else if(GUI.state[7] == 0 && GUI.player == 1) {
					
					GUI.state[7] = 2;
					GUI.player = 0;
				}
				
			// Button 8
			} else if(e.getSource() == GUI.btn[8]) {
				
				if(GUI.state[8] == 0 && GUI.player == 0) {
					
					GUI.state[8] = 1;
					GUI.player = 1;
				} else if(GUI.state[8] == 0 && GUI.player == 1) {
					
					GUI.state[8] = 2;
					GUI.player = 0;
				}
			}
		}
	}
}
