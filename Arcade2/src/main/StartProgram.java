/**
 * 
 */
package main;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import guiPractice.GUIApplication;

public class StartProgram extends GUIApplication {
	
	public static StartProgram sPrg;
	public static User user;
	public static StartScreen startMenu;
	
	static Clip clip;
	
	static boolean keepPlaying = true;
	
	public static SolitaireScreen solitaire;
	
	public StartProgram(int width, int height) {
		super(width, height);
	}
	
	@Override
	protected void initScreen() {
		startMenu = new StartScreen(getWidth(), getHeight());
		solitaire = new SolitaireScreen(getWidth(), getHeight());
		user = new User("User");
		
		
		
		setScreen(startMenu);
		
	}
	
	public static void main(String[] args) {
		AudioInputStream audioIn;
		sPrg = new StartProgram(1200, 960);
		Thread app = new Thread(sPrg);
		app.start();
		String[] mikuWAVs = {
				"./miku01.wav",
				"./miku02.wav",
				"./miku03.wav",
				"./miku04.wav",
				"./miku05.wav",
				"./miku06.wav",
				"./miku07.wav",
				"./miku08.wav",
				"./miku09.wav",
				"./miku10.wav",
				"./miku11.wav",
				"./miku12.wav",
				"./miku13.wav",
				"./miku14.wav",
				"./miku15.wav",
				"./miku16.wav",
		};
		
		AudioInputStream[] streams = new AudioInputStream[mikuWAVs.length];
		
		while (keepPlaying) {
			for (int i = 0; i < streams.length; i++) {

				try {
					streams[i] = AudioSystem.getAudioInputStream(StartProgram.class.getResource(mikuWAVs[i]));
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				for (int i = 0; i < streams.length; i++) {
					streams[i] = AudioSystem.getAudioInputStream(StartProgram.class.getResource(mikuWAVs[i]));
				}
				//			audioIn = AudioSystem.getAudioInputStream(StartProgram.class.getResource("./miku01.wav"));

				for (int i = 0; i < streams.length; i++) {

					clip = AudioSystem.getClip();
					clip.open(streams[i]);
					if(!keepPlaying){
						break;
					}
					clip.start();
					System.out.println("Playing: "+ mikuWAVs[i]);
					if (i<streams.length - 1) {
						Thread.sleep(15000);				
					}
					else {
						Thread.sleep(2000);
					}
				}		


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
		}

		
		
	}

}
