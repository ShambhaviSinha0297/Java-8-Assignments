package collectors_assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Consumer;

import stream_operations.Country;
import stream_operations.Player;

public class StreamCollectorsExercise {

	
	static List<Player> playerList = Arrays.asList(
			new Player [] {
					//ODI
					new Player("MS Dhoni", 350 , 10773, 183, new Country(7, "India")),
					new Player("Virat Kohli", 98 , 5449, 185, new Country(18, "India") ),
					new Player("Smriti Mandhana", 63 ,448 , 135, new Country(18, "India")),
					new Player("Kane Williamson", 6173 , 1617, 148,  new Country(22, "New Zealand") ),
					new Player("Aaron Finch", 132 , 5232, 153, new Country(3, "Australia")),
					new Player("David Warner", 128 , 5455, 179,new Country(31, "Australia") ),
					new Player("AB de Villiers", 228 , 9577, 176, new Country(17, "South Africa"))
			}
			);
	
	static void getPlayersByCountry()
	{
		Map<String, List<Object>> playersMap = playerList.stream()
				    .collect(Collectors.groupingBy(p->p.getCountry().getCountryName(), 
				    		Collectors.mapping(p->p.getPlayerName(), Collectors.toList())));
		
		playersMap.entrySet().forEach(System.out::println);
	}
	
	static void getPlayerNamesByCountry()
	{
		Map<String, List<Object>> playersMap = playerList.stream().filter(p->p.getMatchesPlayed()>100)
				.collect(Collectors.groupingBy(p->p.getCountry().getCountryName(),
						Collectors.mapping(p->p.getPlayerName(), Collectors.toList())));
		playersMap.entrySet().forEach(System.out::println);

	}
	
	static Map<String, Long> getTotalPlayersByCountry()
	{
		Map<String, Long> totalPlayersWithCountry = playerList.stream()
			    .collect(Collectors.groupingBy(p->p.getCountry().getCountryName(),Collectors.mapping(p->p.getPlayerName(), 
			    		Collectors.counting())));
		totalPlayersWithCountry.entrySet().forEach(System.out::println);
		return totalPlayersWithCountry;
	}
	
	static Map<String, Integer> getTotalRunsByCountry()
	{
		Map<String, Integer> playersMap = playerList.stream()
				.collect(Collectors.groupingBy(p->p.getCountry().getCountryName(), Collectors.summingInt(Player::getRuns) ));
		playersMap.entrySet().forEach(System.out::println);
		return playersMap;
	}
	
	static Map<String, Optional<Integer>> getMaxScoreByCountry()
	{	
		Map<String, Optional<Integer>> playersMap = playerList.stream()
				.collect(Collectors.groupingBy(p->p.getCountry().getCountryName()
						,Collectors.mapping(Player::getRuns, Collectors.maxBy(Integer::compareTo))));
		//playersMap.entrySet().forEach(System.out::println);
		for (Entry<String, Optional<Integer>> entry : playersMap.entrySet()) {
	        System.out.println(entry.getKey() + ":" + entry.getValue().get());
	    }
		return playersMap;

	}
	
	static Map<String, List<Object>> getPlayerNamesStringByCountry()
	{
		Map<String, List<Object>> playersMap = playerList.stream()
        .collect(Collectors.groupingBy(p->p.getCountry().getCountryName(), Collectors.mapping(p->p.getPlayerName().toString(),
        		Collectors.toList())));
	
        playersMap.entrySet().forEach(System.out::println);
        return playersMap;
	}
	

	public static void main(String[] args) {
		System.out.println("Players as list against the countries:");
		getPlayersByCountry();
		System.out.println("---------------------------------------------");
		System.out.println("Players who have played > 100 matches as list against the countries: ");
		getPlayerNamesByCountry();
		System.out.println("---------------------------------------------");
		System.out.println("Total Players per country: ");
		getTotalPlayersByCountry();
		System.out.println("---------------------------------------------");
		System.out.println("Total runs per country: ");
		getTotalRunsByCountry();
		System.out.println("---------------------------------------------");
		System.out.println("String of players per country: ");
		getPlayerNamesStringByCountry();
		System.out.println("---------------------------------------------");
		System.out.println("Countries against maximum runs: ");
		getMaxScoreByCountry();

	}

}
