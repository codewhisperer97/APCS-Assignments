public class NumberCruncher 
{
	private double x;
	private double y;
	
	public static void main(String[] args) 
	{
		NumberCruncher cruncher = new NumberCruncher(360, 6);
		System.out.println("Sum:        " + cruncher.getSum());
		System.out.println("Difference: " + cruncher.getDifference());
		System.out.println("Product:    " + cruncher.getProduct());
		System.out.println("Average:    " + cruncher.getAverage());
		System.out.println("Absolute:   " + cruncher.getAbsoluteValue());
		System.out.println("Largest:    " + cruncher.getLargest());
		System.out.println("Smallest:   " + cruncher.getSmallest());
	}
	
	public NumberCruncher(double x, double y) 
	{
		this.x = x;
		this.y = y;
	}
	
	public double getSum() 
	{
		return x + y;
	}
	
	public double getDifference() 
	{
		return x - y;
	}
	
	public double getProduct() 
	{
		return x * y;
	}
	
	public double getAverage() 
	{
		return (x + y) / 2;
	}
	
	public double getAbsoluteValue() 
	{
		return Math.abs(x - y);
	}
	
	public double getLargest() 
	{
		return Math.max(x, y);
	}
	
	public double getSmallest() 
	{
		return Math.min(x, y);
	}
}
