import java.util.Scanner;

public class CardGame 
{
	private static Scanner scanner;
	
	public static void main(String[] args) 
	{
		scanner = new Scanner(System.in);
		System.out.print("Enter a card abbreviation: ");
		
		Card card = new Card();
		String desc = null;
		while((desc = card.getDescription(getInput())) == null)
		{
			System.out.print("Invalid Input! Please try again: ");
		}
		
		System.out.println("You picked " + desc + ".");
	}
	
	public static String getInput()
	{
		return scanner.next();
	}
}