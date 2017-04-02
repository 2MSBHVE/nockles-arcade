package main;

import java.util.ArrayList;

public class User {
	
	private String name;
	private boolean completedSolitaire;
	
	public User(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public boolean hasCompletedSolitaire() {
		return completedSolitaire;
	}

	public void setCompletedSolitaire(boolean completedSolitaire) {
		this.completedSolitaire = completedSolitaire;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
