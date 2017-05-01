package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {


    @Test
    public void test00() throws Throwable {
        //test defult constructor
        CalDay calDay1 = new CalDay();
        assertNull(calDay1);
        assertNull(calDay1.iterator());
        assertNull(calDay1.iterator());
    }

    @Test
    public void test01() throws Throwable {
        //test primary constructor
        int day = 30;
        int month = 4;
        int year = 2017;

        GregorianCalendar cal = new GregorianCalendar(day, month, year);
        CalDay calDay = new CalDay(cal);

        //asserts
        assertEquals(30, calDay.getDay());
        assertEquals(4, calDay.getMonth());
        assertEquals(2017, calDay.getYear());
    }

    @Test //tests the addAppt function
    public void test02() throws Throwable {
        int day = 30;
        int month = 4;
        int year = 2017;
        GregorianCalendar cal = new GregorianCalendar(day, month, year);
        CalDay calDay = new CalDay(cal);

        int startHour = 13;
        int startMinute = 30;
        int startDay = 10;
        int startMonth = 4;
        int startYear = 2017;
        String title = "Birthday Party";
        String description = "This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
        calDay.addAppt(appt);

        //add another appointment to trigger the sort
        startHour = 17;
        startMinute = 30;
        startDay = 10;
        startMonth = 4;
        startYear = 2017;
        title = "Birthday Party";
        description = "This is my birthday party.";
        //Construct a new Appointment object with the initial data
        appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
        calDay.addAppt(appt);

        //add another appointment to trigger the sort
        startHour = 9;
        startMinute = 30;
        startDay = 10;
        startMonth = 4;
        startYear = 2017;
        title = "Birthday Party";
        description = "This is my birthday party.";
        //Construct a new Appointment object with the initial data
        appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
        calDay.addAppt(appt);

        //testing getSizeAppts
        assertEquals(3, calDay.getSizeAppts());


    }

    @Test //tests toString
    public void test03() throws Throwable{
        int day = 30;
        int month = 4;
        int year = 2017;
        GregorianCalendar cal = new GregorianCalendar(day, month, year);
        CalDay calDay = new CalDay(cal);
        assertNotNull(calDay.iterator());

        int startHour = 13;
        int startMinute = 30;
        int startDay = 10;
        int startMonth = 4;
        int startYear = 2017;
        String title = "Birthday Party";
        String description = "This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
        calDay.addAppt(appt);

        //testing tostring
        assertEquals("", calDay.toString());
    }

}
