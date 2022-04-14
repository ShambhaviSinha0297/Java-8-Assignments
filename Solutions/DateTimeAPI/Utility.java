package java8_assessments_DateTimeAPI;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utility {
	
	static List<String> getBusSchedule(String start, Duration frequency)
	{
		List<String> myBusSchedule = new ArrayList<String>();
		LocalDateTime startdate = LocalDateTime.parse(start);
		LocalDateTime date2 = LocalDateTime.parse(start);
		while(date2.getHour()<24 && date2.getDayOfMonth()==startdate.getDayOfMonth())
		{
			date2 = date2.plusSeconds(frequency.getSeconds());
			if(date2.getDayOfMonth()==startdate.getDayOfMonth())
			{
				myBusSchedule.add(date2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
			}
		}
		return myBusSchedule;
	}
	
	public static void main(String[] args) {
		
		Utility obj = new Utility();
		
		obj.getBusSchedule("2022-02-28T01:30:00", Duration.ofHours(1)).forEach(System.out::println);
	}

}
