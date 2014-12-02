public class MonthNumber {
	
	/*
	 * Create Month Constants in order to see that the whitespace on each
	 * word lines up.  These are later put together into the MONTHS constant.
	 */
	public static final String JANUARY   = "January  ";
	public static final String FEBRUARY  = "February ";
	public static final String MARCH     = "March    ";
	public static final String APRIL     = "April    ";
	public static final String MAY       = "May      ";
	public static final String JUNE      = "June     ";
	public static final String JULY      = "July     ";
	public static final String AUGUST    = "August   ";
	public static final String SEPTEMBER = "September";
	public static final String OCTOBER   = "October  ";
	public static final String NOVEMBER  = "November ";
	public static final String DECEMBER  = "December ";

	/*
	 * Combines all month names into a single constant
	 */
	public static final String MONTHS = JANUARY   + 
										FEBRUARY  +
										MARCH     +
										APRIL     +
										MAY       +
										JUNE      +
										JULY      +
										AUGUST    +
										SEPTEMBER +
										OCTOBER   +
										NOVEMBER  +
										DECEMBER;
	
	public static void main(String[] args) {
		MonthNumber month = new MonthNumber();
		
		System.out.println(month.getMonth(1));
		System.out.println(month.getMonth(2));
		System.out.println(month.getMonth(3));
		System.out.println(month.getMonth(4));
		System.out.println(month.getMonth(5));
		System.out.println(month.getMonth(6));
		System.out.println(month.getMonth(7));
		System.out.println(month.getMonth(8));
		System.out.println(month.getMonth(9));
		System.out.println(month.getMonth(10));
		System.out.println(month.getMonth(11));
		System.out.println(month.getMonth(12));
	}
	
	/**
	 * Empty constructor! Yay!
	 */
	public MonthNumber() {
		
	}
	
	/**
	 * Retrieves the month name based on the number. Range is 1-12.  Trim is 
	 * added to remove whitespace.
	 * @param monthNum
	 * @return
	 */
	public String getMonth(int monthNum) {
		return MONTHS.substring((monthNum - 1) * 9, (monthNum * 9)).trim();
	}
}
