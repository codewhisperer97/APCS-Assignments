public class LeapYear 
{
	public static final int TEST_YEAR = 2017;
	
	public static void main(String[] args) 
	{
		Year someYear = new Year(TEST_YEAR);
		System.out.println("The year is " + someYear.getYear() +
						   " and it " + ((someYear.isLeapYear()) ? "is" : "is not") +
						   " a leap year!");
	}
}