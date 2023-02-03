package Pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ActionHandler implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_W) {
		
			variablen.moveup = true;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			
			variablen.movedown = true;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			
			variablen.moveup2 = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			variablen.movedown2 = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_W) {
			
			variablen.moveup = false;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			
			variablen.movedown = false;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			
			variablen.moveup2 = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			variablen.movedown2 = false;
		}
	}

}
