package java8_assessments_DateTimeAPI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class WorkingDaysExercise {
	
	static void getNextMonthsWorkingDays()
	{
		LocalDate today = LocalDate.now();
		LocalDate monthDate = today.withMonth(today.getMonthValue()+1);
		LocalDate startDate = monthDate.with(TemporalAdjusters.firstDayOfMonth());
		LocalDate endDate = monthDate.with(TemporalAdjusters.lastDayOfMonth());
		List<String> workingDays = new ArrayList<String>();
		while(startDate.compareTo(endDate)<0)
		{
			if((startDate.getDayOfWeek()!=DayOfWeek.SATURDAY) &&(startDate.getDayOfWeek()!=DayOfWeek.SUNDAY))
            {
				workingDays.add(startDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			}
			startDate =startDate.plusDays(1);
		}
		workingDays.forEach(System.out::println);
	}

	
	public static void main(String[] args) {
		getNextMonthsWorkingDays();
	}

}
