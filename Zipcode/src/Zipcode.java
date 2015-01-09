import java.util.List;
import java.util.ArrayList;

public class Zipcode
{
    private static final String[] encoding = {
        "||:::",
        ":::||",
        "::|:|",
        "::|||",
        ":|:::",
        ":|:||",
        ":||::",
        "|::::",
        "|::||",
        "|:|::"
    };
    
    private static int zipCode = 95014;
    private static int baseCode;
    
    public static void main(String[] args)
    {
        System.out.println("Encoding:");
        for(int i = 0; i < encoding.length; i++)
        {
            System.out.println(i + ": " + encoding[i]);
        }
        System.out.println();
        
        System.out.println("Zipcode: " + zipCode);
        baseCode = (zipCode * 10) + getCheckDigit(zipCode);
        System.out.println("Basecode: " + baseCode);
        
        String barCode = "";
        System.out.println(barCode = generateBarCode(baseCode));
        System.out.println();
        
        int genCode = 0;
        System.out.println("Barcode: " + (genCode = generateCodeFromBar(barCode)));
        System.out.println("Zipcode: " + (genCode / 10));
    }
    
    /**
     * Accepts a zip code, then adds the digits together and subtracts
     * them from the next highest multiple of 10 and returns that.
     */
    public static int getCheckDigit(int zip)
    {
        int sum = 0;
        Integer[] digits = getDigits(zip);
        
        /*
         * Adds all of the digits of the Zip code together.
         */
        for(Integer i : digits)
        {
            sum += i;
        }
        
        /*
         * This loop counts up in increments of 10 until the first time we
         * exceed the sum of the zipcode digits.  Then, to find the check digit
         * we subtract the sum from that multiple of 10.
         */
        int tenUp = 0;
        while(tenUp < sum)
        {
            tenUp += 10;
        }
        return tenUp - sum;
    }
    
    public static String generateBarCode(int code)
    {
        String barCode = "";
        Integer[] digits = getDigits(code);
        
        /*
         * For each digit in the code we're given, retrieve the barcode equivalent
         * of that digit from the encoding table (array) and concatenate it to our
         * barCode variable.
         */
        for(Integer i : digits)
        {
            barCode += (encoding[i] + "");
        }
        return barCode;
    }
    
    public static int generateCodeFromBar(String bar)
    {
        /*
         * If the barcode's length is not evenly divisible by 5, then we know
         * that something's wrong and we won't be able to decode it, so abort
         * early.
         */
        if(bar.length() % 5 != 0)
        {
            System.out.println("Barcode is not correct size!");
            return -1;
        }
        
        /*
         * This is the variable which we incrementally rebuild the code that the
         * barcode represents.
         */
        int code = 0;
        
        /*
         * Find out how many digits are in our barcode so that we know how many
         * times to cycle and decode portions of it.
         */
        int numDigits = bar.length() / 5;
        
        /*
         * This dynamic array will hold objects that represent one digit of the
         * code, which in barcode format is 5 digits of either | or :.
         */
        ArrayList<String> barSegments = new ArrayList<String>();
        
        /*
         * For each segment of the barcode (i.e. each 5 bars), break up the code
         * and add each segment to the 'barSegments' list using substring.
         */
        for(int i = 0; i < numDigits; i++)
        {
            barSegments.add(bar.substring(i * 5, (i * 5) + 5));
        }
        
        /*
         * Process each segment of the barcode one at a time.  The encoding table
         * is set up so that the index of the array represents the digit of the
         * numerical code, and the value of the array at that index is the 
         * bar code.  So, for each segment we cycle through the encoding table,
         * and when we find a match, we know that that digit of the numerical
         * code is the index at which we found the match for the bar code.
         */
        for(String segment : barSegments)
        {
            for(int i = 0; i < encoding.length; i++)
            {
                if(segment.equals(encoding[i]))
                {
                    /*
                     * By multiplying the current code by 10, we essentially
                     * shift all of the digits to the left by 1, and the ones
                     * digit becomes 0.  Then by adding our new digit (the index
                     * at which we found our barcode match), we effectively add
                     * that digit to the code.
                     */
                    code *= 10;
                    code += i;
                }
            }
        }
        return code;
    }
    
    /**
     * Implementation of a digit separator taken from a stack overflow thread:
     * http://stackoverflow.com/questions/3389264/how-to-get-the-separate-digits-of-an-int-number
     * 
     * Includes getDigits and collectDigits
     */
    private static Integer[] getDigits(int num)
    {
        /*
         * We'll be breaking an integer up into it's individual digits, so we
         * use a List<Integer> to hold a dynamic number of entries so that this
         * digit separator will work with any length of number.
         */
        List<Integer> digits = new ArrayList<Integer>();
        
        /*
         * The collectDigits() method takes parameters for an integer and a list
         * REFERENCE.  This is important because that means that on the inside
         * of this method, if any changes are made to the digits list then those
         * changes will be reflected in the above List object.
         */
        collectDigits(num, digits);
        
        /*
         * After we fill our list with one-digit integers, we convert it into a 
         * simple Integer array (rather than a List) and return it.
         */
        return digits.toArray(new Integer[]{});
    }
    
    /**
     * This is a recursive function that uses integer division to cut off one
     * digit at a time and add it to the 'digits' List.  The recursive nature of
     * this means that it will dive to the bottom of the stack and add the digits
     * to the List in reverse order, meaning that they ultimately end up in the
     * List in the correct order.
     */
    private static void collectDigits(int num, List<Integer> digits)
    {
        /*
         * The importance of this statement is that it determins whether there is
         * another digit left in the 'num' integer.  If a number divided by 10
         * is greater than 0, then we know that the number must be greater than
         * 10 and thus must be two or more digits long.  If this happens, then
         * we use integer division to split off this digit and call this method
         * recursively.
         */
        if(num / 10 > 0)
        {
            collectDigits(num / 10, digits);
        }
        
        /*
         * For each recursion of this method, the original number will be one
         * digit shorter.  That means that for each instance of recursion, taking
         * the modulo of it will give the number at the end of that number.
         * This will happen once per digit, essentially meaning that we cycle
         * through each digit and add them in sequence to the digits List.
         */
        digits.add(num % 10);
    }
}