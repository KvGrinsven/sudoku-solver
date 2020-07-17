package nl.sogyo.javaopdrachten.sudoku;

public class Main {

	public static void main(String[] args) {
		
		String sudoku = "000820090500000000308040007100000040006402503000090010093004000004035200000700900";
		
		Solver s = new Solver(sudoku);
		// Solve doesn't do anything yet :P
		s.solve();
		s.printResult();
		
	}

}
