package lab1;

import javax.swing.JOptionPane;

/**
 * This class requests a user's first and last name via a GUI interface.
 * <p>
 * User responses are validated to ensure that two names, and only two 
 * names are entered.
 * 
 * @author  Kevin Nangle, knangle@my.wctc.edu
 * @version 1.00
 */
public class Challenge1 {
    private static final int LAST_NAME_IDX = 1;
    private static final String ERROR_MESSAGE = "Please enter both your first "
            + "and last name, in that order.  Do not enter middle name or "
            + "initial.";
    private static String fullName = "Unknown";
    private static String lastName = "Unknown";
    private static boolean validName = false;
    private static String msg = "Your last name is: ";
    
    public static void main(String[] args) {  
        
        while(!validName){
            lastName = askForName();
        }
            JOptionPane.showMessageDialog(null, msg + lastName);
        
    }
    
    public static String askForName(){
            Challenge1 app = new Challenge1();
            fullName = JOptionPane.showInputDialog("Enter full name:");
            lastName = app.extractLastName(fullName);
            
            return lastName;
    }
    
    public String extractLastName(String fullName) {
        String lastName = "default";
        try{
        String[] nameParts = fullName.split(" ");
        
        if(nameParts.length != 2) {
                throw new IllegalArgumentException();
        }
            
        lastName = nameParts[LAST_NAME_IDX];
        
        }
        catch(NullPointerException cancel){
            System.exit(0);
        }
        catch(RuntimeException oob){
            JOptionPane.showMessageDialog(null, ERROR_MESSAGE);  
            validName = false;
            lastName = askForName();
        }
        
        validName = true;
        return lastName;
    }

}
