package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 
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
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
		 
	 }

	 @Test
	  public void testStartHour()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
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
		 appt.setStartHour(20);
		 assertEquals(20, appt.getStartHour());
		 assertTrue(appt.getValid());
		 appt.setStartHour(24);
		 assertFalse(appt.getValid());
		 appt.setStartHour(-1);
		 assertFalse(appt.getValid());
		 appt.setStartHour(23);
		 assertTrue(appt.getValid());
		 appt.setStartHour(0);
		 assertTrue(appt.getValid()); 
	 }
	 
	 @Test
	  public void testStartMinute()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
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
		 appt.setStartMinute(20);
		 assertEquals(20, appt.getStartMinute());
		 appt.setStartMinute(60);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(59);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(0);
		 assertTrue(appt.getValid());
	 }
	 
	 @Test
	  public void testStartDay()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
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
		 appt.setStartDay(20);
		 assertEquals(20, appt.getStartDay());
		 appt.setStartDay(0);
		 assertFalse(appt.getValid());
		 appt.setStartDay(CalendarUtil.NumDaysInMonth(startYear, startMonth-1)+1);
		 assertFalse(appt.getValid());
		 appt.setStartDay(1);
		 assertTrue(appt.getValid());
		 appt.setStartDay(CalendarUtil.NumDaysInMonth(startYear, startMonth-1));
		 assertTrue(appt.getValid());
	 }
	 
	 @Test
	  public void testStartMonth()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
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
		 assertEquals(1, appt.getStartMonth());
		 //appt.setStartMonth(0);
		 //assertFalse(appt.getValid());
		 //appt.setStartMonth(13);
		 //assertFalse(appt.getValid());
		 appt.setStartMonth(1);
		 assertTrue(appt.getValid());
		 appt.setStartMonth(12);
		 assertTrue(appt.getValid());
	 }
	 
	 @Test
	  public void testStartYear()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
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
		 appt.setStartYear(2018);
		 assertEquals(2018, appt.getStartYear());
		 assertTrue(appt.getValid());
	 }
	 @Test
	  public void testsetRecurrence()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 int RECUR_BY_MONTHLY =2;
		 int RECUR_NUMBER_NEVER = 0;
		 int[] recurringDays = new int[0];
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
		 appt.setRecurrence(recurringDays, RECUR_BY_MONTHLY, 0, RECUR_NUMBER_NEVER);
		 assertEquals(2, appt.getRecurBy());
		 assertEquals(0, appt.getRecurNumber());
		 assertEquals(0, appt.getRecurIncrement());
		 assertFalse(appt.isRecurring());
		 appt.setRecurrence(recurringDays, RECUR_BY_MONTHLY, 0, 1);
		 assertTrue(appt.isRecurring());
		 
	 }
	
//add more unit tests as you needed
	 
	
}
