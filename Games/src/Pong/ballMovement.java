package Pong;

import java.util.Timer;
import java.util.TimerTask;

public class ballMovement {

	Timer timer;
	
	public ballMovement() {
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				Draw.ballx += variablen.balldirx;
				Draw.bally += variablen.balldiry;
			}
		}, 0, 4);
	}

}
