package main;

import java.awt.Color;
import java.util.List;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Visible;

public class StartScreen extends ClickableScreen {

	private Button startButton;
	
	public StartScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		

		startButton = new Button(getWidth() / 2, getHeight() - 40, 100, 30, "START", Color.RED, new Action() {
			public void act() {
				StartProgram.sPrg.setScreen(StartProgram.solitaire);
			}
		});
		
		viewObjects.add(startButton);
		
	}

	

}
