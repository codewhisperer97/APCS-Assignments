public class AlternatingSums 
{
	public static final int[] numbers = {
		1,
		2,
		3,
		4,
		5,
		6,
		7,
		8,
		9,
		10
	};
	
	/**
	 * Global int to hold the running number.
	 */
	private static int current;
	
	public static void main(String[] args) 
	{
		/*
		 * The current value is going to start at the value of the first
		 * number in the array since we want to add the first two and then
		 * swap each time from then.
		 */
		current = numbers[0];
		
		/*
		 * Loop from the SECOND position in the array to the end, operating
		 * each time and then printing.
		 */
		for(int i = 1; i < numbers.length; i++)
		{
			operate(numbers[i]);
			System.out.println(current);
		}
	}
	
	/**
	 * Adds num to current if num is even, or subtracts num from current 
	 * if num is odd.
	 * @param num The current number fed from the array.
	 */
	public static void operate(int num)
	{
		/*
		 * If the number is even.
		 */
		if((num % 2) == 0)
		{
			current += num;
		}
		/*
		 * If the number is odd.
		 */
		else
		{
			current -= num;
		}
	}
}
