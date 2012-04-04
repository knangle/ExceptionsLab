package lab2;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 * 
 * @author  Kevin Nangle, knangle@my.wctc.edu
 * @version 1.00
 */
public class InputOutputGui {
    private NameService nameService;
    private String fullName = "Unkown";
    private String lastName = "Unkown";
    private String msg = "Your last name is: ";
    private boolean validName = false;
    private static final String ERROR_MESSAGE = "Please enter both your first "
            + "and last name, in that order.  Do not enter middle name or "
            + "initial.";

    public InputOutputGui() {
        nameService = new NameService();
    }

    public void startConversation() {
        
        while (!validName){
        lastName = askForName();
        }
        JOptionPane.showMessageDialog(null, msg + lastName);
        
    }
    public String askForName() {
        
        try{
        fullName = JOptionPane.showInputDialog("Enter full name:");
        lastName = nameService.extractLastName(fullName);
        }
        
        catch(NullPointerException cancel){
            System.exit(0);
        }
        
        catch(RuntimeException nameError){
            JOptionPane.showMessageDialog(null, ERROR_MESSAGE);  
            validName = false;
            lastName = askForName();
        }
        
        validName = true;
        return lastName;
    }
     
}
