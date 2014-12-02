import java.util.Scanner;

public class GradeTranslator 
{
	/*
	 * Creates constants named for each letter grade with the corresponding
	 * GPA value.  The INC is a constant increment of the variation for each
	 * grade if it is a + or -.
	 */
	public static final double A = 4.0;
	public static final double B = 3.0;
	public static final double C = 2.0;
	public static final double D = 1.0;
	public static final double F = 0.0;
	public static final double INC = 0.3;
	
	private Scanner scanner;
	
	public static void main(String[] args) 
	{
		GradeTranslator translator = new GradeTranslator();
		
		/*
		 * The getGPA method returns a double value which represents the GPA
		 * of the letter grade, but if an error occurs in the interpretation
		 * of the input, then getGPA will return -1.0 to represent the error.
		 * Thus, this while loop will continue until the getGPA method returns
		 * a proper value and not an error.
		 */
		while(translator.getGPA(translator.getRawGrade()) == -1.0);
	}
	
	/**
	 * Constructor initializes 'scanner' object to read input.
	 */
	public GradeTranslator() 
	{
		scanner = new Scanner(System.in);
	}
	
	/**
	 * Retrieves user input.
	 * @return A string with the letter grade (and sign if included).
	 */
	public String getRawGrade() {
		System.out.print("Please enter letter grade: ");
		return scanner.next();
	}
	
	/**
	 * Calculates the GPA of a letter grade given by parameter.
	 * @param letterGrade The raw letter grade (including sign if needed).
	 * @return The calculated GPA from the letter grade, or -1.0 if the 
	 * letterGrade parameter is not the correct format (e.g. the letter is not
	 * A-F or the string is less than 1 character long).
	 */
	public double getGPA(String letterGrade) 
	{
		if(letterGrade.length() >= 1 && letterGrade.length() <= 2)
		{
			/*
			 * Parses the 'letter' from the raw letterGrade using substring.
			 */
			String letter = letterGrade.substring(0, 1);
			double gpa = 0.0;
		
			/*
			 * 'If' tree which matches the letter to the base GPA
			 */
			if(letter.toLowerCase().equals("a")) 
			{
				gpa += A;
			} 
			else if(letter.toLowerCase().equals("b"))
			{
				gpa += B;
			}
			else if(letter.toLowerCase().equals("c"))
			{
				gpa += C;
			}
			else if(letter.toLowerCase().equals("d"))
			{
				gpa += D;
			}
			else if(letter.toLowerCase().equals("f"))
			{
				gpa += F;
			}
			else
			{
				/*
				 * If the first character is not a letter A-F, print an error
				 * and return -1.0.
				 */
				System.out.println("Improper input; No letter found!");
				return -1.0;
			}
			
			/*
			 * If the letterGrade string has two characters, substring the
			 * second character as the 'sign' and compare it to match + or -.
			 */
			if(letterGrade.length() == 2)
			{
				String sign = letterGrade.substring(1, 2);
				
				/*
				 * If the sign is +, add the incremental points AS LONG AS
				 * the grade is not an A (4.0) or an F (0.0).
				 */
				if(sign.equals("+") && !(gpa == 4.0) && !(gpa == 0.0))
				{
					gpa += INC;
				}
				/*
				 * If the sign is -, subtract incremental points AS LONG AS
				 * the grade is not an F (0.0).
				 */
				else if(sign.equals("-") && !(gpa == 0.0))
				{
					gpa -= INC;
				}
				else
				{
					System.out.println("Unrecognized sign! Reverting to base letter grade.");
				}
			}
			
			System.out.println("GPA: " + gpa);
			return gpa;
		}
		else
		{
			System.out.println("Improper input; String size out of bounds!");
			return -1.0;
		}
	}
}
