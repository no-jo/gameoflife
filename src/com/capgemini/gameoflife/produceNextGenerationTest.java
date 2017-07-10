package com.capgemini.gameoflife;
 
import static org.junit.Assert.*;

import org.junit.Test;

public class produceNextGenerationTest {
	
	@Test
	public void testConstructorAndGetter() {
		Integer[][] source = {{1,0},{0,0}};
		GameofLife game = new GameofLife(source);
		assertArrayEquals(source, game.getCurrentBoard());
	}

	@Test
	public void simplestCaseofDeath() {
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
	public void assymetricMatrix() {
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
	public void runTwoTurnsAndCheckIfBoardStateIsChanged() {
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
