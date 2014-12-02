import java.util.Scanner;

public class SimpleInterest 
{
	private static Scanner scanner;
	private static double principal = 0.0;
	private static double rate = 0.0;
	private static double years = 0;
	private static double total = 0;
	
	public static void main(String[] args) 
	{
		scanner = new Scanner(System.in);
		
		principal = getPrincipal();
		rate = getRate();
		years = getYears();
		
		total = principal;
		for(int i = 1; i < years; i++)
		{
			total += (principal * (rate * .01));
		}
		
		System.out.println("$" + principal + " at " + rate + "% over " + years +
				" years is $" + total);
		
	}
	
	/**
	 * Method to parse a double value from a String input from the user.
	 * Prompts over again until a proper response is understood.
	 * @return A double value parsed form user input.
	 */
	public static double getDouble()
	{
		double response = -1;
		boolean success = false;
		
		while(!success)
		{
			try
			{
				response = Double.parseDouble(scanner.next());
				success = true;
			}
			catch(Exception e)
			{
				/*
				 * Some error happened parsing
				 */
				System.out.println("Must be a number! Try again: ");
			}
		}
		return response;
	}
	
	public static double getPrincipal()
	{
		System.out.print("What is the principal amount? ");
		double response = -1;
		while(response <= 0)
		{
			response = getDouble();
			
			if(response < 0)
			{
				System.out.println("Principal value must be greater than 0! Try again: ");
			}
		}
		return response;
	}
	
	public static double getRate()
	{
		System.out.print("What is the interest rate? ");
		double response = -1;
		while(response <= 0)
		{
			response = getDouble();
			if(response < 0)
			{
				System.out.println("Interest must be greater than 0! Try again: ");
			}
		}
		return response;
	}
	
	public static double getYears()
	{
		System.out.print("How many years? ");
		
		double response = -1;
		while(response < 0)
		{
			response = getDouble();
			if(response < 0)
			{
				System.out.println("Number of years must be greater than 0! Try again: ");
			}
		}
		return response;
	}
}
