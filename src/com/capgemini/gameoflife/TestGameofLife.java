/**
 * Test class for the game of life class. Checks if the logic for death and revival works correctly. 
 */

package com.capgemini.gameoflife;
 
import static org.junit.Assert.*;

import org.junit.Test;

public class TestGameofLife {
	
	@Test
	public void shouldCreateAndReturnTheBoard() {
		Integer[][] source = {{1,0},{0,0}};
		GameofLife game = new GameofLife(source);
		assertArrayEquals(source, game.getCurrentBoard());
	}

	@Test
	public void liveCellShouldDieWithNoNeighbours() {
		// Given
		Integer[][] source = {{1}};
		Integer[][] result = {{0}};
		GameofLife game = new GameofLife(source);
		//When
		game.runTurn();
		// Then
		assertArrayEquals(result, game.getCurrentBoard());
	}
	
	@Test
	public void deadCellShouldReviveWithThreeLiveNeighbours() {
	// By game's logic this test simultaneously checks that all live cells with two neighbors stay alive.
		// Given
		Integer[][] source = 
			{{1, 0},
			 {1, 1}};
		
		Integer[][] result = 
			{{1, 1},
			 {1, 1}};
		GameofLife game = new GameofLife(source);
		//When
		game.runTurn();
		// Then
		assertArrayEquals(result, game.getCurrentBoard());
	}
		
	@Test
	public void allValueIntervalsShouldWorkInAssymetricMatrix() {
		//This example tests full game logic at once, 
		//with all possible cases (as value intervals) of live and death.
		// Given
		Integer[][] source = 
			{{0,0,1,1,0},
			 {1,1,1,0,0},
			 {0,0,0,1,0}};
		
		Integer[][] result = 
			{{0,0,1,1,0},
			 {0,1,0,0,0},
		 	 {0,1,1,0,0}};
		
		GameofLife game = new GameofLife(source);
		//When
		game.runTurn();
		// Then
		assertArrayEquals(result, game.getCurrentBoard());		
	}
	
	@Test
	public void boardStateShouldChangeCorrectlyWithTwoTurns() {
		// Given
		Integer[][] source = 
			{{0,0,1,1,0},
			{1,1,1,0,0},
			{0,0,0,1,0}};
		Integer[][] result = 
			{{0,0,1,0,0},
			{0,1,0,1,0},
			{0,1,1,0,0}};
		GameofLife game = new GameofLife(source);
		//When
		game.runTurn();
		game.runTurn();
		// Then
		assertArrayEquals(result, game.getCurrentBoard());		
	}

}
