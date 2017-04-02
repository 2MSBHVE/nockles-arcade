package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class UserScreen extends ClickableScreen {

	private Graphic background;
	private Graphic logo;
	
	private TextLabel screenText;
	
	private TextLabel userName;
	private TextLabel userURL;
	
	private Button changeNameBtn;
	private Button changeUrlBtn;
	private Button backBtn;
	private Button stopMusicButton;
	
	private User myUser;
	
	
	public UserScreen(User user, int width, int height) {
		super(width, height);
		this.myUser = user;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		
		background = new Graphic(0, 0, getWidth(), getHeight(), "resources/black.png");
		viewObjects.add(background);
		
		logo = new Graphic(700, 0, 500, 341, "resources/1995.png");
		viewObjects.add(logo);
		
		screenText = new TextLabel(((getWidth() / 2) - (145)), 25, 290, 60, "Helvetica", 40, Color.WHITE,
				"USER SETUP");
		viewObjects.add(screenText);
		
		backBtn = new Button(10, 25, 125, 30, "  GO BACK", Color.RED, new Action() {
			public void act() {
				StartProgram.sPrg.setScreen(StartProgram.sPrg.startMenu);
			}
		});
		viewObjects.add(backBtn);
		
		stopMusicButton = new Button(getWidth() - 165, getHeight() - 40, 140, 30, "STOP MUSIC", Color.RED, new Action() {
			public void act() {
				StartProgram.keepPlaying = false;
				StartProgram.clip.stop();
			}
		});
		viewObjects.add(stopMusicButton);
		
		changeNameBtn = new Button(10, 225, 115, 30, "  CHANGE", Color.GRAY, new Action() {
			public void act() {
				String inputName = (String)JOptionPane.showInputDialog(null,
						"My name is...",
	                    "Change My Name",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    null,
	                    StartProgram.user.getName());
				if (inputName != null){
					StartProgram.user.setName(inputName);
					repaintMyStuff();
				}
			}
		});
		viewObjects.add(changeNameBtn);
		
		userName = new TextLabel(150, 225, 1000, 30, "Helvetica", 20, Color.WHITE,
				"My Name: " + StartProgram.user.getName());
		
		viewObjects.add(userName);
		
		changeUrlBtn = new Button(10, 325, 115, 30, "  CHANGE", Color.GRAY, new Action() {
			public void act() {
				String inputName = (String)JOptionPane.showInputDialog(null,
						"http://www.myspace.com/",
	                    "Change My URL",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    null,
	                    StartProgram.user.getURL());
				if (inputName != null){
					StartProgram.user.setURL(inputName);
					repaintMyStuff();
				}
			}
		});
		viewObjects.add(changeUrlBtn);
		
		userURL = new TextLabel(150, 325, 1000, 30, "Helvetica", 20, Color.WHITE,
				"My MySpace: " + StartProgram.user.getURL());
		
		viewObjects.add(userURL);
		
	}
	
	private void repaintMyStuff(){
		viewObjects.remove(userName);
		userName = new TextLabel(150, 225, 1000, 30, "Helvetica", 20, Color.WHITE,
				"My Name: " + StartProgram.user.getName());
		
		viewObjects.add(userName);
		StartProgram.sPrg.startMenu.repaintUserName();
		StartProgram.sPrg.solitaire.repaintUserName();
		StartProgram.sPrg.solitaire.paintStacks();
		
		viewObjects.remove(userURL);
		if (StartProgram.user.getURL() != "") {
			userURL = new TextLabel(150, 325, 1000, 30, "Helvetica", 20, Color.WHITE,
					"My MySpace: http://www.myspace.com/" + StartProgram.user.getURL());
		}
		else {
			userURL = new TextLabel(150, 325, 1000, 30, "Helvetica", 20, Color.WHITE,
					"My MySpace: " + StartProgram.user.getURL());
		}
		viewObjects.add(userURL);
		
	}

}
