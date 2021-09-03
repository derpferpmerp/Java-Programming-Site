import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;
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

	public static Integer max(List<Integer> lst) {
		return Collections.max(lst);
	}

	public static Integer minIndex(List<Integer> lst) {
		return lst.indexOf(Collections.min(lst));
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
		List<String> listB = input.subList(0,pos).stream().map(String::valueOf).collect(toCollection(ArrayList::new));
		List<String> listM = List.of(String.valueOf(input.get(pos)));
		List<String> listE = input.subList(pos+1,input.size()).stream().map(String::valueOf).collect(toCollection(ArrayList::new));

		Integer amountValid = Collections.min(List.of(listB.size(),listE.size()));
		List<String> begNoFlip = listB.subList(0, listB.size()-amountValid);
		List<String> begFlip = listB.subList(listB.size()-amountValid, listB.size());
		Collections.reverse(begFlip);

		List<String> endNoFlip = listE.subList(amountValid, listE.size());
		List<String> endFlip = listE.subList(0, amountValid);
		Collections.reverse(endFlip);
		if (rMain) {
			System.out.println(String.join(" ", input.stream().map(String::valueOf).toList()));
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
				minIndex(genList),
				12,
				posInList(genList,12),
				pos2Rot,
				weirdRot(genList,pos2Rot,true),
				adjacent(genList,pos2Rot)
		));

	}
}
