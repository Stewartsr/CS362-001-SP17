package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.apache.commons.lang.ObjectUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	@Test
	public void test02() throws Throwable {
        // Test is values outside the upper limit are caught by isValid, starting with only one invalid entry, startHour.
        int startHour=24;
        int startMinute=60;
        int startDay=32;
        int startMonth=13;
        int startYear=2017;
        String title="Birthday Party";
        String description="This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        //test setStartHour() and the upper and lower checks for isValid()
        assertFalse(appt.getValid());
        appt.setStartHour(-1);
        assertFalse(appt.getValid());
        assertEquals(-1, appt.getStartHour());
        appt.setStartHour(0);

        //test setStartMinute() and the upper and lower checks for isValid()
        assertFalse(appt.getValid());
        appt.setStartMinute(-1);
        assertFalse(appt.getValid());
        assertEquals(-1, appt.getStartMinute());
        appt.setStartMinute(0);

        //test setStartDay() and the upper and lower checks for isValid()
        assertFalse(appt.getValid());
        appt.setStartDay(-1);
        assertFalse(appt.getValid());
        assertEquals(-1, appt.getStartDay());
        appt.setStartDay(1);

        //test setStartMonth() and the upper and lower checks for isValid()
        assertFalse(appt.getValid());
        appt.setStartMonth(-1);
        assertFalse(appt.getValid());
        assertEquals(-1, appt.getStartMonth());
    }

    @Test
    public void test03() throws Throwable {
        //now test set year, title, and description
        int startHour=13;
        int startMinute=30;
        int startDay=10;
        int startMonth=4;
        int startYear=2017;
        String title="Birthday Party";
        String description="This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        //tests and assertions for year
        appt.setStartYear(476);
        assertEquals(476, appt.getStartYear());

        //title
        appt.setTitle("Fall of Rome");
        assertEquals("Fall of Rome", appt.getTitle());
        appt.setTitle(null);
        assertEquals("", appt.getTitle());

        //description
        appt.setDescription("The end of an Era");
        assertEquals("The end of an Era", appt.getDescription());
        appt.setDescription(null);
        assertEquals("", appt.getDescription());

    }
    @Test
    public void test04() throws Throwable{
        int startHour=-1;
        int startMinute=30;
        int startDay=10;
        int startMonth=4;
        int startYear=2017;
        String title="Birthday Party";
        String description="This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        //test the ToString function
        assertEquals(null, appt.toString());
        appt.setStartHour(9);
        assertEquals("\t4/10/2017 at 9:30am ,Birthday Party, This is my birthday party.", appt.toString());

	 }

}
