import javax.swing.*;
import javax.swing.event.*;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

import static javax.swing.JOptionPane.*;

public class Project29 {

	public static ArrayList<Integer> reverse(List<Integer> lst) {
		ArrayList<Integer> lout = new ArrayList<>();
		for (int i = lst.size() - 1; i >= 0; i--) {
			lout.add(lst.get(i));
		}
		return lout;
	}

	private static final List<String> mappedValues = Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","x","y","z");
	private static final List<Integer> mappedKeys = Arrays.asList(10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60);
	private static final Map<Integer,String> lNumToChar = new HashMap<>();
	private static final Map<String,Integer> lCharToNum = new HashMap<>();
	static {
		for (int i = 0; i < mappedKeys.size(); i++) {
			lNumToChar.put(mappedKeys.get(i), mappedValues.get(i));
			lCharToNum.put(mappedValues.get(i), mappedKeys.get(i));
		}
	}

	public static Integer toBase10(Integer input, Integer base) {
		String stringed = String.valueOf(input);
		int out = 0;
		for (int i=0; i<stringed.length(); i++) {
			int otherI = stringed.length()-i-1;
			int chrNum = Integer.parseInt(String.valueOf(stringed.charAt(i)));
			out += chrNum * ((int) Math.pow(base,otherI));
		}
		return out;
	}

	public static String compress(List<Integer> lst) {
		System.out.println(lst);
		List<String> outList = new ArrayList<>();
		for (int num : lst) {
			if (num >= 10) {
				outList.add(lNumToChar.get(num));
			} else {
				outList.add(String.valueOf(num));
			}
		}
		return String.join("",outList);
	}

	public static String uncompress(String input) {

		String[] lst = input.split("");
		List<Integer> outList = new ArrayList<>();
		for (String s : lst) {
			Integer integer = mappedValues.contains(s) ? lCharToNum.get(s) : Integer.valueOf(Integer.parseInt(s));
			outList.add(integer);
		}
		List<String> out = new ArrayList<>();
		for (Integer integer : outList) {
			String s = String.valueOf(integer);
			out.add(s);
		}
		return String.join("",out);

	}

	public static String toBaseN(Object baseN, Integer fromBase, Integer base) {
		String based = String.valueOf(baseN);
		Integer baseN2 = Integer.parseInt(uncompress(String.valueOf(based)));
		Integer nDiv = toBase10(baseN2, fromBase);
		List<Integer> lst = new ArrayList<>();
		do {
			int rem = (int) nDiv % base;
			nDiv /= base;
			nDiv = (int) Math.floor(nDiv);
			lst.add(rem);
		} while (nDiv > 0);
		lst = reverse(lst);
		return compress(lst);
	}

	public static JSlider newSlider(Integer min, Integer max, Integer sValue, Integer spacing) {
		JSlider numBaseStartString = new JSlider(min,max,sValue);
		numBaseStartString.setMajorTickSpacing(spacing);
		numBaseStartString.setPaintTicks(true);
		numBaseStartString.setPaintLabels(true);
		numBaseStartString.setMinorTickSpacing(1);
		return numBaseStartString;
	}

	public static Integer mainScreen() {
		JSlider numBaseStartString = newSlider(2,16,4,1);
		JSlider numBaseAfterString = newSlider(2,16,4,1);
		JTextField inputWithBase = new JTextField();
		Object[] mainScreenData = {
				"Number Base (From):", numBaseStartString,
				"Number in Base:", inputWithBase,
				"Number Base (To):", numBaseAfterString
		};
		int confirm = showConfirmDialog(null, mainScreenData, "Number Base Converter", YES_NO_OPTION, PLAIN_MESSAGE, null);
		if (confirm != YES_OPTION) { return confirm; }
		String messageDialog = MessageFormat.format(
				"{0} b{1} = {2} b{3}",
				inputWithBase.getText(),
				numBaseStartString.getValue(),
				toBaseN(inputWithBase.getText(),numBaseStartString.getValue(),numBaseAfterString.getValue()),
				numBaseAfterString.getValue()
		);
		showMessageDialog(null, messageDialog);
		return confirm;
	}


	public static void main(String[] args) {
		int cont;
		do { cont = mainScreen(); } while (cont == OK_OPTION);
	}
}
