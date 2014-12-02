import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarProject 
{
	private static final int THIS_YEAR = 2014;
	private static final int THIS_MONTH = Calendar.SEPTEMBER;
	private static final int THIS_DAY = 14;
	
	private static final int BIRTH_YEAR = 1997;
	private static final int BIRTH_MONTH = Calendar.MARCH;
	private static final int BIRTH_DAY = 6;
	
	public static void main(String[] args) 
	{
		/*
		 * Program was written on 09/14/14
		 */
		GregorianCalendar today = new GregorianCalendar(THIS_YEAR, 
														THIS_MONTH, 
														THIS_DAY);
		today.add(Calendar.DAY_OF_MONTH, 100);
		System.out.print("100 days from now is " + 
						 today.get(Calendar.MONTH) + "/" + 
						 today.get(Calendar.DAY_OF_MONTH) + "/" + 
						 today.get(Calendar.YEAR));
		
		System.out.println(", and that day of week is " + getDayOfWeek(
				today.get(Calendar.DAY_OF_WEEK)));
		
		/*
		 * My birthday is on March 6, 1997
		 */
		GregorianCalendar myBirthday = new GregorianCalendar(BIRTH_YEAR, 
															 BIRTH_MONTH, 
															 BIRTH_DAY);
		int weekday = myBirthday.get(Calendar.DAY_OF_WEEK);
		System.out.println("My birthday was on a " + getDayOfWeek(weekday));
		
		myBirthday.add(Calendar.DAY_OF_MONTH, 10000);
		System.out.println("10,000 days from my birthday is " +
						   myBirthday.get(Calendar.MONTH) + "/" +
						   myBirthday.get(Calendar.DAY_OF_MONTH) + "/" +
						   myBirthday.get(Calendar.YEAR));
	}
	
	public static String getDayOfWeek(int day) {
		if(day == 1) {return "Sunday";}
		else if(day == 2) {return "Monday";}
		else if(day == 3) {return "Tuesday";}
		else if(day == 4) {return "Wednesday";}
		else if(day == 5) {return "Thursday";}
		else if(day == 6) {return "Friday";}
		else if(day == 7) {return "Saturday";}
		else {return "DAY OUT OF BOUNDS!";}
	}
}
