package VierGewinnt;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
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
		
		
	    setTitle("Vier Gewinnt");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
	    setLocationRelativeTo(null);                         
	    setSize(1200, 600);
	    setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    
	    addComponents();     

	    setVisible(true); 
	}
	
	private void addComponents() {
		turn = random.nextInt(2);
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
		board.setBackground(Color.blue);
		board.setBorder(new EtchedBorder());
		addBoard(board);
		
		JPanel east = new JPanel();		 
		east.setPreferredSize(new Dimension(100, 500));
		JPanel west = new JPanel();
		west.setLayout(new FlowLayout());
		west.setPreferredSize(new Dimension(100, 500));
		JPanel placeButtons = new JPanel();
		placeButtons.setLayout(new GridLayout(1,6));
		placeButtons.setPreferredSize(new Dimension(1200, 50));
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(2,1));
		south.setPreferredSize(new Dimension(500, 100));
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		JButton reset = new JButton();
		reset.setBackground(Color.red);
		reset.setText("von vorne Beginnen");
		reset.setHorizontalAlignment(JLabel.CENTER);
		reset.addActionListener(this);
		reset.setActionCommand("reset");
		reset.setFocusable(false);
		reset.setForeground(Color.black);
		reset.setPreferredSize(new Dimension(200, 40));
		JButton home = new JButton();
		home.setBackground(Color.blue);
		home.setText("zurück zum Hauptmenü");
		home.setHorizontalAlignment(JLabel.CENTER);
		home.addActionListener(this);
		home.setActionCommand("home");
		home.setFocusable(false);
		home.setForeground(Color.black);
		home.setPreferredSize(new Dimension(200, 40));
		buttons.add(reset);
		buttons.add(home);
		south.add(placeButtons);
		south.add(buttons);
		for(int i = 0; i < 6; i++) {
			placeChip[i] = new JButton("/\\");
			placeChip[i].addActionListener(this);	
			placeChip[i].setFocusable(false);
			placeChip[i].setBackground(Color.orange);
			board.add(placeChip[i]);
		}	
		game.add(BorderLayout.NORTH, pTitel);
		game.add(BorderLayout.WEST, west);
		game.add(BorderLayout.CENTER, board);
		game.add(BorderLayout.EAST, east);
		game.add(BorderLayout.SOUTH, south);
		
		this.add(game);
	}
	
	private void addBoard(JPanel parent) {
		ImageIcon image = new ImageIcon("./src/fields.png");
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				field[i][j] = new JLabel(" ");
				field[i][j].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
				field[i][j].setBorder(new LineBorder(Color.blue));				
				field[i][j].setIcon(image);
				parent.add(field[i][j]);
			}
		}
	}
	
	private void check(int i, int j) {
		int checkX = 0;
		int checkO = 0;
		for(int k = 0; k < 6; k++) {
			if( field[k][j].getText() == "X") {
				checkO = 0;
				checkX++;
				if(checkX > 3) {
					System.out.println("Vertikal gewonnen!");
					redWin();
					return;
				}
			}
			else if(field[k][j].getText() == "O") {
				checkX = 0;
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
				checkO = 0;
				checkX++;
				if(checkX > 3) {
					System.out.println("Horizontal gewonnen!");
					redWin();
					return;
				}
			}
			else if(field[i][k].getText() == "O") {
				checkX = 0;
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
		while(i2 > -1 && j2 < 6) {
			if( field[i2][j2].getText() == "X") {
				checkO = 0;
				checkX++;
				if(checkX > 3) {
					System.out.println("Horizontal gewonnen!");
					redWin();
					return;
				}
			}
			else if(field[i2][j2].getText() == "O") {
				checkX = 0;
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
		while(i2 > -1 && j2 > 0) {
			i2--;
			j2--;
		}
		checkO = 0;
		checkX = 0;
		System.out.println("I2 ist: " + i2 + " , J2 ist: " + j2);
		while(i2 < 6 && j2 < 6) {
			if( field[i2][j2].getText() == "X") {
				checkO = 0;
				checkX++;
				if(checkX > 3) {
					System.out.println("Horizontal gewonnen!");
					redWin();
					return;
				}
			}
			else if(field[i2][j2].getText() == "O") {
				checkX = 0;
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
				home();
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
			home();
		}
	}
	
	private void redWin() {
		int answer = JOptionPane.showConfirmDialog(this, "Spieler 1 hat gewonnen! Möchtet ihr noch eine Runde spielen?", null, JOptionPane.YES_NO_OPTION);
		if(answer == 0)
		{
			reset();
		}
		else if(answer == 1){
			home();
		}
	}
	
	public void reset() {
		this.remove(game);
		addComponents();
		this.setVisible(true);
	}
	
	public void home() {
		this.setTitle("Fenster schließen");
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
							field[j][i].setIcon(new ImageIcon("./src/fieldsYellow.png"));
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
							field[j][i].setIcon(new ImageIcon("./src/fieldsRed.png"));
							turn = 0;
							titel.setText("Spieler 1 ist dran");
							check(j, i);
							break;
						}
					}	
				}
			}
		}
		if(event.getActionCommand() == "reset") {
			reset();
		}
		else if(event.getActionCommand() == "home") {
			home();
		}
	}
}
