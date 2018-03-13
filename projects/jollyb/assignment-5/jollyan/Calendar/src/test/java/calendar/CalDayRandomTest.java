package calendar;


import org.junit.Test;


import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
	/**
	 * Random Test Generator  for CalDay class.
	 */
	 
		private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
		private static final int NUM_TESTS=100; //100 500

		/**
		 * Return a randomly selected method to be tests !.
		 */
	    public static String RandomSelectMethod(Random random){
	        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

	    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
	    	            
	        return methodArray[n] ; // return the method name 
	        }
		/**
		 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
		 */
	    public static int RandomSelectRecur(Random random){
	        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

	    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
	        return RecurArray[n] ; // return the value of the  appointments to recur 
	        }	
		/**
		 * Return a randomly selected appointments to recur forever or Never recur  !.
		 */
	    public static int RandomSelectRecurForEverNever(Random random){
	        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

	    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
	        return RecurArray[n] ; // return appointments to recur forever or Never recur 
	        }	
	   /**
	     * Generate Random Tests that tests Appt Class.
	     */
		 @Test
		  public void radnomtest()  throws Throwable  {

			 long startTime = Calendar.getInstance().getTimeInMillis();
			 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

			 
			 System.out.println("Start testing...");
			 int falsetest = 0;
			 int truetest = 0;
			try{ 
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {
					long randomseed =System.currentTimeMillis(); //10
		//			System.out.println(" Seed:"+randomseed );
					Random random = new Random(randomseed);
					
					 int startHour=ValuesGenerator.RandInt(random);
					 int startMinute=ValuesGenerator.RandInt(random);
					 int startDay=ValuesGenerator.RandInt(random);;
					 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					 int startYear=ValuesGenerator.RandInt(random);
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
				 //if(!appt.getValid())continue;
				 GregorianCalendar today = new GregorianCalendar(1,1,1);
				 
				 CalDay calDay = new CalDay(today);
				 
				 for (int i = 0; i < NUM_TESTS; i++) {
					 if(calDay.getSizeAppts() <= 0) {
						 falsetest++;
					 }
					 else {
						 assertTrue(calDay.getSizeAppts() > 0);
						 truetest++;
					 }
					 int TstartHour=ValuesGenerator.getRandomIntBetween(random,1, 23); 
					 int TstartMinute=ValuesGenerator.RandInt(random);
					 int TstartDay=ValuesGenerator.RandInt(random);;
					 int TstartMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					 int TstartYear=ValuesGenerator.RandInt(random);
					 String Ttitle="Birthday Party";
					 String Tdescription="This is my birthday party.";
					 //Construct a new Appointment object with the initial data	 
					 Appt Tempappt = new Appt(startHour,
					          TstartMinute ,
					          TstartDay ,
					          TstartMonth ,
					          TstartYear ,
					          Ttitle,
					         Tdescription);
					 calDay.addAppt(Tempappt);
						
						}
				
					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				        if((iteration%10000)==0 && iteration!=0 )
				              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				 
				}
			}catch(NullPointerException e){
				
			}
		 
			System.out.println("Done testing... False test:" + falsetest + " True Test:" + truetest);
		 }

	
}