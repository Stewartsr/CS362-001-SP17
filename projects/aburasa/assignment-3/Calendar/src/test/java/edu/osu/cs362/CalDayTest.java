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
        assertNotNull(calDay1);
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
        assertNotNull(calDay.getDay());
        assertNotNull(calDay.getMonth());
        assertNotNull( calDay.getYear());
        assertTrue(calDay.getDay() > 0);
        assertTrue(calDay.getDay() < 31);
        assertTrue(calDay.getMonth() > 0);
        assertTrue(calDay.getMonth() < 13);
        assertTrue( calDay.getYear() > 0);
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
        assertNotNull(calDay.toString());
    }
//Tests added for mutation coverage
@Test(timeout = 4000)
public void test04()  throws Throwable  {
    GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar();
    CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
    Appt appt0 = new Appt(5, 5, 1, 1, 1, "\t --- 1/14/2014 --- \n --- -------- Appointments ------------ --- \n\n", "\t --- 1/14/2014 --- \n --- -------- Appointments ------------ --- \n\n");
    calDay0.addAppt(appt0);
    String string0 = calDay0.toString();
    assertEquals("\t --- 4/15/2017 --- \n --- -------- Appointments ------------ --- \n\t1/1/1 at 5:5am ,\t --- 1/14/2014 --- \n --- -------- Appointments ------------ --- \n\n, \t --- 1/14/2014 --- \n --- -------- Appointments ------------ --- \n\n\n \n", string0);
}

    @Test(timeout = 4000)
    public void test05()  throws Throwable  {
        CalDay calDay0 = new CalDay();
        String string0 = calDay0.toString();
        assertEquals("", string0);
    }
}
