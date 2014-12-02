import java.util.Random;

public class RandomWalk 
{
	private static Random rand;
	private static int position = 0;
	
	public static void main(String[] args) 
	{
		rand = new Random();
		
		boolean direction = false;
		for(int i = 0; i < 100; i++)
		{
			position += ((direction = rand.nextBoolean()) ? 1 : -1);
			System.out.println("Going " + (direction ? "forward" : "backward") +
					" to " + position);
		}
		
		System.out.println("Final position is " + position + ".");
	}
}