public class MathFunctions 
{
	public static void main(String[] args) 
	{
		System.out.println("Using custom methods:");
		System.out.println("Minimum of 3 and 5: " + min(3, 5));
		System.out.println("Maximum of 3 and 5: " + max(3, 5));
		System.out.println("Absolute of -4: " + absolute(-4));
		
		System.out.println();
		System.out.println("Using java Math methods:");
		System.out.println("Square root of 144: " + Math.sqrt(144));
		System.out.println("Cube root of 27: " + Math.cbrt(27));
		System.out.println("Absolute Value of -15: " + Math.abs(-15));
		System.out.println("123 to the 4th: " + Math.pow(123, 4));
		System.out.println("90 degrees in radians: " + Math.toRadians(90));
		System.out.println("3.7653 rounded to integer: " + Math.round(3.7653));
	}
	
	public static int min(int num1, int num2)
	{
		return (num1 < num2) ? num1 : num2; 
	}
	
	public static int max(int num1, int num2)
	{
		return (num1 > num2) ? num1 : num2;
	}
	
	public static int absolute(int num1)
	{
		return (num1 < 0) ? -num1 : num1;
	}
}
