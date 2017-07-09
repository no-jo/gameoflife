package com.capgemini.gameoflife;

//import java.util.*;

public class StartUp {

	public static void main(String[] args) {
		
		Integer[][] board = {{0,0,1,1,0},
				{1,1,1,0,0},{0,0,0,1,0}};
		//board = [1,2]
		GameofLife game = new GameofLife(board);
		print_board(board);
		System.out.println();

		game.runTurn();
		board = game.getCurrentBoard();
		
		System.out.println();
		print_board(board);

	}

	private static void print_board(Integer[][] board) {
		for (int i = 0; i < board.length; i++){
			for (int k = 0; k < board[0].length; k++) {				
				System.out.printf("%d\t", board[i][k]);
			}
			System.out.println();
		}
	}

}
