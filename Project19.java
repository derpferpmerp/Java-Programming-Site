import java.util.*;
import java.text.MessageFormat;

import static java.util.stream.Collectors.toCollection;

public class Project19 {

	public static List<Integer> randList(Integer amt) {
		Random rand = new Random();
		List<Integer> list = new ArrayList<>();
		Integer integer = 10000000;
		for (int i = 0; i < amt; i++) {
			while (!list.contains(integer)) {
				integer = rand.nextInt(100) + 1;
				if (!list.contains(integer)) {
					list.add(integer);
				}
			}
			integer = 100000;
		}
		return list;
	}

	public static ArrayList<String> reverse(List<String> lst) {
		ArrayList<String> lout = new ArrayList<>();
		for (int i = lst.size() - 1; i >= 0; i--) {
			lout.add(lst.get(i));
		}
		return lout;
	}

	public static Integer max(List<Integer> lst) {
		int greatest = lst.get(0);
		for (Integer pos : lst) {
			if ( pos > greatest ) {
				greatest = pos;
			}
		}
		return greatest;
	}

	public static List<Integer> minIndex(List<Integer> lst) {
		int smallest = lst.get(0);
		int indx = 0;
		for (int i = lst.size() - 1; i > 0; i--) {
			Integer pos = lst.get(i);
			if (pos < smallest) {
				smallest = pos;
				indx = i;
			}
		}
		return Arrays.asList(smallest,indx);
	}

	public static String posInList(List<Integer> lst, Integer chr2Get) {
		List<String> lstout = new ArrayList<>();
		if (!lst.contains(chr2Get)) {
			return "-1";
		}
		for (int i = 0; i < lst.size(); i++) {
			if (Objects.equals(lst.get(i), chr2Get)) {
				lstout.add(String.valueOf(i));
			}
		}
		return String.join(" ", lstout);
	}

	public static String weirdRot(List<Integer> input, Integer pos, Boolean rMain) {
		List<String> listB = new ArrayList<>();
		for (Integer integer2 : input.subList(0, pos)) {
			String of = String.valueOf(integer2);
			listB.add(of);
		}
		List<String> listM = List.of(String.valueOf(input.get(pos)));
		List<String> listE = new ArrayList<>();
		for (Integer integer1 : input.subList(pos + 1, input.size())) {
			String valueOf = String.valueOf(integer1);
			listE.add(valueOf);
		}

		Integer amountValid = Collections.min(List.of(listB.size(),listE.size()));
		List<String> begNoFlip = listB.subList(0, listB.size()-amountValid);
		List<String> begFlip = listB.subList(listB.size()-amountValid, listB.size());
		Collections.reverse(begFlip);

		List<String> endNoFlip = listE.subList(amountValid, listE.size());
		List<String> endFlip = listE.subList(0, amountValid);
		endFlip = reverse(endFlip);
		if (rMain) {
			List<String> list = new ArrayList<>();
			for (Integer integer : input) {
				String s = String.valueOf(integer);
				list.add(s);
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

	public static String adjacent(List<Integer> input, Integer pos) {
		List<String> inputStrings = List.of(weirdRot(input, pos, false).split(" "));
		StringBuilder lists = new StringBuilder();
		for (int i = 0; i <= inputStrings.size(); i++) {
			int g = i*2;
			try {
				List<String> lst2Add = new ArrayList<>(List.of(inputStrings.get(g), inputStrings.get(g + 1)));
				Collections.reverse(lst2Add);
				lists.append(lst2Add.get(0));
				lists.append(" ");
				lists.append(lst2Add.get(1));
				lists.append(" ");
			} catch (Exception ignored) {}

		}
		return lists.toString();
	}

	public static void main(String[] args) {
		int lengthList = 15;

		Random rand = new Random();
		List<Integer> genList = randList(lengthList);
		Integer pos2Rot = rand.nextInt(lengthList-3)+2;
		System.out.println(MessageFormat.format("""
				Max Value: {0}
				Index of Minimum Value: {1}
				Positions of Character {2} in String: {3}
				Rotated Around Position {4}: {5}
				Adjacent Values Swapped: {6}
				""",
				max(genList),
				minIndex(genList).get(1),
				12,
				posInList(genList,12),
				pos2Rot,
				weirdRot(genList,pos2Rot,true),
				adjacent(genList,pos2Rot)
		));

	}
}
