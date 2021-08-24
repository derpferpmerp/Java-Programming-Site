import javax.swing.JOptionPane;
import java.util.Random;

public class Project06 {
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		double randnum = rand.nextInt(8) + 1;
		String guessedNumString = JOptionPane.showInputDialog("Try and Guess My Number (1-8)");
		double guessedNum = Double.parseDouble(guessedNumString);

		if ((int) guessedNum == (int) randnum) {
			JOptionPane.showMessageDialog(null, "You Got It !!!");
		} else {
			JOptionPane.showMessageDialog(null, (guessedNum > randnum) ? "Your Guess Was Too High" : "Your Guess Was Too Low");
		}

		JOptionPane.showMessageDialog(null, "I Picked " + (int) randnum);

	}

}