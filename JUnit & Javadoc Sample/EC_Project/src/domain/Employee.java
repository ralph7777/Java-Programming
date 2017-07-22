package domain;

import utils.BadParameterException;
import utils.NullParameterException;

/** 
 * This class implements an employee in a department.
 * @author Kuangyi Zhang
 */
public class Employee implements Comparable<Employee> {
    
    /**
     * The first name of the employee.
     * @see #getFirstName() 
     * @see #setFirstName(java.lang.String) 
     */
    private String firstName;
    
    /**
     * The last name of the employee.
     * @see #getLastName() 
     * @see #setLastName(java.lang.String) 
     */
    private String lastName;
    
    /**
     * The employee ID.
     * @see #getEmployeeId() 
     * @see #setEmployeeId(int) 
     */
    private int employeeId;
    
    /**
     * The hourly rate of the employee.
     * @see #getHourlyRate() 
     * @see #setHourlyRate(double) 
     */
    private double hourlyRate;
    
    /**
     * The time card of the employee.
     * @see Timecard
     * @see #getTimecard() 
     * @see #setTimecard(domain.Timecard) 
     */
    private Timecard timecard;

    /**
     * This constructs an employee with the specified first name, last name,
     * employee id, hourly rate, and weekly time table.
     * @param fName first name of the employee
     * @param lName last name of the employee
     * @param eId employee id
     * @param hRate hourly rate of the employee
     * @param daysIn working hours in days of the employee stored in an integer
     * array
     * @throws NullParameterException If the first name, last name or daysIn array
     * is null
     * @throws BadParameterException If the first name or last name is empty or
     * longer than 20 characters, id number is less than 1000 or greater than 
     * 9999, the hourly rate is non-positive, or the size of daysIn array is
     * not equal to NUM_DAYS
     * @see #setFirstName(java.lang.String) 
     * @see #setLastName(java.lang.String) 
     * @see #setEmployeeId(int) 
     * @see #setHourlyRate(double) 
     * @see #setTimecard(domain.Timecard) 
     * @see Timecard#NUM_DAYS
     */
    public Employee(String fName, String lName, int eId, double hRate, int[] daysIn) throws NullParameterException, BadParameterException {
        setFirstName(fName);
        setLastName(lName);
        setEmployeeId(eId);
        setHourlyRate(hRate);
        setTimecard(new Timecard(daysIn));
    }

    /**
     * This constructs a copy of the specified employee.
     * @param e the specified employee to be copied
     * @throws NullParameterException If the specified employee's first name, 
     * last name or time card is null.
     * @throws BadParameterException If the specified employee's first name or 
     * last name is empty or longer than 20 characters, id number is less than 
     * 1000 or greater than 9999, or the hourly rate is non-positive
     * @see #getFirstName() 
     * @see #setFirstName(java.lang.String) 
     * @see #getLastName() 
     * @see #setLastName(java.lang.String) 
     * @see #getEmployeeId() 
     * @see #setEmployeeId(int) 
     * @see #getHourlyRate() 
     * @see #setHourlyRate(double) 
     * @see #getTimecard() 
     * @see #setTimecard(domain.Timecard) 
     */
    public Employee(Employee e) throws NullParameterException, BadParameterException {
        setFirstName(e.getFirstName());
        setLastName(e.getLastName());
        setEmployeeId(e.getEmployeeId());
        setHourlyRate(e.getHourlyRate());
        setTimecard(new Timecard(e.getTimecard()));
    }

    /**
     * Compares this employee with a specified employee for order.
     * @param eIn the employee to be compared
     * @return -1, 0, or 1 as this employee's id is less than, equal to, or 
     * greater than the specified employee's id
     */
    @Override
    public int compareTo(Employee eIn) {
        if (getEmployeeId() < eIn.getEmployeeId()) {
            return -1;
        } else if (getEmployeeId() == eIn.getEmployeeId()) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * This returns a weekly pay of this employee, as a product of weekly
     * working hours and hourly rate.
     * @return this employee's weekly pay 
     * @see #getTimecard() 
     * @see Timecard#getWeeklyHours() 
     * @see #getHourlyRate() 
     */
    public double getWeeklyPay() {
        return getTimecard().getWeeklyHours() * getHourlyRate();
    }

    /**
     * This returns the first name of this employee.
     * @return this employee's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of this employee.
     * @param fName string to be set as the first name of this employee
     * @throws NullParameterException If the passed-in string is null
     * @throws BadParameterException If the passed-in string is empty or longer
     * than 20 characters
     */
    public final void setFirstName(String fName) throws NullParameterException, BadParameterException {
        if (fName == null) {
            throw new NullParameterException("Null value passed in for firstName");
        }

        if (fName.length() <= 0 || fName.length() > 20) {
            throw new BadParameterException("Bad value passed in for firstName: " + fName);
        }
        firstName = fName;
    }

    /**
     * This returns the last name of this employee.
     * @return this employee's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of this employee
     * @param lName string to be set as the last name of this employee
     * @throws NullParameterException If the passed-in string is null
     * @throws BadParameterException If the passed-in string is empty or longer
     * than 20 characters
     */
    public final void setLastName(String lName) throws NullParameterException, BadParameterException {
        if (lName == null) {
            throw new NullParameterException("Null value passed in for lastName");
        }
        if (lName.length() <= 0 || lName.length() > 20) {
            throw new BadParameterException("Bad value passed in for lastName: " + lName);
        }
        lastName = lName;
    }

    /**
     * This returns the employee's id.
     * @return the employee's id
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Set the employee id.
     * @param eId integer to be set as the id of this employee
     * @throws BadParameterException If the passed-in integer is less than 1000
     * or greater than 9999
     */
    public final void setEmployeeId(int eId) throws BadParameterException {
        if (eId < 1000 || eId > 9999) {
            throw new BadParameterException("Bad value passed in for employeeId: " + eId);
        }
        employeeId = eId;
    }

    /**
     * This returns the hourly rate of this employee.
     * @return this employee's hourly rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Set the hourly rate of this employee.
     * @param hRate double to be set as the hourly rate of this employee 
     * @throws BadParameterException If the passed-in double is non-positive
     */
    public final void setHourlyRate(double hRate) throws BadParameterException {
        if (hRate <= 0.0) {
            throw new BadParameterException("Bad value passed in for hourlyRate: " + hRate);
        }
        hourlyRate = hRate;
    }

    /**
     * This return the time card of this employee.
     * @return this employee's time card
     */
    private Timecard getTimecard() {
        return timecard;
    }

    /**
     * Set the time card of this employee.
     * @param tCard time card to be set as this employee's time card
     * @throws NullParameterException If the passed-in time card is null
     */
    private void setTimecard(Timecard tCard) throws NullParameterException {
        if (tCard == null) {
            throw new NullParameterException("Null Timecard passed to setTimecard");
        }
        timecard = tCard;
    }

    /**
     * This returns a string representation of this employee, in the order
     * of employee's first name, last name, employee id, hourly rate, time card
     * and weekly pay.
     * @return a string representation of this employee
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-20s %s %s%n", "Name:", getFirstName(), getLastName()));
        sb.append(String.format("%-20s %d%n", "Id:", getEmployeeId()));
        sb.append(String.format("%-20s $%.2f%n", "Hourly Rate:", getHourlyRate()));
        sb.append(String.format("%s", getTimecard()));
        sb.append(String.format("%-20s $%.2f%n", "Weekly Pay:", getWeeklyPay()));

        return sb.toString();
    }
}
