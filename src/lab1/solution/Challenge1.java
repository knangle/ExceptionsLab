package lab1.solution;

import javax.swing.JOptionPane;

/**
 * Here's a solution. There are 3 possible points of failure:
 *   1. On line #60 the array index may be bad causing an
 *      ArrayIndexOutOfBoundsException. This can happen if only a first name
 *      is entered, for example. The exception handler will deal with it. And
 *      it's caught polymorphically on line #68.
 *   2. If nothing is entered and the OK button is pressed, the empty string
 *      returned would cause the exception in #1 above. However, we also
 *      have to deal with the possibility that a first name, plus middle name
 *      plus last name might be entered. In this case, no array exception
 *      would occur. But this is clearly not right, so we have to artificially
 *      create an exception on our own. This is done on line #57. And it it's
 *      caught polymorphically on line #68.
 *   3. If the user enters nothing and presses the CANCEL button, null is 
 *      returned by JOptionPane. That null will result in a NullPointerException
 *      on line #49. If that happens it signals that the user is done and
 *      wants to quit, so we catch the exception on line #63.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.01
 */
public class Challenge1 {
    private static final int LAST_NAME_IDX = 1;
    private static final String ERR_MSG =
            "Sorry, a first name and a last name are required, no more.  "
            + "Please try again.";
    private static final String MSG_TITLE = "Input Error";

    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        
        String fullName = JOptionPane.showInputDialog("Enter full name:");
        
        String lastName = app.extractLastName(fullName);
        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public String extractLastName(String fullName) {
        // Declare this outside the try block so its available at the end
        String lastName = "Unknown";
        
        try {
            // There is no split method if fullName is null!
            String[] nameParts = fullName.split(" ");
            // We excpect length = 2, if not create our own exception
            int arrayLength =  nameParts.length;
            // here we need to validate stuff that won't cause an
            // exception, but are wrong nonetheless. The name shoudln't
            // be empty or have only one part, or have more than two parts.
            if(fullName.length() != 2) {
                // create our own exception
                throw new IllegalArgumentException();
            }
            // Invalid array index will cause an exception
            lastName = nameParts[LAST_NAME_IDX];
            
        // This only happens if the user preses CANCEL
        } catch(NullPointerException iae) {
            // Cancel means quit so lets do it..
            System.exit(0);
            
        // Polymorphic for all other exceptions here    
        } catch(RuntimeException iae) {
            JOptionPane.showMessageDialog(null, ERR_MSG, MSG_TITLE, 
                    JOptionPane.ERROR_MESSAGE);
        }
        
        return lastName;
    }

}
