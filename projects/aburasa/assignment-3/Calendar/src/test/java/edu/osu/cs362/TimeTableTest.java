package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 int day = 30;
		 int month = 4;
		 int year = 2017;
		 GregorianCalendar cal = new GregorianCalendar(day, month, year);
		 CalDay calDay = new CalDay(cal);

         LinkedList<Appt> listAppts = new LinkedList<Appt>();

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

         listAppts.add(appt);

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
         listAppts.add(appt);

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
         listAppts.add(appt);

		 TimeTable timeTable=new TimeTable();
         LinkedList<CalDay> calDays = new LinkedList<CalDay>();
         GregorianCalendar today = new GregorianCalendar(year,month, day);
         GregorianCalendar tomorrow = new GregorianCalendar(year, month, day+1);
         calDays=timeTable.getApptRange(listAppts,today,tomorrow);

         assertNotNull(timeTable.getApptRange(listAppts,today,tomorrow));
         assertNotNull(timeTable.deleteAppt(listAppts, appt));

	 }
//Added tests for mutation
@Test(timeout = 4000)
public void test02()  throws Throwable  {
    TimeTable timeTable0 = new TimeTable();
    Appt appt0 = new Appt(5, 5, 690, 5, 690, "am", "am");
    LinkedList<Appt> linkedList0 = timeTable0.deleteAppt((LinkedList<Appt>) null, appt0);
    assertNull(linkedList0);
}

    @Test(timeout = 4000)
    public void test03()  throws Throwable  {
        TimeTable timeTable0 = new TimeTable();
        LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
        LinkedList<Appt> linkedList1 = timeTable0.deleteAppt(linkedList0, (Appt) null);
        assertNull(linkedList1);
    }
    @Test(timeout = 4000)
    public void test04()  throws Throwable  {
        TimeTable timeTable0 = new TimeTable();
        LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
        Appt appt0 = new Appt(1, 0, 0, 0, 0, "\t --- ", "");
        LinkedList<Appt> linkedList1 = timeTable0.deleteAppt(linkedList0, appt0);
        assertNull(linkedList1);
    }
    @Test(timeout = 4000)
    public void test05()  throws Throwable  {
        TimeTable timeTable0 = new TimeTable();
        GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar();
        CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
        LinkedList<Appt> linkedList0 = calDay0.appts;
        Appt appt0 = new Appt(2, 1, 1, 1, (-351), "\t", "\t");
        linkedList0.add(appt0);
        timeTable0.deleteAppt(linkedList0, appt0);
        assertEquals(0, linkedList0.size());
        assertEquals(0, calDay0.getSizeAppts());
    }
    @Test(timeout = 4000)
    public void test06()  throws Throwable  {
        TimeTable timeTable0 = new TimeTable();
        GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar();
        CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
        LinkedList<Appt> linkedList0 = calDay0.appts;
        Appt appt0 = new Appt(2, 1, 1, 1, (-351), "\t", "\t");
        linkedList0.add(appt0);
        Appt appt1 = new Appt(1, 1, 1, 1, 1, "\t", "\t");
        timeTable0.deleteAppt(linkedList0, appt1);
        assertEquals(1, linkedList0.size());
        assertEquals(1, calDay0.getSizeAppts());
    }
    @Test(timeout = 4000)
    public void test07()  throws Throwable  {
        TimeTable timeTable0 = new TimeTable();
        LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
        linkedList0.addFirst((Appt) null);
        Appt appt0 = new Appt(1, 1, 1, 1, 1, " ,|FMDW</|0^DmThU", "q_~R(W(5)+84X[");
        // Undeclared exception!
        try {
            timeTable0.deleteAppt(linkedList0, appt0);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }
}
