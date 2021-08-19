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
