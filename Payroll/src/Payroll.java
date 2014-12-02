public class Payroll 
{
	public static final double TAX = 0.30;
	
	/**
	 * OVERTIME is a constant because depending on the company and the case, we
	 * may want easy access to change what is considered the 'overtime' limit.
	 * Changing this will alter the time that will start the overtime pay.
	 */
	public static final int OVERTIME = 40;
	
	private double hours;
	private double payPerHour;
	private double grossPay;
	private double netPay;
	
	public static void main(String[] args) 
	{
		Payroll john = new Payroll(45.0, 10.0);
		System.out.println("John's gross pay is : " + john.getGrossPay());
		System.out.println("John's net pay is: " + john.getNetPay());
	}
	
	public Payroll(double hoursWorked, double hourlyRate)
	{
		hours = hoursWorked;
		payPerHour = hourlyRate;
		
		/*
		 * If our employee didn't work, s/he certainly doesn't deserve to get
		 * paid.
		 */
		if(hours <= 0)
		{
			grossPay = 0;
			netPay = 0;
		}
		
		/*
		 * If the employee worked overtime, pay them accordingly.
		 */
		else if(hours > OVERTIME)
		{
			double basePay = OVERTIME * payPerHour;
			double bonus = (hours - OVERTIME) * (payPerHour * 2);
			
			grossPay = basePay + bonus;
			netPay = grossPay - (grossPay * TAX);
		}
		
		/*
		 * If they didn't work overtime, then they worked within normal hours.
		 */
		else
		{
			grossPay = hours * payPerHour;
			netPay = grossPay - (grossPay * TAX);
		}
	}
	
	public double getGrossPay()
	{
		return grossPay;
	}
	
	public double getNetPay()
	{
		return netPay;
	}
}