public class Student 
{
	private String name;
	private double totalQuizScore;
	private int numberOfQuizzesTaken;
	
	/**
	 * Main
	 * @param args Program execution arguments.
	 */
	public static void main(String[] args) {
		Student josh = new Student("Josh", 96);
		System.out.println(josh.getName() + "'s average is " + josh.getAverage());
		josh.addQuiz(99);
		josh.addQuiz(82);
		josh.addQuiz(101);
		josh.addQuiz(92);
		josh.setNumQuizzes(5);
		System.out.println("At mid-term, " + josh.getName() + "'s average is " + 
				josh.getAverage());
	}
	
	/**
	 * Constructs a new student, specifying their name and the score of the
	 * first quiz they have taken.
	 * @param name The student's name.
	 * @param firstQuiz The student's first quiz score.
	 */
	public Student(String name, double firstQuiz) {
		this.name = name;
		this.totalQuizScore = firstQuiz;
		this.numberOfQuizzesTaken = 1;
	}
	
	/**
	 * Returns the name of the student.
	 * @return the name of the student.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the added total of all quizzes this student has taken.
	 * @return the added total of all quizzes this student has taken.
	 */
	public double getTotalScore() {
		return this.totalQuizScore;
	}
	
	/**
	 * Adds a score for a new quiz taken.  A good option would be to have this
	 * method automatically add one to the 'numberOfQuizzesTaken' variable, but
	 * I'll leave it for the sake of keeping to the exercise.  Also, seeing as 
	 * 'totalQuizScore' is a double, it may have been better to have this method
	 * accept a double instead of an int for consistency.
	 * @param score The score of the newly added quiz.
	 */
	public void addQuiz(int score) {
		this.totalQuizScore += score;
	}
	
	/**
	 * Sets the number of quizzes taken by this particular student.  This is
	 * probably a sloppy implementation of this purpose, because each time
	 * assigning a number can be a fault point from the user if they are
	 * unaware of the previous total number of quizzes taken.  A better solution
	 * would be to have the number of quizzes recorded handled by the method
	 * that adds the actual score of the quiz.
	 * @param number The new total number of quizzes taken by this student.
	 */
	public void setNumQuizzes(int number) {
		this.numberOfQuizzesTaken = number;
	}
	
	/**
	 * Returns the average score of quizzes taken by this student.
	 * @return the average score of quizzes taken by this student.
	 */
	public double getAverage() {
		return this.totalQuizScore / this.numberOfQuizzesTaken;
	}
}
