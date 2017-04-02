package main;

import java.util.ArrayList;

public class CardsMethods {

	private final static String[][] IMAGES = {
			{}
	};
	
	public static ArrayList<Card> newDeck() {
		ArrayList<Card> deck = new ArrayList<Card>();
		
		for (int s = 0; s < Card.SUITS.length; s++) {
			for (int c = 1; c < Card.NAMES.length; c++) {
				Card card = new Card(c, s);
				deck.add(card);
//				System.out.println(card.getName());
			}
		}
		
		return deck;
	}
	
	public static ArrayList<Card> shuffle(ArrayList<Card> deck){
		ArrayList<Card> deck2 = new ArrayList<Card>();
		while (!deck.isEmpty()) {
			int rand = (int) (Math.random() * deck.size());
			deck2.add(deck.get(rand));
			deck.remove(rand);
		}
		return deck2;
	}

}
