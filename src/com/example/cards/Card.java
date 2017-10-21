package com.example.cards;

public class Card {
	/**
	 * We're representing a suit with an integer instead of a String. Using an integer can often make it easier because
	 * you don't have to worry about things like misspellings or whether the string should be upper/lowercase, etc.
	 * 
	 * Unfortunately, it also means we need to know that 0 is Hearts, 1 is Diamonds, etc.
	 * 
	 * The variables below are called "Constants"
	 * They're helpful in this case so you don't have to remember that Hearts is represented by 0, Diamonds is 1, etc.
	 * 
	 * They are static (remember: that means they belong to the class as a whole, not the instance) so you can access 
	 * them like this: Card.HEARTS, Card.DIAMONDS, etc. Since they're declared as public you can also do this outside of the class.
	 * 
	 * Similarly, a King is a 13, but we don't have to remember that every time if we define it as a constant.
	 * Now instead of remembering that 1 is an Ace or 13 is a King you can then type Card.ACE or Card.KING instead.
	 */
	public static final int HEARTS = 0;
	public static final int DIAMONDS = 1;
	public static final int SPADES = 2;
	public static final int CLUBS = 3;
	
	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	
	//Each card has a suit and value
	public int number;
	public int suit;
	
	/**
	 * Constructor for creating a new Card with a specified value and suit
	 * @param cardValue - The Card's value, generally between 1 (Ace) and 13 (King)
	 * @param cardSuit - The Card's suit, 
	 */
	public Card(int cardValue, int cardSuit) {
		this.number = cardValue;
		this.suit = cardSuit;
	}
	
	/**
	 * Get a String representation of the name of the Suit. 
	 * If it's not a suit we know about, we'll call it a Joker.
	 * 
	 * @return a String containing the name of the suit
	 */
	public String getSuitName() {
		switch(suit) {
			case HEARTS:
				return "Hearts";
			case DIAMONDS:
				return "Diamonds";
			case SPADES:
				return "Spades";
			case CLUBS:
				return "Clubs";
			default:
				return "Joker";
		}
	}
	
	/**
	 * Get the value of the card in our simplified "blackjack" game
	 * 
	 * Remember, Ace is always worth 1 and all face cards are worth 10
	 * 
	 * @return the value of this card for scoring our simplified blackjack game
	 */
	public int getValue() {
		//If this is a face card, the value is 10, otherwise the value is the number on the card
		if(number > 10) {
			return 10;
		} else {
			return number;
		}
	}
	
	/**
	 * Return a String that holds the value of this Card
	 * 
	 * If the card is an Ace, Jack, Queen, or King, return the name.
	 * If the card is a normal numbered card, return the int's value as a String, for example, "8"
	 * 
	 * @return A string containing the Card's value or name, depending if it's a face card or not
	 */
	public String getCardValueName() {
		if(number == Card.ACE) {
			return "Ace";
		} else if (number == Card.JACK) {
			return "Jack";
		} else if (number == Card.QUEEN) {
			return "Queen";
		} else if (number == Card.KING) {
			return "King";
		} else {
			//We can't return an Integer in a method that we've already defined as returning a String,
			//so we'll have to convert the integer value to a String using String.valueOf(int) before
			//we can return it.
			return String.valueOf(number);
		}
	}
	
	/**
	 * Returns a String containing this Card's name, for example, "Ace of Spades" or "2 of Hearts"
	 */
	@Override
	public String toString() {
		return getCardValueName() + " of " + getSuitName();
	}
}
