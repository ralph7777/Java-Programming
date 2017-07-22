package domain;

import utils.BadParameterException;
import utils.NullParameterException;

/**
 * This class implements a time card of an employee.
 * @author Kuangyi Zhang
 */
public class Timecard {

    /**
     * The number of days in time card, set to {@value}.
     */
    public static final int NUM_DAYS = 5;
    
    /**
     * The integer array storing the working hours in days of the week,
     * with a specified size of NUM_DAYS.
     * @see #NUM_DAYS
     */
    private final int[] daysOfTheWeek = new int[NUM_DAYS];

    /**
     * This constructs a time card with a specified integer array.
     * @param daysIn integer array storing the working hours in days
     * @throws NullParameterException If the passed-in integer array is null
     * @throws BadParameterException If the size of passed-in integer array is
     * not equal to NUM_DAYS
     * @see #setHoursByDay(int, int) 
     */
    public Timecard(int[] daysIn) throws NullParameterException, BadParameterException {
        if (daysIn == null) {
            throw new NullParameterException("Null int array passed to Timecard c'tor");
        }
        if (daysIn.length != NUM_DAYS) {
            throw new BadParameterException("Invalid int array passed to Timecard c'tor, length: " + daysIn.length);
        }
        for (int i = 0; i < NUM_DAYS; i++) {
            setHoursByDay(i, daysIn[i]);
        }
    }

    /**
     * This constructs a copy of the specified time card.
     * @param t the specified time card to be copied
     * @throws BadParameterException If any hours of a day in time card t is
     * negative or greater than 24
     * @see #getHoursByDay(int) 
     * @see #setHoursByDay(int, int) 
     */
    public Timecard(Timecard t) throws BadParameterException {
        for (int i = 0; i < NUM_DAYS; i++) {
            setHoursByDay(i, t.getHoursByDay(i));
        }
    }

    /**
     * This returns a weekly working hours of this time table. 
     * @return the weekly working hours of this time table
     */
    public int getWeeklyHours() {
        int count = 0;
        for (int i = 0; i < NUM_DAYS; i++) {
            try {
                count += getHoursByDay(i);
            } catch (BadParameterException e) {
                System.err.println("Invalid day " + i + " skipped in summing weekly hours");
            }
        }
        return count;
    }

    /**
     * This returns the working hours at a specified day.
     * @param day index of a specified day
     * @return the working hours at the specified day
     * @throws BadParameterException If the passed-in day is negative or not less
     * than NUM_DAYS
     * @see #NUM_DAYS
     */
    public int getHoursByDay(int day) throws BadParameterException {
        if (day < 0 || day >= NUM_DAYS) {
            throw new BadParameterException("Bad day value passed to getHoursByDay: " + day);
        }

        return daysOfTheWeek[day];
    }

    /**
     * Set the working hour of one day in this time card.
     * @param day index of the day to be set
     * @param hours amount of working hours to be set in specified day
     * @throws BadParameterException If the passed-in day is negative or not less
     * than NUM_DAYS, or the passed-in hours is negative or greater than 24.
     */
    private void setHoursByDay(int day, int hours) throws BadParameterException {
        if (day < 0 || day >= NUM_DAYS) {
            throw new BadParameterException("Bad day value passed to setHoursByDay: " + day);
        }
        if (hours < 0 || hours > 24) {
            throw new BadParameterException("Bad hours value passed to setHoursByDay: " + hours);
        }
        daysOfTheWeek[day] = hours;
    }

    /**
     * This returns a string representation of this time card, in the order 
     * of a weekly hours and a list of working hours in each day.
     * @return a string representation of this time card
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %d%n", "Weekly Hours:", getWeeklyHours()));
        for (int i = 0; i < NUM_DAYS; i++) {
            try {
                sb.append(String.format("%7s %d: %11d%n", "Day", (i + 1), getHoursByDay(i)));
            } catch (BadParameterException e) {
                sb.append(String.format("%7s %d: %s %d%n", "Day", (i + 1), "Error Accessing Hours for Day", i));
            }
        }
        return sb.toString();
    }
}
