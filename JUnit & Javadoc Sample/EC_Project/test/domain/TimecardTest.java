package domain;

import static domain.Timecard.NUM_DAYS;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.BadParameterException;
import utils.NullParameterException;

/**
 * Tests for Timecard class.
 * @author Kuangyi Zhang
 */
public class TimecardTest {
    
    public TimecardTest() {
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
    public void testParaConstructor(){
        //test null
        try {
            int[] daysIn=null;
            Timecard timecard1=new Timecard(daysIn);
            fail("Null int array passing to Timecard c'tor does not throw an exception");
        } catch (BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (NullParameterException e){
            assertEquals("Null int array passed to Timecard c'tor",e.getMessage());
        }
        
        //test unmatch array length
        try {
            int[] daysIn={1,2,3,4};
            Timecard timecard2=new Timecard(daysIn);
            fail("Invalid int array passing to Timecard c'tor does not throw an exception");
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e){
            assertEquals("Invalid int array passed to Timecard c'tor, length: 4",e.getMessage());
        }
        
        //test hours out of bond: -1
        try {
            int[] daysIn={1,2,3,4,-1};
            Timecard timecard=new Timecard(daysIn);
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e) {
            assertEquals("Bad hours value passed to setHoursByDay: -1",e.getMessage());
        }
        
        //test hours out of bond: 25
        try {
            int[] daysIn={1,2,3,4,25};
            Timecard timecard=new Timecard(daysIn);
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e) {
            assertEquals("Bad hours value passed to setHoursByDay: 25",e.getMessage());
        }
    }
    
    @Test
    public void testCopyConstructor(){
        try {
            int[] daysIn={1,2,3,4,5};
            Timecard timecard1=new Timecard(daysIn);
            Timecard timecard2=new Timecard(timecard1);
            assertEquals(timecard1.getHoursByDay(4),timecard1.getHoursByDay(4));
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }    
    
    @Test
    public void testGetWeeklyHours() {
        
        //Don't know how to access the BadParameterException branch
        
        //positive test 
        try {
            int[] daysIn={1,1,1,1,1};
            Timecard timecard=new Timecard(daysIn);
            assertEquals(5,timecard.getWeeklyHours());
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
        
    }

    @Test
    public void testGetHoursByDay() throws Exception {
        //day index out of bond: -1
        try {
            int[] daysIn={1,2,3,4,5};
            Timecard timecard=new Timecard(daysIn);
            timecard.getHoursByDay(-1);
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e) {
            assertEquals("Bad day value passed to getHoursByDay: -1",e.getMessage());
        }
        
        //day index out of bond: 5
        try {
            int[] daysIn={1,2,3,4,5};
            Timecard timecard=new Timecard(daysIn);
            timecard.getHoursByDay(5);
        } catch (NullParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        } catch (BadParameterException e) {
            assertEquals("Bad day value passed to getHoursByDay: 5",e.getMessage());
        }
        
        //positive test
        try {
            int[] daysIn={1,2,3,4,5};
            Timecard timecard=new Timecard(daysIn);
            assertEquals(timecard.getHoursByDay(NUM_DAYS-1),5);
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
    }
    
    
    @Test
    public void testToString() {
        //Don't know how to access the BadParameterException branch
        
        //positive test
        try {
            int[] daysIn={1,2,3,4,5};
            Timecard timecard=new Timecard(daysIn);
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-20s %d%n", "Weekly Hours:", timecard.getWeeklyHours()));
            for (int i = 0; i < 5; i++) {
                sb.append(String.format("%7s %d: %11d%n", "Day", (i + 1), timecard.getHoursByDay(i)));
            }
            assertEquals(timecard.toString(),sb.toString());
        } catch (NullParameterException | BadParameterException e){
            fail("Throw a wrong exception: "+e.getMessage());
        }
        
    }
    
}
