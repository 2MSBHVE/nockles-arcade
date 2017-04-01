package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.Visible;

public class SolitaireScreen extends Screen implements KeyListener {

	public ArrayList<Card> deck = CardsMethods.newDeck();
	
	int keyPushed = -1;
	
	public SolitaireScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyPushed = e.getKeyCode();
		
		// REDRAW
		if (e.getKeyCode() == KeyEvent.VK_Q){
		}
		
		// TAKE FROM TURN
		
		
		// OTHER
		
		else if (e.getKeyCode() == KeyEvent.VK_D){
		
		}
		else if (e.getKeyCode() == KeyEvent.VK_F){
		
		}
		else if (e.getKeyCode() == KeyEvent.VK_G){
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_H){
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_J){
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_K){
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_L){
			
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

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}

	public KeyListener getKeyListener(){
		return this;
	}
	
	
	
}
