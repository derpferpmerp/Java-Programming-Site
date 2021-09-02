import java.util.*;
import java.text.MessageFormat;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Project18 {
	public static List<Integer> fOccurence(String inp, String chr) {
		Integer fOccur = 0;
		boolean done = false;
		List<Integer> matchIndexes = new ArrayList<>();
		for (int i=0; i<inp.length(); i++) {
			if (String.valueOf(inp.charAt(i)).equals(chr)) {
				matchIndexes.add(i);
			}
		}
		Integer amtMatches = matchIndexes.size();
		Integer matchedIndex = (amtMatches == 0) ? (-1) : (matchIndexes.get(0));
		return Arrays.asList(amtMatches, matchedIndex);
	}

	public static List<List<Integer>> str2ListInt(String inp) {
		List<String> outl = new ArrayList<>();
		for (int i=0; i<inp.length(); i++) {
			outl.add(String.valueOf(inp.charAt(i)));
		}
		int[] maxValLST = outl.stream().mapToInt(Integer::valueOf).toArray();
		List<Integer> list = IntStream.of(maxValLST).boxed().collect(Collectors.toList());
		List<Integer> sorted = list;
		Collections.sort(sorted);
		Collections.reverse(sorted);
		return Arrays.asList(sorted,list);
	}

	public static String weirdSum(String inp) {
		List<List<Integer>> list = str2ListInt(inp);
		int maxVal = list.get(0).get(0);
		List<String> outList = new ArrayList<>();
		Integer fChar = Integer.parseInt(String.valueOf(inp.charAt(0)));
		Integer sChar = Integer.parseInt(String.valueOf(inp.charAt(1)));
		outList.add(String.valueOf(fChar+sChar));
		for (int i=1; i<inp.length();i++) {
			if (Integer.parseInt(String.valueOf(inp.charAt(i))) == maxVal) {
				outList.add(String.valueOf(2*maxVal));
			} else {
				Integer chr1 = Integer.parseInt(String.valueOf(inp.charAt(i)));
				Integer chr2 = Integer.parseInt(String.valueOf(inp.charAt(i-1)));
				Integer chr3 = chr1 + chr2;
				outList.add(String.valueOf(chr3));
			}
		}
		return String.join(" ",outList);
	}

	public static String weirdDisplay(String inp) {
		List<List<Integer>> lst = str2ListInt(inp);
		int maxChar = lst.get(0).get(0);
		List<Integer> inList = lst.get(0);
		Collections.reverse(inList);
		List<Integer> lstSDisplay = lst.get(1);
		List<String> outStringTest = new ArrayList<>();
		for (int i=inp.length()-1; i>=0;i--) {
			outStringTest.add(String.valueOf(inp.charAt(i)));
		}
		
		List<String> out = new ArrayList<>();
		for (int i=0; i<inList.size(); i++) {
			if (inList.get(i).equals(maxChar)) {
				out.add(String.valueOf(0));
			} else {
				out.add(String.valueOf(inList.get(i)));
			}
		}
		
		return String.join(" ",out) + "\n" + String.join(" ",outStringTest);
	}
	public static void main(String[] args) {
		String inp = "1727737774";
		Integer fOccur = 0;
		boolean done = false;
		String chr2Search = "7";
		List<Integer> occurences = fOccurence(inp, chr2Search);
		System.out.println(MessageFormat.format("The First Occurence of {0} in the Array is {1}\n\n{0} Occurs {2} Times in the Array",chr2Search,occurences.get(1),occurences.get(0)));
		System.out.println(weirdSum(inp));
		System.out.println(weirdDisplay(inp));
	}
}
