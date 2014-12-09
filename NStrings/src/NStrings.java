public class NStrings
{
    public static final int N = 6;
    
    private static String[] original = {
        "o",
        "r",
        "i",
        "g",
        "i",
        "n",
        "a",
        "l"
    };
    
    private static String[] enhanced;
    
    public static void main(String[] args)
    {
        enhanced = new String[N];
        
        if(enhanced.length <= original.length)
        {
            for(int i = 0; i < enhanced.length; i++)
            {
                enhanced[i] = original[i];
            }
        }
        else
        {
            System.out.println("New list is too large!");
        }
        
        for(int i = 0; i < enhanced.length; i++)
        {
            System.out.println(enhanced[i]);
        }
    }
}