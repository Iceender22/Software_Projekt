package Sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuAction implements ActionListener{

	View view;
	
	public void initialise(View view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "reset") {
			this.view.reset();
		}
		else if(e.getActionCommand() == "home") {
			this.view.home();
		}
		
	}
	
}
