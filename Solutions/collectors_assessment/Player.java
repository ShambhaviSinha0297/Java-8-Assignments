package collectors_assessment;

import stream_operations.Country;

public class Player {
	String playerName;
	int matchesPlayed, runs, highestScore;
	Country country;
	public Player(String playerName, int matchesPlayed, int runs, int highestScore, Country country) {
		super();
		this.playerName = playerName;
		this.matchesPlayed = matchesPlayed;
		this.runs = runs;
		this.highestScore = highestScore;
		this.country = country;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getMatchesPlayed() {
		return matchesPlayed;
	}
	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getHighestScore() {
		return highestScore;
	}
	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	
  
}
