package com.example;

public class AlwaysLose implements BettingGame {

	@Override
	public int playGame(int betAmount) {
		return -betAmount;
	}

	@Override
	public String getGameName() {
		return "Always Lose";
	}

}
