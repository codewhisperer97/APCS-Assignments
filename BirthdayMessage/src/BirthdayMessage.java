public class BirthdayMessage 
{
	public static final int DAY = 17;
	public static final int MONTH = 6;
	
	public static final String[] message = {
		"It will be dark and stormy where you live tonight!",
		"You will win the lottery in the next drawing!",
		"Luck isn't looking too good for your home team!",
		"Looks like you're gonna settle down with a Prius.",
		"Something spectacular is happening soon...",
		"Watch out for spilling coffee!",
		"Double check your morning alarm!",
		"Snow is going to come early this year!",
		"The power will go out in a few days!",
		"Midlife crisis ahead!",
		"You're going to win a free carwash!",
		"Be careful around loud music!"
	};
	
	public static void main(String[] args) 
	{
		System.out.println(message[getMsgNum(MONTH, DAY)]);
	}
	
	public static int getMsgNum(int month, int day)
	{
		if(month < 1 || month > 12)
		{
			return -1;
		}
		
		if(day > 0 && day <= 14)
		{
			return month;
		}
		else if(day >=15 && day <= 31)
		{
			return incMonth(month);
		}
		return -1;
	}
	
	/**
	 * This function allows us to cycle up through the months
	 * and automatically returns to 1 after 12.
	 * @param month The month number to increment.
	 * @return The month after the parameter month.
	 */
	private static int incMonth(int month)
	{
		if(month < 1 || month > 12)
		{
			return -1;
		}
		
		if(month == 12)
		{
			return 1;
		}
		return month + 1;
	}
}