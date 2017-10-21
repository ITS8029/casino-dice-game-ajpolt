package com.example.casino;

import java.util.Scanner;

import com.example.games.AlwaysLose;
import com.example.games.Blackjack;
import com.example.games.CoinFlip;
import com.example.games.SimpleCraps;

public class Casino {
	public static void main(String[] args) {
		int totalCash = 100;
		
		while(totalCash > 0) {
			System.out.println("Welcome to the casino! You have $" + totalCash);
			
			System.out.println("1. Blackjack");
			System.out.println("2. Coin Flip");
			System.out.println("3. Always Lose");
			System.out.println("4. SimpleCraps");
			
			System.out.println("Enter a number to choose:");
			
			Scanner myScanner = new Scanner(System.in);
			
			int selection = myScanner.nextInt();
			
			BettingGame game;
			
			if(selection == 1) {
				game = new Blackjack();
			} else if (selection == 2) {
				game = new CoinFlip();
			} else if (selection == 3) {
				game = new AlwaysLose();
			} else if (selection == 4) {
				game = new SimpleCraps();
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
