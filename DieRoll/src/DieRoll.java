import java.util.Random;

public class DieRoll 
{
	public static final int NUM_ROLLS = 60;

	private static Random rand;
	private static int[] rolls = {
		0,
		0,
		0,
		0,
		0,
		0,
	};
	
	public static void main(String[] args)
	{
		rand = new Random();
		
		/*
		 * Loop the NUM_ROLLS number of times.  This is how many
		 * times the die is thrown.
		 */
		int roll = 0;
		for(int i = 0; i < NUM_ROLLS; i++)
		{
			roll = getRoll();
			for(int j = 1; j <= 6; j++)
			{
				if(roll == j)
				{
					/*
					 * Use J-1 because arrays start at 0
					 * and the die starts at 1.
					 */
					rolls[j-1]++;
				}
			}
		}
		
		for(int i = 0; i < rolls.length; i++)
		{
			System.out.println("A " + (i+1) + " was thrown " + rolls[i] + " time(s).");
		}
	}
	 /**
	  * Returns a random number between 1 and 6 inclusive
	  * @return A random number between 1 and 6 inclusive
	  */
	private static int getRoll()
	{
		return rand.nextInt(6) + 1;
	}
}
