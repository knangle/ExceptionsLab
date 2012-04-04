package lab0.solution;

import java.util.Date;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, 
            Date hireDate, int daysVacation) {
        
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        setHireDate(hireDate);
        setDaysVacation(daysVacation);
    }

    
    public final int getDaysVacation() {
        return daysVacation;
    }

    public final void setDaysVacation(int daysVacation) {
        if(daysVacation < 0 || daysVacation > MAX_VACATION_DAYS ) {
            throw new IllegalArgumentException("vaction days out of range.");
        }
        this.daysVacation = daysVacation;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        if(firstName == null || firstName.length() < 2) {
            throw new IllegalArgumentException("first name must be at least 2 characters");
        }
        this.firstName = firstName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public final void setHireDate(Date hireDate) {
        Date today = new Date();
        if(hireDate == null || hireDate.after(today)) {
            throw new IllegalArgumentException("hire date is out of range");
        }
        this.hireDate = hireDate;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        if(lastName == null || lastName.length() < 2) {
            throw new IllegalArgumentException("last name must be at least 2 characters");
        }
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    public final void setSsn(String ssn) {
        if(ssn == null || ssn.length() < 11 ) {
            throw new IllegalArgumentException("ssn must be in format xxx-xx-xxxx");
        }
        this.ssn = ssn;
    }
    
    
}
