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
        appt.setStartHour(1);
        assertFalse(appt.getStartHour() < 0);
        assertFalse(appt.getStartHour() > 23);

        //test setStartMinute() and the upper and lower checks for isValid()
        assertFalse(appt.getValid());
        appt.setStartMinute(-1);
        assertFalse(appt.getValid());
        assertEquals(-1, appt.getStartMinute());
        appt.setStartMinute(1);
        assertFalse(appt.getStartMinute() < 0);
        assertFalse(appt.getStartMinute() > 59);

        //test setStartDay() and the upper and lower checks for isValid()
        assertFalse(appt.getValid());
        appt.setStartDay(-1);
        assertFalse(appt.getValid());
        assertEquals(-1, appt.getStartDay());
        appt.setStartDay(2);
        assertFalse(appt.getStartDay() < 1);
        assertFalse(appt.getStartDay() > 31);

        //test setStartMonth() and the upper and lower checks for isValid()
        assertFalse(appt.getValid());
        appt.setStartMonth(-1);
        assertFalse(appt.getValid());
        assertEquals(-1, appt.getStartMonth());
        appt.setStartMonth(2);
        assertFalse(appt.getStartMonth() < 1);
        assertFalse(appt.getStartMonth() > 12);
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
        //assertEquals("\t4/10/2017 at 9:30am ,Birthday Party, This is my birthday party.", appt.toString());
        assertNotNull(appt.toString());

	 }

	 //Added tests for mutations
    @Test(timeout = 4000)
    public void test05()  throws Throwable  {
        Appt appt0 = new Appt(1, 1, 1, 1, (-4009), "\t", "\t");
        String string0 = appt0.toString();
        assertNotNull(string0);
        assertEquals("\t1/1/-4009 at 1:1am ,\t, \t\n", string0);
    }
    @Test(timeout = 4000)
    public void test06()  throws Throwable  {
        Appt appt0 = new Appt(21, (-793), 12, 12, 21, "am", "am");
        assertEquals(-793, appt0.getStartMinute());

        appt0.setStartMinute(21);
        assertEquals(21, appt0.getStartYear());
    }

    @Test(timeout = 4000)
    public void test07()  throws Throwable  {
        Appt appt0 = new Appt(23, 1310, 23, 23, 1310, "", "J]k1EA ]");
        assertEquals(23, appt0.getStartHour());
        assertEquals("", appt0.getTitle());
        assertFalse(appt0.getValid());
        assertEquals(23, appt0.getStartMonth());
        assertEquals(1310, appt0.getStartMinute());
        assertEquals(1310, appt0.getStartYear());
        assertEquals(23, appt0.getStartDay());
        assertEquals("J]k1EA ]", appt0.getDescription());
    }
    @Test(timeout = 4000)
    public void test08()  throws Throwable  {
        Appt appt0 = new Appt(11, 11, 11, 11, (-655), (String) null, "N0wP49e^");
        String string0 = appt0.toString();
        assertEquals("\t11/11/-655 at 11:11am ,, N0wP49e^\n", string0);
        assertNotNull(string0);
    }



}
