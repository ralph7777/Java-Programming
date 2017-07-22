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
 * Tests for SalesEmployee class.
 * @author Kuangyi Zhang
 */
public class SalesEmployeeTest {
    
    public SalesEmployeeTest() {
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
            SalesEmployee employee1=new SalesEmployee("Daryl", "Morey", 1000, 1,daysIn, 1, 1);
            SalesEmployee employee2=new SalesEmployee(employee1);
            assertEquals(employee1.getSalesAmountNeeded(),employee2.getSalesAmountNeeded(),0.001);
            assertEquals(employee1.getWeeklySalesTotal(),employee2.getWeeklySalesTotal(),0.001);
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }
    
    @Test
    public void testIllegalSalesAmountNeeded(){
        try {
            int[] daysIn={1,1,1,1,1};
            SalesEmployee employee=new SalesEmployee("Daryl", "Morey", 1000, 1,daysIn, 0.0, 1);
            fail("Invalid sales amount passing in does not throw an exception ");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("Invalid sales amount needed: 0.0",e.getMessage());
        }
    }
    
    @Test
    public void testIllegalWeeklySalesTotal(){
        try {
            int[] daysIn={1,1,1,1,1};
            SalesEmployee employee=new SalesEmployee("Daryl", "Morey", 1000, 1,daysIn, 1, 0.0);
            fail("Invalid weekly sales passing in does not throw an exception ");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("Invalid weekly sales total: 0.0",e.getMessage());
        }
    }
    
    @Test
    public void testGetSalesAmountNeeded() {
        //positive test
        try {
            int[] daysIn={1,1,1,1,1};
            SalesEmployee employee=new SalesEmployee("Daryl", "Morey", 1000, 1,daysIn, 1, 1);
            assertEquals(1,employee.getSalesAmountNeeded(),0.001);
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }

    @Test
    public void testGetWeeklySalesTotal() {
        //positive test
        try {
            int[] daysIn={1,1,1,1,1};
            SalesEmployee employee=new SalesEmployee("Daryl", "Morey", 1000, 1,daysIn, 1, 1);
            assertEquals(1,employee.getWeeklySalesTotal(),0.001);
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }

    @Test
    public void testGetWeeklyPay() {
        //test getWeeklySalesTotal() = getSalesAmountNeeded()
        try {
            int[] daysIn={1,1,1,1,1};
            SalesEmployee employee=new SalesEmployee("Daryl", "Morey", 1000, 1,daysIn, 1, 1);
            assertEquals(0.25,employee.getWeeklyPay(),0.001);
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
        
        //test getWeeklySalesTotal() = getSalesAmountNeeded()+1
        try {
            int[] daysIn={1,1,1,1,1};
            SalesEmployee employee=new SalesEmployee("Daryl", "Morey", 1000, 1,daysIn, 1, 2);
            assertEquals(0.5,employee.getWeeklyPay(),0.001);
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
        
        //test getWeeklySalesTotal() = getSalesAmountNeeded()-0.01
        try {
            int[] daysIn={1,1,1,1,1};
            SalesEmployee employee=new SalesEmployee("Daryl", "Morey", 1000, 1,daysIn, 1.01, 1);
            assertEquals(5,employee.getWeeklyPay(),0.001);
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
        
    }

    @Test
    public void testToString() {
        //positive test
        try {
            int[] daysIn={1,1,1,1,1};
            SalesEmployee employee=new SalesEmployee("Daryl", "Morey", 1000, 1,daysIn, 1, 1);
            
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-20s %s %s%n", "Name:", employee.getFirstName(), employee.getLastName()));
            sb.append(String.format("%-20s %d%n", "Id:", employee.getEmployeeId()));
            sb.append(String.format("%-20s $%.2f%n", "Hourly Rate:", employee.getHourlyRate()));
            Timecard timecard=new Timecard(daysIn);
            sb.append(String.format("%s", timecard.toString()));
            sb.append(String.format("%-20s $%.2f%n", "Weekly Pay:", employee.getWeeklyPay()));
            sb.append(String.format("%-20s $%.2f%n", "Sales Amount Needed:", employee.getSalesAmountNeeded()));
            sb.append(String.format("%-20s $%.2f%n", "Weekly Sales Total:", employee.getWeeklySalesTotal()));

            assertEquals(employee.toString(),sb.toString());
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }
    
}
