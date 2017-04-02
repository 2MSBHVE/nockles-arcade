package main;

import java.awt.Color;
import java.util.List;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

public class StartScreen extends ClickableScreen {

	private Graphic background;
	private Button startButton;
	private Button userSetupButton;
	
	private Button stopMusicButton;
	
	public StartScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0, 0, getWidth(), getHeight(), "resources/1995.png");
		viewObjects.add(background);
		
		startButton = new Button(getWidth() / 2, getHeight() - 40, 100, 30, "  START", Color.RED, new Action() {
			public void act() {
				StartProgram.sPrg.setScreen(StartProgram.solitaire);
				StartProgram.solitaire.displayHelp();
			}
		});
		
		viewObjects.add(startButton);
		
		stopMusicButton = new Button(getWidth() - 165, getHeight() - 40, 140, 30, "STOP MUSIC", Color.RED, new Action() {
			public void act() {
				StartProgram.keepPlaying = false;
				StartProgram.clip.stop();
			}
		});
		
		viewObjects.add(stopMusicButton);
		
	}

	

}
