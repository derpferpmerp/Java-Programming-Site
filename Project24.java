import java.io.IOException;
import java.nio.file.*;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;


public class Project24 {

	public static void writeToFile(Object data, String filename, Boolean override) throws IOException {
		String dataString = String.valueOf(data);
		if (override) {
			Files.writeString(Path.of(filename), dataString);
		}
	}

	public static void arrayWrite(List<String> array, String item, String filename) throws IOException {
		if (!array.contains(item)) {
			array.add(item);
		}
		writeToFile(array,filename,true);
	}

	public static List<String> randList(Integer amt) {
		Random idGenerator = new Random();
		List<String> list = new ArrayList<String>();
		Integer integer;
		for (int i = 0; i < amt; i++) {
			integer = idGenerator.nextInt(9) + 1;
			list.add(String.valueOf(integer));
		}
		return list;
	}

	public static Map<String,String> newEntry(Integer itr, List<String> ids) {
		Map<String,String> out = new HashMap<String, String>();
		Random genderChooser = new Random();
		int idLength = 8;
		String id = String.join("",randList(idLength));

		while (ids.contains(id)) {
			id = String.join("",randList(idLength));
			if (!ids.contains(id)) {
				ids.add(id);
				break;
			}
		}

		out.put("ID",id);
		out.put("FN","First Name (P"+itr+")");
		out.put("LN","Last Name (P"+itr+")");
		out.put("GE",genderChooser.nextDouble() >= 0.5? "M" : "F");
		out.put("IDS",String.join(", ", ids));
		return out;
	}

	public static List<String> safeRemove(List<String> list, String item) {
		List<String> stringed = new ArrayList<String>();
		for (String s : list) {
			if (!Objects.equals(item, s)) {
				stringed.add(String.valueOf(s));
			}
		}
		return stringed;
	}

	public static String formatPeople(List<Map<String,String>> input, Integer form) {
		switch (form) {
			case 1:
				StringBuilder sb = new StringBuilder();
				for (Map<String, String> person : input) {
					String format = MessageFormat.format("{0} {1} {2} {3}\n", person.get("ID"), person.get("FN"), person.get("LN"), person.get("GE"));
					sb.append(format);
				}
				return input.size() + "\n" + sb;
			case 2:
				StringBuilder result = new StringBuilder();
				for (Map<String, String> person : input) {
					String format = MessageFormat.format("{0}\n{1} {2}\n{3}\n", person.get("ID"), person.get("FN"), person.get("LN"), person.get("GE"));
					result.append(format);
				}
				return input.size() + "\n" + result;
			default:
				return "INVALID";
		}
	}

	public static void outputToFile(Integer peopleAmount, String filename) throws IOException {
		List<Map<String,String>> generatedPeople = new ArrayList<Map<String, String>>();
		List<String> ids = new ArrayList<String>();
		for (int i = 0; i < peopleAmount; i++) {
			Map<String, String> outValue = newEntry(i,ids);
			ids = Arrays.asList(outValue.get("IDS").split(", "));
			outValue.remove("IDS");
			generatedPeople.add(outValue);
		}
		writeToFile(formatPeople(generatedPeople,1),filename,true);
	}

	public static void main(String[] args) throws IOException {
		List<Map<String,String>> people = new ArrayList<Map<String, String>>();
		List<String> ids = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			Map<String, String> outValue = newEntry(i,ids);
			ids = Arrays.asList(outValue.get("IDS").split(", "));
			outValue.remove("IDS");
			people.add(outValue);
		}
		System.out.println(formatPeople(people,1));
		System.out.println(formatPeople(people,2));

		outputToFile(4,"outfile.txt");
	}
}
