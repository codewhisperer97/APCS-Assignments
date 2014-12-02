public class Loops 
{
	public static void main(String[] args)
	{
		/*
		 * Count 0 to 5
		 */
		System.out.println("Count 0 to 5.");
		for(int i = 0; i <= 5; i++)
		{
			System.out.println(i);
		}
		System.out.println();
		
		/*
		 * Count 10 to 1
		 */
		System.out.println("Count 10 to 1.");
		for(int i = 10; i > 0; i--)
		{
			System.out.println(i);
		}
		System.out.println();
		
		/*
		 * Count 0 to 20 by 2s
		 */
		System.out.println("Count 0 to 20 by 2s.");
		for(int i = 0; i <= 20; i += 2)
		{
			System.out.println(i);
		}
		System.out.println();
		
		/*
		 * Fibonacci Sequence
		 */
		System.out.println("Fibonacci Sequence.");
		int temp = 1;
		int prev = 1;
		int current = 1;
		for(int i = 0; i <= 10; i++)
		{
			System.out.println(current);
			temp = current + prev;
			prev = current;
			current = temp;
		}
		System.out.println();
	}
}
