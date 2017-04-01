package main;

import java.util.ArrayList;

public class CardsMethods {

	
	
	public static ArrayList<Card> newDeck() {
		ArrayList<Card> deck = new ArrayList<Card>();
		
		for (int s = 0; s < Card.SUITS.length; s++) {
			for (int c = 1; c < Card.NAMES.length; c++) {
				deck.add(new Card(s, c));
			}
		}
		
		return deck;
	}

}
