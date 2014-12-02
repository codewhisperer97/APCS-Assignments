import java.util.Scanner;

public class Factorial 
{
	private static Scanner scanner;
	
	public static final int ERROR = -1;
	
	public static void main(String[] args) 
	{		
		scanner = new Scanner(System.in);
		
		System.out.print("Please enter your factorial: ");
		
		/*
		 * The getNum() method automatically checks the feedback from Scanner
		 * to ensure that it is a positive integer, and handles reprompting from
		 * the inside, so we never have to worry about that here.
		 */
		int input = getNum();
		
		/*
		 * Total is the variable that holds our factorial as we process it.  Each
		 * loop, we take the value of the iteration and multiply that into total.
		 */
		int total = 1;
		for(int i = input; i > 0; i--)
		{
			total *= i;
		}
		
		System.out.println("Factorial " + input + "! is " + total);
	}
	
	/**
	 * Gets an Integer parsed by _getNum() and checks to make sure that it is
	 * positive.  If it isn't, then it will call _getNum() for a more suitable
	 * response.  This way, _getNum() will ensure that the input is actually an
	 * Integer and not, say, a String, but getNum() will make sure that the
	 * value of the integer is positive.
	 * @return The final sanitized input from Scanner.
	 */
	private static int getNum()
	{
		int response = ERROR;
		while((response = _getNum()) < 0)
		{
			System.out.println("Invalid input! Please enter new input: ");
		}
		return response;
	}
	
	/**
	 * A more behind-the-scenes layer of sanitizing.  This method will return 
	 * the input from the Scanner ONLY IF it is a valid integer.  If it is a
	 * String or for some reason does not parse to an integer correctly, then
	 * it will return an error (-1), which will then be processed at a higher
	 * level and this will be called again.
	 * @return A parsed Integer of the Scanner input.
	 */
	private static int _getNum()
	{		
		try
		{
			return Integer.parseInt(scanner.next());
		}
		catch(Exception e)
		{
			/*
			 * This brace will run if there was an error parsing
			 * the input to an integer, so in that case the 
			 * response will remain unaltered and we will return
			 * the ERROR code.
			 */
			return ERROR;
		}
	}
}