package lab4.solution;

/**
 * This custom exception is used to control the message returned in a
 * consistent way.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InvalidNameException extends Exception {
    private static final String ERR_MSG =
            "Sorry, a first name and a last name are required, nothing more. "
            + "Please try again.";
    

    public InvalidNameException(String message, Throwable cause) {
        super(ERR_MSG, cause);
    }

    public InvalidNameException(String message) {
        super(ERR_MSG);
    }

    public InvalidNameException() {
        super(ERR_MSG);
    }


    
}
