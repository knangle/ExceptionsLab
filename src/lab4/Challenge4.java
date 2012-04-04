package lab4;

/**
 * This challenge is similar to the third one, except that in this program 
 * you must use add a finally block to your method handler that logs output 
 * to the console explaining the method that was run,
 * whether or not there was an exception.
 * <p>
 * No input or output should be performed here.
 * 
 * @author  Kevin Nangle, knangle@my.wctc.edu
 * @version 1.00
 */
public class Challenge4 {

    public static void main(String[] args) throws InvalidNameException {
        
        new InputOutputGui().startConversation();
    }
    
}
