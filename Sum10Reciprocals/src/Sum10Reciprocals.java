public class Sum10Reciprocals {

	public static void main(String[] args) {
		/*
		 * The first print gives a false answer
		 * because integers are being divided
		 * and the answer evaluated as an integer
		 * at each calculation.
		 */
		System.out.println(
				1/1 + 1/2 +
				1/3 + 1/4 +
				1/5 + 1/6 +
				1/7 + 1/8 +
				1/9 + 1/10);
		
		/*
		 * This calculation works because the .0 on each number
		 * indicates that the number is floating-point, and 
		 * so it manages the calculations including decimals.
		 */
		System.out.println(
				1/1.0 + 1/2.0 +
				1/3.0 + 1/4.0 +
				1/5.0 + 1/6.0 +
				1/7.0 + 1/8.0 +
				1/9.0 + 1/10.0);
	}
}