import java.util.Scanner;

public class Averager 
{
	private static Scanner scanner;
	private static double sum = 0.0;
	private static int items = 0;
	
	public static void main(String[] args) 
	{
		scanner = new Scanner(System.in);
		
		System.out.println("Enter all numbers to average, then enter '-1'.");
		
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
