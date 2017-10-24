package com.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Deck {
	ArrayList<Card> cards = new ArrayList<Card>(52);
	
	/**
	 * This is our Constructor: 
	 * When a new Deck is created, we add cards to the deck ArrayList and shuffle them
	 */
	public Deck() {		
		resetDeck();
		shuffle();
	}
	
	/**
	 * Removes the top card from the deck and returns it
	 * 
	 * @return the next Card in the deck
	 */
	public Card drawCard() {
		//Get the position of the last Card in the list in the cards ArrayList (think of this as the "top" of our deck)
		int lastCardPosition = cards.size() - 1;
		
		//Get the card at the last position
		Card nextCard = cards.get(lastCardPosition);
		
		//Remove the card from the deck
		cards.remove(lastCardPosition);
		
		//Return the card
		return nextCard;
	}
	
	/**
	 * Reset the deck to a full deck with a default order
	 * 
	 * After this is called, the order will be:
	 * 
	 * Ace of Hearts, Ace of Spades, Ace of Diamonds, Ace of Clubs,
	 * Two of Hearts, Two of Spades, Two of Diamonds, Two of Clubs,
	 * ...
	 * Queen of Hearts, Queen of Spades, Queen of Diamonds, Queen of Clubs,
	 * King of Hearts, King of Spades, King of Diamonds, King of Clubs
	 */
	public void resetDeck() {
		//Remove all current cards from the deck
		cards.clear();
		
		//For each value, 1 through 13, add one card of each suit to the deck
		for(int x = Card.ACE; x <= Card.KING; x++) {
			cards.add(new Card(x, Card.HEARTS));
			cards.add(new Card(x, Card.SPADES));
			cards.add(new Card(x, Card.DIAMONDS));
			cards.add(new Card(x, Card.CLUBS));
		}
	}
	
	/**
	 * Shuffles the deck, moving each Card to a random position
	 */
	public void shuffle() {
		//For each position in the List
		for(int x = 0; x < cards.size(); x++) {
			//Pick a random position to swap with the card at position x
			Random random = new Random();
			int newPosition = random.nextInt(cards.size() - 1);
			
			//Swap the cards from the current position ("x") into the selected position ("newPosition")
			swapCards(x, newPosition);
		}
	}
	
	/**
	 * Swap the cards at positions a and b in our Deck
	 */
	private void swapCards(int a, int b) {
		//Get the card that we want to move
		Card cardToMove = cards.get(a);
		
		//First, get the card in the new position and save it in a new variable
		Card temp = cards.get(b);
		
		//Now that we've saved the card at the new position (b), it's safe to move the card at "a" to that position
		cards.set(b, cardToMove);
		
		//Move the card from position b (which we saved earlier) into position a
		cards.set(a, temp);
	}
}
