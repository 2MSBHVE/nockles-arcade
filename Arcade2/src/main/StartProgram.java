/**
 * 
 */
package main;

import guiPractice.GUIApplication;

public class StartProgram extends GUIApplication {
	
	public static StartProgram sPrg;
	public static User user;
	public static StartScreen startMenu;
	
	public static SolitaireScreen solitaire;
	
	public StartProgram(int width, int height) {
		super(width, height);
	}
	
	@Override
	protected void initScreen() {
		startMenu = new StartScreen(getWidth(), getHeight());
		
		setScreen(startMenu);
	}
	
	public static void main(String[] args) {
		sPrg = new StartProgram(1200, 700);
		Thread app = new Thread(sPrg);
		app.start();
	}

}
