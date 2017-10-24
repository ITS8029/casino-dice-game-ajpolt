package com.example.casino;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack implements BettingGame {
	private Deck deck;
	
	@Override
	public int playGame(int betAmount) {
		deck = new Deck();
		
		Card dealerFaceUpCard = deck.drawCard();
		
		System.out.println("\nThe dealer shows " + dealerFaceUpCard.toString() + "\n");
		
		int playerTotal = playerTurn();
		
		if(playerTotal > 21) {
			System.out.println("Bust! You lose!");
			
			int dealerTotal = dealerTurn(dealerFaceUpCard);
			
			return -betAmount;
		} else if (playerTotal == 21) {
			System.out.println("Blackjack! You win!");
			return betAmount * 2;
		} else {
			int dealerTotal = dealerTurn(dealerFaceUpCard);
			
			if(dealerTotal > 21) {
				System.out.println("Dealer Busts! You win!");
				return betAmount;
			} else if(dealerTotal == playerTotal) {
				System.out.println("Push!");
				return 0;
			} else if(playerTotal > dealerTotal) {
				System.out.println("You win!");
				return betAmount;
			} else {
				System.out.println("You lose!");
				return -betAmount;
			}
		}
	}
	
	private int dealerTurn(Card card) {
		int total = card.getValue();
		int aceCount = 0;
		
		if(card.getValue() == 1) {
			aceCount++;
		}
		
		while(getTotalWithAces(total, aceCount) < 17) {
			Card nextCard = deck.drawCard();
			System.out.println("The dealer draws the " + nextCard.toString());
			
			total += nextCard.getValue();
			
			if(nextCard.getValue() == 1) {
				aceCount++;
			}
		}
		
		int dealerTotal = getTotalWithAces(total, aceCount);
		
		System.out.println("Dealer total: " + dealerTotal);
		
		return dealerTotal;
	}
	
	private int playerTurn() {
		int total = 0;
		int aceCount = 0;

		for(int x = 0; x < 2; x++) {
			Card nextCard = drawCard();
			
			total += nextCard.getValue();
			
			if(nextCard.getValue() == 1) {
				aceCount++;
			}
		}
		
		Scanner scanner = new Scanner(System.in);
		
		String hitOrStand = null;
		
		do {
			System.out.println("\nYour total is " + getTotalWithAces(total, aceCount));
			System.out.println("Enter 'H' to hit or 'S' to stand");
			
			hitOrStand = scanner.nextLine();
			hitOrStand = hitOrStand.toUpperCase();
			
			while(!(hitOrStand.equals("H") || hitOrStand.equals("S"))) {
				System.out.println("Invalid input. Please enter 'H' to hit or 'S' to stand: " );
				hitOrStand = scanner.nextLine().toUpperCase();
			}
			
			if(hitOrStand.equals("H")) {
				Card nextCard = drawCard();
				total += nextCard.getValue();
				
				if(nextCard.getValue() == 1) {
					aceCount++;
				}
				
				System.out.println("Your total is now " + getTotalWithAces(total, aceCount));
			}
		} while (hitOrStand.equals("H") && getTotalWithAces(total, aceCount) < 21);
		
		return getTotalWithAces(total, aceCount);
	}
	
	private int getTotalWithAces(int total, int aceCount) {
		int totalWithAces = total;
		
		if(aceCount > 0 && total <= 11) {
			totalWithAces += 10;
		}
		
		return totalWithAces;
	}
	
	private Card drawCard() {
		Card nextCard = deck.drawCard();
		
		System.out.println("You draw the " + nextCard.toString());
		
		return nextCard;
	}

	@Override
	public String getGameName() {
		return "Blackjack";
	}

}
