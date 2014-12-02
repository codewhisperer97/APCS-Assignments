import java.util.Random;

/**
 * The Series class creates objects that are used to keep information about
 * sets of empty rows of booths.  Every time there is a sequence of empty booths
 * in a row, a Series is created with details about that section, such as it's
 * start, end, size, and where you would place a person in it.
 * @author Nick Mosher
 */
public class Series 
{
	private Random rand;
	
	private int start = -1;
	private int end = -1;
	
	public Series(int start, int end)
	{
		rand = new Random();
		
		this.start = start;
		this.end = end;
		
		/*
		 * Print errors if the start is below 0 or if the end is less than
		 * the start.  Used for debugging, should never trigger once the program
		 * is completed.
		 */
		if(start < 0 || end < 0)
		{
			System.out.println("Series Index out of bounds!");
		}
		if((end - start) < 0)
		{
			System.out.println("Series size error!");
		}
	}
	
	/**
	 * Returns the size of all booths in this series.
	 * @return The size of all booths in this series.
	 */
	public int getSize()
	{
		return (end - start) + 1;
	}
	
	/**
	 * Returns the coordinate of the point to place a person at.
	 * @return The coordinate of the point to place a person at.
	 */
	public int getPoint(boolean prioritizeEnds)
	{
		int point = (start + end) / 2;
		
		/*
		 * If this series is on the edge of the whole row of booths, check to 
		 * see if either of the end booths is full.  If they are both empty, then
		 * we choose one at random and fill it.  If only one is full, we fill it.
		 * If neither is full, then we skip down to where we choose a midpoint.
		 */
		if(isEdge() && prioritizeEnds)
		{
			/*
			 * If this series contains both end booths in the ENTIRE line of
			 * booths and they're both empty, then choose one at random to fill.
			 */
			if(start == ChangingBooths.getFirstBooth() && end == ChangingBooths.getLastBooth())
			{
				if(!ChangingBooths.isFull(start) && !ChangingBooths.isFull(end))
				{
					return rand.nextBoolean() ? start : end;
				}
			}
			/*
			 * If this series only contains the first booth and it's empty, fill it
			 */
			else if(start == ChangingBooths.getFirstBooth())
			{
				if(!ChangingBooths.isFull(start))
				{
					return start;
				}
			}
			/*
			 * If this series only contains the last booth and it's empty, fill it
			 */
			else if(end == ChangingBooths.getLastBooth())
			{
				if(!ChangingBooths.isFull(end))
				{
					return end;
				}
			}
		}
		else 
		{
			/*
			 * If the series has an even number of booths, then choose one from the
			 * center two at random.  If there's an odd number, then leave the
			 * choice at the direct center.
			 */
			if(getSize() % 2 == 0)
			{
				point += getChanger();
			}
		}
		return point;
	}
	
	/**
	 * If the series has an even number of booths, then there will be two booths
	 * equally close to the "center", so this method returns either 0 or 1 to 
	 * be added to the lower of the two center ones, effectively picking one
	 * at random.
	 * @return 0 or 1 at random.
	 */
	public int getChanger() 
	{
		return rand.nextInt(2);
	}
	
	/**
	 * Returns the start coordinate of this series.
	 * @return The start coordinate of this series.
	 */
	public int getStart()
	{
		return start;
	}
	
	/**
	 * Returns the end coordinate of this series.
	 * @return The end coordinate of this series.
	 */
	public int getEnd()
	{
		return end;
	}
	
	/**
	 * Detects if this series is located at either edge of the entire line of booths.
	 * @return True if next to an edge, false otherwise.
	 */
	public boolean isEdge()
	{
		return start == ChangingBooths.getFirstBooth() || end == ChangingBooths.getLastBooth();
	}
}
