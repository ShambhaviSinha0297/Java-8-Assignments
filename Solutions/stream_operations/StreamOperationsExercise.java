package stream_operations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperationsExercise {
	
	
	static List<Player> playerList = Arrays.asList(
				new Player [] {
						//ODI
						new Player("MS Dhoni", 350 , 10773, 183, new Country(7, "India")),
						new Player("Virat Kohli", 98 , 5449, 185, new Country(18, "India")),
						new Player("Smriti Mandhana", 63 ,448 , 135, new Country(18, "India")),
						new Player("Kane Williamson", 6173 , 1617, 148, new Country(22, "New Zealand")),
						new Player("Aaron Finch", 132 , 5232, 153, new Country(3, "Australia")),
						new Player("David Warner", 128 , 5455, 179, new Country(31, "Australia")),
						new Player("AB de Villiers", 228 , 9577, 176, new Country(17, "South Africa"))
				}
				);
	
	static void displayPlayers()
	{
		playerList.stream().forEach(p -> System.out.println(p.getPlayerName()));
	}
	
	static void displayPlayersForCountry(String country)
	{
		playerList.stream().filter(a ->a.getCountry().countryName.equals(country)).filter(b -> b.highestScore > 160)
		.forEach(p -> System.out.println(p.getPlayerName()));
		
	}
	
	static void getPlayerNames()
	{
		 playerList.stream().filter(p1 -> p1.getRuns()>5000)
				                  .forEach(p1->System.out.println(p1.getPlayerName()));
	}
	
	static void getAverageRunsByCountry(String country)
	{
		OptionalDouble average =playerList.stream()
				.filter(p1 -> p1.getCountry().getCountryName().equals(country))
				.mapToInt(p -> p.getRuns())
				.average();
		System.out.println(average);
	}
	
	static void getPlayerNamesSorted(String country)
	{
		playerList.stream().filter(p->p.getCountry().getCountryName().equals(country))
		.sorted((p1,p2) -> p1.getPlayerName().compareTo(p2.getPlayerName()))
		.forEach(p->System.out.println(p.getPlayerName()));
		
	}
	
	static void getPlayerCountry()
	{
		Map<Object, Object> playerDetails = StreamOperationsExercise.playerList.stream().filter(p->p.getMatchesPlayed()>200)
                .collect(Collectors.toMap(p1 -> p1.getPlayerName(), p2->p2.getCountry().getCountryName()));
		for (Entry<Object, Object> entry : playerDetails.entrySet())
            System.out.println("Player Name = " + entry.getKey() +
                             ", Country = " + entry.getValue());
    }

	
	static void getMaxRunsPlayer()
	{
		Player details = playerList.stream().max(Comparator.comparing(Player :: getRuns)).get();
		System.out.println("Player name: "+details.getPlayerName() +"---- "+"Runs:"+details.getRuns()+"---- "+"Country:"+details.country.getCountryName());
	}
	
	static void findPlayer(String playername, String countryName)
	{
		playerList.stream().filter(p1 -> p1.getCountry().getCountryName().equals(countryName) && p1.getPlayerName().equals(playername))
		.forEach(p1 -> System.out.println("playername: "+p1.getPlayerName() +"-----runs made: "+p1.getRuns()+ "----ID: "+p1.getCountry().getCountryId()));
		
	}
	
	static void checkHighScorerByCountry(String country)
	{
		boolean result = playerList.stream()
				        .filter(p1->p1.getCountry().getCountryName().equals(country) && p1.getRuns()>10000)
				        .count() > 0;
	    System.out.println(result);
		
	}

	public static void main(String[] args) 
	{
		System.out.println("Display players using displayPlayer method: ");
		displayPlayers();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Display player using displayPlayerForCountry method: ");
		displayPlayersForCountry("Australia");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Display players who have runs > 5000 using getPlayerNames method: ");
		getPlayerNames();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Display player who has the highest run record using getMaxRunsPlayer() method : ");
		getMaxRunsPlayer();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Display player details by giving his name and country using findPlayer() method : ");
		findPlayer("Virat Kohli", "India");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("The average runs made by the players of the given country:");
		getAverageRunsByCountry("India");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Sorted list of the players:");
		getPlayerNamesSorted("India");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Map of players with matches>200:");
		getPlayerCountry();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Highest scorer in the given country");
		checkHighScorerByCountry("India");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Check whether the given country has a player with runs>10000");
		checkHighScorerByCountry("Australia");
		
	}

}
