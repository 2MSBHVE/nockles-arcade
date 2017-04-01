package main;

public class Card {

	final static int DIAMONDS = 0;
	final static int CLUBS = 1;
	final static int HEARTS = 2;
	final static int SPADES = 3;
	
	final int ACE = 1;
	final int JACK = 11;
	final int QUEEN = 12;
	final int KING = 14;
	
	final static String[] SUITS = {"Diamonds", "Clubs", "Hearts", "Spades"};
	final static String[] NAMES = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	
	private int suit;
	private int value;
	private String imgLoc;
	
	private boolean turned = false;
	
	public boolean isTurned() {
		return this.turned;
	}

	public void setTurned(boolean turned) {
		this.turned = turned;
	}

	public Card(int value, int suit){
		this.value = value;
		this.suit = suit;
	}
	
	public String getName(){
		String str = NAMES[value] + " of " + SUITS[suit];
		return str;
	}

	public int getSuit() {
		return this.suit;
	}

	public int getValue() {
		return this.value;
	}
	
	public String getImgLoc(){
		return "cardImages/" + NAMES[this.value] + "_of_" + SUITS[this.suit] + ".png";
	}
	
}
