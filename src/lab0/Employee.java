package lab0;

import java.util.Date;

/**
 *
 * This class is a simulation of a real world Employee.  
 * 
 * @author  Kevin Nangle, knangle@my.wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

/**
 * Constructs an Employee with defaults, with "Unknown" for Strings, today's 
 * date for Dates, and 0 for integers
 */
    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

/**
 * Constructs an Employee with user supplied parameters
 */
    public Employee(String firstName, String lastName, String ssn, Date 
            hireDate, int daysVacation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.hireDate = hireDate;
        this.daysVacation = daysVacation;
    }
    
    public int getDaysVacation() {
        return daysVacation;
    }
/**
 * 
 * Sets vacation days available to Employee
 * @param daysVacation 
 * @throws IllegalArgumentException if days entered are not between 0 and 
 * MAX_VACATION_DAYS
 */
    public void setDaysVacation(int daysVacation) {
        if (daysVacation < 0 || daysVacation > MAX_VACATION_DAYS)
            throw new InvalidNumericRangeException(0,MAX_VACATION_DAYS);
        this.daysVacation = daysVacation;
    }

    public String getFirstName() {
        return firstName;
    }

/**
 * 
 * Sets Employee's first name
 * @param firstName 
 * @throws IllegalArgumentException if String is null or zero length
 */    
    public void setFirstName(String firstName) {
        if(firstName == null || firstName.length() == 0){
            throw new IllegalArgumentException("first name is a required "
                    + "field");
        }
        this.firstName = firstName;
    }

    public Date getHireDate() {
        return hireDate;
    }

/**
 * 
 * Sets Employee's date-of-hire
 * @param hireDate
 * @throws IllegalArgumentException if String is null or zero length
 */ 
    public void setHireDate(Date hireDate) {
        Date now = new Date();
        if(hireDate == null || hireDate.after(now)){
            throw new IllegalArgumentException("date entered is not valid");
        }
        this.hireDate = hireDate;
    }

    public String getLastName() {
        return lastName;
    }
    
/**
 * 
 * Sets Employee's last name
 * @param lastName 
 * @throws IllegalArgumentException if String is null or zero length
 */   
    public void setLastName(String lastName) {
        if(lastName == null || lastName.length() == 0){
            throw new IllegalArgumentException("last name is a required "
                    + "field");
        }
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

/**
 * 
 * Sets Employee's Social Security Number
 * @param ssn
 * @throws IllegalArgumentException if String is null or more than 11 characters
 */ 
    public void setSsn(String ssn) {
        if(ssn == null || ssn.length() > 11){
            throw new IllegalArgumentException("SSN is a required "
                    + "field.  Format is xxx-xx-xxxx or xxx xx xxxx");
        }
        this.ssn = ssn;
    }
    
    
}
