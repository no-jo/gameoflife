package com.capgemini.gameoflife;
//import java.util.*;

public class GameofLife {
	
	private Integer[][] board;
	private Integer rows;
	private Integer cols;

	
	public GameofLife (Integer[][] board) {
		this.board = board;
		this.rows = board.length;
		this.cols = board[0].length;
	}
	
	public void runTurn() {
		
		Integer[][] temporary_board = cloneArray(board);
		produceNextGeneration(temporary_board);
		this.board = cloneArray(temporary_board);
	}
	
	public Integer[][] getCurrentBoard() {
		return board;
	};
	
	private void produceNextGeneration(Integer[][] temporary_board) {

		for (int i = 0; i < rows; i++){
			for (int k = 0; k < cols; k++) {
				if (should_square_live(i, k)) {
					temporary_board[i][k] = 1;
				}
				else {
					temporary_board[i][k] = 0;
				}
			}
		}
				
		return;
	}
	
	private Boolean should_square_live(int rowPos, int colPos) {
		int live_neighbors_counter = count_live_neighbors(rowPos, colPos);
		
		if (live_neighbors_counter == 3 ||
			(live_neighbors_counter == 2 && board[rowPos][colPos] == 1)) 
			return true;
		else
			return false;
	}

	private int count_live_neighbors(int rowPos, int colPos) {
		int live_neighbors_counter = 0;
		
		int startingPointInRow = rowPos > 0 ? rowPos - 1 : rowPos;
		int endingPointInRow = rowPos < rows - 1 ? rowPos + 1 : rowPos;
		int startingPointInCol = colPos > 0 ? colPos - 1 : colPos;
		int endingPointInCol = colPos < cols - 1 ? colPos + 1 : colPos;
		
		for (int i = startingPointInRow; i <= endingPointInRow; i++) {
			for (int k = startingPointInCol; k <= endingPointInCol; k++) {
				if (i != rowPos || k != colPos)
					live_neighbors_counter += board[i][k];
			}
		}	
		return live_neighbors_counter;
	};
	
	private static Integer[][] cloneArray(Integer[][] source) {
	    Integer length = source.length;
	    Integer[][] target = new Integer[length][source[0].length];
	    for (int i = 0; i < length; i++) {
	        System.arraycopy(source[i], 0, target[i], 0, source[i].length);
	    }
	    return target;
	}

}
