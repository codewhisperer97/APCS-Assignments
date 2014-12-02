import java.awt.Rectangle;

public class GrowSquarePrinter 
{	
	public static void main(String[] args)
	{
		Rectangle baseRect = new Rectangle(100, 100, 50, 50);
		System.out.println(baseRect);
		
		baseRect.grow(25, 25);
		baseRect.translate(25, 25);
		System.out.println(baseRect);
	}
}
