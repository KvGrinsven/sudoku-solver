package nl.sogyo.javaopdrachten.sudoku;

import java.util.ArrayList;
import java.util.List;

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
	
	
	private List<Integer> getOptions(int pos) {
		
		List<Integer> options = new ArrayList<>();
		options.add(1);
		options.add(2);
		options.add(3);
		options.add(4);
		options.add(5);
		options.add(6);
		options.add(7);
		options.add(8);
		options.add(9);
		
		int x = pos % 9;
		int y = pos / 9;
		int boxTopLeft = pos - (x % 3) - (y % 3 * 9);
		
		removeForRow(options, pos - x);
		removeForColumn(options, y);
		removeForBox(options, boxTopLeft);
		
		return options;
	}
	
	private void removeForRow(List<Integer> list, int start) {
		for(int i = start; i < start + 9; i++) {
			Integer value = board[i];
			list.remove(value);
		}
	}
	
	private void removeForColumn(List<Integer> list, int y) {
		for(int i = y; i < 81; i += 9) {
			Integer value = board[i];
			list.remove(value);
		}
	}
	
	private void removeForBox(List<Integer> list, int topleft) {
		for(int i = topleft; i < topleft+3; i++) {
			Integer v1 = board[i];
			list.remove(v1);
			
			Integer v2 = board[i+9];
			list.remove(v2);
			
			Integer v3 = board[i+18];
			list.remove(v3);
		}
	}
	
	
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
