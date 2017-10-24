package com.example.casino;

import java.util.Random;
import java.util.Scanner;

public class CoinFlip implements BettingGame {

	@Override
	public int playGame(int betAmount) {
		Random random = new Random();
		
		
		
		Scanner scanner = new Scanner(System.in);
		String input = "";
		
		while(!(input.equals("h") || input.equals("t"))) {
			System.out.println("Enter 'H' for Heads or 'T' for tails:");
			
			input = scanner.nextLine();
			
			//Convert to lowercase so we don't have to check for both uppercase and lowercase
			input = input.toLowerCase();
			
			if(!(input.equals("h") || input.equals("t"))) {
				System.out.println("Invalid choice. Options are 'H' or 'T'");
			}
		}
		
		boolean won;
		
		boolean heads = random.nextBoolean();
		
		System.out.print("The result was ");
		
		if(heads) {
			System.out.println("heads");
		} else {
			System.out.println("tails");
		}
		
		won = (input.equals("h") && heads) || (input.equals("t") && !heads);
		
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
