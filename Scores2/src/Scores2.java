public class Scores2
{
    private static String[] key = {
        "A",
        "B",
        "C",
        "D",
        "C",
        "B",
        "A"
    };
    
    private static String[] answers = {
        "A",
        "?",
        "D",
        "D",
        "C",
        "?",
        "A"
    };
    
    public static void main(String[] args)
    {
        System.out.println("Your score is " + scoreUp(key, answers));
    }
    
    public static int scoreUp(String[] key, String[] answer)
    {
        int score = 0;
        
        if(key.length != answer.length)
        {
            System.out.println("Key and Answers are not the same size!");
            return -1;
        }
        
        for(int i = 0; i < key.length; i++)
        {
            if(answer[i].equals("?"))
            {
                //Student gets 0 points, don't add or subtract.
            } 
            else if(key[i].equalsIgnoreCase(answer[i]))
            {
                score += 4; //If they get it right, give them points.
            }
            else
            {
                score -= 1; //If they get it wrong, subtract a point.
            }
        }
        
        return score;
    }
}