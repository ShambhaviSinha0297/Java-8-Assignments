package java8_assessments_DateTimeAPI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.*;

public class BankDepositExercise {
	
	static String getMaturityDate(String investmentDate, Period duration) throws ParseException
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");  
		LocalDate dateTime = LocalDate.parse(investmentDate, formatter);
		LocalDate result = dateTime.plus(duration);
		String maturityDate = result.toString();
		return maturityDate;	
	}
	
	static void getInvestmentPeriod(String investmentDate, String maturityDate) throws ParseException
	{
		System.out.println("Total Investment period is:");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");  
		LocalDate date1 = LocalDate.parse(investmentDate,formatter);
		//System.out.println(date1);
		LocalDate date2 = LocalDate.parse(maturityDate);
		//System.out.println(date2);
		 Period period = date1.until(date2);
		 int yearsBetween = period.getYears();
		 int daysBetween = period.getDays();
		 System.out.println("Days in Between:"+daysBetween);
		 System.out.println("< "+yearsBetween+" years "+daysBetween+" days >");
	}
	
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Investment Date : ");
		String investmentDate = sc.nextLine();
		
		System.out.println("Enter the duration Period : ");
		int no = sc.nextInt();
		Period duration = Period.ofYears(no);
		System.out.println("The maturity date is : ");
		String maturityDate = getMaturityDate(investmentDate, duration);
		System.out.println(maturityDate);
		getInvestmentPeriod(investmentDate, maturityDate);
	}

}
