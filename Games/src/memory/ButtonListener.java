package memory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener {
    
	private JButton[] button;

    public ButtonListener(JButton[] karten) {
        this.button = karten;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Spiel-Verhalten hinzugefügen, wenn der Button geklickt wird
    	System.out.println("Button geklickt: ");
    }
}
