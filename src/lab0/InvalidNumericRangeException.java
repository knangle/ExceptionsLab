/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab0;

/**
 *
 * @author knangle
 */
public class InvalidNumericRangeException extends IllegalArgumentException{
    
    private static int startRange, endRange;
    private static final String ERR_MSG = "Number input out of range.  Number "
            + "must be between " + startRange +" and " + endRange;
    
    public InvalidNumericRangeException(int StartRange, int endRange, Throwable cause) {
        super(ERR_MSG,cause);
    }

    public InvalidNumericRangeException(int StartRange, int endRange,String message, Throwable cause) {
        super(ERR_MSG, cause);
    }

    public InvalidNumericRangeException(int StartRange, int endRange,String s) {
        super(ERR_MSG);
    }

    public InvalidNumericRangeException(int StartRange, int endRange) {
        super(ERR_MSG);
    }
    
    
    
}
