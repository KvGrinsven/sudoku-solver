package nl.sogyo.javaopdrachten.sudoku;

public class Solver {
	
	int[] board;

	public Solver(String sudoku) {
		
		board = new int[81];
		
		for(int i = 0; i < 81; i++ ) {
			char c = sudoku.charAt(i);
			board[i] = Character.getNumericValue(c);
		}
		
	}
	
	// TODO Implement, dah :P
	public boolean solve() {return true;}
	
	
	// TODO Add actual | and - stuff, if I want to
	public void printResult() {
		
		for(int i = 0; i < 81; i++ ) {
			
			if( i % 9 == 0 ) {
				System.out.println();
			}
			
			System.out.print(board[i] + " ");
			
		}
	}
}
