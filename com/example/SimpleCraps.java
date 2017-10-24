package com.example;

public class SimpleCraps implements BettingGame {

	@Override
	public int playGame(int betAmount) {
		// TODO Add your code here. Return the amount the user won (or a negative number if they lost!)
		
		//To create a die, use:
		//Die die = new Die();
		
		//To roll the die you created, use:
		//int rollResult = die.roll();
		
		//If the result is a win, return betAmount:
		//return betAmount;
		
		//If the result is a loss, return -betAmount:
		//return -betAmount;
		
		//If the result is a draw, return 0:
		return 0;
	}

	@Override
	public String getGameName() {
		return "SimpleCraps";
	}

}
