package Sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class View extends JFrame implements KeyListener{
	int[][] sudokus = {
			{3, 5, 8, 1, 7, 6, 4, 2, 9},
			{2, 4, 1, 8, 5, 9, 3, 7, 6},
			{7, 9, 6, 2, 3, 4, 5, 8, 1},
			{8, 1, 7, 3, 9, 5, 6, 4, 2},
			{5, 6, 3, 4, 2, 8, 1, 9, 7},
			{4, 2, 9, 6, 1, 7, 8, 3, 5},
			{1, 3, 5, 9, 4, 2, 7, 6, 8},
			{9, 8, 4, 7, 6, 1, 2, 5, 3},
			{6, 7, 2, 5, 8, 3, 9, 1, 4}
	};
	int[][] solution = {
			{3, 5, 8, 1, 7, 6, 4, 2, 9},
			{2, 4, 1, 8, 5, 9, 3, 7, 6},
			{7, 9, 6, 2, 3, 4, 5, 8, 1},
			{8, 1, 7, 3, 9, 5, 6, 4, 2},
			{5, 6, 3, 4, 2, 8, 1, 9, 7},
			{4, 2, 9, 6, 1, 7, 8, 3, 5},
			{1, 3, 5, 9, 4, 2, 7, 6, 8},
			{9, 8, 4, 7, 6, 1, 2, 5, 3},
			{6, 7, 2, 5, 8, 3, 9, 1, 4}
	};
	int[][] board = {
			{3, 5, 8, 1, 7, 6, 4, 2, 9},
			{2, 4, 1, 8, 5, 9, 3, 7, 6},
			{7, 9, 6, 2, 3, 4, 5, 8, 1},
			{8, 1, 7, 3, 9, 5, 6, 4, 2},
			{5, 6, 3, 4, 2, 8, 1, 9, 7},
			{4, 2, 9, 6, 1, 7, 8, 3, 5},
			{1, 3, 5, 9, 4, 2, 7, 6, 8},
			{9, 8, 4, 7, 6, 1, 2, 5, 3},
			{6, 7, 2, 5, 8, 3, 9, 1, 4}
	};
	JTextField[][] boxes;
	JPanel titel;
	JPanel left;
	JPanel sudoku;
	JPanel right;
	JPanel bottum;
	Random random = new Random();
	SudokuAction sudokuaction;
	
	public void initialise(SudokuAction sudokuaction)
	  {				
		this.sudokuaction = sudokuaction;
	    setTitle("Sudoku");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //Damit das Fenster sich auch schließt
	    setLocationRelativeTo(null);                         
	    setSize(500,500);
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    
	    addComponents();      //Komponenten einfügen

	    setVisible(true);    
	  }
	
	private void addComponents() {
		initialiseBoard();
		boxes = new JTextField[9][9];
	    this.setLayout(new BorderLayout());
		
		sudoku = new JPanel();
	    sudoku.setLayout(new GridLayout(3, 3));
	    sudoku.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    JPanel sudokuField1 = new JPanel();
	    sudokuField1.setLayout(new GridLayout(3, 3));
	    sudokuField1.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    addLabels(0, sudokuField1);
	    sudoku.add(sudokuField1);
	    
	    JPanel sudokuField2 = new JPanel();
	    sudokuField2.setLayout(new GridLayout(3, 3));
	    sudokuField2.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    addLabels(1, sudokuField2);
	    sudoku.add(sudokuField2);
	    
	    JPanel sudokuField3 = new JPanel();
	    sudokuField3.setLayout(new GridLayout(3, 3));
	    sudokuField3.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    addLabels(2, sudokuField3);
	    sudoku.add(sudokuField3);
	    
	    JPanel sudokuField4 = new JPanel();
	    sudokuField4.setLayout(new GridLayout(3, 3));
	    sudokuField4.setBorder(BorderFactory.createLineBorder(Color.black));

	    addLabels(3, sudokuField4);
	    sudoku.add(sudokuField4);
	    
	    JPanel sudokuField5 = new JPanel();
	    sudokuField5.setLayout(new GridLayout(3, 3));
	    sudokuField5.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    addLabels(4, sudokuField5);
	    sudoku.add(sudokuField5);
	    
	    JPanel sudokuField6 = new JPanel();
	    sudokuField6.setLayout(new GridLayout(3, 3));
	    sudokuField6.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    addLabels(5, sudokuField6);
	    sudoku.add(sudokuField6);
	    
	    JPanel sudokuField7 = new JPanel();
	    sudokuField7.setLayout(new GridLayout(3, 3));
	    sudokuField7.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    addLabels(6, sudokuField7);
	    sudoku.add(sudokuField7);
	    
	    JPanel sudokuField8 = new JPanel();
	    sudokuField8.setLayout(new GridLayout(3, 3));
	    sudokuField8.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    addLabels(7, sudokuField8);
	    sudoku.add(sudokuField8);
	    
	    JPanel sudokuField9 = new JPanel();
	    sudokuField9.setLayout(new GridLayout(3, 3));
	    sudokuField9.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    addLabels(8, sudokuField9);
	    sudoku.add(sudokuField9);
	    
	    titel = new JPanel();
	    titel.setPreferredSize(new Dimension(1000,50));
	    
	    left = new JPanel();
	    left.setPreferredSize(new Dimension(50,1000));
	    
	    right = new JPanel();
	    right.setPreferredSize(new Dimension(50,1000));
	    
	    bottum = new JPanel();
	    bottum.setPreferredSize(new Dimension(1000,50));
	    bottum.setLayout(new FlowLayout());
	    
	    JButton reset = new JButton();
		reset.setBackground(Color.red);
		reset.setText("von vorne Beginnen");
		reset.setHorizontalAlignment(JLabel.CENTER);
		reset.addActionListener(this.sudokuaction);
		reset.setActionCommand("reset");
		reset.setFocusable(false);
		reset.setForeground(Color.black);
		JButton home = new JButton();
		home.setBackground(Color.blue);
		home.setText("zurück zum Hauptmenü");
		home.setHorizontalAlignment(JLabel.CENTER);
		home.addActionListener(this.sudokuaction);
		home.setActionCommand("home");
		home.setFocusable(false);
		home.setForeground(Color.black);
		
		bottum.add(reset);
		bottum.add(home);
	    
	    JLabel tLabel = new JLabel("Sudoku");
	    tLabel.setHorizontalAlignment(JLabel.CENTER);
	    tLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
	    
	    titel.add(tLabel);
	    this.add(BorderLayout.NORTH, titel);
	    this.add(BorderLayout.WEST, left);
	    this.add(BorderLayout.CENTER, sudoku);
	    this.add(BorderLayout.EAST, right);
	    this.add(BorderLayout.SOUTH, bottum);
	}
	
	private void initialiseBoard() {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		int randomInt;
		for(int i = 0; i < 9; i++) {                              /*erzeugen einer Liste mit zufälliger		 																			*/
			randomInt = random.nextInt(9) + 1;                    /*Anordnung der Zahlen 1-9*/ 
			while(digits.contains(randomInt)) {
				randomInt = random.nextInt(9) + 1;
			}
			digits.add(randomInt);
		}
		for(int i = 1; i < 10; i++) {
			for(int j = 0; j < 9; j++) {
				for(int k = 0; k < 9;k++) {
					if(sudokus[j][k] == i) {
						solution[j][k] = digits.get(i-1);           /*Jede Zahl im Mustersudoku Brett wird mit der Zahl ersetzt,*/
					}                                               /*welche die Position in der zufällig erzeugten Liste hat*/  
				}                                                   /*Dies wird im Lösungsarray gespeichert.*/
			}
		}
		int place;
		for (int i = 0; i < 3; i++) {                               /*For Schleife um an zufälligen Stellen im Brett ein Feld zu leereen.*/ 
			int noNumber = 0;                                       /*For Schleife geht drei Blöcke horizontal durch um bestes Ergebnis zu erzeugen*/
			int numbers = 26;
			for (int j = 0; j < 3; j++) {
				for(int k = 0; k < 9; k++) {
					place = random.nextInt(noNumber+numbers);
					if(place < 7) {
						board[j+i*3][k] = 0;
						noNumber++;
					}
					else {
						int number = solution[j+i*3][k];
						board[j+i*3][k] = number;
						numbers--;
					}
				}
			}
		}
	}
	
	private void addLabels(int box, JPanel panel)
	{
		for (int i = Math.floorDiv(box, 3)*3; i < Math.floorDiv(box, 3)*3 + 3; i++)
	      {
			for(int j = box%3*3; j < box%3*3 + 3; j++) {
				boxes[i][j] = new JTextField(String.valueOf(board[i][j]));
				boxes[i][j].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
				boxes[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				boxes[i][j].setBorder(BorderFactory.createLineBorder(Color.red));
				if(board[i][j] == 0)
				{
					boxes[i][j].setText("");
					boxes[i][j].addKeyListener(this);
				}
				else {
					boxes[i][j].setEditable(false);
				}
	        	panel.add(boxes[i][j]);
			}
	      }
	}
	
	public void check() {
		int check = 0;
		for (int i = 0; i < 9 ; i++)
	    {
			for(int j = 0; j < 9; j++) {                               				/*For Schleife geht jedes Feld im Brett durch und vergleicht es mit dem*/					
					if(Integer.parseInt(boxes[i][j].getText()) == solution[i][j]) 	/*Lösungsbrett. Sind die Zahlen in dem Feld gleich, so wird sie check Variable erhöht.*/
					{
						check++;		
					}
			}
	    }
		System.out.println("Check: " + check);
		if(check == 81) {
			int answer = JOptionPane.showConfirmDialog(this, "Du hast das Sudoku gelöst! Möchtest du ein neues lösen?", null, JOptionPane.YES_NO_OPTION); /*Abfrage ob nochmal gespielt werden möchte oder nicht*/
			if(answer == 0)
			{
				reset();
			}
			else if(answer == 1){
				home();
			}
		}
	}
	
	public void reset(){
		this.remove(titel);
		this.remove(left);
		this.remove(sudoku);
		this.remove(right);
		this.remove(bottum);
		addComponents();
		this.setVisible(true);
	}
	
	public void home() {
		this.setTitle("Kehre zurück zum Hauptmenü");
	}

	@Override
	public void keyTyped(KeyEvent event) {
		for (int i = 0; i < 9 ; i++)
	      {
			for(int j = 0; j < 9; j++) {
				if(event.getSource() == boxes[i][j])
				{
					int length  = boxes[i][j].getText().length();
					char key = event.getKeyChar();
					if(key>='1' && key <= '9') {                     //Überprüfung, ob es sich bei der eingegebenen Taste um eine Ziffer ungleich null handelt
						if(length < 1) {                             
							boxes[i][j].setEditable(true);
						}
						else {
							boxes[i][j].setEditable(false);
							boxes[i][j].setBackground(Color.white);
						}
					}
					else if(key == KeyEvent.VK_DELETE || key == KeyEvent.VK_BACK_SPACE) {       //Tasten zum löschen der Zahl
						boxes[i][j].setEditable(true);
					}
					else
					{
						boxes[i][j].setEditable(false);
						boxes[i][j].setBackground(Color.white);
					}
				}
			}
	      }
	}

	@Override
	public void keyPressed(KeyEvent event) {

	}

	@Override
	public void keyReleased(KeyEvent event) {
		for (int i = 0; i < 9 ; i++)
	      {
			for(int j = 0; j < 9; j++) {
				if(event.getSource() == boxes[i][j])
				{
						boxes[i][j].setEditable(true);		
				}
			}
	      }
		check();
	}
}
