package Hangman;

public class launcher {
	
	public static void main(String args[])
	{
		View view = new View();
		HangmanAction hangmanaction = new HangmanAction();
		view.initialise(hangmanaction);
		hangmanaction.initialise(view);
	}
}
