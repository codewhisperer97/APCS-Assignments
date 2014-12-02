import java.awt.Rectangle;

public class FourRectanglePrinter 
{
	public static void main(String[] args) 
	{
		Rectangle rectangle = new Rectangle(5, 12);
		System.out.println(rectangle);
		
		rectangle.translate(5, 0);
		System.out.println(rectangle);
		
		rectangle.translate(-5, 12);
		System.out.println(rectangle);
		
		rectangle.translate(5, 0);
		System.out.println(rectangle);
	}
}