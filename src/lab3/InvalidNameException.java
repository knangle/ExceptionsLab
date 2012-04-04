package lab3;

/**
 *
 * @author  Kevin Nangle, knangle@my.wctc.edu
 */
public class InvalidNameException extends Exception {
    private static final String ERROR_MESSAGE = "Please enter both your first "
            + "and last name, in that order.  Do not enter middle name or "
            + "initial.";
    

    public InvalidNameException(String message, Throwable cause) {
        super(ERROR_MESSAGE, cause);
    }

    public InvalidNameException(String message) {
        super(ERROR_MESSAGE);
    }

    public InvalidNameException() {
        super(ERROR_MESSAGE);
    }


    
}
