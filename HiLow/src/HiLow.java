import java.util.Random;

public class HiLow 
{
	private static Random random;
	
	private static int computerNum;
	private static int computerSuit;
	private static int playerNum;
	private static int playerSuit;
	
	public static void main(String[] args) 
	{
		random = new Random();
		
		computerNum = getRand(13);
		computerSuit = getRand(4);
		playerNum = getRand(13);
		playerSuit = getRand(4);
		
		/*
		 * So for this game, the highest number card will always win, but if
		 * there is a tie, then the the highest suit wins.  The order of the
		 * high suits are arbitrarily:
		 * 
		 * Diamond
		 * Heart
		 * Spade
		 * Club
		 * 
		 * If both the card and the suit match, then somebody is cheating but
		 * we'll call it a tie ;)
		 */
		
		Card computerCard = new Card();
		Card playerCard = new Card();
		
		/*
		 * Honestly, with the way this code is written, most of the methods in
		 * 'Card.java' could be static, because the info they process is totally
		 * based on parameters rather then object data.  But, I'm too far into it
		 * now so I'll just leave it.
		 */
		System.out.println("Player's card is " + 
		playerCard.getDescription(playerCard.getCardAbb(playerNum) + playerCard.getSuitAbb(playerSuit)) +
		", Computer's card is " +
		computerCard.getDescription(computerCard.getCardAbb(computerNum) + computerCard.getSuitAbb(computerSuit)) +
		".");
		
		/*
		 * Game logic to decide which number actually wins.  Number takes
		 * precedence over suit, so we start with that.
		 */
		if(playerNum > computerNum)
		{
			System.out.println("Player wins!");
		}
		else if(playerNum < computerNum)
		{
			System.out.println("Computer wins!");
		}
		
		/*
		 * If the numbers are the same, then we compare winner by suit.
		 */
		else
		{
			if(playerSuit > computerSuit)
			{
				System.out.println("Player wins!");
			}
			else if(playerSuit < computerSuit)
			{
				System.out.println("Computer wins!");
			}
			
			/*
			 * If both number and suit are the same, it's a tie.
			 */
			else
			{
				System.out.println("It's a tie!");
			}
		}
	}
	
	/**
	 * Returns a random number between 1 and the max parameter
	 * inclusive.
	 * @param max The maximum number of the range of a random
	 * number to generate.
	 * @return A random number between 1 and the max parameter
	 * inclusive
	 */
	public static int getRand(int max)
	{
		return random.nextInt(max) + 1;
	}
	
	public static String numberToCard(int num)
	{
		/*
		 * If the input is out of the range of playing card numbers (1-13)
		 * return null to indicate an error.
		 */
		if(num < 1 || num > 13)
		{
			return null;
		}
		
		if(num == 1) {
			return "A";
		}
		else if(num == 11)
		{
			return "J";
		}
		else if(num == 12)
		{
			return "Q";
		}
		else if(num == 13)
		{
			return "K";
		}
		
		/*
		 * If the method has not returned by now, there was an error with the
		 * input so return null.
		 */
		return null;
	}
	
	public static String numberToSuit(int num)
	{
		/*
		 * If the input is out of the range of playing suit numbers (1-4)
		 * return null to indicate an error.
		 */
		if(num < 1 || num > 4)
		{
			return null;
		}
		
		if(num == 1)
		{
			return "D";
		}
		else if(num == 2)
		{
			return "H";
		}
		else if(num == 3)
		{
			return "S";
		}
		else if(num == 4)
		{
			return "C";
		}
		
		/*
		 * If the method has not returned by now, there was an error with the
		 * input so return null.
		 */
		return null;
	}
}
