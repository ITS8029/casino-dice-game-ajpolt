package com.example.games;

import java.util.Random;

import com.example.casino.BettingGame;

public class CoinFlip implements BettingGame {

	@Override
	public int playGame(int betAmount) {
		Random random = new Random();
		
		boolean won = random.nextBoolean();
		
		if(won) {
			System.out.println("You win!");
			return betAmount;
		} else {
			System.out.println("You lose");
			return -betAmount;
		}
	}

	@Override
	public String getGameName() {
		return "Coin Flip";
	}

}
