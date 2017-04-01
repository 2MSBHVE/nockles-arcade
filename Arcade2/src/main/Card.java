package main;

public class Card {

	final int DIAMONDS = 0;
	final int CLUBS = 1;
	final int HEARTS = 2;
	final int SPADES = 3;
	
	final int ACE = 1;
	final int JACK = 11;
	final int QUEEN = 12;
	final int KING = 14;
	
	final static String[] SUITS = {"Diamonds", "Clubs", "Hearts", "Spades"};
	final static String[] NAMES = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	
	private static int suit;
	private static int value;
	
	public Card(int suit, int value){
		this.suit = suit;
		this.value = value;
	}
	
	public static String getName(){
		String str = SUITS[suit] + " of " + NAMES[value];
		return str;
	}

	public static int getSuit() {
		return suit;
	}

	public static int getValue() {
		return value;
	}
	
}
