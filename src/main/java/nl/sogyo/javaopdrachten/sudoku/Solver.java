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
	
	public void solve() {
		int start = 0;
		visitPosition(start);
	}
	
	private boolean visitPosition(int pos) {

		List<Integer> options = getOptions(pos);
				
		if( options.size() == 0 ) {
			return false;
		} else {
						
			for(int i : options) {
				
				board[pos] = i;
				if(hasNext(pos)) {
					int next = getNextEmptyPosition(pos);
					boolean solved = visitPosition(next);
					if(solved) {
						return true;
					}
				} else {
					return true;
				}
				
			}
			
			board[pos] = 0;
			return false;
		}
	}
	
	
	private boolean hasNext(int pos) {
		
		for(int i = pos+1; i < 81; i++) {
			if(board[i] == 0) return true;
		}
		
		return false;
			
	}

	private int getNextEmptyPosition(int afterPos) {
		int candidate = afterPos + 1;
		
		
		while(board[candidate] != 0) {
			candidate++;
		}
		
		return candidate;
	}

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
		
		// x and y being used as (0,0) (1,0), etc
		//						 (0,1) (1,1)
		int x = pos % 9;
		int y = pos / 9;
		int boxTopLeft = pos - (x % 3) - (y % 3 * 9);
		
		removeForRow(options, pos - x);
		removeForColumn(options, x);
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
