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
	String[][][] selectStringShiff ={ {
			{"S", "X", "X", "X", "E", " ", "S", "E", " ", " "}, //1x5, 1x2
			{"SH", " ", "SH", " ", "S", "X", "E", " ", " ", " "}, //2x3, 1x2
			{"X", " ", "EH", " ", " ", " ", " ", " ", " ", " "},
			{"EH", " ", " ", " ", " ", " ", " ", " ", " ", " "},
			{" ", " ", "SH", " ", "S", "X", "X", "E", " ", " "}, //1x4, 1x2
			{" ", " ", "EH", " ", " ", " ", " ", " ", " ", " "},
			{"SH", " ", " ", " ", " ", " ", " ", "S", "X", "E"}, //1x4, 1x3
			{"X", " ", " ", " ", "SH", " ", " ", " ", " ", " "},
			{"X", " ", " ", " ", "EH", " ", " ", " ", " ", " "},
			{"EH", " ", " ", " ", " ", "S", "X", "E", " ", " "}
	},
	{
			{"S", "X", "X", "X", "E", " ", " ", " ", "SH", " "}, //1x5, 1x2
			{" ", " ", " ", " ", " ", "SH", " ", " ", "X", " "}, //2x3, 1x2
			{" ", " ", " ", " ", " ", "EH", " ", " ", "EH", " "},
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
			{" ", "S", "X", "E", "S", "X", "X", "E", " ", " "}, //1x4, 1x2
			{" ", " ", "SH", " ", " ", " ", " ", " ", " ", " "},
			{"SH", " ", "EH", " ", " ", " ", "S", "X", "X", "E"}, //1x4, 1x3
			{"EH", " ", " ", "S", "E", " ", " ", " ", " ", " "},
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
			{" ", " ", "S", "X", "E", "S", "X", "E", " ", " "}
	},
	{
			{"SH", " ", "SH", " ", "S", "X", "E", " ", " ", "SH"}, //1x5, 1x2
			{"X", " ", "X", " ", " ", " ", " ", " ", " ", "EH"}, //2x3, 1x2
			{"X", " ", "EH", " ", " ", " ", " ", " ", " ", " "},
			{"EH", " ", " ", " ", " ", "S", "X", "X", "E", " "},
			{" ", " ", "SH", " ", " ", " ", " ", " ", " ", " "}, //1x4, 1x2
			{" ", " ", "EH", " ", " ", " ", " ", " ", " ", " "},
			{"S", "X", "E", " ", " ", " ", " ", "S", "X", "E"}, //1x4, 1x3
			{" ", "SH", " ", " ", "SH", " ", " ", " ", " ", " "},
			{" ", "EH", " ", " ", "EH", " ", " ", " ", " ", " "},
			{" ", " ", " ", "S", "X", "X", "X", "E", " ", " "}
	},
	{
			{"S", "E", " ", "S", "X", "E", " ", " ", " ", "SH"}, //1x5, 1x2
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", "X"}, //2x3, 1x2
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", "X"},
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", "X"},
			{" ", "S", "E", " ", "S", "X", "X", "E", " ", "EH"}, //1x4, 1x2
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
			{" ", " ", " ", "S", "X", "E", " ", "S", "E", "SH"}, //1x4, 1x3
			{" ", " ", " ", " ", "SH", " ", " ", " ", " ", "X"},
			{"S", "X", "E", " ", "EH", " ", " ", " ", " ", "X"},
			{" ", " ", " ", " ", " ", "S", "X", "E", " ", "EH"}
	},
	{
			{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //1x5, 1x2
			{" ", "S", "X", "X", "E", " ", " ", " ", " ", " "}, //2x3, 1x2
			{" ", " ", " ", " ", " ", "S", "X", "X", "E", " "},
			{" ", "S", "E", " ", " ", " ", " ", " ", " ", "SH"},
			{" ", " ", " ", "S", "X", "X", "X", "E", " ", "X"}, //1x4, 1x2
			{" ", " ", "SH", " ", " ", " ", " ", " ", " ", "EH"},
			{" ", " ", "X", "SH", " ", "SH", " ", "S", "E", " "}, //1x4, 1x3
			{"SH", " ", "EH", "EH", " ", "X", " ", " ", " ", " "},
			{"X", " ", " ", " ", " ", "EH", " ", "S", "E", " "},
			{"EH", " ", " ", " ", " ", " ", " ", " ", " ", " "}
	},
	{
			{" ", "SH", " ", " ", " ", " ", " ", " ", "SH", " "}, //1x5, 1x2
			{" ", "X", " ", " ", "S", "E", " ", " ", "X", " "}, //2x3, 1x2
			{" ", "X", " ", "SH", " ", " ", " ", " ", "X", " "},
			{" ", "EH", " ", "EH", " ", " ", " ", " ", "X", " "},
			{" ", " ", "SH", " ", "S", "E", " ", " ", "EH", " "}, //1x4, 1x2
			{" ", " ", "X", " ", " ", " ", "S", "E", " ", " "},
			{" ", " ", "EH", " ", " ", " ", "S", "X", "X", "E"}, //1x4, 1x3
			{" ", "SH", " ", "S", "X", "E", " ", " ", " ", " "},
			{" ", "X", " ", " ", " ", " ", "S", "X", "E", " "},
			{" ", "EH", " ", " ", " ", " ", " ", " ", " ", " "}
	},
	{
			{"SH", "S", "X", "E", " ", " ", " ", "SH", " ", "SH"}, //1x5, 1x2
			{"X", " ", " ", " ", " ", " ", " ", "X", " ", "X"}, //2x3, 1x2
			{"X", " ", " ", " ", " ", " ", " ", "EH", " ", "X"},
			{"EH", " ", " ", "S", "E", " ", " ", " ", " ", "EH"},
			{" ", " ", " ", " ", " ", " ", "SH", " ", " ", " "}, //1x4, 1x2
			{"SH", " ", " ", " ", " ", " ", "EH", " ", " ", " "},
			{"X", " ", " ", " ", " ", " ", " ", " ", " ", " "}, //1x4, 1x3
			{"X", " ", "SH", " ", "S", "E", " ", " ", "SH", "SH"},
			{"X", " ", "EH", " ", " ", " ", " ", " ", "X", "X"},
			{"EH", " ", " ", " ", " ", " ", " ", " ", "EH", "EH"}
	},
	{
			{" ", " ", " ", " ", " ", " ", " ", " ", "S", "E"}, //1x5, 1x2
			{" ", "SH", " ", " ", "SH", "S", "X", "E", " ", " "}, //2x3, 1x2
			{" ", "EH", " ", " ", "X", " ", " ", "SH", " ", " "},
			{" ", " ", " ", " ", "X", " ", " ", "X", " ", " "},
			{" ", "S", "X", "E", "EH", " ", " ", "EH", " ", " "}, //1x4, 1x2
			{" ", " ", " ", "S", "X", "X", "X", "E", " ", " "},
			{" ", "S", "X", "X", "E", " ", "SH", " ", " ", " "}, //1x4, 1x3
			{" ", " ", " ", " ", " ", " ", "X", " ", " ", " "},
			{" ", "SH", " ", " ", " ", " ", "EH", " ", " ", "SH"},
			{" ", "EH", " ", " ", " ", " ", " ", " ", " ", "EH"}
	}};
	String[][] playerStringShiff = {
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
	JButton[][] shiffSelectButtons;
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
	    setSize(1400, 750);
	    setResizable(false);

	    
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
		
		tLabel = new JLabel("Wähle dir ein Schiffsfeld aus!");
		tLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
		tLabel.setHorizontalAlignment(JLabel.CENTER);
		tLabel.setForeground(Color.decode("#009900"));
		
		titel.add(tLabel);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.setBackground(Color.black);
		
		addButtons(buttons);
		
		playerBoard = new JPanel();
		playerBoard.setLayout(new GridLayout(2, 4));
		playerBoard.setBackground(Color.black);
		
		addPlayerBoard(playerBoard);
		
		aiBoard = new JPanel();
		aiBoard.setLayout(new GridLayout(11, 11));
		aiBoard.setBackground(Color.black);
		
		addAiBoard(aiBoard);
		
		titel.setBackground(Color.black);
		
		game.add(BorderLayout.NORTH, titel);
	    game.add(BorderLayout.CENTER, playerBoard);
	    game.add(BorderLayout.SOUTH, buttons);
		
		this.add(game);
		aiShiffSet();
	}
	
	private void addButtons(JPanel panel){		
		reset = new JButton();
		reset.setBackground(Color.red);
		reset.setText("von vorne Beginnen");
		reset.setHorizontalAlignment(JLabel.CENTER);
		reset.addActionListener(this);
		reset.setActionCommand("reset");
		reset.setFocusable(false);
		reset.setForeground(Color.white);
		home = new JButton();
		home.setBackground(Color.blue);
		home.setText("zurück zum Hauptmenü");
		home.setHorizontalAlignment(JLabel.CENTER);
		home.addActionListener(this);
		home.setActionCommand("home");
		home.setFocusable(false);
		home.setForeground(Color.white);
		panel.add(reset);
		panel.add(home);
	}
	
	private void addPlayerBoard(JPanel panel){
		shiffSelectButtons = new JButton[2][4];
		JLabel[][] shiffSelectLabels = new JLabel[2][4];
		JPanel[][] shiffSelectPanels = new JPanel[2][4];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				shiffSelectPanels[i][j] = new JPanel();
				shiffSelectPanels[i][j].setBackground(Color.black);
				shiffSelectLabels[i][j] = new JLabel();
				shiffSelectLabels[i][j].setIcon(new ImageIcon("./src/field" + ((i*4)+(j+1)) + ".png"));
				shiffSelectPanels[i][j].add(shiffSelectLabels[i][j]);
				shiffSelectButtons[i][j] = new JButton(" "+ ((i*4)+(j+1)) + " ");
				shiffSelectButtons[i][j].addActionListener(this);
				shiffSelectButtons[i][j].setBackground(Color.decode("#009900"));
				shiffSelectButtons[i][j].setBorder(new LineBorder(Color.white, 1));
				shiffSelectButtons[i][j].setForeground(Color.white);
				shiffSelectButtons[i][j].setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
				shiffSelectPanels[i][j].add(shiffSelectButtons[i][j]);
				panel.add(shiffSelectPanels[i][j]);
				
			}
		}
		shiffSelectButtons[0][0].setActionCommand("one");
		shiffSelectButtons[0][1].setActionCommand("two");
		shiffSelectButtons[0][2].setActionCommand("three");
		shiffSelectButtons[0][3].setActionCommand("four");
		shiffSelectButtons[1][0].setActionCommand("five");
		shiffSelectButtons[1][1].setActionCommand("six");
		shiffSelectButtons[1][2].setActionCommand("seven");
		shiffSelectButtons[1][3].setActionCommand("eight");
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
		int boots = 0;
		int place = 1;
		aiShiffs();
		int i;
		int j;
		while( boots < 11)
		{	
			i = random.nextInt(10);
			j = random.nextInt(10);
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
	
	private void shiffSet(){
			int answer = JOptionPane.showConfirmDialog(this, "Sind sie sicher das sie das Brett möcchten?", null, JOptionPane.YES_NO_OPTION);
			if(answer == 0)
			{
				JPanel playerBoard2 = new JPanel();
				playerBoard2.setLayout(new GridLayout(11, 11));
				playerBoard2.setBackground(Color.black);
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
						if(playerStringShiff[i-1][j-1] == "S") {
							playerLabels[i][j].setIcon(new ImageIcon("./src/schiffAnfang.png"));
						}
						else if(playerStringShiff[i-1][j-1] == "E") {
							playerLabels[i][j].setIcon(new ImageIcon("./src/schiffEnde.png"));
						}
						else if(playerStringShiff[i-1][j-1] == "SH") {
							playerLabels[i][j].setIcon(new ImageIcon("./src/schiffAnfangH.png"));
						}
						else if(playerStringShiff[i-1][j-1] == "EH") {
							playerLabels[i][j].setIcon(new ImageIcon("./src/schiffEndeH.png"));
						}
						else if(playerStringShiff[i-1][j-1] == "X") {
							playerLabels[i][j].setIcon(new ImageIcon("./src/schiffMitte.png"));
						}
					}
				}
				for(int i = 0; i < 11; i++) {
					for(int j = 0; j < 11; j++) {
						playerLabels[i][j].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
						playerLabels[i][j].setBorder(new LineBorder(Color.decode("#009900")));
						playerLabels[i][j].setForeground(Color.decode("#009900"));
						playerLabels[i][j].setHorizontalAlignment(JLabel.CENTER);			
						playerBoard2.add(playerLabels[i][j]);
					}
				}
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
				board1.add(BorderLayout.CENTER, playerBoard2);
				board2.add(BorderLayout.NORTH, titel2);
				board2.add(BorderLayout.CENTER, aiBoard);
				center.add(board1);
				center.add(board2);
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
						playerLabels[foundRow+2][foundColumn+1].setIcon(new ImageIcon("./src/schiffMitteTreffer.png"));
						jumped++;
						foundRow++;
						directionFound = "S";
						checkAiWin();
					}
					else if( playerStringShiff[foundRow+1][foundColumn] == "S") {
						playerLabels[foundRow+2][foundColumn+1].setText("X");
						playerLabels[foundRow+2][foundColumn+1].setForeground(Color.red);
						playerLabels[foundRow+2][foundColumn+1].setIcon(new ImageIcon("./src/schiffAnfangTreffer.png"));
						jumped++;
						foundRow++;
						directionFound = "S";
						checkAiWin();
					}
					else if( playerStringShiff[foundRow+1][foundColumn] == "E") {
						playerLabels[foundRow+2][foundColumn+1].setText("X");
						playerLabels[foundRow+2][foundColumn+1].setForeground(Color.red);
						playerLabels[foundRow+2][foundColumn+1].setIcon(new ImageIcon("./src/schiffEndeTreffer.png"));
						jumped++;
						foundRow++;
						directionFound = "S";
						checkAiWin();
					}
					else if( playerStringShiff[foundRow+1][foundColumn] == "SH") {
						playerLabels[foundRow+2][foundColumn+1].setText("X");
						playerLabels[foundRow+2][foundColumn+1].setForeground(Color.red);
						playerLabels[foundRow+2][foundColumn+1].setIcon(new ImageIcon("./src/schiffAnfangHTreffer.png"));
						jumped++;
						foundRow++;
						directionFound = "S";
						checkAiWin();
					}
					else if( playerStringShiff[foundRow+1][foundColumn] == "EH") {
						playerLabels[foundRow+2][foundColumn+1].setText("X");
						playerLabels[foundRow+2][foundColumn+1].setForeground(Color.red);
						playerLabels[foundRow+2][foundColumn+1].setIcon(new ImageIcon("./src/schiffEndeHTreffer.png"));
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
						playerLabels[foundRow+1][foundColumn].setIcon(new ImageIcon("./src/schiffMitteTreffer.png"));
						jumped++;
						foundColumn--;
						directionFound = "W";
						checkAiWin();
					}
					else if( playerStringShiff[foundRow][foundColumn-1] == "S") {
						playerLabels[foundRow+1][foundColumn].setText("X");
						playerLabels[foundRow+1][foundColumn].setForeground(Color.red);
						playerLabels[foundRow+1][foundColumn].setIcon(new ImageIcon("./src/schiffAnfangTreffer.png"));
						jumped++;
						foundColumn--;
						directionFound = "W";
						checkAiWin();
					}
					else if( playerStringShiff[foundRow][foundColumn-1] == "E") {
						playerLabels[foundRow+1][foundColumn].setText("X");
						playerLabels[foundRow+1][foundColumn].setForeground(Color.red);
						playerLabels[foundRow+1][foundColumn].setIcon(new ImageIcon("./src/schiffEndeTreffer.png"));
						jumped++;
						foundColumn--;
						directionFound = "W";
						checkAiWin();
					}
					else if( playerStringShiff[foundRow][foundColumn-1] == "SH") {
						playerLabels[foundRow+1][foundColumn].setText("X");
						playerLabels[foundRow+1][foundColumn].setForeground(Color.red);
						playerLabels[foundRow+1][foundColumn].setIcon(new ImageIcon("./src/schiffAnfangHTreffer.png"));
						jumped++;
						foundColumn--;
						directionFound = "W";
						checkAiWin();
					}
					else if( playerStringShiff[foundRow][foundColumn-1] == "EH") {
						playerLabels[foundRow+1][foundColumn].setText("X");
						playerLabels[foundRow+1][foundColumn].setForeground(Color.red);
						playerLabels[foundRow+1][foundColumn].setIcon(new ImageIcon("./src/schiffEndeHTreffer.png"));
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
						playerLabels[foundRow][foundColumn+1].setIcon(new ImageIcon("./src/schiffMitteTreffer.png"));
						jumped++;
						foundRow--;
						directionFound = "S";
						checkAiWin();
					}
					else if( playerStringShiff[foundRow-1][foundColumn] == "S") {
						playerLabels[foundRow][foundColumn+1].setText("X");
						playerLabels[foundRow][foundColumn+1].setForeground(Color.red);
						playerLabels[foundRow][foundColumn+1].setIcon(new ImageIcon("./src/schiffAnfangTreffer.png"));
						jumped++;
						foundRow--;
						directionFound = "S";
						checkAiWin();
					}
					else if( playerStringShiff[foundRow-1][foundColumn] == "E") {
						playerLabels[foundRow][foundColumn+1].setText("X");
						playerLabels[foundRow][foundColumn+1].setForeground(Color.red);
						playerLabels[foundRow][foundColumn+1].setIcon(new ImageIcon("./src/schiffEndeTreffer.png"));
						jumped++;
						foundRow--;
						directionFound = "S";
						checkAiWin();
					}
					else if( playerStringShiff[foundRow-1][foundColumn] == "SH") {
						playerLabels[foundRow][foundColumn+1].setText("X");
						playerLabels[foundRow][foundColumn+1].setForeground(Color.red);
						playerLabels[foundRow][foundColumn+1].setIcon(new ImageIcon("./src/schiffAnfangHTreffer.png"));
						jumped++;
						foundRow--;
						directionFound = "S";
						checkAiWin();
					}
					else if( playerStringShiff[foundRow-1][foundColumn] == "EH") {
						playerLabels[foundRow][foundColumn+1].setText("X");
						playerLabels[foundRow][foundColumn+1].setForeground(Color.red);
						playerLabels[foundRow][foundColumn+1].setIcon(new ImageIcon("./src/schiffEndeHTreffer.png"));
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
						playerLabels[foundRow+1][foundColumn+2].setIcon(new ImageIcon("./src/schiffMitteTreffer.png"));
						jumped++;
						foundColumn++;
						checkAiWin();
					}
					else if( playerStringShiff[foundRow][foundColumn+1] == "S") {
						playerLabels[foundRow+1][foundColumn+2].setText("X");
						playerLabels[foundRow+1][foundColumn+2].setForeground(Color.red);
						playerLabels[foundRow+1][foundColumn+2].setIcon(new ImageIcon("./src/schiffAnfangTreffer.png"));
						jumped++;
						foundColumn++;
						checkAiWin();
					}
					else if( playerStringShiff[foundRow][foundColumn+1] == "E") {
						playerLabels[foundRow+1][foundColumn+2].setText("X");
						playerLabels[foundRow+1][foundColumn+2].setForeground(Color.red);
						playerLabels[foundRow+1][foundColumn+2].setIcon(new ImageIcon("./src/schiffEndeTreffer.png"));
						jumped++;
						foundColumn++;
						checkAiWin();
					}
					else if( playerStringShiff[foundRow][foundColumn+1] == "SH") {
						playerLabels[foundRow+1][foundColumn+2].setText("X");
						playerLabels[foundRow+1][foundColumn+2].setForeground(Color.red);
						playerLabels[foundRow+1][foundColumn+2].setIcon(new ImageIcon("./src/schiffAnfangHTreffer.png"));
						jumped++;
						foundColumn++;
						checkAiWin();
					}
					else if( playerStringShiff[foundRow][foundColumn+1] == "EH") {
						playerLabels[foundRow+1][foundColumn+2].setText("X");
						playerLabels[foundRow+1][foundColumn+2].setForeground(Color.red);
						playerLabels[foundRow+1][foundColumn+2].setIcon(new ImageIcon("./src/schiffEndeHTreffer.png"));
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
				playerLabels[row+1][column+1].setIcon(new ImageIcon("./src/schiffMitteTreffer.png"));
				playerLabels[row+1][column+1].setForeground(Color.red);
				foundRow = row; 
				foundColumn = column;
				checkAiWin();
			}
			else if( playerStringShiff[row][column] == "S") {
				playerLabels[row+1][column+1].setText("X");
				playerLabels[row+1][column+1].setIcon(new ImageIcon("./src/schiffAnfangTreffer.png"));
				playerLabels[row+1][column+1].setForeground(Color.red);
				foundRow = row; 
				foundColumn = column;
				checkAiWin();
			}
			else if( playerStringShiff[row][column] == "E") {
				playerLabels[row+1][column+1].setText("X");
				playerLabels[row+1][column+1].setIcon(new ImageIcon("./src/schiffEndeTreffer.png"));
				playerLabels[row+1][column+1].setForeground(Color.red);
				foundRow = row; 
				foundColumn = column;
				checkAiWin();
			}
			else if( playerStringShiff[row][column] == "SH") {
				playerLabels[row+1][column+1].setText("X");
				playerLabels[row+1][column+1].setIcon(new ImageIcon("./src/schiffAnfangHTreffer.png"));
				playerLabels[row+1][column+1].setForeground(Color.red);
				foundRow = row; 
				foundColumn = column;
				checkAiWin();
			}
			else if( playerStringShiff[row][column] == "EH") {
				playerLabels[row+1][column+1].setText("X");
				playerLabels[row+1][column+1].setIcon(new ImageIcon("./src/schiffEndeHTreffer.png"));
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
		if(event.getActionCommand() == "one") {
			playerStringShiff = selectStringShiff[0];
			shiffSet();
		}
		else if(event.getActionCommand() == "two") {
			playerStringShiff = selectStringShiff[1];
			shiffSet();
		}
		else if(event.getActionCommand() == "three") {
			playerStringShiff = selectStringShiff[2];
			shiffSet();
		}
		else if(event.getActionCommand() == "four") {
			playerStringShiff = selectStringShiff[3];
			shiffSet();
		}
		else if(event.getActionCommand() == "five") {
			playerStringShiff = selectStringShiff[4];
			shiffSet();
		}
		else if(event.getActionCommand() == "six") {
			playerStringShiff = selectStringShiff[5];
			shiffSet();
		}
		else if(event.getActionCommand() == "seven") {
			playerStringShiff = selectStringShiff[6];
			shiffSet();
		}
		else if(event.getActionCommand() == "eight") {
			playerStringShiff = selectStringShiff[7];
			shiffSet();
		}
		else if(event.getActionCommand() == "reset") {
			reset();
		}
		else if(event.getActionCommand() == "home") {
			home();
		}
	}
	
}
