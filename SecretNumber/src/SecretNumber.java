import java.util.Random;

public class SecretNumber {
	
	/**
	 * Hardcoded guess.
	 */
	public static final int GUESS = 2;
	
	private Random rand = new Random();
	private int secretNum;
	
	public static void main(String[] args) {
		SecretNumber secret = new SecretNumber();
		secret.checkNum(GUESS);
	}
	
	 /**
	  * Constructor that generates a random number.
	  * rand.nextInt(5) generates a range of possibilities of 0-4 rather than
	  * the desired 1-5, so I simply added 1 to the result of the generated
	  * number.
	  * Also, I added a print statement here for debugging purposes so that I
	  * could tell what the true number was.  I'll leave it so that future 
	  * viewers can also see the 'internal workings'.
	  */
	public SecretNumber() {
		secretNum = rand.nextInt(5) + 1;
		System.out.println("Random (secret) number is: " + secretNum);
	}
	
	/**
	 * Compares if the guessed number was in fact the secret number and prints
	 * a message that says whether it is or not.
	 * @param guess The number that the 'user' guessed.
	 */
	public void checkNum(int guess) {
		if(guess == secretNum) {
			System.out.println("Correct! The number was " + secretNum + "!");
		} else {
			System.out.println("Sorry, " + guess + " was not the secret number!");
		}
	}
}
