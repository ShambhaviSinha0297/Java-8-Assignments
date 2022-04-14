package collectors_assessment;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpecialStreamExercise {
	
	static void getSquaresOfThree()
	{
		 IntStream numStream =  IntStream.range(20, 51);
		 LinkedList<Integer> oddMultiplesSquared = numStream.filter(num -> num%3==0 && num%2!=0).mapToObj(num->num*num)
	                                                   .collect(Collectors.toCollection(LinkedList::new));
		   System.out.println(oddMultiplesSquared);
	}
	
	static void getMultiplesOfFive()
	{
		int[] arr= IntStream.iterate(1, i -> i + 1).filter(num->num%5==0).limit(20).toArray();
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		getSquaresOfThree();
		getMultiplesOfFive();
		
		

	}

}
