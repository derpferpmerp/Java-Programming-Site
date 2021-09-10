import java.text.MessageFormat;
import java.util.regex.*;
import java.util.*;
import static javax.swing.JOptionPane.*;

public class Project28 {

	public static void main(String[] args) {
		//String inpString = "bcaaaeefffaaaabaaaaaccc\"";
		String inpString = showInputDialog("Enter A String.");
		String regexCharacter = showInputDialog("Enter A Letter.");
		String removedLetter = inpString.replaceAll(regexCharacter+"+","");
		String rDoubles = inpString.replaceAll("(.)\\1","");
		String rDoublesPlus = inpString.replaceAll("(.)\\1+","");
		String pairs = inpString.replaceAll(regexCharacter+"+","-").replaceAll(".-","").replaceAll("-",regexCharacter);

		System.out.println(MessageFormat.format("""
				Original String: {0}
				Remove Letter "{1}" from String: {2}
				Remove Repeated Characters (2x): {3}
				Remove Repeated Characters (2x+): {4}
				Remove Letter "{1}" and Previous: {5}
				""",inpString,regexCharacter,removedLetter,rDoubles,rDoublesPlus,pairs));
	}
}
