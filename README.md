# Java-Programming-Site
_Coded By Cole Fleming and Cole Fleming only_

<details closed>
<summary>Project 01</summary>
<!--All you need is a blank line-->

```java
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog("What is your name?");

        String hourlywage = JOptionPane.showInputDialog(name + ", how much do you make per hour?");
        double hourlywagenum = Double.parseDouble(hourlywage);

        String amthoursstr = JOptionPane.showInputDialog("One more question " + name + "; how many hours did you work last week?");
        double amthoursnum = Double.parseDouble(amthoursstr);

        double weekwage = amthoursnum * hourlywagenum;

        JOptionPane.showMessageDialog(null, name + " made $" + weekwage + " last week.");
    }

}
```
</details>

<details closed>
<summary>Project 02</summary>
<!--All you need is a blank line-->

```java
public class Main {
		
	public static void Str1() {System.out.println("  *");}
	public static void Str2() {System.out.println(" * ");}
	public static void Str3() {System.out.println("*  ");}
	public static void Str4() {System.out.println(" **");}
	public static void Str5() {System.out.println("** ");}
	public static void Str6() {System.out.println("* *");}
	public static void Str7() {System.out.println("***");}
	public static void Str8() {System.out.println("   ");}
	
	public static void main(String[] args) {
		// 1
		Str1();
		Str1();
		Str1();
		Str1();
		Str1();
		
		Str8();  
		Str8();	


		// 2
		Str7();
		Str1();
		Str7();
		Str3();
		Str7(); 

		Str8();  
		Str8();	

		// 3

		Str7();
		Str1();
		Str7();
		Str1();
		Str7();

		Str8();  
		Str8();	

		// 4

		Str6();
		Str6();
		Str7();
		Str1();
		Str1();

		Str8();  
		Str8();

		// 5

		Str7();
		Str3();
		Str7();
		Str1();
		Str7();

		Str8();  
		Str8();	

		// 6

		Str7();
		Str3();
		Str7();
		Str6();
		Str7();

		Str8();  
		Str8();	

		// 7

		Str7();
		Str1();
		Str1();
		Str1();
		Str1();

		Str8();  
		Str8();	

		// 8

		Str7();
		Str6();
		Str7();
		Str6();
		Str7();

		Str8();  
		Str8();	

		// 9

		Str7();
		Str6();
		Str7();
		Str1();
		Str1();

		Str8();  
		Str8();	
	}
  
}
```
</details>

<details closed>
<summary>Project 03</summary>
<!--All you need is a blank line-->

```java
public class Main {

    static void printNcharacters(String str, int numCharacters) {
        for (int i = 0; i < numCharacters; i++) {
            System.out.print(str);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        printNcharacters("@", 12);
        printNcharacters("*", 3);
        printNcharacters("$", 5);
        printNcharacters("$@", 4);
        printNcharacters("&@$%", 5);
    }
}
```
</details>
	
<details closed>
<summary>Project 04</summary>
<!--All you need is a blank line-->

```java
import javax.swing.JOptionPane;

public class Main {

    public static double FtoC(double fah) {
        double c = 5;
        double c2 = c / 9;
        double c3 = (fah - 32);
        return c2 * c3;
    }

    public static double CtoF(double cel) {
        double f = 9;
        double f2p1 = f / 5;
        double f3 = f2p1 * cel;
        return f3 + 32;
    }


    public static void main(String[] args) {
        String fInput = JOptionPane.showInputDialog("Enter a temperature in Fahrenheit");
        double fVal = Double.parseDouble(fInput);

        double cConv = FtoC(fVal);

        JOptionPane.showMessageDialog(null, fInput + "F is " + cConv + "C.");

        String cInput = JOptionPane.showInputDialog("Enter a temperature in Celsius");
        double cVal = Double.parseDouble(cInput);

        double fConv = CtoF(cVal);

        JOptionPane.showMessageDialog(null, cInput + "C is " + fConv + "F.");
    }

}
```
</details>

<details closed>
<summary>Project 05</summary>
<!--All you need is a blank line-->

```java
import javax.swing.JOptionPane;

public class Project05 {

    public static void main(String[] args) {
        String p1 = JOptionPane.showInputDialog("Name A Basketball Player");

        String p1pointsstr = JOptionPane.showInputDialog("How Many Points Did " + p1 + " Score Last Night?");
        double p1pointsnum = Double.parseDouble(p1pointsstr);

        String p2 = JOptionPane.showInputDialog("Name Another Basketball Player");

        String p2pointsstr = JOptionPane.showInputDialog("How Many Points Did " + p2 + " Score Last Night?");
        double p2pointsnum = Double.parseDouble(p2pointsstr);

        String larger = (p2pointsnum > p1pointsnum) ? p2 : p1;
        String smaller = (p2pointsnum > p1pointsnum) ? p1 : p2;
        double diff = Math.abs(p2pointsnum - p1pointsnum);

        JOptionPane.showMessageDialog(null, larger + " Scored " + diff + " more points than " + smaller + ".");
    }

}
```
</details>

<details closed>
<summary>Project 06</summary>
<!--All you need is a blank line-->

```java
import javax.swing.JOptionPane;
import java.util.Random;

public class Project06 {

    public static void main(String[] args) {

        Random rand = new Random();
        double randnum = rand.nextInt(8) + 1;
        String guessedNumString = JOptionPane.showInputDialog("Try and Guess My Number (1-8)");
        double guessedNum = Double.parseDouble(guessedNumString);

        if ((int) guessedNum == (int) randnum) {
            JOptionPane.showMessageDialog(null, "You Got It !!!");
        } else {
            JOptionPane.showMessageDialog(null, (guessedNum > randnum) ? "Your Guess Was Too High" : "Your Guess Was Too Low");
        }

        JOptionPane.showMessageDialog(null, "I Picked " + (int) randnum);

    }

}
```
</details>

<details closed>
<summary>Project 07</summary>
<!--All you need is a blank line-->

```java
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
```
</details>