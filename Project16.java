import java.text.MessageFormat;
import java.util.*;
import static javax.swing.JOptionPane.*;

public class Project16 {
	public static String multMatch(String input, String char2Find, Map<Integer,String> mapList, Integer maxNum) {
		Integer cNum = 0;
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			String character = String.valueOf(input.charAt(i));
			if (character.equals(char2Find)) {
				out.append(mapList.get(cNum));
				if (cNum.equals(maxNum)) {
					cNum = 0;
				} else {
					cNum += 1;
				}
			} else {
				out.append(input.charAt(i));
			}
		}
		return out.toString();
	}


	public static void main(String[] args) {
		String bigString = showInputDialog("Enter A Big String.");
		String word = showInputDialog("Enter A 'word'");
		String letter = showInputDialog("Enter A Single Letter");
		Map<Integer, String> mapVals = new HashMap<>();
		mapVals.put(0,"X");
		mapVals.put(1,"Y");
		mapVals.put(2,"Z");
		String withXYZ = multMatch(bigString,letter,mapVals,2);
		String withX = multMatch(bigString,letter,mapVals,0);
		System.out.println(MessageFormat.format("""
				Replace Letter With X: {0}
				Replace Letter With XYZ: {1}
				Replace Word With Letter: {2}
				""",withX,withXYZ, bigString.replaceAll(word, letter)));
	}
}
