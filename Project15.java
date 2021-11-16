import java.text.MessageFormat;
import static javax.swing.JOptionPane.showInputDialog;

public class Project15 {
	public static int matches(String str, String pat, Boolean overlap) {
		int amt = 0;
		for ( int i = 0; i <= str.length(); i++ ) {
			int end = (i + pat.length() > str.length()) ? str.length() : i + pat.length();
			String substr = str.substring(i, end);
			if (substr.equals(pat)) {
				i += (overlap) ? 0 : pat.length() - 1;
				amt += 1;
			}
		}
		return amt;
	}

	public static void main(String[] args) {
		String original = showInputDialog("String to Search");
		String pattern = showInputDialog("Pattern to Look For");
		int overlap = matches(original, pattern, true);
		int nooverlap = matches(original, pattern, false);
		String reversed = new StringBuilder(original).reverse().toString();
		System.out.println(MessageFormat.format("Original String: {0}\nOriginal Word: {1}\nReversed: {2}\nMatches With Overlap: {3}\nMatches Without Overlap: {4}",original,pattern,reversed,overlap,nooverlap));
	}
}
