import java.util.*;
import java.text.MessageFormat;

public class Project14 {

	public static int sum(List<Integer> lst) {
		int sum = 0;
		for (Integer integer : lst) {
			int valueOf = integer;
			sum += valueOf;
		}
		return sum;
	}
	public static void RandOccurence(Integer num) {
		Random rand = new Random();
		List<Integer> generatedIntegers = new ArrayList<Integer>();
		do {
			Integer generated = rand.nextInt(20)+1;
			generatedIntegers.add(generated);
			System.out.println("The Number Generated Was "+generated);
		} while (!generatedIntegers.contains(num));
		System.out.println("It Took "+generatedIntegers.size()+" Tries before 10 was generated");
	}
	public static void RandomSum(Integer num) {
		Random rand = new Random();
		List<Integer> generatedIntegers = new ArrayList<Integer>();
		do {
			Integer generated = rand.nextInt(20)+1;
			generatedIntegers.add(generated);
			System.out.println(MessageFormat.format("The Number Generated is {0}, The Sum is {1}",generated,sum(generatedIntegers)));
		} while (sum(generatedIntegers) < num);

	}
	public static void main(String[] args) {
		RandOccurence(10);
		RandomSum(200);
	}
}
