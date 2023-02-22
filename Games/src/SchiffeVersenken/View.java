package SchiffeVersenken;

import java.awt.BorderLayout;
import java.awt.Color;
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
			{"X", " ", " ", " ", " ", "X", "X", "x", " ", " "}
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
	
	public void initialise() {		
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
	    setTitle("Schiffe versenken");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //Damit das Fenster sich auch schlie�t
	    setLocationRelativeTo(null);                         
	    setSize(1200, 600);
	    
	    addComponents();      //Komponenten einf�gen

	    setVisible(true); 
	    aiShiffSet();
	    checkShiffSet();
	}

	public void addComponents() {
		game = new JPanel();
		game.setLayout(new BorderLayout());
		
		JPanel titel = new JPanel();
		
		tLabel = new JLabel("W�hle die Position deiner Schiffe aus!");
		tLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
		tLabel.setHorizontalAlignment(JLabel.CENTER);
		
		titel.add(tLabel);
		
		JPanel selectShiff = new JPanel();
		selectShiff.setLayout(new GridLayout(4, 1));
		
		addShiffSelect(selectShiff);
		
		JPanel playerBoard = new JPanel();
		playerBoard.setLayout(new GridLayout(11, 11));
		
		addPlayerBoard(playerBoard);
		
		JPanel AiBoard = new JPanel();
		AiBoard.setLayout(new GridLayout(11, 11));
		
		addAiBoard(AiBoard);
		
		JPanel bottum = new JPanel();
		
		JPanel Boards = new JPanel();
		Boards.setLayout(new FlowLayout());

		Boards.add(playerBoard);
		Boards.add(AiBoard);
		
		game.add(BorderLayout.NORTH, titel);
	    game.add(BorderLayout.WEST, selectShiff);
	    game.add(BorderLayout.CENTER, Boards);
	    game.add(BorderLayout.SOUTH, bottum);
		
		this.add(game);
	}
	
	private void addShiffSelect(JPanel panel){
		JPanel twoPanel = new JPanel();
		twoPanel.setLayout(new FlowLayout());	
		JLabel[] twoLabel = new JLabel[4];
		for(int i = 0; i < 4; i++) {
			twoLabel[i] = new JLabel("XX");
			twoLabel[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
			twoPanel.add(twoLabel[i]);
		}
		JPanel threePanel = new JPanel();
		threePanel.setLayout(new FlowLayout());
		JLabel[] threeLabel = new JLabel[4];
		for(int i = 0; i < 4; i++) {
			threeLabel[i] = new JLabel("XXX");
			threeLabel[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
			threePanel.add(threeLabel[i]);
		}
		JPanel fourPanel = new JPanel();
		fourPanel.setLayout(new FlowLayout());
		JLabel[] fourLabel = new JLabel[2];
		for(int i = 0; i < 2; i++) {
			fourLabel[i] = new JLabel("XXXX");
			fourLabel[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
			fourPanel.add(fourLabel[i]);
		}
		JPanel fivePanel = new JPanel();
		fivePanel.setLayout(new FlowLayout());
		JLabel fiveLabel = new JLabel();
		fiveLabel = new JLabel("XXXXX");
		fiveLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		fivePanel.add(fiveLabel);
		panel.add(twoPanel);
		panel.add(threePanel);
		panel.add(fourPanel);
		panel.add(fivePanel);
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
				playerLabels[i][j].setBorder(new LineBorder(Color.black));
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
				aiButtons[i][j].setBorder(new LineBorder(Color.black));
				aiButtons[i][j].setForeground(Color.red);
				aiButtons[i][j].setHorizontalAlignment(JLabel.CENTER);
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
		while( boots < 11)
		{	
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					System.out.println("gebaute Boote:" + boots + ", Schiffsl�nge: " + sizeBoot);
					if ( prevInf < 10 ) {
						place = random.nextInt(2);
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
										System.out.println("X horizontal im weg!");
										setPossible = 0;
										break;
									}
								}
								if(setPossible == 1) {
									for(int k = 0; k < sizeBoot; k++) {
										aiStringShiff[i][j+k] = "X"; 
									}
									System.out.println("Boot:" + boots + " der Schiffsl�nge " + sizeBoot + " wurde horizontal gebaut!");
									boots++;
									if(boots == 11) {
										break;
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
										break;
									}
								}
								if(setPossible == 1) {
									for(int k = 0; k < sizeBoot; k++) {
										aiStringShiff[i+k][j] = "X"; 
									}
									System.out.println("Boot:" + boots + " der Schiffsl�nge " + sizeBoot + " wurde vertikal gebaut an X= " + j + " und Y = " + i);
									boots++;
									if(boots == 11) {
										break;
									}
									aiShiffs();
								}
							}
						}
					}
				}
				if(boots == 11) {
					break;
				}
			}
			prevInf++;
		}
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if( aiStringShiff[i][j] == " ") {
					System.out.print( "O" );
				}
				else {
					System.out.print( aiStringShiff[i][j] );	
				}
			}
			System.out.println( "" );
		}
	}
	
	private void checkShiffSet(){
		int shiffPlaces = 23;
		for(int i = 1; i < 11; i++) {
			for(int j = 1; j < 11; j++) {
				if( aiButtons[i][j].getText() == "X") {
					shiffPlaces++;
				}
			}
		}
		if(shiffPlaces == 23) {
			int answer = JOptionPane.showConfirmDialog(this, "M�chtest du das so behalten?", null, JOptionPane.YES_NO_OPTION);
			if(answer == 0)
			{
				turn = random.nextInt(2);
				if(turn == 0) {
					aiTurn();
				}
				else {
					tLabel.setText("Du bist am Zug");
				}
			}
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
						jumped++;
						foundRow++;
						directionFound = "S";
						checkAiWin();
					}
					else {
						playerLabels[foundRow+2][foundColumn+1].setText("O");
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
						jumped++;
						foundColumn--;
						directionFound = "W";
						checkAiWin();
					}
					else {
						playerLabels[foundRow+1][foundColumn].setText("O");
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
						jumped++;
						foundRow--;
						directionFound = "S";
						checkAiWin();
					}
					else {
						playerLabels[foundRow][foundColumn+1].setText("O");
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
						jumped++;
						foundColumn++;
						checkAiWin();
					}
					else {
						playerLabels[foundRow+1][foundColumn+2].setText("O");
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
				foundRow = row; 
				foundColumn = column;
				checkAiWin();
			}/*
			else if( (row < 10 || playerStringShiff[row+1][column] == "X") &&
					(column < 10 || playerStringShiff[row][column+1] == "X") 
					&& (column > 0 || playerStringShiff[row][column-1] == "X" ) 
					&& (row > 0 || playerStringShiff[row-1][column] == "X" )) {
					aiTurn();
			}*/
			else {
				playerLabels[row+1][column+1].setText("O");
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
				if(playerStringShiff[i-1][j-1] == playerLabels[i][j].getText() && playerLabels[i][j].getText() == "X") {
					hitsAi++;
				}
			}
		}	
		System.out.println("Treffer KI: " + hitsAi);
		if(hitsAi == 32) {
			int answer = JOptionPane.showConfirmDialog(this, "Du hast verloren! M�chtest du es erneut versuchen?", null, JOptionPane.YES_NO_OPTION);
			if(answer == 0)
			{
				reset();
			}
			else if(answer == 1){
				this.setTitle("Fenster schlie�en");;
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
				if(aiStringShiff[i-1][j-1] == aiButtons[i][j].getText() && aiButtons[i][j].getText() == "X") {
					hitsPlayer++;
				}
			}
		}
		System.out.println("Treffer Spieler: " + hitsPlayer);
		if(hitsPlayer == 32) {
			int answer = JOptionPane.showConfirmDialog(this, "Du hast gewonnen! M�chtest du ein neues Spiel starten?", null, JOptionPane.YES_NO_OPTION);
			if(answer == 0)
			{
				reset();
			}
			else if(answer == 1){
				this.setTitle("Fenster schlie�en");;
			}
		}
		else {
			//aiTurn();
		}
	}
	
	public void reset() {
		this.remove(game);
		initialise();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(turn == 1) {
			for(int i = 1; i < 11; i++) {
				for(int j = 1; j < 11; j++) {
					if(event.getSource() == aiButtons[i][j]) {
						if(aiStringShiff[i-1][j-1] == "X") {
							aiButtons[i][j].setText("X");
							//turn = 0;
							aiButtons[i][j].setEnabled(false);
							checkPlayerWin();
						}
						else{
							aiButtons[i][j].setText("O");
							turn = 0;
							aiButtons[i][j].setEnabled(false);
							aiTurn();
						}
					}
				}
			}	
		}
	}
	
}
