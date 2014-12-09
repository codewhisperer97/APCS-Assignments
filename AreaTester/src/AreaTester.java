import java.awt.Rectangle;

public class AreaTester 
{
	public static void main(String[] args) 
	{
		/**
		 * Creates a Rectangle object with dimensions 25, 50.
		 */
		Rectangle baseRect = new Rectangle(25, 50);
		
		System.out.println("Expected area: 1250");
		
		/*
		 * Retrieves the width and the height of the rectangle and multiplies
		 * them together.
		 */
		System.out.println("Calculated area: " + baseRect.getWidth() * baseRect.getHeight());
	}
}
