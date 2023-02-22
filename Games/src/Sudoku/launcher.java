package Sudoku;

//Hauptklasse
public class launcher{
 
 //Main Methode
 public static void main(String args[])
 {
	 View view = new View();
	 SudokuAction sudokuaction = new SudokuAction();
	 
	 view.initialise(sudokuaction);
	 sudokuaction.initialise(view);
 }
}
