package lab3.solution;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * This class handles problems in a similar way to Challenge #2, except that
 * it uses a custom exception class (InvalidNameException) which controls
 * the message in a consistent way (see line #40 below and line #33 in the
 * NameService class.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {
    private NameService nameService;

    public InputOutputGui() {
        nameService = new NameService();
    }

    public void startConversation() {     
        String fullName = JOptionPane.showInputDialog("Enter full name:");
        
        // This happens if CANCEL button pressed. No need for exception
        // handling here!
        if(fullName == null) {
            // User must want to quit...
            System.exit(0);
        }
        
        // Always declare the variables you need in the try-catch outside 
        // because inside would make them local variables.
        String lastName = "Unknown";

        try {
            lastName = nameService.extractLastName(fullName);
            
        } catch (InvalidNameException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
        
    }
     
}
