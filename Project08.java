import java.util.*;
import static javax.swing.JOptionPane.*;

class HelloWorld {
	
	public static Object top(List<Integer> lst, Integer amt) {
		Collections.sort(lst);
		Collections.reverse(lst);
		List<String> lststrs = new ArrayList<>();
		List<Integer> lists = lst.subList(0,amt);
		Collections.reverse(lists);
		for (Integer intv : lists) {
			lststrs.add(String.valueOf(intv));
		}
		String lstout = String.join(", ", lststrs);
		int maxchar = Collections.max(lst);
		String lstoutf = lstout.replace(", "+maxchar, ", and "+maxchar);
		return lstoutf;
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
		List<Integer> list = Arrays.asList(a,b,c,d);
		int maxnum = Collections.max(list);
		System.out.printf(a+" is%1$s bigger than %2$s",(b>a) ? " NOT" : "",b);
		System.out.println("\n");
		System.out.printf(a+" is%1$s the biggest of %2$s",(maxnum>a) ? " NOT" : "",top(list,3));
		System.out.println("\n");
		String top2 = String.valueOf(top(list,2));
		boolean conts = top2.contains(", "+a) || top2.contains(", and "+a) || top2.toLowerCase().startsWith(a+",");

		System.out.printf(a+" is%1$s in the top two of %2$s",(!conts) ? " NOT" : "",top(list,4));
		System.out.println("\n");
		System.out.printf("Again, "+a+" is%1$s in the top two of %2$s",(!conts) ? " NOT" : "",top(list,4));
		System.out.println("\n");
	}
}
