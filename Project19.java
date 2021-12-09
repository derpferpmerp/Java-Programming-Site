import java.util.*;
import java.text.MessageFormat;

public class Project19 {

	public static boolean dnHaveItem(int[] lst, Object itm) {
		for (int i : lst) {
			if (Objects.equals(i,itm)) {
				return false;
			}
		}
		return true;
	}

	public static int[] sublist(int[] lst, int start, int end) {
		int[] cSlice = new int[end-start];
		System.arraycopy(lst, start, cSlice, 0, cSlice.length);
		return cSlice;
	}

	public static String[] sublist(String[] lst, int start, int end) {
		String[] cSlice = new String[end-start];
		System.arraycopy(lst, start, cSlice, 0, cSlice.length);
		return cSlice;
	}

	public static int[] randList(Integer amt) {
		Random rand = new Random();
		int[] list = new int[amt];
		int integer = 10000000;
		int indx = 0;
		for (int i = 0; i < amt; i++) {
			while (dnHaveItem(list, integer)) {
				integer = rand.nextInt(100) + 1;
				if (dnHaveItem(list, integer)) {
					list[indx] = integer;
					indx += 1;
				}
			}
			integer = 100000;
		}
		return list;
	}

	public static String[] reverse(String[] lst) {
		String[] lout = new String[lst.length];
		System.arraycopy(lst, 0, lout, 0, lst.length - 1 + 1);
		return lout;
	}

	public static Integer max(int[] lst) {
		int greatest = lst[0];
		for (int pos : lst) {
			if ( pos > greatest ) {
				greatest = pos;
			}
		}
		return greatest;
	}

	public static int[] minIndex(int[] lst) {
		int smallest = lst[0];
		int indx = 0;
		for (int i = lst.length - 1; i > 0; i--) {
			int pos = lst[i];
			if (pos < smallest) {
				smallest = pos;
				indx = i;
			}
		}
		return new int[]{ smallest, indx };
	}

	public static String posInList(int[] lst, int chr2Get) {
		String[] lstout = new String[lst.length];
		if (dnHaveItem(lst, chr2Get)) {
			return "-1";
		}
		int indx = 0;
		for (int i = 0; i < lst.length; i++) {
			if (Objects.equals(lst[i], chr2Get)) {
				lstout[indx] = (String.valueOf(i));
				indx += 1;
			}
		}
		return String.join(" ", lstout);
	}

	public static String weirdRot(int[] input, int pos, boolean rMain) {
		String[] listB = new String[pos];
		int indx_1 = 0;
		int[] sublist = sublist(input, 0, pos);
		for (Integer integer2 : sublist) {
			String of = String.valueOf(integer2);
			listB[indx_1] = of;
			indx_1 += 1;
		}
		String[] listM = new String[]{String.valueOf(input[pos])};
		String[] listE = new String[input.length - pos - 1];
		int indx_2 = 0;
		for (Integer integer1 : sublist(input, pos + 1, input.length)) {
			String valueOf = String.valueOf(integer1);
			listE[indx_2] = valueOf;
			indx_2 += 1;
		}

		int amountValid = minIndex(new int[]{ listB.length,listE.length })[0];
		String[] begNoFlip = sublist(listB, 0, listB.length-amountValid);
		String[] begFlip = sublist(listB, listB.length-amountValid, listB.length);
		begFlip = reverse(begFlip);

		String[] endNoFlip = sublist(listE, amountValid, listE.length);
		String[] endFlip = sublist(listE, 0, amountValid);
		endFlip = reverse(endFlip);

		if (rMain) {
			String[] list = new String[input.length];
			for (int i = 0; i < input.length; i++) {
				list[i] = String.valueOf(input[i]);
			}
			System.out.println(String.join(" ", list));
		}
		return MessageFormat.format("{0} {1} {2} {3} {4}",
				String.join(" ", begNoFlip),
				String.join(" ", endFlip),
				String.join(" ", listM),
				String.join(" ", begFlip),
				String.join(" ", endNoFlip)
		);
	}

	public static String adjacent(int[] input, int pos) {
		String[] inputStrings = weirdRot(input, pos, false).split(" ");
		StringBuilder lists = new StringBuilder();
		for (int i = 0; i <= inputStrings.length; i++) {
			int g = i*2;
			try {
				String[] lst2Add = new String[]{ inputStrings[g], inputStrings[g + 1] };
				lists.append(lst2Add[1]);
				lists.append(" ");
				lists.append(lst2Add[0]);
				lists.append(" ");
			} catch (Exception ignored) {}

		}
		if (inputStrings.length % 2 != 0) {
			lists.append(inputStrings[inputStrings.length - 1]);
		}
		return lists.toString();
	}

	public static void main(String[] args) {
		int lengthList = 15;

		Random rand = new Random();
		int[] genList = randList(lengthList);
		int pos2Rot = rand.nextInt(lengthList-3)+2;
		System.out.println(MessageFormat.format("""
				Max Value: {0}
				Index of Minimum Value: {1}
				Positions of Character {2} in String: {3}
				Rotated Around Position {4}: {5}
				Adjacent Values Swapped: {6}
				""",
				max(genList),
				minIndex(genList)[1],
				12,
				posInList(genList,12),
				pos2Rot,
				weirdRot(genList,pos2Rot,true),
				adjacent(genList,pos2Rot)
		));

	}
}
