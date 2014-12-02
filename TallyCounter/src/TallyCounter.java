public class TallyCounter 
{
	private static TallyCounter counter;
	private int count;
	
	public TallyCounter() {
		count = 0;
	}
	
	public static void main(String[] args) 
	{
		counter = new TallyCounter();
		
		counter.click();
		counter.click();
		counter.click();
		counter.click();
		
		System.out.println("Count: " + counter.getCount());
		
		counter.undo();
		counter.undo();
		counter.undo();
		
		System.out.println("Count: " + counter.getCount());
		
		counter.undo();
		counter.undo();
		counter.undo();
		counter.undo();
		
		System.out.println("Count: " + counter.getCount());
	}
	
	public void click() {
		count++;
	}
	
	public void undo() {
		if(count > 0) {
			count--;
		}
	}
	
	public int getCount() {
		return count;
	}
}
