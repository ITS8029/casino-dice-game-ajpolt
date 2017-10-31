package com.example;

public class SimpleCraps implements BettingGame {

	@Override
	public int playGame(int betAmount) {
		Die die1 = new Die();
		Die die2 = new Die();
		
		int playerTotal = 0;
		int rollTotal = 0;
		
		while(rollTotal != 7) {
			rollTotal = die1.roll() + die2.roll();
			
			System.out.println("You rolled a " + rollTotal);
			
			playerTotal += rollTotal;
		}
		
		System.out.println("Player total: " + playerTotal);
		
		rollTotal = 0;
		int dealerTotal = 0;
		
		while(rollTotal != 7) {
			rollTotal = die1.roll() + die2.roll();
			System.out.println("Dealer rolled a " + rollTotal);
			dealerTotal += rollTotal;
		}
		
		System.out.println("Dealer Total: " + dealerTotal);
		
		if(playerTotal > dealerTotal) {
			System.out.println("You win!");
			return betAmount;
		} else if (dealerTotal > playerTotal) {
			System.out.println("You lose!");
			return -betAmount;
		} else {
			System.out.println("You tied");
			return 0;
		}
	}

	@Override
	public String getGameName() {
		return "SimpleCraps";
	}

}
