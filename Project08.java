import java.util.*;
import static javax.swing.JOptionPane.*;

class Project08 {

	public static ArrayList<Integer> reverse(List<Integer> lst) {
		ArrayList<Integer> lout = new ArrayList<>();
		for (int i = lst.size() - 1; i >= 0; i--) {
			lout.add(lst.get(i));
		}
		return lout;
	}

	public static Integer max(List<Integer> lst) {
		int greatest = lst.get(0);
		for (Integer pos : lst) {
			if ( pos > greatest ) {
				greatest = pos;
			}
		}
		return greatest;
	}

	public static List<Integer> min(List<Integer> lst) {
		int smallest = lst.get(0);
		int indx = 0;
		for (int i = lst.size() - 1; i > 0; i--) {
			Integer pos = lst.get(i);
			if (pos < smallest) {
				smallest = pos;
				indx = i;
			}
		}
		return Arrays.asList(smallest,indx);
	}

	public static ArrayList<Integer> sort(List<Integer> lst) {
		List<Integer> lFallback = List.of();
		ArrayList<Integer> sorted = new ArrayList<>();
		while (!lst.equals(lFallback)) {
			List<Integer> mResult = min(lst);
			int chr = mResult.get(0);
			sorted.add(chr);
			lst.remove((Integer) chr);
		}
		return sorted;
	}


	public static Object top(List<Integer> lst, Integer amt) {
		List<Integer> srtd = sort(lst);
		List<Integer> rsort = reverse(srtd);

		List<String> lststrs = new ArrayList<>();
		List<Integer> lists = rsort.subList(0,amt);
		lists = reverse(lists);
		for (Integer intv : lists) {
			lststrs.add(String.valueOf(intv));
		}
		String lstout = String.join(", ", lststrs);
		int maxchar = max(rsort);
		return lstout.replace(", " + maxchar, ", and " + maxchar);
	}
	
	
	public static void main(String[] args) {
		String ainput = showInputDialog("Enter A");
		String binput = showInputDialog("Enter b");
		String cinput = showInputDialog("Enter c");
		String dinput = showInputDialog("Enter d");
		int a = (int) Math.round(Double.parseDouble(ainput));
		int b = (int) Math.round(Double.parseDouble(binput));
		int c = (int) Math.round(Double.parseDouble(cinput));
		int d = (int) Math.round(Double.parseDouble(dinput));
		List<Integer> list = new ArrayList<>(Arrays.asList(a, b, c, d));
		int maxnum = max(list);

		System.out.printf(a+" is%1$s bigger than %2$s",(b>a) ? " NOT" : "",b);
		System.out.println("\n");
		System.out.printf(a+" is%1$s the biggest of %2$s",(maxnum>a) ? " NOT" : "",top(list,3));
		System.out.println("\n");

		String top2 = String.valueOf(top(new ArrayList<>(Arrays.asList(a,b,c,d)),2));

		boolean conts = top2.contains(", "+a) || top2.contains(", and "+a) || top2.toLowerCase().startsWith(a+",");

		for (String s : Arrays.asList(a + " is%1$s in the top two of %2$s", "Again, " + a + " is%1$s in the top two of %2$s")) {
			System.out.printf(s,(!conts) ? " NOT" : "",top(new ArrayList<>(Arrays.asList(a,b,c,d)),4));
			System.out.println("\n");
		}
	}
}
