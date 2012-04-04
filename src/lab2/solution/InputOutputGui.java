package lab2.solution;

import javax.swing.JOptionPane;

/**
 * The solution comes in two parts:
 *    1. First we test input (fullName) for null on line #37. This can happen 
 *       if the CANCEL button is pressed. We don't need exception handling 
 *       for this.
 *    2. Next, we pass the fullName to the NameService for processing. If you
 *       look there you will see that the processing may result in an
 *       exception, which is thrown back to this class for handling on 
 *       line #52. It's not the responsibility of the NameService to display
 *       error messages, so handling the exception here is appropriate.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {
    private static final String ERR_MSG =
            "Sorry, a first name and a last name are required, no more. "
            + "Please try again.";
    private static final String MSG_TITLE = "Input Error";

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
        
        // The exception was thrown to us by NameService
        // It should be handled here!
        try {
            lastName = nameService.extractLastName(fullName);
        
        // Polymrophically catches others for this app.
        } catch(RuntimeException ae) {
            JOptionPane.showMessageDialog(null, ERR_MSG, MSG_TITLE, 
                    JOptionPane.ERROR_MESSAGE);
        }
        
        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
        
    }
     
}
