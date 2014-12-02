import java.awt.Rectangle;

public class AreaTester 
{
	public static void main(String[] args) 
	{
		Rectangle baseRect = new Rectangle(25, 50);
		
		System.out.println("Expected area: 1250");
		System.out.println("Calculated area: " + baseRect.getWidth() * baseRect.getHeight());
	}
}
