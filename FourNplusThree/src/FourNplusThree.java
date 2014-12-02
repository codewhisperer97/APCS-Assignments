import java.util.Scanner;

public class FourNplusThree 
{
	private static Scanner scanner;
	private static int input;
	
	public static void main(String[] args) 
	{
		scanner = new Scanner(System.in);
		System.out.print("Enter a sequence length: ");
		input = getInput();
		
		for(int i = 0; i < input; i++)
		{
			System.out.println((4 * i) + 3);
		}
	}
	
	private static int getInput()
	{
		int response = -1;
		boolean success = false;
		
		while(response < 1)
		{
			success = false;
			while(!success)
			{
				try
				{
					response = Integer.parseInt(scanner.next());
					success = true;
				}
				catch(Exception e)
				{
					/*
					 * If there are any errors parsing then we don't
					 * have an integer, so try again.
					 */
					success = false;
					System.out.println("Must be an integer! Try again: ");
				}
			}
			if(response < 1)
			{
				System.out.println("Must be 1 or greater! Try again: ");
			}
		}
		return response;
	}
}
