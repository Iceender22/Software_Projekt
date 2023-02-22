package SchiffeVersenken;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class View extends JFrame implements ActionListener{

	JPanel game;
	JPanel playerBoard;
	JPanel aiBoard;
	JLabel tLabel;
	JButton[][] aiButtons = new JButton[11][11];
	JLabel[][] playerLabels = new JLabel[11][11];
	String[][] playerStringShiff = {
			{"X", "X", "X", "X", "X", " ", "X", "X", " ", " "}, //1x5, 1x2
			{"X", " ", "X", " ", "X", "X", "X", " ", " ", " "}, //2x3, 1x2
			{"X", " ", "X", " ", " ", " ", " ", " ", " ", " "},
			{"X", " ", " ", " ", " ", " ", " ", " ", " ", " "},
			{" ", " ", "X", " ", "X", "X", "X", "X", " ", " "}, //1x4, 1x2
			{" ", " ", "X", " ", " ", " ", " ", " ", " ", " "},
			{"X", " ", " ", " ", " ", " ", " ", "X", "X", "X"}, //1x4, 1x3
			{"X", " ", " ", " ", "X", " ", " ", " ", " ", " "},
			{"X", " ", " ", " ", "X", " ", " ", " ", " ", " "},
			{"X", " ", " ", " ", " ", "X", "X", "X", " ", " "}
	};
	String[][] aiStringShiff = {
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //1x5, 1x2
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //2x3, 1x2
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //1x4, 1x2
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //1x4, 1x3
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "}
	};
	Random random = new Random();
	int turn;
	int foundRow;
	int foundColumn;
	int jumped;
	String direction;
	String directionFound;
	int maxRandom = 4;
	int minRandom = 2;
	int twoBoot = 0;
	int threeBoot = 0;
	int fourBoot = 0;
	int fiveBoot = 0;
	int sizeBoot;
	int horizontal;
	JButton reset;
	JButton home;
	
	public void initialise() {		
	    setTitle("Schiffe versenken");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //Damit das Fenster sich auch schließt
	    setLocationRelativeTo(null);                         
	    setSize(1200, 600);
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    
	    addComponents();      //Komponenten einfügen

	    setVisible(true); 
	}

	public void addComponents() {
		foundRow = -1;
		foundColumn = -1;
		jumped = 0;
		direction = "S";
		maxRandom = 4;
		minRandom = 2;
		twoBoot = 0;
		threeBoot = 0;
		fourBoot = 0;
		fiveBoot = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				aiStringShiff[i][j] = " ";
			}
		}
		game = new JPanel();
		game.setLayout(new BorderLayout());
		game.setBackground(Color.black);
		
		JPanel titel = new JPanel();
		
		tLabel = new JLabel("Wähle die Position deiner Schiffe aus!");
		tLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
		tLabel.setHorizontalAlignment(JLabel.CENTER);
		tLabel.setForeground(Color.decode("#009900"));
		
		titel.add(tLabel);
		
		JPanel selectShiff = new JPanel();
		selectShiff.setLayout(new GridLayout(7, 1));
		
		addShiffSelect(selectShiff);
		
		playerBoard = new JPanel();
		playerBoard.setLayout(new GridLayout(11, 11));
		playerBoard.setBackground(Color.black);
		
		addPlayerBoard(playerBoard);
		
		aiBoard = new JPanel();
		aiBoard.setLayout(new GridLayout(11, 11));
		aiBoard.setBackground(Color.black);
		
		addAiBoard(aiBoard);
		
		JPanel bottum = new JPanel();
		
		titel.setBackground(Color.black);
		selectShiff.setBackground(Color.black);
		bottum.setBackground(Color.black);
		
		game.add(BorderLayout.NORTH, titel);
	    game.add(BorderLayout.WEST, selectShiff);
	    game.add(BorderLayout.CENTER, playerBoard);
	    game.add(BorderLayout.SOUTH, bottum);
		
		this.add(game);
		aiShiffSet();
	}
	
	private void addShiffSelect(JPanel panel){
		JPanel twoPanel = new JPanel();
		twoPanel.setLayout(new FlowLayout());
		twoPanel.setBackground(Color.black);
		JLabel[] twoLabel = new JLabel[4];
		for(int i = 0; i < 4; i++) {
			twoLabel[i] = new JLabel("XX");
			twoLabel[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
			twoLabel[i].setForeground(Color.decode("#009900"));
			twoPanel.add(twoLabel[i]);
		}
		JPanel threePanel = new JPanel();
		threePanel.setLayout(new FlowLayout());
		threePanel.setBackground(Color.black);
		JLabel[] threeLabel = new JLabel[4];
		for(int i = 0; i < 4; i++) {
			threeLabel[i] = new JLabel("XXX");
			threeLabel[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
			threeLabel[i].setForeground(Color.decode("#009900"));
			threePanel.add(threeLabel[i]);
		}
		JPanel fourPanel = new JPanel();
		fourPanel.setLayout(new FlowLayout());
		fourPanel.setBackground(Color.black);
		JLabel[] fourLabel = new JLabel[2];
		for(int i = 0; i < 2; i++) {
			fourLabel[i] = new JLabel("XXXX");
			fourLabel[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
			fourLabel[i].setForeground(Color.decode("#009900"));
			fourPanel.add(fourLabel[i]);
		}
		JPanel fivePanel = new JPanel();
		fivePanel.setLayout(new FlowLayout());
		fivePanel.setBackground(Color.black);
		JLabel fiveLabel = new JLabel();
		fiveLabel = new JLabel("XXXXX");
		fiveLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		fiveLabel.setForeground(Color.decode("#009900"));
		fivePanel.add(fiveLabel);
		JButton confirm = new JButton();
		confirm.setBackground(Color.decode("#009900"));
		confirm.setText("fertig mit platzieren");
		confirm.setHorizontalAlignment(JLabel.CENTER);
		confirm.addActionListener(this);
		confirm.setActionCommand("confirm");
		confirm.setFocusable(false);
		confirm.setForeground(Color.black);
		JPanel button1 = new JPanel();
		button1.setLayout(new BorderLayout());
		JPanel button2 = new JPanel();
		button2.setLayout(new BorderLayout());
		JPanel button3 = new JPanel();
		button3.setLayout(new BorderLayout());
		reset = new JButton();
		reset.setBackground(Color.red);
		reset.setText("von vorne Beginnen");
		reset.setHorizontalAlignment(JLabel.CENTER);
		reset.addActionListener(this);
		reset.setActionCommand("reset");
		reset.setFocusable(false);
		reset.setForeground(Color.black);
		home = new JButton();
		home.setBackground(Color.blue);
		home.setText("zurück zum Hauptmenü");
		home.setHorizontalAlignment(JLabel.CENTER);
		home.addActionListener(this);
		home.setActionCommand("home");
		home.setFocusable(false);
		home.setForeground(Color.black);
		JPanel place = new JPanel();
		place.setBackground(Color.black);
		JPanel place2 = new JPanel();
		place2.setBackground(Color.black);
		JPanel place3 = new JPanel();
		place3.setBackground(Color.black);
		JPanel place4 = new JPanel();
		place4.setBackground(Color.black);
		JPanel place5 = new JPanel();
		place5.setBackground(Color.black);
		JPanel place6 = new JPanel();
		place6.setBackground(Color.black);
		JPanel place7 = new JPanel();
		place7.setBackground(Color.black);
		JPanel place8 = new JPanel();
		place8.setBackground(Color.black);
		JPanel place9 = new JPanel();
		place9.setBackground(Color.black);
		button1.add(BorderLayout.CENTER, confirm);
		button1.add(BorderLayout.SOUTH, place);
		button1.add(BorderLayout.EAST, place2);
		button1.add(BorderLayout.WEST, place3);
		button2.add(BorderLayout.CENTER, reset);
		button2.add(BorderLayout.SOUTH, place4);
		button2.add(BorderLayout.EAST, place5);
		button2.add(BorderLayout.WEST, place6);
		button3.add(BorderLayout.CENTER, home);
		button3.add(BorderLayout.SOUTH, place7);
		button3.add(BorderLayout.EAST, place8);
		button3.add(BorderLayout.WEST, place9);
		panel.add(twoPanel);
		panel.add(threePanel);
		panel.add(fourPanel);
		panel.add(fivePanel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
	}
	
	private void addPlayerBoard(JPanel panel){
		playerLabels[0][0] = new JLabel(" ");
		playerLabels[0][1] = new JLabel("1");
		playerLabels[0][2] = new JLabel("2");
		playerLabels[0][3] = new JLabel("3");
		playerLabels[0][4] = new JLabel("4");
		playerLabels[0][5] = new JLabel("5");
		playerLabels[0][6] = new JLabel("6");
		playerLabels[0][7] = new JLabel("7");
		playerLabels[0][8] = new JLabel("8");
		playerLabels[0][9] = new JLabel("9");
		playerLabels[0][10] = new JLabel("10");
		playerLabels[1][0] = new JLabel("A");
		playerLabels[2][0] = new JLabel("B");
		playerLabels[3][0] = new JLabel("C");
		playerLabels[4][0] = new JLabel("D");
		playerLabels[5][0] = new JLabel("E");
		playerLabels[6][0] = new JLabel("F");
		playerLabels[7][0] = new JLabel("G");
		playerLabels[8][0] = new JLabel("H");
		playerLabels[9][0] = new JLabel("I");
		playerLabels[10][0] = new JLabel("J");
		for(int i = 1; i < 11; i++) {
			for(int j = 1; j < 11; j++) {
				playerLabels[i][j] = new JLabel(" ");
			}
		}
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				playerLabels[i][j].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
				playerLabels[i][j].setBorder(new LineBorder(Color.decode("#009900")));
				playerLabels[i][j].setForeground(Color.decode("#009900"));
				playerLabels[i][j].setHorizontalAlignment(JLabel.CENTER);			
				panel.add(playerLabels[i][j]);
			}
		}
	}
	
	private void addAiBoard(JPanel panel){
		aiButtons[0][0] = new JButton(" ");
		aiButtons[0][0].setEnabled(false);
		aiButtons[0][1] = new JButton("1");
		aiButtons[0][1].setEnabled(false);
		aiButtons[0][2] = new JButton("2");
		aiButtons[0][2].setEnabled(false);
		aiButtons[0][3] = new JButton("3");
		aiButtons[0][3].setEnabled(false);
		aiButtons[0][4] = new JButton("4");
		aiButtons[0][4].setEnabled(false);
		aiButtons[0][5] = new JButton("5");
		aiButtons[0][5].setEnabled(false);
		aiButtons[0][6] = new JButton("6");
		aiButtons[0][6].setEnabled(false);
		aiButtons[0][7] = new JButton("7");
		aiButtons[0][7].setEnabled(false);
		aiButtons[0][8] = new JButton("8");
		aiButtons[0][8].setEnabled(false);
		aiButtons[0][9] = new JButton("9");
		aiButtons[0][9].setEnabled(false);
		aiButtons[0][10] = new JButton("10");
		aiButtons[0][10].setEnabled(false);
		aiButtons[1][0] = new JButton("A");
		aiButtons[1][0].setEnabled(false);
		aiButtons[2][0] = new JButton("B");
		aiButtons[2][0].setEnabled(false);
		aiButtons[3][0] = new JButton("C");
		aiButtons[3][0].setEnabled(false);
		aiButtons[4][0] = new JButton("D");
		aiButtons[4][0].setEnabled(false);
		aiButtons[5][0] = new JButton("E");
		aiButtons[5][0].setEnabled(false);
		aiButtons[6][0] = new JButton("F");
		aiButtons[6][0].setEnabled(false);
		aiButtons[7][0] = new JButton("G");
		aiButtons[7][0].setEnabled(false);
		aiButtons[8][0] = new JButton("H");
		aiButtons[8][0].setEnabled(false);
		aiButtons[9][0] = new JButton("I");
		aiButtons[9][0].setEnabled(false);
		aiButtons[10][0] = new JButton("J");
		aiButtons[10][0].setEnabled(false);
		for(int i = 1; i < 11; i++) {
			for(int j = 1; j < 11; j++) {
				aiButtons[i][j] = new JButton(" ");
				aiButtons[i][j].addActionListener(this);
			}
		}
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				aiButtons[i][j].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
				aiButtons[i][j].setBorder(new LineBorder(Color.decode("#009900")));
				aiButtons[i][j].setForeground(Color.decode("#009900"));
				aiButtons[i][j].setHorizontalAlignment(JLabel.CENTER);
				aiButtons[i][j].setBackground(Color.black);
				aiButtons[i][j].setFocusable(false);
				panel.add(aiButtons[i][j]);
			}
		}
	}
	
	private void aiShiffs() {
		sizeBoot = random.nextInt(maxRandom)+minRandom;
		if(sizeBoot == 2) {
			twoBoot++;
		}
		else if(sizeBoot == 3) {
			threeBoot++;
		}
		else if(sizeBoot == 4) {
			fourBoot++;
		}
		else if(sizeBoot == 5) {
			fiveBoot++;
		}
		if(twoBoot > 3) {
			if(minRandom == 2) {
				minRandom++;
				maxRandom--;
			}
		}
		if(fiveBoot > 0) {
			if(maxRandom + minRandom == 6) {
				maxRandom--;
			}
		}
		if(threeBoot > 3) {
			if(minRandom == 3) {
				minRandom++;
				maxRandom--;
			}
			else if(minRandom == 2){
				sizeBoot--;
				twoBoot++;
				threeBoot--;
				if(twoBoot > 3) {
					minRandom++;
					maxRandom--;
				}
			}
		}
		if(fourBoot > 1) {
			if(maxRandom + minRandom == 5){
				maxRandom--;
			}
			else if(maxRandom + minRandom == 6){
				maxRandom--;
				sizeBoot++;
				fiveBoot++;
				fourBoot--;
			}
		}
		horizontal = random.nextInt(2);
	}
	
	
	private void aiShiffSet() {
		int prevInf = 0;
		int boots = 0;
		int place;
		aiShiffs();
		int i;
		int j;
		while( boots < 11)
		{	
			i = random.nextInt(10);
			j = random.nextInt(10);
			if ( prevInf < 10 ) {
				place = random.nextInt(6);
			}
			else{
				place = 1;
				if(prevInf == 15) {
					horizontal = 1;
				}
				else if(prevInf == 16){
					horizontal = 0;
				}
				else if(prevInf == 17){
					System.out.println("Hat nicht funktioniert :'(");
					return;
				}
			}
			if( place == 1 ) {
				if( horizontal == 1)
				{
					if( j + sizeBoot < 10 ) {
						int setPossible = 1;
						for(int k = 0; k < sizeBoot; k++) {
							if( aiStringShiff[i][j+k] == "X" ) {
								setPossible = 0;
								continue;
							}
						}
						if(setPossible == 1) {
							for(int k = 0; k < sizeBoot; k++) {
								aiStringShiff[i][j+k] = "X"; 
							}
							boots++;
							if(boots == 11) {
								continue;
							}
							aiShiffs();
						}
					}
				}
				else {
					if( i + sizeBoot < 10 ) {
						int setPossible = 1;
						for(int k = 0; k < sizeBoot; k++) {
							if( aiStringShiff[i+k][j] == "X" ) {
								setPossible = 0;
								continue;
							}
						}
						if(setPossible == 1) {
							for(int k = 0; k < sizeBoot; k++) {
								aiStringShiff[i+k][j] = "X"; 
							}
							//System.out.println("Boot:" + boots + " der Schiffslänge " + sizeBoot + " wurde vertikal gebaut an X= " + j + " und Y = " + i);
							boots++;
							if(boots == 11) {
								continue;
							}
							aiShiffs();
						}
					}
				}
			}
		}
		for(int i2 = 0; i2 < 10; i2++) {
			for(int j2 = 0; j2 < 10; j2++) {
				if( aiStringShiff[i2][j2] == " ") {
					System.out.print( "O" );
				}
				else {
					System.out.print( aiStringShiff[i2][j2] );	
				}
			}
			System.out.println( "" );
		}
	}
	
	private void checkShiffSet(){
		int shiffPlaces = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if( playerStringShiff[i][j] == "X") {
					shiffPlaces++;
				}
			}
		}
		System.out.println("shiffplaces: " + shiffPlaces);
		if(shiffPlaces == 33) {
			int answer = JOptionPane.showConfirmDialog(this, "Möchtest du das so behalten?", null, JOptionPane.YES_NO_OPTION);
			if(answer == 0)
			{
				JPanel center = new JPanel();
				center.setBackground(Color.black);
				JPanel board1 = new JPanel();
				board1.setLayout(new BorderLayout());
				board1.setBackground(Color.black);
				board1.setPreferredSize(new Dimension(500, 500));
				JPanel board2 = new JPanel();
				board2.setLayout(new BorderLayout());
				board2.setBackground(Color.black);
				board2.setPreferredSize(new Dimension(500, 500));
				JPanel titel1 = new JPanel();
				titel1.setLayout(new GridLayout(1,2));
				titel1.setBackground(Color.black);
				JPanel titel2 = new JPanel();
				titel2.setLayout(new GridLayout(1,2));
				titel2.setBackground(Color.black);
				JLabel playerTitel = new JLabel("Dein Schiffsfeld");
				playerTitel .setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
				playerTitel .setForeground(Color.decode("#009900"));
				playerTitel .setHorizontalAlignment(JLabel.CENTER);
				playerTitel .setBackground(Color.black);
				JLabel aiTitel = new JLabel("Computer Schiffsfeld");
				aiTitel .setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
				aiTitel .setForeground(Color.decode("#009900"));
				aiTitel .setHorizontalAlignment(JLabel.CENTER);
				aiTitel .setBackground(Color.black);
				titel1.add(playerTitel);
				titel2.add(aiTitel);
				board1.add(BorderLayout.NORTH, titel1);
				board1.add(BorderLayout.CENTER, playerBoard);
				board2.add(BorderLayout.NORTH, titel2);
				board2.add(BorderLayout.CENTER, aiBoard);
				center.add(board1);
				center.add(board2);
				game.remove(game.getComponent(1));
				game.remove(playerBoard);
				JPanel buttons = new JPanel();
				buttons.setLayout(new FlowLayout());
				buttons.setBackground(Color.black);
				buttons.add(reset);
				buttons.add(home);
				JPanel east = new JPanel();
				east.setBackground(Color.black);
				east.setPreferredSize(new Dimension(90, 900));
				JPanel west = new JPanel();
				west.setBackground(Color.black);
				west.setPreferredSize(new Dimension(90, 900));
				game.add(BorderLayout.CENTER, center);
				game.add(BorderLayout.SOUTH, buttons);
				game.add(BorderLayout.EAST, east);
				game.add(BorderLayout.WEST, west);
				this.setVisible(true);
				turn = random.nextInt(2);
				if(turn == 0) {
					aiTurn();
				}
				else {
					tLabel.setText("Du bist am Zug");
				}
			}
		}
		else {
			tLabel.setText("Du hast noch nicht alle Schiffe platziert!");
		}
	}
	
	private void aiTurn() {
		tLabel.setText("Der Computer ist am Zug");
		int row = random.nextInt(10);
		int column = random.nextInt(10);
		if(playerLabels[row+1][column+1].getText() != "O"  && playerLabels[row+1][column+1].getText() != "X")
		{
			if(foundRow != -1 && foundColumn != -1) {
				if( direction == "S" ) {
					if( foundRow == 9 ) {
						if(directionFound == "S") {
							direction = "N";
						}
						else {
							direction = "W";
						}
						foundRow = foundRow - jumped;
						jumped = 0;
						aiTurn();
					}
					else if( playerLabels[foundRow+2][foundColumn+1].getText() == "O") {
						if(directionFound == "S") {
							direction = "N";
						}
						else {
							direction = "W";
						}
						foundRow = foundRow - jumped;
						jumped = 0;
						aiTurn();
					}
					else if( playerLabels[foundRow+2][foundColumn+1].getText() == "X") {
						foundRow++;
						jumped++;
						directionFound = "S";
						aiTurn();
					}
					else if( playerStringShiff[foundRow+1][foundColumn] == "X") {
						playerLabels[foundRow+2][foundColumn+1].setText("X");
						playerLabels[foundRow+2][foundColumn+1].setForeground(Color.red);
						jumped++;
						foundRow++;
						directionFound = "S";
						checkAiWin();
					}
					else {
						playerLabels[foundRow+2][foundColumn+1].setText("O");
						playerLabels[foundRow+2][foundColumn+1].setForeground(Color.blue);
						if(directionFound == "S") {
							direction = "N";
						}
						else {
							direction = "W";
						}
						foundRow = foundRow - jumped;
						jumped = 0;
					}
				}
				else if( direction == "W" ) {
					if( foundColumn == 0 ) {
						if(directionFound == "W") {
							direction = "E";
						}
						else {
							direction = "N";
						}
						foundColumn = foundColumn + jumped;
						jumped = 0;
						aiTurn();
					}
					else if( playerLabels[foundRow+1][foundColumn].getText() == "O") {
						if(directionFound == "W") {
							direction = "E";
						}
						else {
							direction = "N";
						}
						foundColumn = foundColumn + jumped;
						jumped = 0;
						aiTurn();
					}
					else if( playerLabels[foundRow+1][foundColumn].getText() == "X") {
						foundColumn--;
						jumped++;
						directionFound = "W";
						aiTurn();
					}
					else if( playerStringShiff[foundRow][foundColumn-1] == "X") {
						playerLabels[foundRow+1][foundColumn].setText("X");
						playerLabels[foundRow+1][foundColumn].setForeground(Color.red);
						jumped++;
						foundColumn--;
						directionFound = "W";
						checkAiWin();
					}
					else {
						playerLabels[foundRow+1][foundColumn].setText("O");
						playerLabels[foundRow+1][foundColumn].setForeground(Color.blue);
						if(directionFound == "W") {
							direction = "E";
						}
						else {
							direction = "N";
						}
						foundColumn = foundColumn + jumped;
						jumped = 0;
					}
				}
				else if( direction == "N" ) {
					if( foundRow == 0 ) {
						if(directionFound == "S") {
							direction = "S";
							foundRow = -1;
							foundColumn = -1;
							jumped = 0;
							directionFound = "";
						}
						else {
							direction = "E";
							foundRow = foundRow + jumped;
							jumped = 0;
						}
						aiTurn();
					}
					else if( playerLabels[foundRow][foundColumn+1].getText() == "O") {
						if(directionFound == "S") {
							direction = "S";
							foundRow = -1;
							foundColumn = -1;
							directionFound = "";
							jumped = 0;
						}
						else {
							direction = "E";
							foundRow = foundRow + jumped;
							jumped = 0;
						}
						aiTurn();
					}
					else if( playerLabels[foundRow][foundColumn+1].getText() == "X") {
						directionFound = "S";
						foundRow--;
						jumped++;
						aiTurn();
					}
					else if( playerStringShiff[foundRow-1][foundColumn] == "X") {
						playerLabels[foundRow][foundColumn+1].setText("X");
						playerLabels[foundRow][foundColumn+1].setForeground(Color.red);
						jumped++;
						foundRow--;
						directionFound = "S";
						checkAiWin();
					}
					else {
						playerLabels[foundRow][foundColumn+1].setText("O");
						playerLabels[foundRow][foundColumn+1].setForeground(Color.blue);
						if(directionFound == "S") {
							direction = "S";
							foundRow = -1;
							foundColumn = -1;
							directionFound = "";
							jumped = 0;
						}
						else {
							direction = "E";
							foundRow = foundRow + jumped;
							jumped = 0;
						}
					}
				}
				else if( direction == "E" ) {
					if( foundColumn == 9 ) {
						direction = "S";
						foundRow = -1;
						foundColumn = -1;
						directionFound = "";
						jumped = 0;
						aiTurn();
					}
					else if( playerLabels[foundRow+1][foundColumn+2].getText() == "O") {
						direction = "S";
						foundRow = -1;
						foundColumn = -1;
						directionFound = "";
						jumped = 0;
						aiTurn();
					}
					else if( playerLabels[foundRow+1][foundColumn+2].getText() == "X") {
						foundColumn++;
						jumped++;
						aiTurn();
					}
					else if( playerStringShiff[foundRow][foundColumn+1] == "X") {
						playerLabels[foundRow+1][foundColumn+2].setText("X");
						playerLabels[foundRow+1][foundColumn+2].setForeground(Color.red);
						jumped++;
						foundColumn++;
						checkAiWin();
					}
					else {
						playerLabels[foundRow+1][foundColumn+2].setText("O");
						playerLabels[foundRow+1][foundColumn+2].setForeground(Color.blue);
						direction = "S";
						foundRow = -1;
						foundColumn = -1;
						directionFound = "";
						jumped = 0;
					}
				}
			}
			else if( playerStringShiff[row][column] == "X") {
				playerLabels[row+1][column+1].setText("X");
				playerLabels[row+1][column+1].setForeground(Color.red);
				foundRow = row; 
				foundColumn = column;
				checkAiWin();
			}
			else if( row < 9 && column < 9 && column > 0 && row > 0 ) {
				if( playerLabels[row+2][column+1].getText() == "O" && playerLabels[row+1][column+2].getText() == "O" 
						&& playerLabels[row+1][column].getText() == "O"  && playerLabels[row][column+1].getText() == "O" ) {
						aiTurn();
				}
				else {
					playerLabels[row+1][column+1].setText("O");
					playerLabels[row+1][column+1].setForeground(Color.blue);
				}
			}
			else if( row == 9 && column == 9) {
				if( playerLabels[row+1][column].getText() == "O"  && playerLabels[row][column+1].getText() == "O" ) {
						aiTurn();
				}
				else {
					playerLabels[row+1][column+1].setText("O");
					playerLabels[row+1][column+1].setForeground(Color.blue);
				}
			}
			else if( row == 9 && column == 0) {
				if( playerLabels[row][column+1].getText() == "O"  && playerLabels[row+1][column+2].getText() == "O" ) {
						aiTurn();
				}
				else {
					playerLabels[row+1][column+1].setText("O");
					playerLabels[row+1][column+1].setForeground(Color.blue);
				}
			}
			else if( row == 0 && column == 9) {
				if( playerLabels[row+2][column+1].getText() == "O"  && playerLabels[row+1][column].getText() == "O" ) {
						aiTurn();
				}
				else {
					playerLabels[row+1][column+1].setText("O");
					playerLabels[row+1][column+1].setForeground(Color.blue);
				}
			}
			else if( row == 0 && column == 0) {
				if( playerLabels[row+2][column+1].getText() == "O"  && playerLabels[row+1][column+2].getText() == "O" ) {
						aiTurn();
				}
				else {
					playerLabels[row+1][column+1].setText("O");
					playerLabels[row+1][column+1].setForeground(Color.blue);
				}
			}
			else if( row == 0 ) {
				if( playerLabels[row+2][column+1].getText() == "O"  && playerLabels[row+1][column+2].getText() == "O" && playerLabels[row+1][column].getText() == "O") {
						aiTurn();
				}
				else {
					playerLabels[row+1][column+1].setText("O");
					playerLabels[row+1][column+1].setForeground(Color.blue);
				}
			}
			else if( row == 9 ) {
				if( playerLabels[row][column+1].getText() == "O"  && playerLabels[row+1][column+2].getText() == "O" && playerLabels[row+1][column].getText() == "O") {
						aiTurn();
				}
				else {
					playerLabels[row+1][column+1].setText("O");
					playerLabels[row+1][column+1].setForeground(Color.blue);
				}
			}
			else if( column == 0 ) {
				if( playerLabels[row+2][column+1].getText() == "O"  && playerLabels[row][column+1].getText() == "O" && playerLabels[row+1][column+2].getText() == "O") {
						aiTurn();
				}
				else {
					playerLabels[row+1][column+1].setText("O");
					playerLabels[row+1][column+1].setForeground(Color.blue);
				}
			}
			else if( column == 9 ) {
				if( playerLabels[row+2][column+1].getText() == "O"  && playerLabels[row][column+1].getText() == "O" && playerLabels[row+1][column].getText() == "O") {
						aiTurn();
				}
				else {
					playerLabels[row+1][column+1].setText("O");
					playerLabels[row+1][column+1].setForeground(Color.blue);
				}
			}
			else {
				playerLabels[row+1][column+1].setText("O");
				playerLabels[row+1][column+1].setForeground(Color.blue);
			}
			turn = 1;	
			tLabel.setText("Du bist am Zug");
		}
		else {
			aiTurn();
		}
	}
	
	private void checkAiWin() {
		int hitsAi = 0;
		for(int i = 1; i < 11; i++) {
			for(int j = 1; j < 11; j++) {
				if(playerLabels[i][j].getText() == "X") {
					hitsAi++;
				}
			}
		}	
		System.out.println("Treffer KI: " + hitsAi);
		if(hitsAi == 33) {
			int answer = JOptionPane.showConfirmDialog(this, "Du hast verloren! Möchtest du es erneut versuchen?", null, JOptionPane.YES_NO_OPTION);
			if(answer == 0)
			{
				reset();
			}
			else if(answer == 1){
				home();
			}
		}
		else {
			aiTurn();
		}
	}
	
	public void checkPlayerWin() {
		int hitsPlayer = 0;
		for(int i = 1; i < 11; i++) {
			for(int j = 1; j < 11; j++) {
				if(aiButtons[i][j].getText() == "X") {
					hitsPlayer++;
				}
			}
		}
		System.out.println("Treffer Spieler: " + hitsPlayer);
		if(hitsPlayer == 33) {
			int answer = JOptionPane.showConfirmDialog(this, "Du hast gewonnen! Möchtest du ein neues Spiel starten?", null, JOptionPane.YES_NO_OPTION);
			if(answer == 0)
			{
				reset();
			}
			else if(answer == 1){
				home();
			}
		}
	}
	
	public void reset() {
		this.remove(game);
		addComponents();
		this.setVisible(true);
	}
	
	private void home() {
		tLabel.setText("Kehre zurück zum Hauptmenü");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(turn == 1) {
			for(int i = 1; i < 11; i++) {
				for(int j = 1; j < 11; j++) {
					if(event.getSource() == aiButtons[i][j]) {
						if(aiStringShiff[i-1][j-1] == "X") {
							JLabel a = new JLabel();
							a.setForeground(Color.red);
							a.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
							a.setHorizontalAlignment(JLabel.CENTER);
							aiButtons[i][j].setEnabled(false);
							aiButtons[i][j].setText("X");
							aiButtons[i][j].setLayout(new GridLayout(1,1));
							aiButtons[i][j].add(a);
							a.setText("X");
							checkPlayerWin();
						}
						else{
							JLabel a = new JLabel("O");
							a.setForeground(Color.blue);
							a.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
							a.setHorizontalAlignment(JLabel.CENTER);
							aiButtons[i][j].setEnabled(false);
							aiButtons[i][j].setLayout(new GridLayout(1,1));
							aiButtons[i][j].add(a);
							turn = 0;
							aiTurn();
						}
					}
				}
			}	
		}
		if(event.getActionCommand() == "confirm") {
			checkShiffSet();
		}
		else if(event.getActionCommand() == "reset") {
			reset();
		}
		else if(event.getActionCommand() == "home") {
			home();
		}
	}
	
}
