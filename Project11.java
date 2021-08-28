import java.util.*;
import static javax.swing.JOptionPane.*;

public class Project11 {
	public static Map<String,String> genDice(List<Integer> dice) {
		List<Integer> randomDiceAmounts = new ArrayList<>();
		Random rand = new Random();
		for (Integer amt: dice) {
			randomDiceAmounts.add(rand.nextInt(amt) + 1);
		}
		Integer first = randomDiceAmounts.get(0);
		List<String> outString = new ArrayList<>();
		Integer sz = randomDiceAmounts.size();
		for (int i = 0; i < randomDiceAmounts.size(); i++) {
			if (i == 0) {
				outString.add("You Rolled A " + randomDiceAmounts.get(i) + " On the " + dice.get(i) + "-sided die,");
			} else if (i == randomDiceAmounts.size() - 1) {
				outString.add("and a " + randomDiceAmounts.get(i) + " on the " + dice.get(i) + "-sided die");
			} else {
				outString.add("a " + randomDiceAmounts.get(i) + " on the " + dice.get(i) + "-sided die,");
			}
		}
		Set<Integer> ns = new HashSet<>(randomDiceAmounts);
		int sameDice = randomDiceAmounts.size() - ns.size();
		Map<String, String> maps = new HashMap<>();
		maps.put("GUI",String.join("\n", outString));

		sameDice = (sameDice > 0) ? (sameDice + 1) : sameDice;
		Map<Integer, String> wordvals;
		wordvals = new HashMap<>();
		wordvals.put(0, "All of them show different numbers.");
		wordvals.put(2, "Exactly Two of them show the same number.");
		wordvals.put(3, "All 3 Dice show the same number!");
		String diceAmountOut = wordvals.get(sameDice);
		maps.put("AMT",diceAmountOut);
		return maps;
	}

	public static void ask(List<Integer> inps) {
		List<String> strings = new ArrayList<>();
		String last = String.valueOf(inps.get(inps.size()-1));
		for (Integer i: inps) {
			if (!Objects.equals(i, inps.get(inps.size() - 1))) {
				strings.add(String.valueOf(i));
			}
		}
		String joinedDice = String.join(", ", strings)+", and "+last;
		showMessageDialog(null,"Press 'OK' to roll "+joinedDice+" sided dice");
	}

	public static void main(String[] args) {
		List<Integer> lststrs = Arrays.asList(4, 5, 6);
		ask(lststrs);
		Map<String, String> out = genDice(lststrs);
		for (String s : Arrays.asList("GUI", "AMT")) {
			showMessageDialog(null,out.get(s));
		}
	}
}
