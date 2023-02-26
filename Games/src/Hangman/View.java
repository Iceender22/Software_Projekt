package Hangman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;

public class View extends JFrame implements KeyListener{
	
	String[] words = {
			"Hausverwaltung", "Mumie", "Discokugel", "empathisch", "Fussgaengerueberweg", "Gitarrensaite", "inspiration", "Quittung", "Kiosk", "Jacuzzi",
			"Bausparvertrag", "Plusquamperfekt", "Obrigkeit", "Trapez", "Aequivalent", "Oval", "Transparenz", "Tendenz", "Strickleiter", "delegieren",
			"Arbeitsunfall", "Charisma", "kohaerent", "lynchen", "Buefett", "Epidemie", "Hobby", "Obsolet", "peripher", "Quarz",
			"Chloroplast", "redundant", "reziprok", "Symmetrie", "uebersaet", "zartbesaitet", "Obszoenitaet", "piesacken", "verhoekern", "Diskrepanz",
			"Zebrastreifen", "einheitlich", "Zwischenablage", "Autolenkrad", "Mobilitaet", "wissenswert", "Yacht", "leugnen", "Xylophon", "Hydrophobie",
					};
	String gesucht;
	Random random = new Random();
	JLabel[] letters; 
	JPanel titel;
	JPanel word;
	JPanel lifeDisplay;
	JPanel bottum;
	int life;
	ArrayList<Character> usedLetters;
	ArrayList<Character> unusedLetters;
	int gefunden;
	JLabel hangman;
	JLabel used;
	JLabel unused;
	JPanel displayUnusedLetters;
    JPanel displayUsedLetters;
    HangmanAction hangmanaction;
	
	public void initialise(HangmanAction hangmanaction) {
		this.hangmanaction = hangmanaction;
	    setTitle("Hang Man");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
	    setLocationRelativeTo(null);                         
	    setSize(1200,700);
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    addKeyListener(this);
	    setBackground(Color.white);
	    this.setLayout(new BorderLayout());
	    addComponents();      

	    setVisible(true);    
	  }
	
