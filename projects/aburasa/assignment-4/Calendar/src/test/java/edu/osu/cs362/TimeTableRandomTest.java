package edu.osu.cs362;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setDescription"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");

		long randomseed = Calendar.getInstance().getTimeInMillis();//System.currentTimeMillis();
		Random inputs = new Random(randomseed); 
		int day = ValuesGenerator.getRandomIntBetween(inputs, 1, 30); 					
		int month = ValuesGenerator.getRandomIntBetween(inputs, 1, 12); 					
		int year = ValuesGenerator.getRandomIntBetween(inputs, 1900, 2250); 					
		GregorianCalendar cal = new GregorianCalendar(day, month, year);
		CalDay calDay = new CalDay(cal);

		//code added for TimeTable
		LinkedList<Appt> listApps = new LinkedList<Appt>();	
		LinkedList<Appt> nullApps = null;
		Appt appt2 = null;
		TimeTable timeTable = new TimeTable();

			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				randomseed = Calendar.getInstance().getTimeInMillis();//System.currentTimeMillis();
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				inputs = new Random(randomseed);
			        int a = ValuesGenerator.getRandomIntBetween(inputs, 1, 24); 					
				 int startHour=a;
				inputs = new Random(randomseed);
			        a = ValuesGenerator.getRandomIntBetween(inputs, 1, 59); 					
				 int startMinute=a;
				inputs = new Random(randomseed);
			        a = ValuesGenerator.getRandomIntBetween(inputs, 1, 30); 					
				 int startDay=a;
				inputs = new Random(randomseed);
			        a = ValuesGenerator.getRandomIntBetween(inputs, 0, 14); 					
				 int startMonth=a;
				a = ValuesGenerator.getRandomIntBetween(inputs, 1002, 2250); 					
				 int startYear=a;
				 String title="Birthday Party";				
				 String description="This is a birthday party.";   	
				 //Construct a new Appointment object with the initial data	 
				 Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);

				listApps.add(appt);

				//More TimeTable added code	
			        a = ValuesGenerator.getRandomIntBetween(inputs, 1, 4);
				if(a == 1){ timeTable.deleteAppt(listApps, appt); }
				if(a == 2){ timeTable.deleteAppt(listApps, appt2); }
				if(a == 3){ timeTable.deleteAppt(nullApps, appt); }
				if(a == 4){ timeTable.deleteAppt(nullApps, appt2); }
									

				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = CalDayRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					
				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
	 
	 
		 System.out.println("Done testing...");
	 }
	
}
