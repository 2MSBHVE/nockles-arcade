package main;

import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import guiPractice.ClickableScreen;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class SolitaireScreen extends ClickableScreen implements KeyListener {

	private Graphic background;
	private Graphic cover;
	private Graphic cover2;
	
	private boolean offeredAutoPlay = false;

	private TextLabel userTextLabel;
	
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
	private ClickableGraphic drawImg;

	private Button useDrawnBtn;
	
	private Button moveCardsBtn;
	private Button newGameBtn;
	private Button exitBtn;

	private int drawIdx;

	private Button selectStack1;
	private Button selectStack2;
	private Button selectStack3;
	private Button selectStack4;
	private Button selectStack5;
	private Button selectStack6;
	private Button selectStack7;

	private Button selectEndStack1;
	private Button selectEndStack2;
	private Button selectEndStack3;
	private Button selectEndStack4;
	
	private Button stopMusicButton;

	int keyPushed = -1;

	private String instructions = "Welcome to Solitaire!" + "\n\n"
			+ "Click the face-down card at the top left - or press 'Q' - to cycle through the deck. \n"
			+ "Click on a \"Stack\" button to move the currently drawn card to a stack. \n"
			+ "Click \"Move Cards\" - or press 'U' - to move cards between stacks. \n"
			+ "\n\n"
			+ "Press 'H' at any time to show this menu, or 'R' to refresh the graphics.";

	public SolitaireScreen(int width, int height) {
		super(width, height);
		
	}

	public void displayHelp(){
		 JOptionPane.showMessageDialog(null, instructions);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// keyPushed = e.getKeyCode();

		if (e.getKeyCode() == KeyEvent.VK_Q) {
			draw();
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			useDrawnCard();
		} else if (e.getKeyCode() == KeyEvent.VK_U) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			useCard2();
		} else if (e.getKeyCode() == KeyEvent.VK_M) {
			checkWinConditions(true);
		} else if (e.getKeyCode() == KeyEvent.VK_N) {
			newGame();
		}else if (e.getKeyCode() == KeyEvent.VK_R) {
			paintStacks();
		}
			else if (e.getKeyCode() == KeyEvent.VK_H) {
			displayHelp();
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

	public void useDrawnCard() {
		System.out.println("useDrawnCard() not completed");

		// give the stack buttons actions

		selectStack1.setAction(new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack1);
				if (successful) {
					deck.remove(draw);
					drawIdx--;
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}

			}
		});

		selectStack2.setAction(new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack2);
				if (successful) {
					deck.remove(draw);
					drawIdx--;
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}

			}
		});

		selectStack3.setAction(new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack3);
				if (successful) {
					deck.remove(draw);
					drawIdx--;
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}

			}
		});

		selectStack4.setAction(new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack4);
				if (successful) {
					deck.remove(draw);
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}

			}
		});

		selectStack5.setAction(new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack5);
				if (successful) {
					deck.remove(draw);
					drawIdx--;
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}

			}
		});

		selectStack6.setAction(new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack6);
				if (successful) {
					deck.remove(draw);
					drawIdx--;
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}

			}
		});

		selectStack7.setAction(new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack7);
				if (successful) {
					deck.remove(draw);
					drawIdx--;
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}

			}
		});

		// Card toMove = deck.remove(drawIdx);
		// drawIdx--;

	}

	private boolean placeCardOnStack(Card card, ArrayList<Card> stack) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println(stack.size());
		if (card != null) {

			if (stack.size() == 0 && card.getValue() == Card.KING) {
				stack.add(card);
				if(card == draw){
					viewObjects.remove(drawImg);
				}
				return true;
			} else if (!stack.isEmpty()) {
				if ((stack.get(stack.size() - 1).getSuit() % 2) != (card.getSuit() % 2)) {
					if (card.getValue() == stack.get(stack.size() - 1).getValue() - 1) {
						stack.add(card);
						if(card == draw){
							viewObjects.remove(drawImg);
						}
						return true;
						
					}
				}
			}
		}
		return false;
	}

	public void draw() {
		if (drawIdx > deck.size() - 1) {
			drawIdx = 0;
		}
		draw = deck.get(drawIdx);
		draw.setTurned(true);
		
		drawImg = new ClickableGraphic(130, 100, 80, 120, draw.getImgLoc());
		viewObjects.add(drawImg);
		
		if (drawIdx == deck.size() - 1) {
			viewObjects.remove(deckImg);
			deckImg = new ClickableGraphic(20, 100, 80, 120, "cardImages/card-outline.png");
			deckImg.setAction(new Action() {
				public void act() {
					System.out.println("drawIdx = " + drawIdx);
					if (drawIdx > deck.size() - 1) {
						drawIdx = 0;
					}
					draw();
				}
			});
			viewObjects.add(deckImg);
//		} else if (!viewObjects.contains(deckImg)) {
		} else if (deckImg.getImagePath() != "cardImages/cardback.png") {
			viewObjects.remove(deckImg);
			deckImg = new ClickableGraphic(20, 100, 80, 120, "cardImages/cardback.png");
			deckImg.setAction(new Action() {
				public void act() {
					System.out.println("drawIdx = " + drawIdx);
					if (drawIdx > deck.size() - 1) {
						drawIdx = 0;
					}
					draw();
				}
			});
			viewObjects.add(deckImg);
		} else {
			deckImg = new ClickableGraphic(20, 100, 80, 120, "cardImages/cardback.png");
			deckImg.setAction(new Action() {
				public void act() {
					System.out.println("drawIdx = " + drawIdx);
					if (drawIdx > deck.size() - 1) {
						drawIdx = 0;
					}
					draw();
				}
			});
			viewObjects.add(deckImg);
			
		}

		// System.out.println(d.size());
		// for (int i = 0; i < d.size(); i++) {
		// System.out.print(d.get(i).getName() + " ");
		// }
		// System.out.println();

		drawIdx++;
		if (drawIdx > deck.size() - 1) {
			drawIdx = 0;
		}
	}

	private void selectCard(Card chosen) {
		boolean inStack = false;

		if (stack1.contains(chosen) || stack2.contains(chosen) || stack3.contains(chosen) || stack4.contains(chosen)
				|| stack5.contains(chosen) || stack6.contains(chosen) || stack7.contains(chosen)) {
			inStack = true;
		}

	}

	void paintStacks() {
		checkWinConditions(false);
		try{
			for (int i = 0; i < viewObjects.size(); i++) {
				if (viewObjects.get(i).getY() > 340 && viewObjects.get(i).getClass() != new Button(0, 0, 2, 2, null, null, null).getClass()) {
					viewObjects.remove(i);
				}
				if (viewObjects.get(i).getX() > 240 && viewObjects.get(i).getY() < 230) {
					viewObjects.remove(i);
				}
			}

			cover = new Graphic(250, 350, getWidth() - 250, (getHeight() - 350) - 75, "resources/green.png");
			cover2 = new Graphic(240, 60, getWidth() - 240, 170, "resources/green.png");

			viewObjects.add(cover);
			viewObjects.add(cover2);

			if (viewObjects.contains(userTextLabel)) {
				viewObjects.remove(userTextLabel);
			}
			viewObjects.add(userTextLabel); 




			ArrayList<ArrayList<Card>> apple = new ArrayList<ArrayList<Card>>();

			apple.add(stack1);
			apple.add(stack2);
			apple.add(stack3);
			apple.add(stack4);
			apple.add(stack5);
			apple.add(stack6);
			apple.add(stack7);

			ArrayList<ArrayList<Card>> endStacksAL = new ArrayList<ArrayList<Card>>();

			endStacksAL.add(endStack1);
			endStacksAL.add(endStack2);
			endStacksAL.add(endStack3);
			endStacksAL.add(endStack4);

			int initX = 250;

			for (int i = 0; i < apple.size(); i++) {

				int initY = 350;

				for (int j = 0; j < apple.get(i).size(); j++) {
					if (j == apple.get(i).size() - 1) {
						apple.get(i).get(j).setTurned(true);
					}

					if (apple.get(i).get(j).isTurned()) {
						viewObjects.add(new Graphic(initX, initY, 80, 120, apple.get(i).get(j).getImgLoc()));
					} else {
						viewObjects.add(new Graphic(initX, initY, 80, 120, "cardImages/cardback.png"));
					}

					initY += 25;
				}

				initX += 100;
			}

			int initX2 = 250;
			for (int i = 0; i < endStacksAL.size(); i++) {
				if (endStacksAL.get(i).size() > 0) {
					viewObjects.add(new Graphic(initX2, 100, 80, 120,
							endStacksAL.get(i).get(endStacksAL.get(i).size() - 1).getImgLoc()));
				}
				initX2 += 100;
			}
		} catch (Exception e) {
			paintStacks();
		}
	}

	private void checkWinConditions(boolean cheat) {
		if ((endStack1.size() + endStack2.size() + endStack3.size() + endStack4.size() == 52) || cheat) {
			JOptionPane.showMessageDialog(null, "You win!");
			StartProgram.sPrg.user.setCompletedSolitaire(true);
			StartProgram.sPrg.setScreen(StartProgram.sPrg.startMenu);
			StartProgram.sPrg.solitaire = new SolitaireScreen(getWidth(), getHeight());
		}
		else if (!offeredAutoPlay) {
			ArrayList<ArrayList<Card>> apple = new ArrayList<ArrayList<Card>>();

			apple.add(stack1);
			apple.add(stack2);
			apple.add(stack3);
			apple.add(stack4);
			apple.add(stack5);
			apple.add(stack6);
			apple.add(stack7);
			
			int unTurnedCards = 0;
			
			for (int i = 0; i < apple.size(); i++) {
				for (int j = 0; j < apple.get(i).size(); j++) {
					Card c = apple.get(i).get(j);
					if(!c.isTurned()){
						unTurnedCards++;
					}
				}
			}
			
			if (unTurnedCards == 0) {
				int n = JOptionPane.showConfirmDialog(
					    null,
					    "There are no unrevealed cards on the board. Would you like to auto-play the rest of the game?",
					    "",
					    JOptionPane.YES_NO_OPTION);
				if(n == 0) {
					checkWinConditions(true);
				}
			}
		}
	}
	
	private void newGame(){
		StartProgram.sPrg.solitaire = new SolitaireScreen(getWidth(), getHeight());
		StartProgram.sPrg.setScreen(StartProgram.sPrg.solitaire);
	}

	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		deck = CardsMethods.shuffle(CardsMethods.newDeck());

		background = new Graphic(0, 0, getWidth(), getHeight(), "resources/green.png");
		viewObjects.add(background);
