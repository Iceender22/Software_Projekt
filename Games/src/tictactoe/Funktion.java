package tictactoe;

public class Funktion {

	public static void reset() {
		
		for(int i = 0; i < GUI.state.length; i++) {
			
			// Alle Felder zurücksetzen
			GUI.state[i] = 0;
		}

		// Keine Spieler beim Start
		GUI.player = 0;
		// Keinen Gewinner beim Start
		GUI.gewinner = 0;
	}
}
