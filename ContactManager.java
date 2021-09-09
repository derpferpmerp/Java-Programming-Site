import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.text.MessageFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.OK_OPTION;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ContactManager {

	private static ImageIcon contactsIcon;
	private static String dbFileLocation = "contactsOutput.txt";

	static {
		try {
			contactsIcon = new ImageIcon(new URL("https://i.ibb.co/F5pmGbN/featured-content-contacts-icon-2x-1.png"));
		} catch (MalformedURLException ignored) {}
	}

	private static void changeDBFile() throws IOException {
		JFileChooser fileChooser = new JFileChooser(Paths.get("").toAbsolutePath().toString());
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		fileChooser.setFileFilter(filter);
		fileChooser.showOpenDialog(null);
		dbFileLocation = fileChooser.getSelectedFile().getName();
		List<Map<String,String>> parsedData = parseFile(dbFileLocation);
		List<String> names = new ArrayList<>();
		for (Map<String,String> contact : parsedData) {
			names.add(contact.get("FN")+" "+contact.get("LN"));
		}
		mainScreen(names);
	}

	private static void writeToFile(Object data, String filename) throws IOException {
		String dataString = String.valueOf(data);
		Files.writeString(Path.of(filename), dataString);
	}

	private static void arrayWrite(List<String> array, String item, String filename) throws IOException {
		if (!array.contains(item)) {
			array.add(item);
		}
		writeToFile(array,filename);
	}

	private static List<String> randList(Integer amt) {
		Random idGenerator = new Random();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < amt; i++) {
			Integer integer = idGenerator.nextInt(9) + 1;
			switch (i) {
				case 0 -> list.add("(" + integer);
				case 2 -> list.add(integer + ")-");
				case 6 -> list.add("-" + integer);
				default -> list.add(String.valueOf(integer));
			}
		}
		return list;
	}

	private static Map<String,String> newEntry(Integer itr, List<String> ids) {
		Map<String,String> out = new HashMap<>();
		Random genderChooser = new Random();
		int idLength = 10;
		String id = String.join("",randList(idLength));

		while (ids.contains(id)) {
			id = String.join("",randList(idLength));
			if (!ids.contains(id)) {
				ids.add(id);
				break;
			}
		}

		out.put("PN",id);
		out.put("FN","fn(P"+itr+")");
		out.put("LN","ln(P"+itr+")");
		out.put("GE",genderChooser.nextDouble() >= 0.5? "M" : "F");
		out.put("IDS",String.join(", ", ids));
		return out;
	}

	private static List<String> safeRemove(List<Map<String,String>> list, Map<String,String> item) {
		return list.stream().filter(s -> !Objects.equals(item, s)).map(String::valueOf).collect(Collectors.toList());
	}

	private static String formatPeople(List<Map<String, String>> input) {
		return input.size() + "\n" + input.stream().map(person -> MessageFormat.format("{0} {1} {2} {3}\n", person.get("FN"), person.get("LN"), person.get("PN"), person.get("GE"))).collect(Collectors.joining());
	}

	// Parses the File `filename`, grabs list of contacts, Opens Up new GUI window with Input Text Boxes for each value in the Contacts, adds created contact to list of parsed contacts, then updates the infile with the new edited formatted contact list.
	private static void guiAddContact(String filename, Map<String,String> textFieldValues) throws IOException {
		List<Map<String,String>> contacts = parseFile(filename);
		JTextField ID = new JTextField(textFieldValues.get("ID"));
		JTextField fName = new JTextField(textFieldValues.get("FN"));
		JTextField lName = new JTextField(textFieldValues.get("LN"));

		String[] genders = {"M", "F"};
		JList<String> genderList = new JList<>(genders);

		Object[] win = {
				contactsIcon,
				"Phone Number:", ID,
				"First Name:", fName,
				"Last Name:", lName,
				"Gender:", genderList,
		};
		genderList.setSelectedValue(textFieldValues.get("GE"),true);
		int option = showConfirmDialog(null, win, "Modify Contact", OK_CANCEL_OPTION, PLAIN_MESSAGE,null);
		if (option == OK_OPTION) {
			Map<String, String> output = new HashMap<>();
			output.put("PN",ID.getText());
			output.put("FN",fName.getText());
			output.put("LN",lName.getText());
			String gender = genderList.getSelectedValuesList().get(0);
			output.put("GE",gender);
			boolean inList = false;
			for (int i=0;i<contacts.size();i++) {
				if (contacts.get(i).get("FN").equals(output.get("FN")) && contacts.get(i).get("LN").equals(output.get("LN"))) {
					contacts.set(i,output);
					inList = true;
				}
			}
			if (!inList) {
				contacts.add(output);
			}
			System.out.println(output);
			writeToFile(formatPeople(contacts),filename);
		}
		listInitializer(contacts);
	}

	private static void listInitializer(List<Map<String, String>> contacts) throws IOException {
		List<String> contactNames = new ArrayList<>();
		for (Map<String, String> contact : contacts) {
			String itm = contact.get("FN") + " " + contact.get("LN");
			contactNames.add(itm);
		}
		mainScreen(contactNames);
	}

	// Parses File `filename` and retrieves preset values from splitting into spaces and mapping indices.
	private static List<Map<String,String>> parseFile(String filename) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get(filename)));
		List<String> byLine = Arrays.asList(content.split("\n"));
		List<Map<String,String>> contacts = new ArrayList<>();

		for (int i=1; i<byLine.size(); i++) {
			List<String> splittedLine = Arrays.asList(byLine.get(i).split(" "));
			Map<String, String> contact = new HashMap<>();
			contact.put("FN",splittedLine.get(0));
			contact.put("LN",splittedLine.get(1));
			contact.put("PN",splittedLine.get(2));
			contact.put("GE",splittedLine.get(3));
			contacts.add(contact);
		}
		return contacts;

	}

	private static void displayContacts(List<Map<String,String>> contacts) throws IOException {
		List<String> cNames = new ArrayList<>();
		for (Map<String, String> contact : contacts) {
			String fullName = contact.get("FN") + " " + contact.get("LN");
			String gender = contact.get("GE");
			System.out.println(MessageFormat.format("{0} {1}\n{2}\n", fullName, gender, contact.get("PN")));
			cNames.add(fullName);
		}
		mainScreen(cNames);
	}

	private static void mainScreen(List<String> contactNames) throws IOException {
		contactNames.addAll(Arrays.asList("New Contact", "Display Contacts", "Sort Contacts", "Change Database File"));
		Object[] contactObjList = contactNames.toArray();
		JList<Object> contactNameSelectionList = new JList<>(contactObjList);
		Object[] mainWindow = {
				contactsIcon,
				"Choose A Contact",
				contactNameSelectionList
		};
		int result = showConfirmDialog(null, mainWindow, "Contact Editor", OK_CANCEL_OPTION, PLAIN_MESSAGE,null);
		if (contactNameSelectionList.getSelectedValuesList().size() > 0) {
			String contactName = (String) contactNameSelectionList.getSelectedValuesList().get(0);
			String contactsFileName = dbFileLocation;

			if (Objects.equals(contactName, "New Contact")) {

				Map<String, String> textFieldValues = new HashMap<>();
				for (String i : Arrays.asList("ID", "FN", "LN")) {
					textFieldValues.put(i, "");
				}
				textFieldValues.put("GE", "M");
				guiAddContact(contactsFileName, textFieldValues);


			} else if (Objects.equals(contactName, "Display Contacts")) {
				displayContacts(parseFile(contactsFileName));
			} else if (Objects.equals(contactName, "Change Database File")) {
				changeDBFile();
			} else if (Objects.equals(contactName, "Sort Contacts")) {
				List<Map<String, String>> contacts = parseFile(contactsFileName);
				Map<String,Map<String,String>> reGetMatches = new HashMap<>();

				List<String> listToSort = new ArrayList<>();
				for (Map<String, String> stringStringMap : contacts) {
					String ln = stringStringMap.get("LN");
					listToSort.add(ln);
					reGetMatches.put(ln,stringStringMap);
				}
				List<String> sorted = listToSort.stream().sorted().collect(Collectors.toList());
				List<Map<String, String>> sortedContacts = new ArrayList<>();
				for (String s : sorted) {
					Map<String, String> stringStringMap = reGetMatches.get(s);
					sortedContacts.add(stringStringMap);
				}
				writeToFile(formatPeople(sortedContacts), contactsFileName);
				List<String> cNames = sortedContacts.stream().map(contact -> contact.get("FN") + " " + contact.get("LN")).collect(Collectors.toList());
				mainScreen(cNames);
			} else if (!Objects.equals(contactName, "Quit") && !Objects.equals(contactName, null)) {
				List<Map<String, String>> contacts = parseFile(contactsFileName);
				Map<String, String> targetContact = new HashMap<>();
				String chosenMethod = chooseMethod();
				for (Map<String, String> contact : contacts) {
					String shouldbe = contact.get("FN") + " " + contact.get("LN");
					if (Objects.equals(shouldbe, contactName)) {
						targetContact = contact;
					}
				}
				if (Objects.equals(chosenMethod, "Modify")) {
					Map<String, String> textFieldValues = new HashMap<>();
					for (String i : Arrays.asList("FN", "LN", "GE")) {
						textFieldValues.put(i, targetContact.get(i));
					}
					textFieldValues.put("ID", targetContact.get("PN"));
					guiAddContact(contactsFileName, textFieldValues);
				} else {
					contacts.remove(targetContact);
					writeToFile(formatPeople(contacts), contactsFileName);
					List<String> cNames = contacts.stream().map(contact -> contact.get("FN") + " " + contact.get("LN")).collect(Collectors.toList());
					mainScreen(cNames);
				}
			}
		}
	}

	private static String chooseMethod() {
		List<String> methods = Arrays.asList("Modify", "Remove");
		return (String) showInputDialog(null, "Choose a Method", "Contact Menu", PLAIN_MESSAGE, null, methods.toArray(), "");
	}

	public static void main(String[] args) throws IOException {
		List<String> names = new ArrayList<>();
		List<String> ids = new ArrayList<>();
		List<Map<String, String>> people = new ArrayList<>();
		boolean doNotTry = false;
		try { parseFile(dbFileLocation); } catch (IOException ignored) { doNotTry = true; }
		if (doNotTry || parseFile(dbFileLocation).size() == 0) {
			for (int i = 0; i < 5; i++) {
				Map<String, String> outValue = newEntry(i,ids);
				ids = Arrays.asList(outValue.get("IDS").split(", "));
				names.add(outValue.get("FN")+" "+outValue.get("LN"));
				outValue.remove("IDS");
				people.add(outValue);
			}
			writeToFile(formatPeople(people),dbFileLocation);
		} else {
			List<Map<String,String>> parsedFileData = parseFile(dbFileLocation);
			for (Map<String,String> contact : parsedFileData) {
				ids.add(contact.get("PN"));
				names.add(contact.get("FN")+" "+contact.get("LN"));
				people.add(contact);
			}
		}
		mainScreen(names);
	}
}
