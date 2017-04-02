package main;

import java.util.ArrayList;

public class User {
	
	private String name;
	private String myURL;
	private boolean completedSolitaire;
	
	public User(String name) {
		this.name = name;
		this.myURL = "";
	}
	
	public String getURL() {
		return this.myURL;
	}

	public void setURL(String myURL) {
		this.myURL = myURL;
	}

	

	public String getName() {
		return this.name;
	}

	public boolean hasCompletedSolitaire() {
		return this.completedSolitaire;
	}

	public void setCompletedSolitaire(boolean completedSolitaire) {
		this.completedSolitaire = completedSolitaire;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
