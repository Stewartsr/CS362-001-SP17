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
         assertNull(timeTable.deleteAppt(listAppts, appt));

	 }

}
