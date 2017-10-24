package com.example.games;

import com.example.casino.BettingGame;

public class SimpleCraps implements BettingGame {

	@Override
	public int playGame(int betAmount) {
		// TODO Add your code here. Return the amount the user won (or a negative number if they lost!):
		Die die = new Die();
		int rollResult = die.roll();
				
		return 0;
	}

	@Override
	public String getGameName() {
		return "SimpleCraps";
	}

}
