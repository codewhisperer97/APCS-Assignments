import java.util.Random;

public class Insulter
{
    private Random rand;
    
    /**
     * Instead of making three ArrayLists, I decied to use a 2D array.
     * This is unlike traditional 2D arrays because it is not 'rectangular'
     * I manually create 1D arrays that each represent an individual
     * WordList, and that collection of arrays is held within this 2D 'insults'
     * array.  More cleanly stated, 'insults' is an array that holds arrays of
     * words.
     */
    private String[][] insults = {
        new String[] { //WordListOne
            "unmuzzled",
            "vain",
            "venomed",
            "villainous",
            "warped",
            "wayward",
            "froward",
            "frothy",
            "gleeking",
            "goatish",
            "artless",
            "bawdy",
            "beslubbering",
            "bootless",
            "churlish"
        },
        
        new String[] { //WordListTwo
            "sheep-biting",
            "spur-galled",
            "swag-bellied",
            "tardy-gaited",
            "tickle-brained",
            "elf-skinned",
            "fat-kidneyed",
            "half-faced",
            "flap-mouthed",
            "fly-bitten",
            "base-court",
            "bat-fowling",
            "beef-witted",
            "beetle-headed",
            "boil-brained"
        },
        
        new String[] { //WordListThree
            "ratsbane",
            "scut",
            "skainsmate",
            "strumpet",
            "varlot",
            "wayward",
            "flax-wench",
            "flirt-gill",
            "foot-licker",
            "fustilarian",
            "apple-john",
            "baggage",
            "barnade",
            "bladder",
            "boar-pig",
            "harpy"
        }
    };
    
    public Insulter()
    {
        rand = new Random();
    }
    
    /**
     * Method that will randomly choose a word from each of the three lists
     * and string them together to make an insult.
     */
    public String getInsult()
    {
        StringBuffer curse = new StringBuffer();
        curse.append("Thou ");
        
        /*
         * For each array inside of 'insults' i.e. for each WordList...
         */
        for(int wordList = 0; wordList < insults.length; wordList++)
        {
            //Append to our curse a random word from the current WordList
            curse.append(insults[wordList][rand.nextInt(insults[wordList].length)]);
            
            //If we're not at the end of the list, add a space.
            if(!(wordList == insults.length - 1))
            {
                curse.append(" ");
            }
        }
        curse.append("!");
        return curse.toString();
    }
}