import java.util.*;
import static javax.swing.JOptionPane.*;

public class Project07 {

	public static Object index(Object inp, Integer indx, String type) {
		String inpString = "" + inp;
		char cAT = inpString.charAt(indx);
		String og = String.valueOf(cAT);
		Object rObject;
		if ("bool".equals(type)) {
			rObject = Boolean.parseBoolean(og);
		} else if ("int".equals(type)) {
			rObject = (int) Math.round(Double.parseDouble(og));
		} else if ("double".equals(type)) {
			rObject = Double.parseDouble(og);
		} else if ("char".equals(type)) {
			rObject = cAT;
		} else {
			rObject = og;
		}

		return rObject;
	}

	public static String isDivisibleBy(Double num1, Double num2, Boolean invert) {
		double leftover = num1 % num2;
		boolean opt = invert != (leftover == 0);

		if (opt) {
			return "True";
		} else if (leftover == 0) {
			return "False";
		} else {
			return "False (Remainder of " + leftover + ")";
		}
	}

	public static String isOdd(Object inNum, Integer indx, Boolean place) {

		String stringedInputNum = "" + Math.round((Double) inNum);
		String AtIndex = (place) ? String.valueOf(stringedInputNum.charAt(indx)) : stringedInputNum;
		double decimalNumber = Double.parseDouble(AtIndex);
		return "[RESULT] " + isDivisibleBy(decimalNumber, (double) 2, true);

	}

	public static String nthPosOfNumber(String inpNumber, Integer pfr) {

		int pos = (inpNumber).length() - pfr;

		try {
			index(inpNumber, pos, "int");
		} catch (Exception ignored) {
			showMessageDialog(null, "[DEV] Number Length Cannot be Less than 4 Digits", "Error", WARNING_MESSAGE);
			return "";
		}
		int valAtIndex = (int) index(inpNumber,pos,"int");

		Map<Integer, String> maps = new HashMap<>();
		maps.put(1, "st");
		maps.put(2, "nd");
		maps.put(3, "rd");
		return String.format("The %1$s%2$s Position from Right to Left of the Number is %3$s",pfr,(pfr>3) ? "th" : maps.get(pfr),valAtIndex);

	}

	public static void main(String[] args) {
		String firstInput = showInputDialog("Enter the First Number");
		String secondInput = showInputDialog("Enter the Second Number");
		double firstNumber = Double.parseDouble(firstInput);
		double secondNumber = Double.parseDouble(secondInput);
		String divMessage = isDivisibleBy(firstNumber,secondNumber,false);
		System.out.printf(
				"Your First Number was %1$s\nYour Second Number was %2$s\nDoes the Second Number Divide the First Number?\n[RESULT] %3$s%n\nIs the Right Most Digit Odd?\n%4$s%n",
				firstNumber,
				secondNumber,
				divMessage,
				isOdd(firstNumber, (firstInput).length() - 1, true)
		);

		for (int i = 1; i < 4; i++) {
			System.out.println(nthPosOfNumber(firstInput, i));
		}

		String indxAsString = showInputDialog("Enter the Number Position (R->L, 1 -> "+firstInput.length()+")");
		int indx = (int) Math.round(Double.parseDouble(indxAsString));
		System.out.println(nthPosOfNumber(firstInput,indx));
	}

}
