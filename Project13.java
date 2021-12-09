import java.text.MessageFormat;
import java.util.*;

public class Project13 {

	public static List<Integer> multMatch(String input, String mchar) {
		List<Integer> matches = new ArrayList<Integer>();
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
		List<String> lines = new ArrayList<String>();
		do {
			ln = lreader.nextLine();
			lines.add(ln);
		} while (!(ln.contains("x") || ln.contains("X")));
		List<String> parsed = new ArrayList<String>();
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

		switch (matchedChars.size()) {
			case 0:
				System.out.println(MessageFormat.format("Character \"{0}\" Occurs Zero Times", searchCharacter));
				break;
			case 1:
				System.out.println(MessageFormat.format("{0} Occurs only once, at index {1}", searchCharacter, matchedChars.get(0)));
				break;
			default:
				System.out.println(MessageFormat.format("The Second Position of {0} is {1}", searchCharacter, matchedChars.get(1)));
				break;
		}


	}
}
