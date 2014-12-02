import java.util.Scanner;

public class MonthTranslator
{
	private static Scanner scanner;
	
	public static void main(String[] args)
	{
		scanner = new Scanner(System.in);
		
		/*
		 * Initial user prompt
		 */
		System.out.print("What number month is it? ");
		Month month = new Month(getNumFromScanner());
		
		/*
		 * Logic loop that will continue prompting the user for a proper input
		 * if the response is not a proper or expected one.
		 */
		while(month.numDays() == -1)
		{
			System.out.print("Error: Improper month input! "
					+ "Please enter a new month number: ");
			month.setMonth(getNumFromScanner());
		}
		
		System.out.println("Number of days in your month is: " + month.numDays());
	}
	
	/**
	 * Simple method to parse a user input into an integer.
	 * @return Integer version of a scanner input.
	 */
	private static int getNumFromScanner()
	{
		int response = -1;
		try 
		{
			response = Integer.parseInt(scanner.next());
		}
		catch(NumberFormatException e)
		{
			response = -1;
			/*
			 * An error happened, so the response will remain -1.  Later in the
			 * program, -1 will be recognized as an error and this will be
			 * called again in an attempt to receive a proper response.
			 * 
			 * For debugging purposes: e.printStackTrace();
			 */
		}
		return response;
	}
}