	private void addComponents() {
		
		 gesucht = words[random.nextInt(words.length)];
		    letters = new JLabel[gesucht.length()];
		    life = 10;
		    gefunden = 0;
		    usedLetters = new ArrayList<Character>();
		    unusedLetters = new ArrayList<Character>();	    
		    unusedLetters.add('a');
		    unusedLetters.add('b');
		    unusedLetters.add('c');
		    unusedLetters.add('d');
		    unusedLetters.add('e');
		    unusedLetters.add('f');
		    unusedLetters.add('g');
		    unusedLetters.add('h');
		    unusedLetters.add('i');
		    unusedLetters.add('j');
		    unusedLetters.add('k');
		    unusedLetters.add('l');
		    unusedLetters.add('m');
		    unusedLetters.add('n');
		    unusedLetters.add('o');
		    unusedLetters.add('p');
		    unusedLetters.add('q');
		    unusedLetters.add('r');
		    unusedLetters.add('s');
		    unusedLetters.add('t');
		    unusedLetters.add('u');
		    unusedLetters.add('v');
		    unusedLetters.add('w');
		    unusedLetters.add('x');
		    unusedLetters.add('y');
		    unusedLetters.add('z');
		
		titel = new JPanel();
	    titel.setSize(1000, 100);
		
		JLabel tLabel = new JLabel("Hang Man");
	    tLabel.setHorizontalAlignment(JLabel.CENTER);
	    tLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 60));
	    
	    titel.add(tLabel);
	    
	    word = new JPanel();
	    word.setLayout(new FlowLayout());
	    
	    addUnderlines(word);
	    
	    lifeDisplay = new JPanel();
	    hangman = new JLabel();
	    hangman.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
		hangman.setHorizontalAlignment(JLabel.CENTER);
	    lifeDisplay.add(hangman);
	    
	    JPanel displayLetters = new JPanel();
	    displayLetters.setLayout(new GridLayout(1,1));
	    
	    displayUnusedLetters = new JPanel();
	    displayUnusedLetters.setLayout(new GridLayout(2,1));
	    displayUnusedLetters.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	    displayUnusedLetters.setBackground(Color.blue);
	    
	    JLabel titelUnused = new JLabel("Unbenutzte Buchstaben:");
	    titelUnused.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	    titelUnused.setHorizontalAlignment(JLabel.LEFT);
	    titelUnused.setForeground(Color.black);
	    
	    unused = new JLabel();
	    unused.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
	    unused.setForeground(Color.white);
	    
	    addUnusedLetters();
	    
	    displayUnusedLetters.add(titelUnused);
	    displayUnusedLetters.add(unused);
	    
	    displayUsedLetters = new JPanel();
	    displayUsedLetters.setLayout(new GridLayout(2,1));
	    displayUsedLetters.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	    displayUsedLetters.setBackground(Color.red);
	    
	    JLabel titelUsed = new JLabel("Benutzte Buchstaben:");
	    titelUsed.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	    titelUsed.setHorizontalAlignment(JLabel.LEFT);
	    titelUsed.setForeground(Color.white);
	    
	    used = new JLabel();
	    used.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
	    used.setForeground(Color.white);
	    
	    addUsedLetters();
	    
	    titel.setBackground(Color.white);
	    word.setBackground(Color.white);
	    lifeDisplay.setBackground(Color.white);
	    displayLetters.setBackground(Color.white);
	    
	    displayUsedLetters.add(titelUsed);
	    displayUsedLetters.add(used);
	    
	    displayLetters.add(displayUnusedLetters);
	    displayLetters.add(displayUsedLetters);
	    
	    hangman.setIcon(new ImageIcon("./res/life10.png"));
	    JButton reset = new JButton();
		reset.setBackground(Color.red);
		reset.setText("von vorne Beginnen");
		reset.setHorizontalAlignment(JLabel.CENTER);
		reset.addActionListener(this.hangmanaction);
		reset.setActionCommand("reset");
		reset.setFocusable(false);
		reset.setForeground(Color.white);
		reset.setPreferredSize(new Dimension(200, 40));
		JButton home = new JButton();
		home.setBackground(Color.blue);
		home.setText("zur�ck zum Hauptmen�");
		home.setHorizontalAlignment(JLabel.CENTER);
		home.addActionListener(this.hangmanaction);
		home.setActionCommand("home");
		home.setFocusable(false);
		home.setForeground(Color.white);
		home.setPreferredSize(new Dimension(200, 40));
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.setPreferredSize(new Dimension(1000, 50));
		buttons.setBackground(Color.white);
		
		buttons.add(reset);
		buttons.add(home);
		
		bottum = new JPanel();
		bottum.setLayout(new GridLayout(2,1));
		
		bottum.add(displayLetters);
		bottum.add(buttons);
	    
	    this.add(BorderLayout.NORTH, titel);
	    this.add(BorderLayout.CENTER, word);
	    this.add(BorderLayout.EAST, lifeDisplay);
	    this.add(BorderLayout.SOUTH, bottum);
	}

	private void addUnderlines(JPanel parent){
		int laenge = gesucht.length();
		for(int i = 0; i < laenge; i++) {
			letters[i] = new JLabel(" ");
			letters[i].setBorder(BorderFactory.createLineBorder(Color.red, 1));
			letters[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 60));
			letters[i].setHorizontalAlignment(JLabel.LEFT);
        	parent.add(letters[i]);
		}
	}
	
	private void addUnusedLetters() {
		String letterUnused = "";
		Iterator<Character> iterator = unusedLetters.iterator();
		while (iterator.hasNext()) {
			letterUnused = letterUnused + iterator.next();
			if(iterator.hasNext()) {
				letterUnused = letterUnused + ", ";
			}
		}
		unused.setText(letterUnused);
	}

	private void addUsedLetters() {
		String letterUsed = "";
		Iterator<Character> iterator = usedLetters.iterator();	
		while (iterator.hasNext()) {
			letterUsed = letterUsed + iterator.next();
			if(iterator.hasNext()) {
				letterUsed = letterUsed + ", ";
			}
		}
		used.setText(letterUsed);
	}
	
	private void check() {
		if(life == 0) {
			int answer = JOptionPane.showConfirmDialog(this, "Du hast verloren! M�chtest du es erneut versuchen?", null, JOptionPane.YES_NO_OPTION);
			if(answer == 0)
			{
				reset();
			}
			else if(answer == 1){
				this.setTitle("Fenster schlie�en");;
			}
		}
		else if( gefunden == gesucht.length()) {
			int answer = JOptionPane.showConfirmDialog(this, "Du hast das Wort gefunden! M�chtest du nochmal?", null, JOptionPane.YES_NO_OPTION);
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
		this.remove(word);
		this.remove(lifeDisplay);
		this.remove(bottum);
		addComponents();
		this.setVisible(true);
	}
	
	public void home() {
		setTitle("Kehre zur�ck zum Hauptmen�");
	}
	
	@Override
	public void keyTyped(KeyEvent event) {
		char key = Character.toLowerCase(event.getKeyChar());
		int laenge = gesucht.length();
		String lGesucht = gesucht.toLowerCase();
		int nichtGefunden = 0;
		if(key>='a' && key <= 'z') {
			if(!usedLetters.contains(key)) {
				for(int i = 0; i < laenge; i++) {
					if(lGesucht.charAt(i) == key) {
						letters[i].setText(""+gesucht.charAt(i));
						gefunden++;
					}
					else {
						nichtGefunden++;
					}
				}
				if( nichtGefunden == laenge) {
					life--;
					if(life == 9) {
						hangman.setIcon(new ImageIcon("./res/life9.png"));
					}
					else if(life == 8) {
						hangman.setIcon(new ImageIcon("./res/life8.png"));
					}
					else if(life == 7) {
						hangman.setIcon(new ImageIcon(".res/life7.png"));
					}
					else if(life == 6) {
						hangman.setIcon(new ImageIcon("./res/life6.png"));
					}
					else if(life == 5) {
						hangman.setIcon(new ImageIcon("./res/life5.png"));
					}
					else if(life == 4) {
						hangman.setIcon(new ImageIcon("./res/life4.png"));
					}
					else if(life == 3) {
						hangman.setIcon(new ImageIcon("./res/life3.png"));
					}
					else if(life == 2) {
						hangman.setIcon(new ImageIcon("./res/life2.png"));
					}
					else if(life == 1) {
						hangman.setIcon(new ImageIcon("./res/life1.png"));
					}
					else if(life == 0) {
						hangman.setIcon(new ImageIcon("./res/life0.png"));
					}			
				}
				usedLetters.add(key);
				unusedLetters.remove(unusedLetters.indexOf(key));
				addUnusedLetters();
				addUsedLetters();
			}
	    }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Automatisch generierter Methodenstub
		check();
		System.out.println("Gefunden: " + gefunden);
	}
	
}
