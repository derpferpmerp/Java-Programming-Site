import java.util.*;

// USES 9 SEMICOLONS INCLUDING IMPORTS

public class Project21 {

	public static void main(String[] args) {
		//int num = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Enter A Number"));
		for (int numitr = 1; numitr <= 300; numitr++) {
			int num = numitr * 10;
			System.out.println(java.text.MessageFormat.format("{0} in Roman Numerals Is: {1}", num, rom(num)));
		}
	}

	public static List<String> closestToNum(Integer num, List<Integer> integers, List<String> map2) {
		return List.of(
				map2.get(integers.indexOf(
						integers.stream()
							.filter(integer -> integer <= num)
							.findFirst()
							.orElse(0)
				)),
				String.valueOf(integers.stream()
						.filter(integer -> integer <= num)
						.findFirst()
						.orElse(0)
				)
		);
	}

	public static String rom(int number) {
		List<Integer> integers = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
		List<String> strings = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");

		List<String> r = closestToNum(number,integers,strings);
		int floored = Integer.parseInt(r.get(1));
		return (number == floored) ? r.get(0) : (closestToNum(floored, integers, strings).get(0) + rom(number - floored));
	}
}
