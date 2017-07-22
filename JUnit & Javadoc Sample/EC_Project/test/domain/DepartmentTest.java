package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.BadParameterException;
import utils.NullParameterException;

/**
 * Tests for Department class.
 * @author Kuangyi Zhang
 */
public class DepartmentTest {
    
    public DepartmentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIllegalDepartment(){
        //test null
        try {
            Department department=new Department(null);
            fail("Null value passing in for departmentName does not throw an exception");
        } catch (BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (NullParameterException e){
            assertEquals("Null value passed in for departmentName",e.getMessage());
        }

        //test empty string
        try {
            Department department=new Department("");
            fail("Invalid Department Name: ");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("Invalid Department Name: ",e.getMessage());
        }
    }
    
    @Test
    public void testGetDepartmentName() {
        //positive test
        try {
            Department department=new Department("Rockets");
            assertEquals("Rockets",department.getDepartmentName());
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }

    @Test
    public void testAddEmployee_Employee() throws Exception {
        //test null
        try {
            Department department=new Department("Rockets");
            department.addEmployee((Employee) null);
            fail("Null Employee passing in addEmployee does not throw an exception");
        } catch (BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (NullParameterException e){
            assertEquals("Null Employee sent to addEmployee!",e.getMessage());
        }
        
        //test getEmployeeList().size()=20 and positive test
        try {
            Department department=new Department("Rockets");
            int[] daysIn={1,1,1,1,1};
            for (int i=0;i<21;i++) {
                String fn=((char) 65+i)+"";
                String ln=((char) 65+i)+"er";
                Employee employee=new Employee(fn, ln, 1000+i, 0.1,daysIn);   
                department.addEmployee(employee);
            }
            fail("Add employee to a full department does not throw an exception");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("This Department is already at the max. number of employees: 20",e.getMessage());
        }
    }

    @Test
    public void testAddEmployee_SalesEmployee() throws Exception {
        //test null
        try {
            Department department=new Department("Rockets");
            department.addEmployee((SalesEmployee) null);
            fail("Null Employee passing in addEmployee does not throw an exception");
        } catch (BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (NullParameterException e){
            assertEquals("Null Employee sent to addEmployee!",e.getMessage());
        }
        
        //test getEmployeeList().size()=20 and positive test
        try {
            Department department=new Department("Rockets");
            int[] daysIn={1,1,1,1,1};
            for (int i=0;i<22;i++) {
                String fn=((char) 65+i)+"";
                String ln=((char) 65+i)+"er";
                SalesEmployee employee=new SalesEmployee(fn, ln, 1000+i, 1,daysIn, 1, 1);
                department.addEmployee(employee);
            }
            fail("Add employee to a full department does not throw an exception");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("This Department is already at the max. number of employees: 20",e.getMessage());
        }
        
    }

    @Test
    public void testRemoveEmployee() {
        //positive test: try remove sb in
        try {
            Department department=new Department("Rockets");
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 0.1,daysIn);  
            department.addEmployee(employee);
            assertEquals(1000,department.removeEmployee(1000).getEmployeeId());
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
        
        //positive test: try remove sb not in
        try {
            Department department=new Department("Rockets");
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 0.1,daysIn);  
            department.addEmployee(employee);
            assertNull(department.removeEmployee(9999));
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }

    @Test
    public void testIsInDepartment() {
        //positive test: in
        try {
            Department department=new Department("Rockets");
            int[] daysIn={1,1,1,1,1};
            Employee employee1=new Employee("James", "Harden", 1000, 0.1,daysIn); 
            Employee employee2=new Employee("Patrick", "Beverley", 9999, 0.1,daysIn);  
            department.addEmployee(employee1);
            department.addEmployee(employee2);
            assertTrue(department.isInDepartment(9999));
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
        
        //positive test: not in
        try {
            Department department=new Department("Rockets");
            assertFalse(department.isInDepartment(1000));
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }
    

    @Test
    public void testGetNumInDepartment() {
        //positive test: not in
        try {
            Department department=new Department("Rockets");
            assertEquals(0,department.getNumInDepartment());
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
        
    }

    @Test
    public void testToString() {
        //positive test
        try {
            Department department=new Department("Rockets");
            int[] daysIn={1,1,1,1,1};
            Employee employee1=new Employee("James", "Harden", 1000, 0.1,daysIn); 
            Employee employee2=new Employee("Patrick", "Beverley", 9999, 0.1,daysIn);  
            department.addEmployee(employee1);
            department.addEmployee(employee2);
            
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Department: %s\n", department.getDepartmentName()));
            for (int i = 0; i < ("Department: " + department.getDepartmentName()).length(); i++) {
                sb.append("-");
            }
            sb.append("\nEmployees:\n");
            sb.append(employee1 + "\n");
            sb.append(employee2 + "\n");
            
            assertEquals(department.toString(),sb.toString());
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }
    
}
