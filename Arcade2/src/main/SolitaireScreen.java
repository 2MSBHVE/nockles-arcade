package main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import guiPractice.ClickableScreen;
import guiPractice.Screen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

public class SolitaireScreen extends ClickableScreen implements KeyListener {

	private ArrayList<Card> deck;
	private ClickableGraphic deckImg;
	
	
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
	private Graphic drawImg;
	
	private int drawIdx;
	
	private Button selectStack1;
	private Button selectStack2;
	private Button selectStack3;
	private Button selectStack4;
	private Button selectStack5;
	private Button selectStack6;
	private Button selectStack7;
	

	int keyPushed = -1;
	
	public SolitaireScreen(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
//		keyPushed = e.getKeyCode();
		
		
		if (e.getKeyCode() == KeyEvent.VK_Q){
			draw();
		}
		else if (e.getKeyCode() == KeyEvent.VK_W){
			selectCard(draw);
		}
	}

	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	public void draw() {
		if (drawIdx >= deck.size()) {
			drawIdx = 0;
		}
		draw = deck.get(drawIdx);
//		deck.remove(0);
		
//		if (viewObjects.contains(drawImg)) {
//			viewObjects.remove(drawImg);
//		}
		drawImg = new Graphic(130, 100, 80, 120, draw.getImgLoc());
		viewObjects.add(drawImg);
		if (drawIdx == deck.size() -1) {
			viewObjects.remove(deckImg);
		}
		else if (!viewObjects.contains(deckImg)) {
			viewObjects.add(deckImg);
		}
		
//		System.out.println(d.size());
//		for (int i = 0; i < d.size(); i++) {
//			System.out.print(d.get(i).getName() + " ");
//		}
//		System.out.println();
		
		drawIdx++;
		if (drawIdx >= deck.size()) {
			drawIdx = 0;
		}
	}
	
	private void selectCard(Card chosen) {
		boolean inStack = false;
		
		if (stack1.contains(chosen) ||
			stack2.contains(chosen) ||
			stack3.contains(chosen) ||
			stack4.contains(chosen) ||
			stack5.contains(chosen) ||
			stack6.contains(chosen) ||
			stack7.contains(chosen)	) {
			inStack = true;
		}
		
	}
	
	private void paintStacks() {
		ArrayList<ArrayList<Card>> apple = new ArrayList<ArrayList<Card>>();
		
		apple.add(stack1);
		apple.add(stack2);
		apple.add(stack3);
		apple.add(stack4);
		apple.add(stack5);
		apple.add(stack6);
		apple.add(stack7);
		
		int initX = 250;
		
		for (int i = 0; i < apple.size(); i++) {
			
			int initY = 350;
			
			for (int j = 0; j < apple.get(i).size(); j++) {
//				apple.get(i).get(j)
				if (apple.get(i).get(j).isTurned()) {
					viewObjects.add(new Graphic(initX, initY, 80, 120, apple.get(i).get(j).getImgLoc()));
				}
				else {
					viewObjects.add(new Graphic(initX, initY, 80, 120, "cardImages/cardback.png"));
				}
				
				initY += 25;
			}
			
			initX += 100;
		}
	}
	
	public KeyListener getKeyListener(){
		return this;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
deck = CardsMethods.shuffle(CardsMethods.newDeck());
		
		deckImg = new ClickableGraphic(20, 100, 80, 120, "cardImages/cardback.png");
		deckImg.setAction(new Action() {
			public void act() {
				draw();
			}
		});
		viewObjects.add(deckImg);
		
		drawIdx = 0;
		
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
		
		ArrayList<ArrayList<Card>> apple = new ArrayList<ArrayList<Card>>();
		
		apple.add(stack1);
		apple.add(stack2);
		apple.add(stack3);
		apple.add(stack4);
		apple.add(stack5);
		apple.add(stack6);
		apple.add(stack7);
		
		for (int i = 0; i < apple.size(); i++) {
			for (int j = 0; j < i+1; j++) {
				apple.get(i).add(deck.remove(0));
			}
			
			apple.get(i).get(apple.get(i).size() - 1).setTurned(true);
			
			System.out.println();
			System.out.println();
			System.out.println();
			for (int j = 0; j < apple.get(i).size(); j++) {
				System.out.print(apple.get(i).get(j).getName() + " ");
			}
		}
		
		paintStacks();
		
		
//		make stack selection buttons
		
		ArrayList<Button> selectStackButtons = new ArrayList<Button>(); 
		
		selectStack1 = new Button(250, 300, 80, 30, "stack 1", Color.RED, new Action() {
			public void act() {
				
			}
		});
		
//		selectStack2
//		selectStack3
//		selectStack4
//		selectStack5
//		selectStack6
//		selectStack7
		
		
			viewObjects.add(selectStack1);
	}
	
	
	
}
