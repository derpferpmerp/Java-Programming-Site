import javax.swing.JOptionPane;

public class Project05 {
	
	public static void main(String[] args) {
		String p1 = JOptionPane.showInputDialog("Name A Basketball Player");

		String p1pointsstr = JOptionPane.showInputDialog("How Many Points Did " + p1 + " Score Last Night?");
		double p1pointsnum = Double.parseDouble(p1pointsstr);

		String p2 = JOptionPane.showInputDialog("Name Another Basketball Player");

		String p2pointsstr = JOptionPane.showInputDialog("How Many Points Did " + p2 + " Score Last Night?");
		double p2pointsnum = Double.parseDouble(p2pointsstr);

		String larger = (p2pointsnum > p1pointsnum) ? p2 : p1;
		String smaller = (p2pointsnum > p1pointsnum) ? p1 : p2;
		double diff = Math.abs(p2pointsnum - p1pointsnum);

		JOptionPane.showMessageDialog(null, larger + " Scored " + diff + " more points than " + smaller + ".");
	}

}