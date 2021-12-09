import javax.print.attribute.IntegerSyntax;
import javax.swing.*;
import java.text.MessageFormat;
import java.util.*;
import static javax.swing.JOptionPane.*;

public class Project12 {
	public static Integer checkNum(String inp) {
		// Rounds and Converts (+/-) (Int/Dbl) to +Int
		String userInput = showInputDialog(null,inp);
		double decimal = Double.parseDouble(userInput);
		int rounded = (int) Math.round(decimal);
		return Math.abs(rounded);
	}

	public static String fact(Integer n) {
		Integer scaleValue = n;
		for (int i = n; i > 0; i--) {
			scaleValue *= i;
		}
		return MessageFormat.format("{0} Factorial is {1}", n, scaleValue);
	}

	public static void pyramid(Integer n) {
		for (int i = n; i > 0; i--) {
			List<String> tempLst = new ArrayList<String>();
			for (int g = i; g > 0; g--) {
				tempLst.add(String.valueOf(i));
			}
			String joined = String.join(" ",tempLst);
			System.out.println(joined);
		}

	}

	public static List<String> primes(Integer n) {
		List<String> primeNumbers = new ArrayList<String>();
		for (int i = 1; i < n; i++) {
			boolean isPrime = true;
			for (int j = 1; j < i; j++) {
				if (i % j == 0 && j != 1) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primeNumbers.add(String.valueOf(i));
			}

		}
		return primeNumbers;
	}

	public static Map<String,List<String>> upto(Integer num) {
		Map<String, List<String>> outValues = new HashMap<String, List<String>>();
		List<String> oddnums = new ArrayList<String>();
		List<String> twoOrThree = new ArrayList<String>();
		for (int i = 0; i < num; i++) {
			if (i % 2 != 0) {
				oddnums.add(String.valueOf(i));
			}
			if (i % 2 == 0 ^ i % 3 == 0) {
				twoOrThree.add(String.valueOf(i));
			}
		}
		outValues.put("Odd Numbers",oddnums);

		int sum = 0;
		for (String oddnum : oddnums) {
			int valueOf = Integer.parseInt(oddnum);
			sum += valueOf;
		}
		List<String> summed = List.of(String.valueOf(sum));
		outValues.put("Sum",summed);
		outValues.put("DBy2Or3",twoOrThree);
		return outValues;
	}

	public static void main(String[] args) {
		Integer input = checkNum("Enter Any Integer");
		Map<String,List<String>> arrout = upto(input);

		System.out.println("The Number You Entered Was "+input);
		System.out.println("The Odd Numbers Up to "+input+" are -->\n"+String.join("\n",arrout.get("Odd Numbers")));
		System.out.println("The Sum of the Odd Integers Up to "+input+" is "+arrout.get("Sum").get(0)+"\n");
		System.out.println(fact(input)+"\n");
		System.out.println("Numbers Divisible By 2 or 3, But Not Both -->\n"+String.join("\n",arrout.get("DBy2Or3"))+"\n");
		pyramid(input);
		System.out.println("\nAll the Prime Numbers up to "+input+" are -->\n"+String.join("\n",primes(input))+"\n");
	}
}
