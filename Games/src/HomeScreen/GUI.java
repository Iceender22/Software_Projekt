package HomeScreen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {

	JFrame screen;
	JPanel panelback, panelfor;
	JLabel background;
	JButton ttt, snake, sudoku, memory, tetris, pong, svs, hang;
	
	public GUI() {
		
		screen = new JFrame();
		screen.setSize(590, 350);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLocationRelativeTo(null);
		screen.setResizable(false);
		screen.setTitle("Dies Spielesammlung!");
		screen.setLayout(null);
		
		panelback = new JPanel();
		panelback.setSize(590, 350);
		
		panelfor = new JPanel();
		panelfor.setSize(590, 350);
		panelfor.setLayout(null);
		
		background = new JLabel(new ImageIcon("res/homeback2.png"));
		
		ttt = new JButton("Tic Tac Toe");
		ttt.setBounds(98, 73, 100, 30);
		ttt.setVisible(true);
		ttt.setBackground(Color.ORANGE);
		ttt.setForeground(Color.BLACK);
		ttt.setFocusPainted(false);
		ttt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Homescreen schließen
				screen.dispose();
				// Spiel TicTacToe öffnen
				new tictactoe.GUI();
				new tictactoe.ImageLoader();
				new tictactoe.Winner();
			}
		});
		
		snake = new JButton("Snake");
		snake.setBounds(246, 73, 100, 30);
		snake.setVisible(true);
		snake.setBackground(Color.ORANGE);
		snake.setForeground(Color.BLACK);
		snake.setFocusPainted(false);
		snake.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Homescreen schließen
				screen.dispose();
				// Spiel Snake öffnen
				new snake.GUI();
				
			}
		});
		
		sudoku = new JButton("SuDoKu");
		sudoku.setBounds(394, 73, 100, 30);
		sudoku.setVisible(true);
		sudoku.setBackground(Color.ORANGE);
		sudoku.setForeground(Color.BLACK);
		sudoku.setFocusPainted(false);
		sudoku.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Homescreen schließen
				// screen.dispose();
				// Spiel Sudoku öffnen
				
			}
		});
		
		memory = new JButton("Memory");
		memory.setBounds(98, 161, 100, 30);
		memory.setVisible(true);
		memory.setBackground(Color.ORANGE);
		memory.setForeground(Color.BLACK);
		memory.setFocusPainted(false);
		memory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Homescreen schließen
				// screen.dispose();
				// Spiel Memory öffnen
				
			}
		});
		
		tetris = new JButton("Tetris");
		tetris.setBounds(246, 161, 100, 30);
		tetris.setVisible(true);
		tetris.setBackground(Color.ORANGE);
		tetris.setForeground(Color.BLACK);
		tetris.setFocusPainted(false);
		tetris.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Homescreen schließen
				// screen.dispose();
				// Spiel Tetris öffnen
				
			}
		});
		
		pong = new JButton("Pong");
		pong.setBounds(394, 161, 100, 30);
		pong.setVisible(true);
		pong.setBackground(Color.ORANGE);
		pong.setForeground(Color.BLACK);
		pong.setFocusPainted(false);
		pong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Homescreen schließen
				screen.dispose();
				// Spiel Pong öffnen
				new Pong.GUI();
				new Pong.variablen();
				new Pong.playerMovement();
				new Pong.ballMovement();
				new Pong.collision();
				
			}
		});
		
		svs = new JButton("Schiffe versenken");
		svs.setBounds(122, 249, 150, 30);
		svs.setVisible(true);
		svs.setBackground(Color.ORANGE);
		svs.setForeground(Color.BLACK);
		svs.setFocusPainted(false);
		svs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Homescreen schließen
				screen.dispose();
				
			}
		});
		
		hang = new JButton("Hangman");
		hang.setBounds(319, 249, 150, 30);
		hang.setVisible(true);
		hang.setBackground(Color.ORANGE);
		hang.setForeground(Color.BLACK);
		hang.setFocusPainted(false);
		hang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Homescreen schließen
				screen.dispose();
				
			}
		});
		
		panelback.add(background);
		
		screen.add(panelback);
		screen.add(panelfor);
		
		panelfor.add(ttt);
		panelfor.add(snake);
		panelfor.add(sudoku);
		panelfor.add(memory);
		panelfor.add(tetris);
		panelfor.add(pong);
		panelfor.add(svs);
		panelfor.add(hang);
		
		screen.setVisible(true);
	}
}
