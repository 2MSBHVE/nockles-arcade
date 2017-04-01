package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import guiPractice.Screen;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

public class SolitaireScreen extends Screen implements KeyListener {

	private ArrayList<Card> deck;
	
	private ArrayList<Card> endStack1;
	private ArrayList<Card> endStack2;
	private ArrayList<Card> endStack3;
	private ArrayList<Card> endStack4;
	
	private ArrayList<Card> stack1;
	private ArrayList<Card> stack2;
	private ArrayList<Card> stack3;
	private ArrayList<Card> stack4;
	private ArrayList<Card> stack5;
	private ArrayList<Card> stack6;
	private ArrayList<Card> stack7;
	
	private Card draw; 
	

	int keyPushed = -1;
	
	public SolitaireScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyPushed = e.getKeyCode();
		
		// REDRAW
//		if (e.getKeyCode() == KeyEvent.VK_Q){
//		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		
		deck = CardsMethods.shuffle(CardsMethods.newDeck());
		
		endStack1 = new ArrayList<Card>();
		endStack2 = new ArrayList<Card>();
		endStack3 = new ArrayList<Card>();
		endStack4 = new ArrayList<Card>();
		
		stack1 = new ArrayList<Card>();
		stack2 = new ArrayList<Card>();
		stack3 = new ArrayList<Card>();
		stack4 = new ArrayList<Card>();
		stack5 = new ArrayList<Card>();
		stack6 = new ArrayList<Card>();
		stack7 = new ArrayList<Card>();
		
		
		for (int i = 0; i < 1; i++) {
			int idx = deck.size() - 1;
			stack1.add(deck.get(idx));
			deck.remove(idx);
		}
		
		Card c = new Card(Card.SPADES, 4);
		Graphic g = new Graphic(110, 100, 100, 150, c.getImgLoc());
		viewObjects.add(g);
	}
	
	public void draw() {
		
	}

	public KeyListener getKeyListener(){
		return this;
	}
	
	
	
}
