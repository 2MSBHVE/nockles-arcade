package main;


import java.awt.Color;

import java.io.IOException;
import java.util.List;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;


import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class StartScreen extends ClickableScreen {

	private boolean newToSolitaire = true;
	
	private TextLabel userTextLabel;
	
	private Graphic background;
	
	private Button startButton;
	private Button userSetupButton;
	
	private Button stopMusicButton;
	
	private Button futureButton;
	
	public StartScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0, 0, getWidth(), getHeight(), "resources/1995.png");
		viewObjects.add(background);
		
		startButton = new Button(getWidth()/2 - 90, getHeight() - 40, 180, 30, " PLAY SOLITAIRE", Color.BLUE, new Action() {
			public void act() {
				StartProgram.sPrg.setScreen(StartProgram.solitaire);
				if (newToSolitaire) {
					StartProgram.solitaire.displayHelp();
					newToSolitaire = false;
				}
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
		
		userSetupButton = new Button(10, 25, 145, 30, " USER SETUP", new Color(0,127,0), new Action() {
			public void act() {
				StartProgram.sPrg.setScreen(StartProgram.sPrg.userMenu);
			}
		});
		viewObjects.add(userSetupButton);
		
		userTextLabel = new TextLabel(165, 25, 1000, 30, "Helvetica", 20, Color.WHITE,
				"User: " + StartProgram.user.getName());
		
		viewObjects.add(userTextLabel);
		
		futureButton = new Button(25, getHeight() - 40, 290, 30, "  RETURN TO THE PRESENT", new Color(0, 127, 127), new Action() {
			@SuppressWarnings("deprecation")
			public void act() {
				endSequence();
			}
		});
		
		viewObjects.add(futureButton);
		
	}
	
	private void endSequence(){
//		Window x = StartProgram.sPrg;
//		StartProgram.sPrg.dispose();
		
		
		StartProgram.keepPlaying = false;
		StartProgram.clip.stop();

		new Thread() {
			public void run() {
				viewObjects.remove(startButton);
			}
		}.start();
		
		new Thread() {
			public void run() {

				try {

					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(StartProgram.class.getResource("./end.wav")));
					clip.start();
					Thread.sleep(22200);
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.exit(0);
			}
		}.start(); 
		
		new Thread() {
			public void run() {
				
				
				
//				StartProgram.sPrg.setName("Corrupted");
				boolean b = true;
				while(true){
//					boolean b = (Math.random() < 0.5);
					b = !b;
					if(b){
						StartProgram.sPrg.setTitle("WARNING!");
					} else {
						StartProgram.sPrg.setTitle("Program Corrupted");
					}

//					StartProgram.sPrg.repaint();
					
//					StartProgram.sPrg.update(null);
					
				    
					try {
						Thread.sleep(750);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				try {
					Thread.sleep(7871);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
//				
				
				boolean b = true;
				while(true){
//					boolean b = (Math.random() < 0.5);
					b = !b;
					StartProgram.sPrg.setVisible(b);
//					StartProgram.sPrg.repaint();
					
//					StartProgram.sPrg.update(null);
					
				    
					try {
						Thread.sleep((long) ((Math.random() * 125)));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start(); 
		
		try {
			Thread.sleep(19452);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			JOptionPane.showMessageDialog(null, "Returning to the future... \n\n"
					+ "Incoming message from 1995: \n"
					+ "Hope you had fun! But before you go, just remember... \n"
					+ "Don't do anything stupid like elect some billionaire as President or something...");
		}
	
	}

	public void repaintUserName() {
		viewObjects.remove(userTextLabel);
		userTextLabel = new TextLabel(165, 25, 1000, 30, "Helvetica", 20, Color.WHITE,
				"User: " + StartProgram.user.getName());
		
		viewObjects.add(userTextLabel);
		}

	

}
