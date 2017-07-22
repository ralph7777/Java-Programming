
package domain;

import java.util.ArrayList;
import java.util.Collections;
import utils.BadParameterException;
import utils.NullParameterException;

/**
 * This class implements a department for employees.
 * @author Kuangyi Zhang
 */
public class Department {

    /**
     * The name of this department.
     * @see #getDepartmentName() 
     * @see #setDepartmentName(java.lang.String) 
     */
    private String departmentName;
    
    /**
     * The maximum employee number in this department, set to {@value}.
     */
    public static final int MAX_EMP = 20;
    
    /**
     * The list of employees in this department.
     * @see #getEmployeeList() 
     */
    private final ArrayList<Employee> employeeList = new ArrayList<>(0);

    /**
     * This constructs a department with a specified department name.
     * @param dName string to be set as the name of this department
     * @throws NullParameterException If the passed-in string is null
     * @throws BadParameterException  If the passed-in string is empty
     * @see #setDepartmentName(java.lang.String) 
     */
    public Department(String dName) throws NullParameterException, BadParameterException {
        setDepartmentName(dName);
    }

    /**
     * This returns the name of this department.
     * @return the name of this department
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Set the name of this department.
     * @param dNameIn string to be set as the name of this department
     * @throws NullParameterException If the passed-in string is null
     * @throws BadParameterException  If the passed-in string is empty
     */
    private void setDepartmentName(String dNameIn) throws NullParameterException, BadParameterException {
        if (dNameIn == null) {
            throw new NullParameterException("Null value passed in for departmentName");
        }
        if (dNameIn.isEmpty()) {
            throw new BadParameterException("Invalid Department Name: " + dNameIn);
        }
        departmentName = dNameIn;
    }

    /**
     * This returns an array list of employees in this department.
     * @return an array list of employees in this department
     */
    private ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    /**
     * This adds a specified employee into this department, then sorts
     * employees in this department according to their employee id.
     * @param e employee to be added into this department
     * @throws NullParameterException If the passed-in employee is null
     * @throws BadParameterException If this department is already full, meaning 
     * the number of employees in this department is equal or greater than MAX_EMP
     * before adding.
     * @see #MAX_EMP
     */
    public void addEmployee(Employee e) throws NullParameterException, BadParameterException {
        if (e == null) {
            throw new NullParameterException("Null Employee sent to addEmployee!");
        }
        if (getEmployeeList().size() >= MAX_EMP) {
            throw new BadParameterException("This Department is already at the max. number of employees: " + MAX_EMP);
        }
        getEmployeeList().add(new Employee(e));
        Collections.sort(getEmployeeList());
    }

    /**
     * This adds a copy of specified sales employee into this department,
     * then sorts employees in this department according to their employee id.
     * @param e sales employee to be copied and added into this department
     * @throws NullParameterException If the passed-in sales employee is null
     * @throws BadParameterException If the number of employees in this department 
     * is already greater than MAX_EMP before adding.
     * @see #MAX_EMP
     */
    public void addEmployee(SalesEmployee e) throws NullParameterException, BadParameterException {
        if (e == null) {
            throw new NullParameterException("Null Employee sent to addEmployee!");
        }
        if (getEmployeeList().size() > MAX_EMP) {
            throw new BadParameterException("This Department is already at the max. number of employees: " + MAX_EMP);
        }

        SalesEmployee ee = new SalesEmployee(e); // Create a SalesEmployee copy
        getEmployeeList().add(ee);
        Collections.sort(getEmployeeList());

    }

    /**
     * Remove an employee with the specified id from this department.
     * @param id id of the employee to be removed
     * @return the employee with a specified id if he/she is in this department,
     * otherwise returns null
     */
    public Employee removeEmployee(int id) {
        for (Employee e : getEmployeeList()) {
            if (e.getEmployeeId() == id) {
                Employee emp = e;
                getEmployeeList().remove(e);
                return emp;
            }
        }
        return null;
    }

    /**
     * Returns true if the employee with a specified id is in this
     * department.
     * @param id id of an employee whose presence in this department is to be tested
     * @return true if this department contains the employee with a specified id,
     * otherwise returns false
     */
    public boolean isInDepartment(int id) {
        for (Employee e : getEmployeeList()) {
            if (e.getEmployeeId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * This returns the number of employee in this department.
     * @return number of employee in this department
     */
    public int getNumInDepartment() {
        return getEmployeeList().size();
    }

    /**
     * This returns a string representation of this department, in the order 
     * of a department name and a list of employee details in this department.
     * @return a string representation of this department
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Department: %s\n", getDepartmentName()));
        for (int i = 0; i < ("Department: " + getDepartmentName()).length(); i++) {
            sb.append("-");
        }
        sb.append("\nEmployees:\n");
        for (Employee e : getEmployeeList()) {
            sb.append(e + "\n");
        }

        return sb.toString();

    }
}
