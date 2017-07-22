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
 * Tests for Employee class.
 * @author Kuangyi Zhang
 */
public class EmployeeTest {
    
    public EmployeeTest() {
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
    public void testCopyConstructor(){
        //positive test
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee1=new Employee("James", "Harden", 1000, 1,daysIn);
            Employee employee2=new Employee(employee1);
            assertEquals(employee1.getEmployeeId(),employee2.getEmployeeId());
            assertEquals(employee1.getFirstName(),employee2.getFirstName());
            assertEquals(employee1.getLastName(),employee2.getLastName());
            assertEquals(employee1.getHourlyRate(),employee2.getHourlyRate(),0.001);
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }
    
    @Test
    public void testIllegalTimecard(){
        //test null, but the exception will be thrown from Timetable c'tor...
//        try {
//            Employee employee=new Employee("James", "Harden", 1000, 1, null);
//            fail("Null Timecard passing to setTimecard does not throw an exception ");
//        } catch (BadParameterException e){
//            fail("Throw a wrong exception: "+e.getMessage());
//        } catch (NullParameterException e){
//            assertEquals("Null Timecard passed to setTimecard",e.getMessage());
//        }
    }
    
    @Test
    public void testCompareTo() {
        //test -1 and 1
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee1=new Employee("James", "Harden", 1000, 0.1,daysIn);
            Employee employee2=new Employee("Patrick", "Beverley", 9999, 0.1,daysIn);
            assertEquals(-1,employee1.compareTo(employee2));            
            assertEquals(1,employee2.compareTo(employee1));
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
        
        //test 0
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee1=new Employee("James", "Harden", 1000, 0.1,daysIn);
            Employee employee2=new Employee("Jeremy", "Lin", 1000, 0.1,daysIn);
            assertEquals(0,employee1.compareTo(employee2));
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }

    @Test
    public void testGetWeeklyPay() {
        //positive test
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 1,daysIn);
            assertEquals(5,employee.getWeeklyPay(),0.1);
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }

    @Test
    public void testGetFirstName() {
        //positive test
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 1,daysIn);
            assertEquals("James",employee.getFirstName());
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }

    @Test
    public void testSetFirstName() {
        //test null
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 1,daysIn);
            employee.setFirstName(null);
            fail("Null value passing to setFirstName does not throw an exception");
        } catch (BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (NullParameterException e){
            assertEquals("Null value passed in for firstName",e.getMessage());
        }
        
        //test empty string
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 1,daysIn);
            employee.setFirstName("");
            fail("Bad value passing in for firstName does not throw an exception");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("Bad value passed in for firstName: ",e.getMessage());
        }
        
        //test string.length()=21
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 1,daysIn);
            employee.setFirstName("Abcdefghijklmnopqrstu");
            fail("Bad value passing in for firstName does not throw an exception");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("Bad value passed in for firstName: Abcdefghijklmnopqrstu",e.getMessage());
        }
    }

    @Test
    public void testGetLastName() {
        //positive test
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 1,daysIn);
            assertEquals("Harden",employee.getLastName());
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }

    @Test
    public void testSetLastName(){
        //test null
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 1,daysIn);
            employee.setLastName(null);
            fail("Null value passing to setLastName does not throw an exception");
        } catch (BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (NullParameterException e){
            assertEquals("Null value passed in for lastName",e.getMessage());
        }
        
        //test empty string
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 1,daysIn);
            employee.setLastName("");
            fail("Bad value passing in for lastName does not throw an exception");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("Bad value passed in for lastName: ",e.getMessage());
        }
        
        //test string.length()=21
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 1,daysIn);
            employee.setLastName("Abcdefghijklmnopqrstu");
            fail("Bad value passing in for lastName does not throw an exception");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("Bad value passed in for lastName: Abcdefghijklmnopqrstu",e.getMessage());
        }
    }

    @Test
    public void testGetEmployeeId() {
        //positive test
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 1,daysIn);
            assertEquals(1000,employee.getEmployeeId());
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }

    @Test
    public void testSetEmployeeId() {
        //test id=999
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 999, 1,daysIn);
            fail("Bad value passing in for employeeId does not throw an exception");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("Bad value passed in for employeeId: 999",e.getMessage());
        }
        
        //test id=10000
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 10000, 1,daysIn);
            fail("Bad value passing in for employeeId does not throw an exception");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("Bad value passed in for employeeId: 10000",e.getMessage());
        }
    }

    @Test
    public void testGetHourlyRate() {
        //positive test
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 1,daysIn);
            assertEquals(1,employee.getHourlyRate(),0.01);
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }

    @Test
    public void testSetHourlyRate() {
        //test rate=0.0
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 0.0, daysIn);
            fail("Bad value passing in for hourlyRate does not throw an exception");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("Bad value passed in for hourlyRate: 0.0",e.getMessage());
        }
        
        //test rate=-0.1
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, -0.1, daysIn);
            fail("Bad value passing in for hourlyRate does not throw an exception");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("Bad value passed in for hourlyRate: -0.1",e.getMessage());
        }        
    }

    @Test
    public void testToString() {
        //positive test
        try {
            int[] daysIn={1,1,1,1,1};
            Employee employee=new Employee("James", "Harden", 1000, 1, daysIn);
            
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-20s %s %s%n", "Name:", employee.getFirstName(), employee.getLastName()));
            sb.append(String.format("%-20s %d%n", "Id:", employee.getEmployeeId()));
            sb.append(String.format("%-20s $%.2f%n", "Hourly Rate:", employee.getHourlyRate()));
            Timecard timecard=new Timecard(daysIn);
            sb.append(String.format("%s", timecard.toString()));
            sb.append(String.format("%-20s $%.2f%n", "Weekly Pay:", employee.getWeeklyPay()));

            assertEquals(employee.toString(),sb.toString());
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }
    
}