//		140, 25, 125, 30
		userTextLabel = new TextLabel(280, 25, 1000, 30, "Helvetica", 20, Color.WHITE,
				"User: " + StartProgram.user.getName());
		
		
		
		deckImg = new ClickableGraphic(20, 100, 80, 120, "cardImages/cardback.png");
		deckImg.setAction(new Action() {
			public void act() {
				System.out.println("drawIdx = " + drawIdx);
				if (drawIdx > deck.size() - 1) {
					drawIdx = 0;
				}
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
			for (int j = 0; j < i + 1; j++) {
				apple.get(i).add(deck.remove(0));
			}

			apple.get(i).get(apple.get(i).size() - 1).setTurned(true);

//			System.out.println();
//			System.out.println();
//			System.out.println();
//			for (int j = 0; j < apple.get(i).size(); j++) {
//				System.out.print(apple.get(i).get(j).getName() + " ");
//			}
		}

		paintStacks();

		// make stack selection buttons

		ArrayList<Button> selectStackButtons = new ArrayList<Button>();

		selectStack1 = new Button(250, 300, 80, 30, "Stack 1", Color.GRAY, new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack1);
				if (successful) {
					deck.remove(draw);
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}
			}
		});

		selectStack2 = new Button(350, 300, 80, 30, "Stack 2", Color.GRAY, new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack2);
				if (successful) {
					deck.remove(draw);
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}
			}
		});

		selectStack3 = new Button(450, 300, 80, 30, "Stack 3", Color.GRAY, new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack3);
				if (successful) {
					deck.remove(draw);
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}
			}
		});

		selectStack4 = new Button(550, 300, 80, 30, "Stack 4", Color.GRAY, new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack4);
				if (successful) {
					deck.remove(draw);
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}
			}
		});

		selectStack5 = new Button(650, 300, 80, 30, "Stack 5", Color.GRAY, new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack5);
				if (successful) {
					deck.remove(draw);
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}
			}
		});

		selectStack6 = new Button(750, 300, 80, 30, "Stack 6", Color.GRAY, new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack6);
				if (successful) {
					deck.remove(draw);
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}
			}
		});

		selectStack7 = new Button(850, 300, 80, 30, "Stack 7", Color.GRAY, new Action() {
			public void act() {
				boolean successful = placeCardOnStack(draw, stack7);
				if (successful) {
					deck.remove(draw);
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}
			}
		});

		selectEndStack1 = new Button(250, 240, 80, 30, "Stack A", Color.GRAY, new Action() {
			public void act() {
				boolean successful = placeCardOnEndStack(draw, deck, endStack1);
				if (successful) {
					deck.remove(draw);
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}
			}
		});

		selectEndStack2 = new Button(350, 240, 80, 30, "Stack B", Color.GRAY, new Action() {
			public void act() {
				boolean successful = placeCardOnEndStack(draw, deck, endStack2);
				if (successful) {
					deck.remove(draw);
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}
			}
		});
		selectEndStack3 = new Button(450, 240, 80, 30, "Stack C", Color.GRAY, new Action() {
			public void act() {
				boolean successful = placeCardOnEndStack(draw, deck, endStack3);
				if (successful) {
					deck.remove(draw);
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}
			}
		});
		selectEndStack4 = new Button(550, 240, 80, 30, "Stack D", Color.GRAY, new Action() {
			public void act() {
				boolean successful = placeCardOnEndStack(draw, deck, endStack4);
				if (successful) {
					deck.remove(draw);
					paintStacks();
					if (drawIdx == deck.size() - 1 || drawIdx < 0) {
						drawIdx = 0;
					}
					draw();

				}
			}
		});

		viewObjects.add(selectStack1);
		viewObjects.add(selectStack2);
		viewObjects.add(selectStack3);
		viewObjects.add(selectStack4);
		viewObjects.add(selectStack5);
		viewObjects.add(selectStack6);
		viewObjects.add(selectStack7);

		viewObjects.add(selectEndStack1);
		viewObjects.add(selectEndStack2);
		viewObjects.add(selectEndStack3);
		viewObjects.add(selectEndStack4);

		moveCardsBtn = new Button(1000, 300, 170, 30, "  MOVE CARDS", Color.GRAY, new Action() {
			public void act() {
				useCard2();
			}
		});
		viewObjects.add(moveCardsBtn);
		viewObjects.add(userTextLabel);
		stopMusicButton = new Button(getWidth() - 165, getHeight() - 40, 140, 30, "STOP MUSIC", Color.RED, new Action() {
			public void act() {
				StartProgram.keepPlaying = false;
				StartProgram.clip.stop();
			}
		});
		
		viewObjects.add(stopMusicButton);
		
		exitBtn = new Button(10, 25, 125, 30, "  GO BACK", Color.RED, new Action() {
			public void act() {
				StartProgram.sPrg.setScreen(StartProgram.sPrg.startMenu);
			}
		});
		newGameBtn = new Button(140, 25, 135, 30, " NEW GAME", Color.BLUE, new Action() {
			public void act() {
				newGame();
			}
		});
		viewObjects.add(exitBtn);
		viewObjects.add(newGameBtn);
	}

	private boolean placeCardOnEndStack(Card card, ArrayList<Card> source, ArrayList<Card> dest) {
		// TODO Auto-generated method stub

		if (dest.isEmpty()) {
			if (card.getValue() == 1) {
				dest.add(card);

				// paintStacks();
				return true;
			}
		} else {

			if (card.getSuit() == dest.get(0).getSuit()
					&& card.getValue() == dest.get(dest.size() - 1).getValue() + 1) {
				dest.add(card);

				// paintStacks();
				return true;
			}

		}
		return false;
	}

	// private void useCard2(ArrayList<Card> source, int sourceIdx,
	// ArrayList<Card> destination) {
	private void useCard2() {
		System.out.println("UseCard2 activated");

		ArrayList<ArrayList<Card>> apple = new ArrayList<ArrayList<Card>>();

		apple.add(stack1);
		apple.add(stack2);
		apple.add(stack3);
		apple.add(stack4);
		apple.add(stack5);
		apple.add(stack6);
		apple.add(stack7);

		ArrayList<ArrayList<Card>> endStacksArrayList = new ArrayList<ArrayList<Card>>();

		endStacksArrayList.add(endStack1);
		endStacksArrayList.add(endStack2);
		endStacksArrayList.add(endStack3);
		endStacksArrayList.add(endStack4);

		// int x = askForInput("enter source stack #", 0, 0);
		// int y = askForInput("enter source card index", 0, 0);
		// int z = askForInput("enter dest stack #", 0, 0);
try {
		int x = -1;

		boolean validInput = false;
		while (!validInput) {
			String input1 = JOptionPane.showInputDialog("I want to take cards from Stack...");
			if (input1 == null){
				return;
			}
			try {
				int xTemp = Integer.parseInt(input1);
				if (1 <= xTemp && xTemp <= 7) {
					validInput = true;
					x = xTemp;
				}

			} catch (Exception e) {
				// TODO: handle exception

			}
		}
		final ArrayList<Card> source = apple.get(x - 1);

		// int y = Integer.parseInt(JOptionPane.showInputDialog(null, "enter
		// source card index"));

		ArrayList<String> allCNames = new ArrayList<String>();
		for (int i = 0; i < source.size(); i++) {

			allCNames.add(source.get(i).getName());

		}
		ArrayList<String> cNames = new ArrayList<String>();
		for (int i = source.size() - 1; i >= 0; i--) {
			if (source.get(i).isTurned()) {
				cNames.add(source.get(i).getName());
			}
		}

		int y2 = -1;
		if (cNames.size() == 1) {
			y2 = allCNames.indexOf(cNames.get(0));
		} else {
			Object[] cardNamesInStack = cNames.toArray();

			y2 = allCNames.indexOf(cardNamesInStack[JOptionPane.showOptionDialog(null, "From Stack " + x + ", I want to move the...", "",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, cardNamesInStack, null)]);
			System.out.println(source.get(y2).getName());
		}
		final Card card = source.get(y2);

		String[] endStacks = { "A", "a", "B", "b", "C", "c", "D", "d" };
		ArrayList<String> endStacksLtrAL = new ArrayList<String>();
		for (String str : endStacks) {
			endStacksLtrAL.add(str);
		}

		int z = -1;
		boolean choseEndStack = false;

		String input3 = new String();
		boolean validInput3 = false;
		while (!validInput3) {
			input3 = JOptionPane.showInputDialog("I want to move the " + card.getName() + " from Stack " + x + " to Stack...");
			if (input3 == null){
				return;
			}
			try {
				int zTemp = Integer.parseInt(input3);
				if (1 <= zTemp && zTemp <= 7) {
					validInput3 = true;
					z = zTemp;
				}

			} catch (Exception e) {
				// TODO: handle exception

				if (endStacksLtrAL.contains(input3)) {
					validInput3 = true;
					choseEndStack = true;
				}
			}
		}
		// int z = Integer.parseInt(JOptionPane.showInputDialog(null, "enter
		// dest stack #"));

		final ArrayList<Card> dest;

		int sourceIdx = source.indexOf(card);
		if (choseEndStack) {
			dest = endStacksArrayList.get(endStacksLtrAL.indexOf(input3) / 2);
			if (dest.isEmpty()) {
				if (card.getValue() == 1) {
					dest.add(card);
					source.remove(card);
					paintStacks();
				}
			} else {
				if (sourceIdx == source.size() - 1) {
					if (card.getSuit() == dest.get(0).getSuit()
							&& card.getValue() == dest.get(dest.size() - 1).getValue() + 1) {
						dest.add(card);
						source.remove(card);
						paintStacks();
					}
				}
			}
		} else {
			dest = apple.get(z - 1);

			boolean successful = placeCardOnStack(card, dest);

			if (successful) {
				source.remove(card);
				while (sourceIdx < source.size()) {
					placeCardOnStack(source.get(sourceIdx), dest);
					source.remove(sourceIdx);
				}
				paintStacks();
			}

		}
		
}
catch(Exception e){
	e.printStackTrace();
}

		// give the stack buttons actions

	}

	private static int askForInput(String prompt, int a, int b) {
		Scanner in = new Scanner(System.in);
		System.out.println();
		System.out.println(prompt);
		int x = in.nextInt();
		System.out.println("Entered: " + x);

		return x;
	}

	public void repaintUserName() {
		viewObjects.remove(userTextLabel);
		userTextLabel = new TextLabel(280, 25, 1000, 30, "Helvetica", 20, Color.WHITE,
				"User: " + StartProgram.user.getName());
		viewObjects.add(userTextLabel);
	}

}
