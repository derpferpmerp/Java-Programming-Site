import javax.swing.JOptionPane;

public class Project01 {

  public static void main(String[] args) {

    String name = JOptionPane.showInputDialog("What is your name?");

    String hourlywage = JOptionPane.showInputDialog(name + ", how much do you make per hour?");
    double hourlywagenum = Double.parseDouble(hourlywage);

    String amthoursstr = JOptionPane.showInputDialog("One more question " + name + "; how many hours did you work last week?");
    double amthoursnum = Double.parseDouble(amthoursstr);

    double weekwage = amthoursnum * hourlywagenum;

    JOptionPane.showMessageDialog(null, name + " made $" + weekwage + " last week.");
    
  }
  
}
