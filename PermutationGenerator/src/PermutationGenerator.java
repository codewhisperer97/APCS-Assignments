import java.util.ArrayList;
import java.util.Random;

public class PermutationGenerator 
{
	private int mLength;
	private ArrayList<Integer> baseArray;
	private int[] permArray;
	private Random rand;
	
	public PermutationGenerator(int length)
	{
		mLength = length;
		baseArray = new ArrayList<Integer>();
		permArray = new int[mLength];
		rand = new Random();
	}
	
	private void initBaseArray()
	{
		baseArray.clear();
		
		for(int i = 0; i < mLength; i++)
		{
			baseArray.add(new Integer(i + 1));
		}
	}
	
	public int[] nextPermutation()
	{
		initBaseArray();
		permArray = new int[mLength];
		int index = 0;
		for(int i = 0; i < permArray.length; i++)
		{
			index = rand.nextInt(baseArray.size());
			permArray[i] = baseArray.get(index);
			baseArray.remove(index);
		}
		return permArray;
	}
}
