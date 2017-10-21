package com.example.casino;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.games.AlwaysLose;
import com.example.games.Blackjack;
import com.example.games.CoinFlip;
import com.example.games.SimpleCraps;

public class Casino {
	public static void main(String[] args) {
		int totalCash = 100;
		
		while(totalCash > 0) {
			ArrayList<BettingGame> games = new ArrayList<>();
			
			games.add(new Blackjack());
			games.add(new CoinFlip());
			games.add(new AlwaysLose());
			games.add(new SimpleCraps());
			
			System.out.println("\nWelcome to the casino! You have $" + totalCash);
			
			for(int x = 0; x < games.size(); x++) {
				BettingGame game = games.get(x);
				System.out.println((x + 1) + ". " + game.getGameName());
			}
			
			System.out.println("Enter a number to choose:");
			
			Scanner myScanner = new Scanner(System.in);
			
			int selection = myScanner.nextInt();
			
			BettingGame game;
			
			if(selection > 0 && selection <= games.size()) {
				game = games.get(selection - 1);
			} else {
				System.out.println("Invalid choice--Enter a nuber between 1-4");
				continue;
			}
			
			System.out.println("Enter a bet amount: ");
			
			int betAmount = myScanner.nextInt();
			
			while(betAmount < 0 || betAmount > totalCash) {
				System.out.println("Invalid bet amount. Please enter an amount between 1 and " + totalCash);
				
				betAmount = myScanner.nextInt();
			}
			
			int amountWon = game.playGame(betAmount);
			
			if(amountWon > 0) {
				System.out.println("You won $" + amountWon);
			} else {
				System.out.println("You lost $" + -amountWon);
			}
			totalCash += amountWon;
		}
	}
}
