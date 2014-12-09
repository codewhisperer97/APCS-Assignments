import java.util.Random;

public class Scores
{
    public static final int ARRAY_SIZE = 3;
    
    private static Random rand;
    private static int[] array;
    
    public static void main(String[] args)
    {
        array = new int[ARRAY_SIZE];
        rand = new Random();
        
        for(int i = 0; i < array.length; i++)
        {
            System.out.println(array[i] = rand.nextInt(10));
        }
        
        System.out.println("Scores increasing: " + scoresIncreasing(array));
    }
    
    public static boolean scoresIncreasing(int[] scores)
    {
        int prev = -1;
        
        for(int i = 0; i < scores.length; i++)
        {
            /*
             * Used to initialize the first iteration of this loop to establish
             * a 'first' case and to give 'prev' a meaningful value.
             */
            if(prev == -1)
            {
                prev = scores[i];
            }
            
            /*
             * If this score is less than the previous one, we can stop because
             * we know it's not increasing.
             */
            if(scores[i] < prev)
            {
                return false;
            }
            prev = scores[i];
        }
        
        /*
         * If the loop was not interrupted by a number in the sequence being
         * less than it's former, then that means that each number must be
         * equal or increasing.
         */
        return true;
    }
}