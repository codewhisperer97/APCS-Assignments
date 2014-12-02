public class Bug {
	
	private int position;
	private int direction;
	
	public static void main(String[] args) {
		Bug bugby = new Bug(3, -1);
		System.out.println("Bugby starts at " + bugby.getPosition() + "!");
		bugby.move();
		bugby.move();
		bugby.move();
		System.out.println("Bugby is now at " + bugby.getPosition());
		bugby.turn();
		bugby.move();
		bugby.move();
		bugby.move();
		bugby.move();
		bugby.move();
		bugby.move();
		bugby.move();
		System.out.println("Bugby is now at " + bugby.getPosition());
	}
	
	/**
	 * This constructor accepts a parameter only for the starting position of
	 * the Bug.  We need to create a default direction, then, so that we don't
	 * leave 'direction' uninitialized.  I also created another constructor that
	 * overloads this one and accepts a parameter for direction as well.  Now
	 * the user has an option to specify the direction that the bug moves as 
	 * soon as it's constructed, or they can simply specify the initial position
	 * and the bug will move forward by default (1).
	 * @param startPos The position that the bug starts at.
	 */
	public Bug(int startPos) {
		this(startPos, 1);
	}
	
	/**
	 * The constructor that actually sets initial value to the instance variables,
	 * based on a user call or a call from an earlier constructor.
	 * @param startPos The position that the bug starts at.
	 * @param startDir The direction that the bug starts moving in (can be 
	 * either 1 or -1.  A better way to implement this would be to use a 
	 * boolean variable so that there can be no way to accidently assign the 
	 * direction to an improper value.
	 */
	public Bug(int startPos, int startDir) {
		this.position = startPos;
		this.direction = startDir;
	}
	
	/**
	 * Detects if the current direction that the bug is moving is equal to 1,
	 * and if it is, it changes to -1.  If the direction is not equal to 1, then
	 * it must be -1 and so it changes to 1.
	 */
	public void turn() {
		direction = (direction == 1 ? -1 : 1);
	}
	
	/**
	 * Since the direction is simply a number value of 1 or -1, adding that 
	 * value to the position is sufficient to make the desired change.
	 */
	public void move() {
		position += direction;
	}
	
	/**
	 * Returns the current position of the bug.
	 * @return the current position of the bug.
	 */
	public int getPosition() {
		return this.position;
	}
}
