import java.awt.Rectangle;

public class Rectangle42 
{
	public static void main(String[] args) 
	{
		Rectangle areaRect = new Rectangle(6, 7);
		Rectangle perimeterRect = new Rectangle(20, 1);
		
		System.out.println("Rectangle of Area 42: Width = " + 
						 areaRect.getWidth() + "; Height = " +
						 areaRect.getHeight());
		
		System.out.println("Rectangle of Perimeter 42: Width = " +
						   perimeterRect.getWidth() + "; Height = " +
						   perimeterRect.getHeight());
	}
}
