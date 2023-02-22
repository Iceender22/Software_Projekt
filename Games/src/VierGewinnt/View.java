package VierGewinnt;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class View extends JFrame implements ActionListener{

	int turn;
	Random random = new Random();
	JLabel titel; 
	JPanel game;
	JLabel[][] field = new JLabel[6][6];
	JButton[] placeChip = new JButton[6];
	
	public void initialise() {
		
		turn = random.nextInt(2);
	    setTitle("Vier Gewinnt");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
	    setLocationRelativeTo(null);                         
	    setSize(1200, 600);
	    
	    addComponents();     

	    setVisible(true); 
	}
	
	private void addComponents() {
		game = new JPanel();
		game.setLayout(new BorderLayout());
		
		JPanel pTitel = new JPanel();
		titel = new JLabel("Vier Gewinnt");
		if(turn == 0) {
			titel.setText("Spieler 1 ist dran");
		}
		else {
			titel.setText("Spieler 2 ist dran");
		}
		titel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
		
		pTitel.add(titel);
		
		JPanel board = new JPanel();
		board.setLayout(new GridLayout(7,6));
		
		addBoard(board);
		
		game.add(BorderLayout.NORTH, pTitel);
		game.add(BorderLayout.CENTER, board);
		
		this.add(game);
	}
	
	private void addBoard(JPanel parent) {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				field[i][j] = new JLabel(" ");
				field[i][j].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
				field[i][j].setBorder(new LineBorder(Color.black));
				field[i][j].setHorizontalAlignment(JLabel.CENTER);
				parent.add(field[i][j]);
			}
		}
		for(int i = 0; i < 6; i++) {
			placeChip[i] = new JButton("/\\");
			placeChip[i].addActionListener(this);
			parent.add(placeChip[i]);
		}
	}
	
	private void check(int i, int j) {
		int checkX = 0;
		int checkO = 0;
		for(int k = 0; k < 6; k++) {
			if( field[k][j].getText() == "X") {
				if(checkO > 0) {
					checkX = 0;
				}
				checkX++;
				if(checkX > 3) {
					System.out.println("Vertikal gewonnen!");
					redWin();
					return;
				}
			}
			else if(field[k][j].getText() == "O") {
				if(checkX > 0 || field[k][j].getText() == " ") {
					checkO = 0;
				}
				checkO++;
				if(checkO > 3) {
					System.out.println("Vertikal gewonnen!");
					yellowWin();
					return;
				}
			}
			else{
				checkX = 0;
				checkO = 0;
			}
		}
		checkO = 0;
		checkX = 0;
		for(int k = 0; k < 6; k++) {
			if( field[i][k].getText() == "X") {
				if(checkO > 0) {
					checkX = 0;
				}
				checkX++;
				if(checkX > 3) {
					System.out.println("Horizontal gewonnen!");
					redWin();
					return;
				}
			}
			else if(field[i][k].getText() == "O") {
				if(checkX > 0 || field[i][k].getText() == " ") {
					checkO = 0;
				}
				checkO++;
				if(checkO > 3) {
					System.out.println("Horizontal gewonnen!");
					yellowWin();
					return;
				}
			}
			else{
				checkX = 0;
				checkO = 0;
			}
		}
		int i2 = i;
		int j2 = j;
		while(i2 < 5 && j2 > 0) {
			i2++;
			j2--;
		}
		checkO = 0;
		checkX = 0;
		System.out.println("I2 ist: " + i2 + " , J2 ist: " + j2);
		while(i2 > 0 && j2 < 6) {
			if( field[i2][j2].getText() == "X") {
				if(checkO > 0) {
					checkX = 0;
				}
				checkX++;
				if(checkX > 3) {
					System.out.println("Horizontal gewonnen!");
					redWin();
					return;
				}
			}
			else if(field[i2][j2].getText() == "O") {
				if(checkX > 0) {
					checkO = 0;
				}
				checkO++;
				if(checkO > 3) {
					System.out.println("Horizontal gewonnen!");
					yellowWin();
					return;
				}
			}
			else{
				checkX = 0;
				checkO = 0;
			}
			i2--;
			j2++;
		}
		i2 = i;
		j2 = j;
		while(i2 > 0 && j2 > 0) {
			i2--;
			j2--;
		}
		checkO = 0;
		checkX = 0;
		System.out.println("I2 ist: " + i2 + " , J2 ist: " + j2);
		while(i2 < 6 && j2 < 6) {
			if( field[i2][j2].getText() == "X") {
				if(checkO > 0) {
					checkX = 0;
				}
				checkX++;
				if(checkX > 3) {
					System.out.println("Horizontal gewonnen!");
					redWin();
					return;
				}
			}
			else if(field[i2][j2].getText() == "O") {
				if(checkX > 0) {
					checkO = 0;
				}
				checkO++;
				if(checkO > 3 ) {
					System.out.println("Horizontal gewonnen!");
					yellowWin();
					return;
				}
			}
			else{
				checkX = 0;
				checkO = 0;
			}
			i2++;
			j2++;
		}
		int checkTie = 0;
		for(int k = 0; k < 6; k++) {
			for(int l = 0; l < 6; l++) {
				if( field[k][l].getText() != " ") {
					checkTie++;
				}
			}
		}
		if(checkTie == 36) {
			int answer = JOptionPane.showConfirmDialog(this, "Unentschieden! Möchtet ihr noch eine Runde spielen?", null, JOptionPane.YES_NO_OPTION);
			if(answer == 0)
			{
				reset();
			}
			else if(answer == 1){
				this.setTitle("Fenster schließen");;
			}
		}
	}
	
	private void yellowWin() {
		int answer = JOptionPane.showConfirmDialog(this, "Spieler 2 hat gewonnen! Möchtet ihr noch eine Runde spielen?", null, JOptionPane.YES_NO_OPTION);
		if(answer == 0)
		{
			reset();
		}
		else if(answer == 1){
			this.setTitle("Fenster schließen");;
		}
	}
	
	private void redWin() {
		int answer = JOptionPane.showConfirmDialog(this, "Spieler 1 hat gewonnen! Möchtet ihr noch eine Runde spielen?", null, JOptionPane.YES_NO_OPTION);
		if(answer == 0)
		{
			reset();
		}
		else if(answer == 1){
			this.setTitle("Fenster schließen");;
		}
	}
	
	private void reset() {
		this.remove(game);
		initialise();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		for(int i = 0; i < 6; i++) {
			if(event.getSource() == placeChip[i]) {
				if( turn == 0) {
					for(int j = 5; j >= 0;j--) {
						if( field[j][i].getText() == " ") {
							System.out.println("I ist: " + i + " , J ist: " + j);
							field[j][i].setText("O");
							field[j][i].setForeground(Color.yellow);
							turn = 1;
							titel.setText("Spieler 2 ist dran");
							check(j, i);
							break;
						}
					}				
				}
				else {
					for(int j = 5; j >= 0;j--) {
						if( field[j][i].getText() == " ") {
							System.out.println("I ist: " + i + " , J ist: " + j);
							field[j][i].setText("X");
							field[j][i].setForeground(Color.red);
							turn = 0;
							titel.setText("Spieler 1 ist dran");
							check(j, i);
							break;
						}
					}	
				}
			}
		}	
	}
}
