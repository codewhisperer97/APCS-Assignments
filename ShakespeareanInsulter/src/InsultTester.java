public class InsultTester
{
    private static Insulter insulter;
    
    public static void main(String[] args)
    {
        insulter = new Insulter();
        System.out.println(insulter.getInsult());
    }
}