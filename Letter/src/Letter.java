public class Letter {
	
	private String body;
	private String sender;
	private String recipient;
	
	private StringBuilder builder;
	
	public static void main(String[] args) {
		Letter post = new Letter("Alex", "Aunty Cristo");
		post.addLine("It was great to see you!");
		post.addLine("How was your vacation?");
		post.addSignature();
		System.out.println(post.getText());
	}
	
	/**
	 * Creates a new letter from a sender to a recipient.
	 * @param from The sender of the letter.
	 * @param to The recipient of the letter.
	 */
	public Letter(String from, String to) {
		this.sender = from;
		this.recipient = to;
		this.builder = new StringBuilder("Dear " + recipient + ", \n");
		this.body = builder.toString();
	}
	
	/**
	 * Adds a new line to the letter.  Uses the newline special character '\n'.
	 * @param line The new text to add on a new line.
	 */
	public void addLine(String line) {
		builder.append(line).append("\n");
	}
	
	/**
	 * I put this in for fun, I figured it gave an excuse to use the sender's 
	 * name.
	 */
	public void addSignature() {
		builder.append("\n").append("Love, " + sender + ".");
	}
	
	/**
	 * Returns the text of the full letter.
	 * @return the text of the full letter.
	 */
	public String getText() {
		body = builder.toString();
		return body;
	}
}
