package Hangman;

import java.awt.BorderLayout;
import java.awt.Color;
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
	JPanel displayLetters;
	int life;
	ArrayList<Character> usedLetters;
	ArrayList<Character> unusedLetters;
	int gefunden;
	JLabel hangman;
	JLabel used;
	JLabel unused;
	
	public void initialise() {
	    setTitle("Hang Man");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
	    setLocationRelativeTo(null);                         
	    setSize(1000,500);
	    addKeyListener(this);
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
	    unusedLetters.add('a');
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
	    
	    addComponents();      //Komponenten einfügen

	    setVisible(true);    
	  }
	
	private void addComponents() {
		this.setLayout(new BorderLayout());
		
		titel = new JPanel();
	    titel.setSize(1000, 100);
		
		JLabel tLabel = new JLabel("Hang Man");
	    tLabel.setHorizontalAlignment(JLabel.CENTER);
	    tLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
	    
	    titel.add(tLabel);
	    
	    word = new JPanel();
	    word.setLayout(new FlowLayout());
	    
	    addUnderlines(word);
	    
	    lifeDisplay = new JPanel();
	    hangman = new JLabel("Leben: " + life);
	    hangman.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
		hangman.setHorizontalAlignment(JLabel.CENTER);
	    lifeDisplay.add(hangman);
	    
	    displayLetters = new JPanel();
	    displayLetters.setLayout(new FlowLayout());
	    
	    JPanel displayUnusedLetters = new JPanel();
	    displayUnusedLetters.setLayout(new GridLayout(2,1));
	    
	    JLabel titelUnused = new JLabel("Unbenutzte Buchstaben:");
	    titelUnused.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	    titelUnused.setHorizontalAlignment(JLabel.LEFT);
	    
	    unused = new JLabel("");
	    unused.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
	    unused.setHorizontalAlignment(JLabel.CENTER);
	    
	    addUnusedLetters();
	    
	    displayUnusedLetters.add(titelUnused);
	    displayUnusedLetters.add(unused);
	    
	    JPanel displayUsedLetters = new JPanel();
	    displayUsedLetters.setLayout(new GridLayout(2,1));
	    
	    JLabel titelUsed = new JLabel("Benutzte Buchstaben:");
	    titelUsed.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	    titelUsed.setHorizontalAlignment(JLabel.LEFT);
	    
	    used = new JLabel("");
	    used.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
	    used.setHorizontalAlignment(JLabel.CENTER);
	    
	    addUsedLetters();
	    
	    displayUsedLetters.add(titelUsed);
	    displayUsedLetters.add(used);
	    
	    displayLetters.add(displayUnusedLetters);
	    displayLetters.add(displayUsedLetters);
	    
	    this.add(BorderLayout.NORTH, titel);
	    this.add(BorderLayout.WEST, word);
	    this.add(BorderLayout.EAST, lifeDisplay);
	    this.add(BorderLayout.SOUTH, displayLetters);
	}

	private void addUnderlines(JPanel parent){
		int laenge = gesucht.length();
		for(int i = 0; i < laenge; i++) {
			letters[i] = new JLabel("");
			letters[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			letters[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
			letters[i].setHorizontalAlignment(JLabel.CENTER);
        	parent.add(letters[i]);
		}
	}
	
	private void addUnusedLetters() {
		String letterUnused = "";
		Iterator<Character> iterator = unusedLetters.iterator();
		int linebreak = 0;
		while (iterator.hasNext()) {
			letterUnused = letterUnused + iterator.next() + ", ";
			linebreak++;
			if(linebreak == 7) {
				letterUnused = letterUnused + '\n';
				linebreak = 0;
			}
		}
		unused.setText(letterUnused);
	}

	private void addUsedLetters() {
		String letterUsed = "";
		Iterator<Character> iterator = usedLetters.iterator();
		int linebreak = 0;
		while (iterator.hasNext()) {
			letterUsed = letterUsed + iterator.next() + ", ";
			linebreak++;
			if(linebreak == 7) {
				letterUsed = letterUsed + '\n';
				linebreak = 0;
			}
		}
		used.setText(letterUsed);
	}
	
	private void check() {
		hangman.setText("Leben: " + life);
		if(life == 0) {
			int answer = JOptionPane.showConfirmDialog(this, "Du hast verloren! Möchtest du es erneut versuchen?", null, JOptionPane.YES_NO_OPTION);
			if(answer == 0)
			{
				reset();
			}
			else if(answer == 1){
				this.setTitle("Fenster schließen");;
			}
		}
		else if( gefunden == gesucht.length()) {
			int answer = JOptionPane.showConfirmDialog(this, "Du hast das Wort gefunden! Möchtest du nochmal?", null, JOptionPane.YES_NO_OPTION);
			if(answer == 0)
			{
				reset();
			}
			else if(answer == 1){
				this.setTitle("Fenster schließen");;
			}
		}
	}
	
	private void reset(){
		this.remove(titel);
		this.remove(word);
		this.remove(lifeDisplay);
		this.remove(displayLetters);
		initialise();
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
		// TODO Automatisch generierter Methodenstub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Automatisch generierter Methodenstub
		check();
		System.out.println("Gefunden: " + gefunden);
	}
	
}
