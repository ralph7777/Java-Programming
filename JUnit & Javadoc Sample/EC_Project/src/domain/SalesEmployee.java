
package domain;

import utils.BadParameterException;
import utils.NullParameterException;

/** 
 * This class implements a sales employee in a department. It inherits from
 * class Employee.
 * @author Kuangyi Zhang
 * @see Employee
 */
public class SalesEmployee extends Employee {

    /**
     * The required sales amount for this sales employee.
     * @see #getSalesAmountNeeded() 
     * @see #setSalesAmountNeeded(double) 
     */
    private double salesAmountNeeded;
    
    /**
     * The total weekly sales amount of this sales employee.
     * @see #getWeeklySalesTotal() 
     * @see #setWeeklySalesTotal(double) 
     */
    private double weeklySalesTotal;
    
    /**
     * The bonus multiplier for this sales employee, set to {@value}.
     */
    public static final double BONUS_MULTIPLIER = 0.25;

    /**
     * This constructs a sales employee with the specified first name, last
     * name, employee id, hourly rate, weekly time table, sales amount
     * needed and total weekly sales.
     * @param fName first name of the sales employee
     * @param lName last name of the sales employee
     * @param eId sales employee id
     * @param hRate hourly rate of the sales employee
     * @param daysIn working hours in days of the sales employee stored in
     * an integer array
     * @param salesNeeded sales amount needed of the sales employee
     * @param weeklyTotal total weekly sales of the sales employee 
     * @throws NullParameterException If the first name, last name or daysIn array
     * is null
     * @throws BadParameterException If the first name or last name is empty or
     * longer than 20 characters, id number is less than 1000 or greater than 
     * 9999, the hourly rate is non-positive, the size of daysIn array is
     * not equal to NUM_DAYS, the sales needed is non-positive, or the weekly 
     * sales is non-positive
     * @see Employee#Employee(java.lang.String, java.lang.String, int, double, int[]) 
     * @see Timecard#NUM_DAYS
     * @see #setSalesAmountNeeded(double) 
     * @see #setWeeklySalesTotal(double) 
     */
    public SalesEmployee(String fName, String lName, int eId, double hRate, int[] daysIn, 
            double salesNeeded, double weeklyTotal) throws NullParameterException, BadParameterException {
        super(fName, lName, eId, hRate, daysIn);
        setSalesAmountNeeded(salesNeeded);
        setWeeklySalesTotal(weeklyTotal);
    }

    /**
     * This constructs a copy of the specified sales employee.
     * @param se the specified sales employee to be copied
     * @throws NullParameterException If the specified sales employee's first name, 
     * last name or time card is null
     * @throws BadParameterException If the specified sales employee's first name
     * or last name is empty or longer than 20 characters, id number is less than 
     * 1000 or greater than 9999, the hourly rate is non-positive, the sales needed
     * is non-positive, or the weekly sales is non-positive
     * @see Employee#Employee(domain.Employee) 
     * @see #setSalesAmountNeeded(double) 
     * @see #setWeeklySalesTotal(double) 
     */
    public SalesEmployee(SalesEmployee se) throws NullParameterException, BadParameterException {
        super(se);
        setSalesAmountNeeded(se.getSalesAmountNeeded());
        setWeeklySalesTotal(se.getWeeklySalesTotal());
    }

    /**
     * This returns the sales amount needed of this sales employee.
     * @return the sales employee's sales amount needed
     */
    public double getSalesAmountNeeded() {
        return salesAmountNeeded;
    }

    /**
     * This returns the total weekly sales of this sales employee.
     * @return the sales employee's total weekly sales
     */
    public double getWeeklySalesTotal() {
        return weeklySalesTotal;
    }

    /**
     * Set the sales amount needed of this sales employee
     * @param d double to be set as the sales amount needed of this sales employee
     * @throws BadParameterException If the passed-in double is non-positive
     */
    private void setSalesAmountNeeded(double d) throws BadParameterException {
        if (d <= 0.0) {
            throw new BadParameterException("Invalid sales amount needed: " + d);
        }
        salesAmountNeeded = d;
    }

    /**
     * Set the total weekly sales of this sales employee 
     * @param totalIn double to be set as the total weekly sales of this sales
     * employee
     * @throws BadParameterException If the passed-in double is non-positive
     */
    private void setWeeklySalesTotal(double totalIn) throws BadParameterException {
        if (totalIn <= 0.0) {
            throw new BadParameterException("Invalid weekly sales total: " + totalIn);
        }
        weeklySalesTotal = totalIn;
    }

    /**
     * This returns the weekly pay of this sales employee. If the employee's 
     * total weekly sales is more than the sales amount needed, the weekly pay 
     * would be the sales amount times the bonus multiplier. Otherwise, the weekly
     * pay would be the working hours times the hourly rate, as done in the Employee
     * Class.
     * @return the weekly pay of this sales employee
     * @see Employee#getWeeklyPay() 
     */
    @Override
    public double getWeeklyPay() {
        if (getWeeklySalesTotal() >= getSalesAmountNeeded()) {
            return getWeeklySalesTotal() * BONUS_MULTIPLIER;
        }
        return super.getWeeklyPay();
    }

    /**
     * This returns a string representation of this sales employee, in
     * the order of employee's first name, last name, employee id, hourly
     * rate, time card, weekly pay, sales amount needed and weekly sales
     * total. Generally, it constructs a string as done in toString method in
     * Employee Class plus a sales amount needed and a weekly sales total.
     * @return a string representation of this sales employee
     * @see Employee#toString() 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("%-20s $%.2f%n", "Sales Amount Needed:", getSalesAmountNeeded()));
        sb.append(String.format("%-20s $%.2f%n", "Weekly Sales Total:", getWeeklySalesTotal()));
        return sb.toString();
    }
}
