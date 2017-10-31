package com.example;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.AlwaysLose;
import com.example.BettingGame;
import com.example.Blackjack;
import com.example.CoinFlip;
import com.example.SimpleCraps;

public class Casino {
	public static void main(String[] args) {
		int totalCash = 100;
		
		test();
		
		while(totalCash > 0) {
			ArrayList<BettingGame> games = new ArrayList<>();
			
			System.out.println("Press 1 for Blackjack");
			
			games.add(new Blackjack());
			games.add(new CoinFlip());
			games.add(new AlwaysLose());
			games.add(new SimpleCraps());
			
			System.out.println("\nWelcome to the casino! You have $" + totalCash);
			
			for(int x = 0; x < games.size(); x++) {
				BettingGame game = games.get(x);
				System.out.println((x + 1) + ". " + game.getGameName());
			}
			
			System.out.println("Enter a number to choose a game:");
			
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
		
		System.out.println("You're out of money. Goodbye.");
	}
	
	private static void test() {
		int x = 2;
		x ++;
		System.out.println("X is " + x);
		
		if(x == 1) {
			return;
		}
		
		x ++;
		System.out.println("X is " + x);
	}
	
	
	
	
	
	
}
