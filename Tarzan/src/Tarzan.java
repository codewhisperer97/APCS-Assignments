public class Tarzan 
{
	public static final String[] words = {
		"Tarzan ",
		"loves ",
		"Jane "
	};
	
	public static void main(String[] args) 
	{
		listForward();
		listBackward();
	}
	
	/**
	 * Prints the contents of the String array starting at 0.
	 */
	public static void listForward()
	{
		/*
		 * Loop that cycles from 0 to the max size of the array.
		 */
		for(int i = 0; i < words.length; i++)
		{
			System.out.print(words[i]);
		}
		System.out.println();
	}
	
	/**
	 * Prints the contents of the String array starting at the max size to 0.
	 */
	public static void listBackward()
	{
		/*
		 * Loop that cycles from the max size of the array to 0.
		 */
		for(int i = (words.length - 1); i >= 0; i--)
		{
			System.out.print(words[i]);
		}
		System.out.println();
	}
}
