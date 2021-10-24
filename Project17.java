import java.util.*;
import java.text.MessageFormat;
import static javax.swing.JOptionPane.*;

public class Project17 {

	public static int sum(List<Integer> lst) {
		int sum = 0;
		for (Integer integer : lst) {
			int valueOf = integer;
			sum += valueOf;
		}
		return sum;
	}

	public static String checkRoll(List<Integer> rolls, Map<Integer,String> winList) {
		Integer summed = sum(rolls);
		switch (winList.get(summed)) {
			case "WIN":
				return "You Win!";
			case "LOSE":
				return "Sorry, You Rolled A " + summed;
			default:
				return "NONE";
		}

	}

	public static void main(String[] args) {
		Random rand = new Random();


		Map<Integer, String> winValues = new HashMap<>();
		cc(winValues);

		boolean lost = false;
		String ret;
		int cRoll = 0;
		int fRoll = 0;
		int wins = 0;
		int losses = 0;
		showMessageDialog(null,"Welcome to My Craps Game.");
		showMessageDialog(null,"Press 'OK' to Roll the Dice");
		do {
			Integer roll1 = rand.nextInt(6)+1;
			Integer roll2 = rand.nextInt(6)+1;
			List<Integer> rolls = Arrays.asList(roll1,roll2);
			Integer summedRolls = sum(rolls);
			showMessageDialog(null, MessageFormat.format("""
					You Rolled a {0} and a {1}
					
					The Sum is {2}
					""",roll1,roll2,summedRolls));
			ret = checkRoll(rolls,winValues);
			if (cRoll > 0) {
				winValues.put(7,"LOSE");
				winValues.put(11,"NONE");
				for (int i : new int[]{2, 3, 4, 5, 6, 8, 9, 10, 12}) {
					if (i != fRoll) {
						winValues.put(i, "NONE");
					}
				}

			}

			if (cRoll == 0 && Objects.equals(winValues.get(summedRolls), "NONE")) {
				winValues.put(summedRolls, "WIN");
				fRoll = summedRolls;
				cRoll += 1;
				winValues.put(7,"LOSE");
				for (int i : new int[]{12, 2, 3}) {
					winValues.put(i,"NONE");
				}
			} else if (ret.contains("You Win!")) {
				wins += 1;
				cRoll = 0;
				showMessageDialog(null,"You Win!");
				showMessageDialog(null, MessageFormat.format("""
						Wins: {0}
						Losses: {1}
						""",wins,losses));
				lost = (!Objects.equals(showInputDialog(null, "Continue? (y/n)"), "y"));
				cc(winValues);
			} else if (ret.contains("Sorry, You Rolled A ")) {
				if (cRoll != 0 || !ret.contains("7")) {
					losses += 1;
					cRoll = 0;
					showMessageDialog(null, ret);
					showMessageDialog(null, MessageFormat.format("""
							Wins: {0}
							Losses: {1}
							""", wins, losses));
					lost = (!Objects.equals(showInputDialog(null, "Continue? (y/n)"), "y"));
				}
			} else {
				winValues.put(7,"LOSE");
				showMessageDialog(null, MessageFormat.format("""
						You Must Keep Rolling
						To Win: {0}
						To Lose: 7
						""",fRoll));
				cRoll += 1;
			}

		} while (!lost);

	}

	public static void cc(Map<Integer, String> winValues) {
		for (int i = 0; i < 13; i++) {
			winValues.put(i,"NONE");
		}
		winValues.put(7,"WIN");
		winValues.put(11,"WIN");
		for (int i : new int[]{2, 3, 12}) {
			winValues.put(i,"LOSE");
		}
	}
}
