public class Month 
{
	/*
	 * These constants are used just to hold a value of the month's number to 
	 * make comparisons in the if statements more readable.  These are not used
	 * in my current implementation because I'm using a loop.
	 *
	public static final int JAN_NUM = 1;
	public static final int FEB_NUM = 2;
	public static final int MAR_NUM = 3;
	public static final int APR_NUM = 4;
	public static final int MAY_NUM = 5;
	public static final int JUN_NUM = 6;
	public static final int JUL_NUM = 7;
	public static final int AUG_NUM = 8;
	public static final int SEP_NUM = 9;
	public static final int OCT_NUM = 10;
	public static final int NOV_NUM = 11;
	public static final int DEC_NUM = 12;
	 */
	
	/*
	 * These constants are used in the classic if/else-if/else stack, but I'm
	 * using a constant array for my actual execution.  
	 * 
	public static final int JANUARY = 31;
	public static final int FEBRUARY = 28;
	public static final int MARCH = 31;
	public static final int APRIL = 30;
	public static final int MAY = 31;
	public static final int JUNE = 30;
	public static final int JULY = 31;
	public static final int AUGUST = 31;
	public static final int SEPTEMBER = 30;
	public static final int OCTOBER = 31;
	public static final int NOVEMBER = 30;
	public static final int DECEMBER = 31;
	 */

	/**
	 * This array holds the number of days of each month IN SEQUENCE of months.
	 */
	public static final int[] monthDays = {
		31, //January
		28, //February
		31, //March
		30, //April
		31, //May
		30, //June
		31, //July
		31, //August
		30, //September
		31, //October
		30, //November
		31  //December
	};
	
	private int monthNum = -1;
	
	/**
	 * Constructs this month of a certain number.
	 * @param month The number of month this is.
	 */
	public Month(int month)
	{
		monthNum = month;
	}
	
	/**
	 * Sets the number of the month.
	 * @param month The new number for this month.
	 */
	public void setMonth(int month)
	{
		monthNum = month;
	}
	
	/**
	 * Returns the number of the month.
	 * @return The number of the month.
	 */
	public int getMonthNum()
	{
		return monthNum;
	}
	
	public int numDays()
	{
		/*
		 * This is the classic way to return the number of days per month with
		 * if statements.  However, this method is not expandable, so when new
		 * months are added to the year we'll be in trouble.
		  
		   if(monthNum == JAN_NUM)
		   {
		   	  return JANUARY;
		   }
		   else if(monthNum == FEB_NUM)
		   {
		   	  return FEBRUARY;
		   }
		   else if(monthNum == MAR_NUM)
		   {
		   	  return MARCH;
		   }
		   else if(monthNum == APR_NUM)
		   {
		   	  return APRIL;
		   }
		   else if(monthNum == MAY_NUM)
		   {
		   	  return MAY;
		   }
		   else if(monthNum == JUN_NUM)
		   {
		   	  return JUNE;
		   }
		   else if(monthNum == JUL_NUM)
		   {
		   	  return JULY;
		   }
		   else if(monthNum == AUG_NUM)
		   {
		      return AUGUST;
		   }
		   else if(monthNum == SEP_NUM)
		   {
		   	  return SEPTEMBER;
		   }
		   else if(monthNum == OCT_NUM)
		   {
		   	  return OCTOBER;
		   }
		   else if(monthNum == NOV_NUM)
		   {
		   	  return NOVEMBER;
		   }
		   else if(monthNum == DEC_NUM)
		   {
		   	  return DECEMBER;
		   }
		 */
		
		/*
		 * A better way to do this is to use a constant array and cycle through
		 * it.
		 */
		for(int i = 0; i < 12; i++)
		{
			/*
			 * Here, the for loop will cycle through the values of 0-11, which
			 * is good because that's the same range that our constant array has.
			 * However, the user will be expecting to input a 1-12, so when we're
			 * comparing with 'monthNum' that was set by the user, we bump up
			 * the range by 1 by simply adding (i + 1) for the proper comparison.
			 */
			if(monthNum == i + 1)
			{
				return monthDays[i];
			}
		}
		
		/*
		 * If a return statement has not been hit yet, then none of the months
		 * match the number input by the user, so return -1 to represent an
		 * error.
		 */
		return -1;
	}
}