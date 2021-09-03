import java.util.*;
import static java.util.stream.Collectors.toCollection;
import static javax.swing.JOptionPane.*;

public class Project20 {

	public static List<Integer> genRandList(Integer amt) {
		Random rng = new Random();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < amt; i++) {
			int integer = rng.nextInt(99) + 1;
			list.add(integer);
		}
		return list;
	}

	public static void main(String[] args) {
		int amountOfNumbers = Integer.parseInt(showInputDialog("How Many Numbers Do You Want to Sort?"));
		List<Integer> randomNumbers = genRandList(amountOfNumbers);
		List<String> randOut = randomNumbers.stream().map(String::valueOf).collect(toCollection(ArrayList::new));
		System.out.println("Unsorted: " + randOut);
		Collections.sort(randomNumbers);
		System.out.println("Sorted: " + randomNumbers);
	}
}
