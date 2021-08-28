import java.util.*;
import static javax.swing.JOptionPane.*;

public class Project10 {

	public static Map<String, String> Person(Integer n, String addy) {
		Map<String, String> tmp = new HashMap<>();
		String fn = showInputDialog("Enter the First Name for Contact #"+n);
		String ln = showInputDialog("Enter the Last Name for Contact #"+n);
		tmp.put("First",fn);
		tmp.put("Last",ln);
		if (Objects.equals(addy, "False")) {
			String hpn = showInputDialog("Enter the Home Phone Number for "+fn);
			String mpn = showInputDialog("Enter the Mobile Phone Number for "+fn);
			tmp.put("HNumber",hpn);
			tmp.put("MNumber",mpn);
			return tmp;
		}
		if (Objects.equals(addy, "True")) {
			String sadd = showInputDialog("Enter the Street Address where "+fn+" lives");
			String city = showInputDialog("Enter the City where "+fn+" lives");
			String state = showInputDialog("Enter the State where "+fn+" lives");
			String zc = showInputDialog("Enter the Zip Code where "+fn+" lives");
			tmp.put("Address1",sadd);
			tmp.put("Address2",city+", "+state+" "+zc);
			return tmp;
		}
	
		return tmp;
	}


	public static void main(String[] args) {

		Map<String, Map<String, String>> maps;
		maps = new HashMap<>();
		maps.put("Contact1",Person(1, "False"));
		maps.put("Contact2",Person(2, "True"));
		maps.put("Contact3",Person(3, "None"));
		for (String s : Arrays.asList("Last", "First")) {
			System.out.println(maps.get("Contact1").get(s));
			System.out.println(maps.get("Contact3").get(s));
		}
		String L1 = maps.get("Contact1").get("Last");
		String L3 = maps.get("Contact3").get("Last");
		String F1 = maps.get("Contact1").get("First");
		String F3 = maps.get("Contact3").get("First");
		if (L1.equals(L3) && F1.equals(F3)) {
			String hnum = maps.get("Contact1").get("HNumber");
			String mnum = maps.get("Contact1").get("MNumber");
			System.out.println("Contacts Match");
			showMessageDialog(null,String.format("%1$s\nHome: %2$s\nMobile: %3$s",F1+" "+L1,hnum,mnum));
		}
		else {
			showMessageDialog(null, "[DEV] Contacts Don't Match","Error",WARNING_MESSAGE);
		}
	}
}
