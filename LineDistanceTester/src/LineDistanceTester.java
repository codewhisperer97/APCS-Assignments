import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class LineDistanceTester 
{
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();
		
		frame.setSize(300, 400);
		frame.setTitle("Frame with a Line!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Draw the line from point (100, 100) to (200, 200)
		LineComponent line = new LineComponent(100, 100, 200, 200);
		frame.add(line);
		
		/*
		 * I had difficulty here.  I tried making a separate JComponent class
		 * to use Point2D, until I realized that Point2D did not implement
		 * Shape and therefore could not be passed to g2.draw().  I looked
		 * online and saw a suggestion to simply generate a line whose start
		 * and end point were the same, but when I did that, the JFrame
		 * showed up totally blank, erasing even the first line (which had been
		 * drawn successfully until I added this).
		 */
		//LineComponent point = new LineComponent(250, 50, 250, 50);
		//frame.add(point);
		//LineComponent point2 = new LineComponent(100, 200, 100, 200);
		//frame.add(point2);
		
		frame.setVisible(true);
	}
	
	public static class LineComponent extends JComponent 
	{	
		/*
		 * Member variables.  I am wondering if the fact that this class is
		 * static is the problem with drawing more than one element.  I tried
		 * running this class without being static, but something about being
		 * instantiated inside of a static method (main) caused it to throw an
		 * error, yet it would work when I made this static.  The problem might
		 * be that I'm trying to use this static class as an object. 
		 */
		int mX1 = 0;
		int mY1 = 0;
		int mX2 = 0;
		int mY2 = 0;
		Line2D.Double segment;
		
		/**
		 * Constructor for LineComponent, which records segment endpoint values
		 * and then creates a Line2D.Double object with those coodinates.
		 */
		public LineComponent(int x1, int y1, int x2, int y2) {
			mX1 = x1;
			mY1 = y1;
			mX2 = x2;
			mY2 = y2;
			segment = new Line2D.Double(mX1, mY1, mX2, mY2);
		}
		
		/**
		 * This method is overriden (I assume from JComponent or higher) and
		 * delivers the Graphics object which we draw with.  I simply passed it
		 * the Line2D.Double object that was created in the constructor.
		 */
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.draw(segment);
		}
	}
}
