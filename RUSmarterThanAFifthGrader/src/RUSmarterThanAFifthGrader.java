import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RUSmarterThanAFifthGrader 
{
	private static Random rand;
	private static Scanner scanner;
	
	/**
	 * ArrayList will hold our custom Question objects, so when we initialize
	 * questions, the program will automatically ask every one without us needing
	 * to add extra code for those prompts.
	 */
	private static ArrayList<Question> questions;
	
	private static int score = 0;
	
	public static void main(String[] args) 
	{
		rand = new Random(); //Random number generator
		scanner = new Scanner(System.in); //Scanner for input
		questions = new ArrayList<Question>();
		
		System.out.println("Are you smarter than a fifth grader?");
		
		/*
		 * Below, initialize every question's prompt and correct answer.  A new
		 * Question object is created (independent of a variable) and immediately
		 * stored into the 'questions' ArrayList for storage.  The first parameter
		 * of each question is the prompt i.e. the question itself, and the
		 * second parameter is the answer to that prompt.
		 * In between each question, I call the rand.nextInt() function to give
		 * new values to our numbers so that each question has a different set
		 * of numbers in it.
		 */
		int num1 = rand.nextInt(100);
		int num2 = rand.nextInt(100);
		questions.add(new Question("What is " + num1 + " plus " + num2 + "?", new StringBuffer().append(num1 + num2).toString()));
		
		num1 = rand.nextInt(100);
		num2 = rand.nextInt(100);
		questions.add(new Question("What is " + num1 + " minus " + num2 +"?", new StringBuffer().append(num1 - num2).toString()));
		
		num1 = rand.nextInt(100);
		num2 = rand.nextInt(100);
		questions.add(new Question("What is " + num1 + " times " + num2 + "?", new StringBuffer().append(num1 * num2).toString()));
		
		num1 = rand.nextInt(100);
		num2 = rand.nextInt(100);
		questions.add(new Question("What is " + num1 + " divided by " + num2 + ", rounded down?", new StringBuffer().append(num1 / num2).toString()));
		
		num1 = rand.nextInt(100);
		num2 = rand.nextInt(100);
		questions.add(new Question("What is the remainder of " + num1 + " divided by " + num2 + "?", new StringBuffer().append(num1 % num2).toString()));
		
		String response = "";
		for(int i = 0; i < questions.size(); i++)
		{
			System.out.print(questions.get(i).getPrompt() + " ");
			response = getInput();
			if(response.equalsIgnoreCase(questions.get(i).getAnswer()))
			{
				System.out.println("Correct! The answer was " + questions.get(i).getAnswer() + "!");
				score++;
			}
			else
			{
				System.out.println("Sorry, the correct answer was " + questions.get(i).getAnswer() + ", not " + response + ".");
			}
			System.out.println();
		}
		
		System.out.println("That's all! You scored a " + score + " out of " + questions.size() + ".");
	}
	
	public static String getInput()
	{
		return scanner.next();
	}
}
