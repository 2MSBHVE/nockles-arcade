package main;

import java.util.ArrayList;

public class User {
	
	private String name;
	private ArrayList<Integer> scores;
	
	public User(String name) {
		this.name = name;
		this.scores = new ArrayList<Integer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Integer> getScores() {
		return scores;
	}

	public void addScore(int score) {
		scores.add(score);
	}
	
	public void clearScores() {
		scores = new ArrayList<Integer>();
	}
	
	
	
}
