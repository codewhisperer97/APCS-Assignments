import java.util.Random;

public class Dealer21 
{
	private static Random rand;
	private static Card theCard;
	private static int total;
	
	public static void main(String[] args) 
	{
		rand = new Random();
		total = 0;
		
		/*
		 * Generate two cards to start the deal, keeping track of the total
		 * value.
		 */
		theCard = new Card(generateRandomCard());
		System.out.print("The first card is " + theCard.getDescription());
		total += theCard.getCardValue(total <= 10);
		
		theCard = new Card(generateRandomCard());
		System.out.println(" and the second card is " + theCard.getDescription() + ".");
		total += theCard.getCardValue(total <= 10);
		
		System.out.println("The total is " + total + ".");
		
		/*
		 * For as long as the total remains less than 17, continue drawing cards.
		 */
		while(total < 17)
		{
			System.out.println();
			
			theCard = new Card(generateRandomCard());
			System.out.println("The next card is " + theCard.getDescription() + ".");
			
			total += theCard.getCardValue(total <= 10);
			System.out.println("The total is " + total + ".");
		}
		
		System.out.println();
		
		/*
		 * After the value has risen above 17, check the score.
		 */
		if(total > 21)
		{
			System.out.println("The Dealer has busted!");
		}
		else if(total == 21)
		{
			System.out.println("The Dealer has won!");
		}
		else if(total < 21)
		{
			System.out.println("The Dealer has lost!");
		}
	}
	
	/**
	 * Generates a String that is an abbreviation of a random card.
	 * @return An abbreviation of a random card.
	 */
	public static String generateRandomCard()
	{
		int temp = 0;
		StringBuffer response = new StringBuffer();
		
		temp = rand.nextInt(Card.cardAbbreviations.length);
		response.append(Card.cardAbbreviations[temp]);
		
		temp = rand.nextInt(Card.suitAbbreviations.length);
		response.append(Card.suitAbbreviations[temp]);
		
		return response.toString();
	}
}
