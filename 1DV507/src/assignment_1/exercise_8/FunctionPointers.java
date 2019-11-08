/**
 * FunctionPointers.java
 * 13 jan 2017
 */
package assignment_1.exercise_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author jlnmsi
 *
 */
public class FunctionPointers {

	public static void main(String[] args) {
		System.out.println("Part 1: Apply predicates");
		List<Integer> list = Arrays.asList(45, 3, 24, 16, 1, 1, 3, 8, 7, 6, 10, 12, 17, 22, 30);
		System.out.println("Original: " + list);			// Remove
		
		System.out.print("\nPrint all numbers:\t\t\t");		// Remove \n
		Predicate<Integer> all = n -> true;
		selectAndPrint(list, all); 

		System.out.print("\nPrint all odd numbers:\t\t\t");
		Predicate<Integer> odd = n -> (n % 2 != 0);			// Must be updated
		selectAndPrint(list, odd);
		
		System.out.print("\nPrint all even numbers:\t\t\t");
		Predicate<Integer> even = n -> (n % 2 == 0);		// Must be updated
		selectAndPrint(list, even);
		
		System.out.print("\nPrint all numbers greater than 10:\t");
		Predicate<Integer> aboveTen = n -> (n > 10);		// Must be updated
		selectAndPrint(list, aboveTen);
		
		System.out.print("\nPrint all numbers lesser than 10:\t");
		Predicate<Integer> belowTen = n -> (n < 10);
		selectAndPrint(list, belowTen);
		
		System.out.println("\n\nPart 2: Apply functions");
		List<Double> numbers = Arrays.asList(1.0, 16.0, 25.0, 81.0);
		System.out.println("Original: "+numbers);
		System.out.println("Square root:\t\t\t\t" + applyFunction(numbers, Math::sqrt));
		System.out.println("Power of two:\t\t\t\t" + applyFunction(numbers, FunctionPointers::powerOfTwo));
	}


	// Prints all elements in the list where predicate evaluates to true
	public static void selectAndPrint(List<Integer> list, Predicate<Integer> predicate) {
		// Add code here
		List<Integer> temp = list.stream()
				.filter(predicate)
				.collect(Collectors.toList());

		System.out.println(temp);
	}

	// Returns a new list containing the numbers resulting from applying fx 
	// on the input list numbers
	private static List<Double> applyFunction(List<Double> numbers, Function<Double, Double> fx) {
		// Add code here
		List<Double> list = new ArrayList<>();
		for(Double i : numbers) {
			list.add(fx.apply(i));
		}
		return list;
	}

	private static Double powerOfTwo(Double d) {
		return Math.pow(d, 2);							// Must be updated
	}
}
