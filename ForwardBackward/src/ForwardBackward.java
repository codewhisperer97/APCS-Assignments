public class ForwardBackward
{
    private static int[] array = {
        0,
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9
    };
    
    public static void main(String[] args)
    {
        /*
         * Prints the array forward
         */
        for(int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
        
        System.out.println(); //Print a space for clarity
        
        /*
         * Prints the array backward
         */
        for(int i = array.length - 1; i >= 0; i--)
        {
            System.out.println(array[i]);
        }
    }
}