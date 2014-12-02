import java.awt.Rectangle;

public class IntersectionPrinter 
{
	public static void main(String[] args) 
	{
		Rectangle baseRectangle = new Rectangle(10, 10);
		Rectangle secondRectangle = new Rectangle(5, 5, 10, 10);
		
		Rectangle intersectRectangle = baseRectangle.intersection(
				secondRectangle);
		
		System.out.println(intersectRectangle);
		
		/*
		 * To determine if the intersectRectangle is empty, you can call the
		 * isEmpty() method from the Rectangle class, which returns a boolean
		 * value indicating whether the particular rectangle is empty.
		 */
	}
}
