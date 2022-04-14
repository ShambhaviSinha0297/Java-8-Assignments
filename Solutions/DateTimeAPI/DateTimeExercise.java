package java8_assessments_DateTimeAPI;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class DateTimeExercise {
	
	 static List<Tablet> tabletList = 
			Arrays.asList(new Tablet[] {
					new Tablet("Clavam","Alkem Lab",LocalDate.of(2020, 01, 12),LocalDate.of(2022, 10, 12)),
					new Tablet("Paracetamol","JS Pharma",LocalDate.of(2018, 10, 04),LocalDate.of(2021, 10, 04)),
					new Tablet("Zincovit","Mulmin",LocalDate.of(2021, 10, 04),LocalDate.of(2023, 10, 12)),
					new Tablet("Crocin","Alkem Lab",LocalDate.of(2017, 04, 15),LocalDate.of(2021, 01, 12))
					}
          );
	
	 static void getExpiringTablets(int months)
	 {
		 tabletList.stream()
		 .filter(tb -> tb.expiry_date.isAfter(LocalDate.now().plusMonths(months)))
		 .forEach(System.out::print);
		 
		 /*List<String> tabletNames = new ArrayList<String>();
		 BiConsumer<LocalDate, List<Tablet>> tbList = (a,b) -> b.forEach(c-> {
			 if(a.until(c.getExpiry_date(),ChronoUnit.MONTHS) <= months) 
			 {
				 tabletNames.add(c.getTablet_name());
			 }
		 });
		 
		 tbList.accept(LocalDate.now(), tabletList);*/
	 }
	 
	 static void getExpiringTabletsSorted()
	 {
		 Comparator<Tablet> newList = (Tablet t1, Tablet t2) -> t1.getExpiry_date().compareTo( t2.getExpiry_date() );
		 
		 Collections.sort(tabletList, newList);
		 System.out.println(tabletList);

	 }
	 
	 static void getTabletsExpiringPeriod()
	 {
		 Map<String,String> ExpTablet = new HashMap<String, String>();
		 tabletList.forEach(t -> {
			 Period p1 = Period.between(t.getManufacture_date(), t.getExpiry_date());
			 ExpTablet.put(t.getTablet_name(), p1.getYears() + "year/s " +p1.getMonths()+"month/s "+p1.getDays()+"day/s ");
		 });
		 System.out.println(ExpTablet);
	 }
	 
	 static void getSameYearExpiry()
	 {
		 Map<String, List<String>> myList = new HashMap<String, List<String>>();
		 LocalDate today = LocalDate.now();
		 tabletList.forEach( t -> {
			 List<String> names = new ArrayList<String>();
			 if((t.getManufacture_date().getYear() == today.getYear()) && t.getExpiry_date().compareTo(today)<0)
			 {
				 if(myList.containsKey(t.getManufacturer()))
				 {
					 names = myList.get(t.getManufacturer());
				 }
				 names.add(t.getTablet_name());
				 myList.put(t.getManufacturer(), names);
			 }
		 });
	 }
	 
	 public static void main(String[] args) {
		System.out.println("The tablet List : \n"+tabletList);
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("The tablets expiring within a given months from now: ");
		getExpiringTablets(8);
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("The tablets sorted in order of their expiry dates:");
		getExpiringTabletsSorted();
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("The tablets with the expiry period:");
		getTabletsExpiringPeriod();
	}

}
