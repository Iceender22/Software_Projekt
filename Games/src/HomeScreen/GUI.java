package HomeScreen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Pong.ballMovement;
import Pong.collision;
import Pong.playerMovement;
import Pong.variablen;

public class GUI {

	JFrame screen;
	JButton ttt, snake, sudoku, memory, tetris, pong;
	
	public GUI() {
		
		screen = new JFrame();
		screen.setSize(800, 600);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLocationRelativeTo(null);
		screen.setResizable(false);
		screen.setTitle("Dies Spielesammlung!");
		// TODO: Layout anpassen
		screen.setLayout(new FlowLayout());
		
		ttt = new JButton("Tic Tac Toe");
		ttt.setBounds(50, 50, 100, 25);
		ttt.setVisible(true);
		ttt.setBackground(Color.CYAN);
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
		snake.setBounds(200, 50, 100, 25);
		snake.setVisible(true);
		snake.setBackground(Color.CYAN);
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
		sudoku.setBounds(350, 50, 100, 25);
		sudoku.setVisible(true);
		sudoku.setBackground(Color.CYAN);
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
		memory.setBounds(500, 50, 100, 25);
		memory.setVisible(true);
		memory.setBackground(Color.CYAN);
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
		tetris.setBounds(50, 100, 100, 25);
		tetris.setVisible(true);
		tetris.setBackground(Color.CYAN);
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
		pong.setBounds(200, 100, 100, 25);
		pong.setVisible(true);
		pong.setBackground(Color.CYAN);
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
		
		screen.add(ttt);
		screen.add(snake);
		screen.add(sudoku);
		screen.add(memory);
		screen.add(tetris);
		screen.add(pong);
		
		screen.setVisible(true);
	}
}
