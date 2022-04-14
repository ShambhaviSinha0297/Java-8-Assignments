package collectors_assessment;

import java.util.Arrays;
import java.util.List;

import stream_operations.Country;
import stream_operations.Player;

public class StreamRepo {
	static Country country1 =  new Country(7, "India");
	//static Country country2 = new Country(18, "India");
	static Country country3 =  new Country(18, "India");
	static Country country4 = new Country(22, "New Zealand");
	static Country country5 =  new Country(3, "Australia");
	static Country country6 = new Country(31, "Australia");
	static Country country7 =  new Country(17, "South Africa");
	
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

}
