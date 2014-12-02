public class Greeter 
{
	private String name;
	
	public static void main(String[] args) 
	{
		Greeter greeter = new Greeter("George");
		System.out.println(greeter.sayHello());
		System.out.println(greeter.sayGoodbye());
		System.out.println(greeter.refuseHelp());
	}

	public Greeter(String name) 
	{
		this.name = name;
	}
	
	public String sayHello() 
	{
		return "Hello, " + name + "!";
	}
	
	public String sayGoodbye() 
	{
		return "Goodbye, " + name + "!";
	}
	
	public String refuseHelp() 
	{
		return "I'm sorry, " + name + ", I'm afraid I can't do that";
	}
}
