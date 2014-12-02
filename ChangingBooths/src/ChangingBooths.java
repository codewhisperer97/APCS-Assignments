import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ChangingBooths 
{
	public static final int ERROR = -1;
	
	private static Scanner scanner;
	private static Random rand;
	
	private static int booths = 0;
	private static boolean prioritizeEnds = false;
	private static boolean[] list;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		rand = new Random();
		
		booths = getNumBooths();
		prioritizeEnds = getPriority();
		System.out.println("There " + (booths == 1 ? "is " : "are ") + booths + (booths == 1 ? " booth." : " booths."));
		
		/*
		 * Create a boolean array that is as large as our number of booths. Then,
		 * fill each slot of the array with false to indicate empty booths.
		 */
		list = new boolean[booths];
		for(int i = 0; i < list.length; i++)
		{
			list[i] = false;
		}
		
		/**
		 * ArrayList to hold all of the Series objects created from
		 * scanning the booths.
		 */
		ArrayList<Series> series = new ArrayList<Series>();
		/**
		 * ArrayList to hold all ties for the longest Series of empty booths.
		 */
		ArrayList<Series> largest = new ArrayList<Series>();
		Series current;
		int start;
		int end;
		/**
		 * The 'largest' ArrayList is going to hold all of the Series OBJECTS that
		 * are tied for the largest value, but as we're scanning, we may find
		 * a Series that is larger than all of them.  Rather than scanning the
		 * ArrayList each time, this int will keep track of the value that all
		 * of the Series are tied for in the 'largest' ArrayList.  If a newly
		 * Scanned Series is larger than this, then we'll dump all values in the
		 * 'largest' list so far and start over.  That way by the end of the
		 * scanning, we'll only have Series that are tied for the longest remaining
		 * in that ArrayList.
		 */
		int largestSize;
		int selector;
		boolean newBooth;
		
		/*
		 * This while loop will continue for as long as not all of the booths
		 * are full.
		 */
		System.out.println(getBoothRep());
		while(!boothsFull())
		{
			/*
			 * Every time we start another scan, reset all analyzing variables.
			 */
			series.clear();
			largest.clear();
			start = -1;
			end = -1;
			largestSize = -1;
			selector = -1;
			newBooth = true;
			
			/*
			 * This for loop will count once through each index of list.  When
			 * it finds a slot that is empty (false), it will create a new Series object
			 * and store it as the 'start' position of a new Series object, then
			 * it will continue until it finds a full (true) slot and place the
			 * last empty slot as the 'end' position of the Series.  Then it
			 * will store that new Series object in the series ArrayList and
			 * continue until it has created a Series object for each time there
			 * is a gap of empty booths.
			 */
			for(int i = 0; i < list.length; i++)
			{
				/*
				 * If this booth is empty, and it is not part of an existing
				 * series, mark it as the start of a new series and flag
				 * 'newBooth' as false so that the next discovered booth is
				 * counted as part of THIS series rather than a new one.
				 */
				if(!list[i] && newBooth)
				{
					newBooth = false;
					start = i;
				}
				
				/*
				 * If this booth is full but the existing series has not been
				 * marked finished, then we've reached the end of that series
				 * of booths.  Mark that the next booth to be empty will be a
				 * start of a new series by setting 'newBooth' to true, then
				 * complete the previous Series object with its end position
				 * and store it into our series ArrayList.
				 */
				if(list[i] && !newBooth)
				{
					newBooth = true;
					/*
					 * This booth is full, so it itself is not part of the past
					 * series, the one before it was.
					 */
					end = i - 1;
					
					/*
					 * Create a new Series object with the proper start and
					 * end, then add it to the series ArrayList.
					 */
					series.add(new Series(start, end));
				}
				
				/*
				 * If we reach the end of the list without hitting a full booth,
				 * then all of the booths are empty and the series should be the
				 * entire line of booths, or the series we're on extends from
				 * some point all the way to the edge of the line of stalls.
				 */
				if(i == (list.length - 1) && newBooth == false)
				{
					/*
					 * All of the booths INCLUDING THIS ONE are empty, so this
					 * one does become part of the Series.
					 */
					end = i;
					
					/*
					 * Create a new Series object with the proper start and
					 * end, then add it to the series ArrayList.
					 */
					series.add(new Series(start, end));
				}
			}
			
			/*
			 * For every series of empty booths we detected, we need to sort
			 * those series by how large they are, i.e. what is the longest
			 * length of empty booths in a a row.  If we detect that a new series
			 * is tied to another series for the longest length, then the new
			 * series is added into an ArrayList with the existing largest
			 * series.  If a newly detected series is larger than the existing
			 * largest series, then we clear() the ArrayList with the previously
			 * largest series in it and add the newly dominant large series.
			 */
			for(int i = 0; i < series.size(); i++)
			{
				current = series.get(i);
				
				/*
				 * If the currently analyzed series is tied for largeness with
				 * the existing largest series, then just add it to a list to 
				 * be 'tied' with the other largest series.
				 */
				if(current.getSize() == largestSize)
				{
					largest.add(current);
				}
				/*
				 * If the currently analyzed series is LARGER than the previously
				 * largest, then dump all of the previously largest series and
				 * replace them with this newest one.
				 */
				else if(current.getSize() > largestSize)
				{
					largestSize = current.getSize();
					largest.clear();
					largest.add(current);
				}
				
				/*
				 * If the series was smaller than the largest ones, then do
				 * nothing with them because they'd put us closer to an occupied
				 * stall.
				 */
			}
			
			/*
			 * Now that we have an ArrayList of all of our largest series, we
			 * can finally choose one and place a person in the center of that
			 * series.
			 */
			selector = rand.nextInt(largest.size());
			list[largest.get(selector).getPoint(prioritizeEnds)] = true;
			
			System.out.println(getBoothRep());
		}
	}
	
	/**
	 * Method to return a valid, in-range integer of how many booths are present
	 * in the scenario.  This method calles _getNumBooths() which allows it to
	 * perform step-by-step sanitation:
	 * First, __getNumBooths() makes sure that the number retrieved from the 
	 * scanner is a properly parsed Integer.
	 * Second, _getNumBooths() makes sure that the number is within the range that
	 * we want for this purpose, namely, greater than 0.
	 * @return The sanitized input.
	 */
	public static int getNumBooths()
	{
		int response = ERROR;
		System.out.print("How many booths? ");
		
		while((response = _getNumBooths()) < 1)
		{
			System.out.println("Can't be less than 1! Try again: ");
		}
		return response;
	}
	
	private static int _getNumBooths()
	{
		int response = ERROR;
		
		while((response = __getNumBooths()) == ERROR)
		{
			System.out.print("Not an integer! Try again: ");
		}
		return response;
	}
	
	private static int __getNumBooths()
	{
		int response = ERROR;
		
		try
		{
			response = Integer.parseInt(scanner.next());
		}
		catch(Exception e)
		{
			/*
			 * If this portion of the code is run, then there was an error
			 * parsing the String input into an Integer, so it should return
			 * an error.  I'm resetting 'response' to ERROR here in case there's
			 * a weird change in the try block.
			 */
			response = ERROR;
		}
		return response;
	}
	
	private static boolean getPriority()
	{
		String response = "";
		boolean priority = false;
		boolean success = false;
		System.out.print("Should we prioritize the middle (M) or ends (E) of segments? ");
		
		while(!success)
		{
			response = scanner.next();
			if(!response.equalsIgnoreCase("M") && !response.equalsIgnoreCase("E"))
			{
				System.out.println("Please type M for middle or E for end: ");
			}
			else if(response.equalsIgnoreCase("M"))
			{
				priority = false;
				success = true;
			}
			else if(response.equalsIgnoreCase("E"))
			{
				priority = true;
				success = true;
			}
		}
		return priority;
	}
	
	private static String getBoothRep()
	{
		StringBuffer response = new StringBuffer();
		for(int i = 0; i < list.length; i++)
		{
			response.append(list[i] ? "X" : "-").append("");
		}		
		return response.toString();
	}
	
	/**
	 * Single-purpose method to determine whether all booths are full so that
	 * we know when to stop execution.
	 * @return True if all booths are full, false otherwise.
	 */
	private static boolean boothsFull()
	{
		for(int i = 0; i < list.length; i++)
		{
			if(list[i] == false)
			{
				return false;
			}
		}
		return true;
	}
	
	public static int getFirstBooth()
	{
		return 0;
	}
	
	public static int getLastBooth()
	{
		return list.length - 1;
	}
	
	public static boolean isFull(int boothNum)
	{
		if(boothNum < 0)
		{
			return false;
		}
		
		if(boothNum >= list.length)
		{
			return false;
		}
		
		return list[boothNum];
	}
}
