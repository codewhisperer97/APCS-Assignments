import java.util.Scanner;

public class Averager 
{
	/**
	 * Scanner object receives input from the user through the console window.
	 */
	private static Scanner scanner;
	
	/**
	 * Decimal number that keeps a running total of all grades that have been
	 * entered.
	 */
	private static double sum = 0.0;
	
	/**
	 * Integer that keeps a running total of the number of grades that have been
	 * entered
	 */
	private static int items = 0;
	
	public static void main(String[] args) 
	{
		//Initialize the Scanner to read from System.in (user input)
		scanner = new Scanner(System.in);
		
		System.out.println("Enter all numbers to average, then enter '-1'.");
		
		/*
		 * In this loop, the user is prompted to enter as many grades as they
		 * want.  -1 is used to represent 'done', so if the user finishes typing
		 * in grades, they they type -1 to signal that they're done, and the
		 * loop will exit.
		 */
		int i = -1;
		while(((i = getInput()) != -1) && (i > 0)) 
		{
			sum += i;
			items++;
		}
		
		if(sum > 0)
		{
			sum /= items;
		}
		else
		{
			sum = 0;
		}
		
		System.out.println("Average: " + sum);
	}
	
	/**
	 * Separate method (function) that reads input from the user.  It will
	 * sense if the input is an integer and terminate if it is not.
	 */
	public static int getInput()
	{
		try
		{
			return Integer.parseInt(scanner.next());
		}
		catch(Exception e)
		{
			System.out.println("Invalid input; Terminating.");
			return -1;
		}
	}
}
