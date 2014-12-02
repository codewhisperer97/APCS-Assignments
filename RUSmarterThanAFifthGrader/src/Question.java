/**
 * The Question class holds String values of our desired prompts and questions.
 * This deserved its own class because each set of a prompt and question are
 * related to each other, thus putting them into an object together makes them
 * easy to store in mass in an ArrayList, while preserving their relationship
 * to one another.
 * @author Nick Mosher
 */
public class Question 
{
	private String prompt;
	private String answer;
	
	public Question()
	{
		prompt = "";
		answer = "";
	}
	
	public Question(String p, String a)
	{
		prompt = p;
		answer = a;
	}
	
	public void setPrompt(String p)
	{
		prompt = p;
	}
	
	public void setAnswer(String a)
	{
		answer = a;
	}
	
	public String getPrompt()
	{
		return prompt;
	}
	
	public String getAnswer()
	{
		return answer;
	}
}
