package lab3;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 * 
 * @author  Kevin Nangle, knangle@my.wctc.edu
 * @version 1.00
 */
public class InputOutputGui {
    private NameService nameService;
    private String fullName = "Unknown";
    private String lastName = "Unknown";
    private String msg = "Your last name is: ";
    private boolean validName = false;

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
        catch(InvalidNameException nameError){
            JOptionPane.showMessageDialog(null, nameError.getMessage(), 
                    "Input Error", 
            JOptionPane.ERROR_MESSAGE);
            validName = false;
            lastName = askForName();
        }
        
        validName = true;
        return lastName;
    }
     
}
