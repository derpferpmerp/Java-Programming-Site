import javax.swing.JOptionPane;
import java.util.*;

import static javax.swing.JOptionPane.*;

public class Project07 {

    public static Object index(Object inp, Integer indx, String type) {
        String inpString = "" + inp;
        char cAT = inpString.charAt(indx);
        String og = String.valueOf(cAT);
        Object rObject;
        switch (type) {
            case "bool"   -> rObject = (boolean) Boolean.parseBoolean(og);
            case "int"    -> rObject = (int) Math.round(Double.parseDouble(og));
            case "double" -> rObject = (double) Double.parseDouble(og);
            case "char"   -> rObject = (char) cAT;
            default       -> rObject = (String) og;
        }

        return rObject;
    }

    public static String isDivisibleBy(Double num1, Double num2, Boolean invert) {
        double leftover = num1 % num2;
        boolean opt = (leftover == 0);
        opt = invert != opt;

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

    public static String nthPosOfNumber(String inpNumber, Integer pfr) throws Exception {

        int pos = (inpNumber).length() - pfr;

        try {
            int valAtIndex = (int) index(inpNumber,pos,"int");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "[DEV] Number Length Cannot be Less than 4 Digits",
                    "Error",
                    WARNING_MESSAGE
            );
            return "";
        }
        int valAtIndex = (int) index(inpNumber,pos,"int");

        Map<Integer, String> maps;
        maps = new HashMap<>();
        maps.put(1, "st");
        maps.put(2, "nd");
        maps.put(3, "rd");
        return String.format("The %1$s%2$s Position from Right to Left of the Number is %3$s",pfr,(pfr>3) ? "th" : maps.get(pfr),valAtIndex);

    }

    public static void main(String[] args) throws Exception {
        String firstInput = showInputDialog("Enter the First Number");
        String secondInput = showInputDialog("Enter the Second Number");
        double firstNumber = Double.parseDouble(firstInput);
        double secondNumber = Double.parseDouble(secondInput);
        String divMessage = isDivisibleBy(firstNumber,secondNumber,false);
        String formatted = String.format("""
                Your First Number was %1$s
                Your Second Number was %2$s
                Does the Second Number Divide the First Number?
                [RESULT] %3$s""", firstNumber, secondNumber, divMessage);
        System.out.println(formatted);

        System.out.println("\nIs the Right Most Digit Odd?\n" + isOdd(firstNumber,(firstInput).length()-1,true));

        System.out.println(nthPosOfNumber(firstInput,1));
        System.out.println(nthPosOfNumber(firstInput,2));
        System.out.println(nthPosOfNumber(firstInput,3));

        String indxAsString = JOptionPane.showInputDialog("Enter the Number Position (R->L, 1 -> %d)".formatted(firstInput.length()));
        int indx = (int) Math.round(Double.parseDouble(indxAsString));
        System.out.println(nthPosOfNumber(firstInput,indx));
    }

}
