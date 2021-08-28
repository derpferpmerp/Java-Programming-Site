import javax.swing.JOptionPane;
import java.text.MessageFormat;

public class Project09 {

	public static void main(String[] args) {
	
		String bigString = "abcdefghijklmnopqrstuvwxyz";   //This may be changed to ANYTHING

		String strInput = JOptionPane.showInputDialog("Enter a string");

		int strLen = strInput.length();
		
		System.out.println(MessageFormat.format("The string ''{0}'' has {1} characters.", strInput, strLen));
		
		//INSERT LINE HERE
		int bigLen = bigString.length();
			
		System.out.println("The string '"+bigString+"' has "+bigLen+" characters.");
		
		//INSERT LINE HERE
		int loc = bigString.indexOf(strInput);
		
		if(loc==-1) {
		
			System.out.println(strInput+" does not appear in '"+bigString+"'.");
			
		} else {
		
			System.out.println(strInput+" begins at position "+loc+" in '"+bigString+"'.");

			String before = bigString.substring(0, loc);

			System.out.println("The letters before "+strInput+" are '"+before+"'.");

			String after = bigString.substring(loc + strInput.length());

			//INSERT LINE HERE
			
			System.out.println("The letters after "+strInput+" are '"+after+"'.");
			System.out.println("Put them together and you have '"+before+after+"'.");
		
		}	
	}
}
