import javax.swing.JOptionPane;

public class Project04 {
  
	public static double FtoC(double fah) {
		double c = 5;
		double c2 = c/9;
		double c3 = (fah - 32);
		return c2 * c3;
	}
   
	public static double CtoF(double cel) {
		double f = 9;
		double f2p1 = f/5;
		double f3 = f2p1 * cel;
		return f3 + 32;
	}
   
  
   
   
	public static void main(String[] args) {
		String fInput = JOptionPane.showInputDialog("Enter a temperature in Fahrenheit");
		double fVal = Double.parseDouble(fInput);
		
		double cConv = FtoC(fVal);
		
		JOptionPane.showMessageDialog(null,fInput+"F is "+cConv+"C.");   

		String cInput = JOptionPane.showInputDialog("Enter a temperature in Celsius");
		double cVal = Double.parseDouble(cInput);
		
		double fConv = CtoF(cVal);
		
		JOptionPane.showMessageDialog(null,cInput+"C is "+fConv+"F.");  			
	}

}
