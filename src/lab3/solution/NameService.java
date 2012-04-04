package lab3.solution;

/**
 * This solution is similar to challenge #2 except that it uses a custom
 * exception class (InvalidNameException) which controls
 * the message in a consistent way (see line #33 below.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class NameService {
    private static final int FIRST_NAME_IDX = 0;
    private static final int LAST_NAME_IDX = 1;
    
    /**
     * Finds and returns the last name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     */
    public String extractLastName(String fullName) 
            throws InvalidNameException {
        
        // No chance that this will cause a NullPointerException because
        // that was tested in the Gui.
        String[] nameParts = fullName.split(" ");

        // The fullName should have two parts -- firstName and lastName.
        // Anything else is illegal so catch that!        
        if(nameParts.length != 2) {
            // create our own exception
            throw new InvalidNameException();
        }
            
        // By the time we get to here, there cannot be a problem because
        // everything else has already been tested
        return nameParts[LAST_NAME_IDX];
    }
    
    /**
     * Finds and returns the first name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the first name
     */
    public String extractFirstName(String fullName) {
        String[] nameParts = fullName.split(" ");
        return nameParts[FIRST_NAME_IDX];
    }

    /**
     * Gets the length of a name.
     * 
     * @param name - any full name or part of a name.
     * @return the length of the name or part.
     */
    public int getNameLength(String name) {
        return name.length();
    }
    
}
