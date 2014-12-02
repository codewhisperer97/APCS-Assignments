import java.awt.Color;

import javax.swing.JFrame;

public class BrighterDemo 
{
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		Color myColor = new Color(50, 100, 150);
		
		System.out.println(myColor);  //Used to print initial color
		myColor = myColor.brighter();
		System.out.println(myColor);  //Used to print brighter color
		
		frame.getContentPane().setBackground(myColor);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
