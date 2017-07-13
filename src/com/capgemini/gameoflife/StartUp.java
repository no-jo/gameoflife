package com.capgemini.gameoflife;

import java.util.Scanner;

//import java.util.*;

public class StartUp {

	public static void main(String[] args) {

		// start state
		Integer[][] board = { { 0, 0, 0, 1, 0 }, 
							  { 1, 1, 1, 0, 0 }, 
							  { 0, 0, 0, 1, 0 } };

		GameofLife game = new GameofLife(board);

		Scanner scan = new Scanner(System.in);
		String text = null;

		// continues game
		do {
			board = game.getCurrentBoard();
			print_board(board);
			game.runTurn();
			text = scan.nextLine();
		} while (!text.equals("q"));

		scan.close();
		System.out.println("Game ended");
	}

	private static void print_board(Integer[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int k = 0; k < board[0].length; k++) {
				System.out.printf("%d ", board[i][k]);
			}
			System.out.println();
		}
	}

}
