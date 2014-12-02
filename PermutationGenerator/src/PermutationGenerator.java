import java.util.ArrayList;
import java.util.Random;

public class PermutationGenerator 
{
	private static ArrayList<Integer> data;
	private static Random rand;
	
	public static void main(String[] args) 
	{
		data = new ArrayList<Integer>();
		rand = new Random();
		
		for(int i = 1; i <= 10; i++)
		{
			data.add(new Integer(i));
		}
		
		for(int i = 0; i < data.size(); i++)
		{
			System.out.println(data.get(i));
		}
		
		int index = -1;
		int size = -1;
		for(int i = 0; i < data.size(); i++)
		{
			System.out.println("Data=" + data.get(index = rand.nextInt(size = data.size())));
			data.remove(index);
		}
	}
}
