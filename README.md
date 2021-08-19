# Java-Programming-Site
_Coded By Cole Fleming and Cole Fleming only_

<details closed>
<summary>Project 01</summary>
<!--All you need is a blank line-->

```java
import javax.swing.JOptionPane;

public class Main {

  public static void main(String args[]) {

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
    
    
    public static void main(String args[])
    {
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
		double c2 = c/9;
		double c3 = (fah - 32);
		double c4 = c2 * c3;
		return c4;
	}
   
	public static double CtoF(double cel) {
		double f = 9;
		double f2p1 = f/5;
		double f3 = f2p1 * cel;
		double f4 = f3 + 32;
		return f4;
	}
   
  
   
   
	public static void main(String args[]) {
		String fInput = JOptionPane.showInputDialog("Enter a temperature in Fahrenheit");
		double fVal = Double.parseDouble(fInput);
		
		double cConv = FtoC(fVal);
		
		JOptionPane.showMessageDialog(null,fInput+"F is "+cConv+"C.");   

		String cInput = JOptionPane.showInputDialog("Enter a temperature in Celsius");
		double cVal = Double.parseDouble(cInput);
		
		double fConv = CtoF(cVal);
		
		JOptionPane.showMessageDialog(null,cInput+"C is "+fConv+"F.");  			
	}

}
```
</details>
