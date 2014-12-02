public class Prime 
{
	/**
	 * Change this number to tell the cap to search for prime numbers.
	 */
	public static final int COUNT = 1000;
	
	public static void main(String[] args) 
	{
		/*
		 * For every number we're counting, if it's prime, print it.
		 */
		for(int i = 0; i < COUNT; i++)
		{
			if(isPrime(i))
			{
				System.out.println(i);
			}
		}
	}
	
	/**
	 * Checks if the parameter input is a prime number.
	 * @param number The number to check as prime.
	 * @return True if prime, false otherwise.
	 */
	private static boolean isPrime(int number)
	{
		/*
		 * This loop starts at 2 because dividing a number evenly by 1 does
		 * not make a number non-prime.  The loop counts up by 1 until just
		 * before the input number, and each time divides the number by the
		 * count of the loop.  This ensures that no number between 2 and
		 * the number can be divided evenly.
		 */
		for(int i = 2; i < number; i++)
		{
			/*
			 * If we hit a number that CAN be divided evenly, then we know
			 * that this number is not prime so we can return false and
			 * cancel the loop.
			 */
			if(number % i == 0)
			{
				return false;
			}
		}
		
		/*
		 * If the entire loop runs out and does not find a number that
		 * divides evenly, then the number must be prime.
		 */
		return true;
	}
}
