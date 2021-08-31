import java.text.MessageFormat;
import java.util.*;

public class Project13 {
	public static List<Integer> multMatch(String input, String mchar) {
		List<Integer> matches = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			if (String.valueOf(input.charAt(i)).equals(mchar)) {
				matches.add(i);
			}
		}
		return matches;
	}



	public static void main(String[] args) {
		Scanner lreader = new Scanner(System.in);
		String ln;
		List<String> lines = new ArrayList<>();
		do {
			ln = lreader.nextLine();
			lines.add(ln);
		} while (!(ln.contains("x") || ln.contains("X")));
		List<String> parsed = new ArrayList<>();
		for (String line : lines) {
			if (!(line.contains("x") || line.contains("X"))) {
				parsed.add(line);
			}
		}
		String outstr = String.join("",parsed);

		System.out.println(outstr);
		System.out.println("Enter A Character to Search For -->");

		String searchCharacter = String.valueOf(lreader.nextLine());
		List<Integer> matchedChars = multMatch(outstr,searchCharacter);

		System.out.println(MessageFormat.format("The Second Position of {0} is {1}", searchCharacter, matchedChars.get(1)));
	}
}
