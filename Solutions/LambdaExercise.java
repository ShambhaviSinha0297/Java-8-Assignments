package java8_assessments;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;


public class LambdaExercise {
	
	static List<String> countries = new ArrayList<String>();
	static Map<String, String> countryCapitals = new HashMap<String, String>();
	
	static
	{
		countries.add("India");
		countries.add("Italy");
		countries.add("Spain");
		countries.add("France");
		countries.add("Australia");
		countries.add("Thailand");
		
		countryCapitals.put(countries.get(0), "New Delhi");
		countryCapitals.put(countries.get(1),"Rome");
		countryCapitals.put(countries.get(2),"Madrid");
		countryCapitals.put(countries.get(3),"Paris");
		countryCapitals.put(countries.get(4),"Canberra");
		countryCapitals.put(countries.get(5),"Bangkok");
	}
	
	static void displayCountries()
	{
		Consumer<List<String>> display = countries -> countries.stream().forEach(a -> System.out.print(a + " "));
		display.accept(countries);
	}
	
	static void displayCountryCapitals()
	{
		BiConsumer<List<String>, Map<String, String> > dispCapitals = (countries, countryCapitals) -> {
			System.out.println(countryCapitals);	
		};
		dispCapitals.accept(countries, countryCapitals);
	}
	
	static void sortCountriesByName()
	{
	     countries.stream().sorted(Comparator.reverseOrder());
		 System.out.println(countries);
	}
	
	static void sortCountriesByLength()
	{
//		Collections.sort(countries,Comparator.comparing(String::length).reversed());
//		System.out.println(countries);
		Comparator<String> sortByLength = (c1, c2) -> c2.length() - c1.length();
	    countries.stream().sorted(sortByLength).forEach(System.out::println);
		
	}
	
	static void removeCountry()
	{
	   List<String> l1 =countries.stream().filter(a -> a.length()>6).collect(Collectors.toList());
	   countries.removeAll(l1);
	   System.out.println("Countries with length  > 6 :");
	   System.out.println(l1);
	   System.out.println("---------------------------------------------------------------------------------------------");
	   System.out.println("After removing the elements having length >6 : ");
	   System.out.println(countries);
	}
	
	public static void main(String[] args) {
		
		System.out.println("The country list is : " +countries);
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("The countries with their capitals Mappeds : " +countryCapitals);
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("The country list using displayCountries method: ");
		displayCountries();
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Iterating through the Capitals via BiConsumer ");
		displayCountryCapitals();
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("The Reverse Sorted List of Countries Alphabetically: ");
		sortCountriesByName();
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("The Reverse Sorted List of Countries By Length: ");
		sortCountriesByLength();
		System.out.println("---------------------------------------------------------------------------------------------");
		removeCountry();		
		
	}

}
