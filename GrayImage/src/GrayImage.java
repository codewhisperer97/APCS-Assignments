public class GrayImage
{
    public static final int BLACK = 0;
    public static final int WHITE = 255;
    
    /**
     * A hardcoded representation of the grayscale image in a 2D array.
     */
    private int[][] pixelValues = {
        new int[] {
            221, 184, 178, 84, 135
        },
        new int[] {
            84, 255, 255, 130, 84
        },
        new int[] {
            78, 255, 0, 0, 78
        },
        new int[] {
            84, 130, 255, 130, 84
        }
    };
    
    public GrayImage()
    {
        
    }
    
    /**
     * Returns the number of white pixels in the grayscale image.
     * @return the number of white pixels in the grayscale image.
     */
    public int countWhitePixels()
    {
        int count = 0;
        
        /*
         * Cycle through rows (row-major order)
         */
        for(int row = 0; row < pixelValues.length; row++)
        {
            /*
             * Cycle through columns
             */
            for(int col = 0; col < pixelValues[row].length; col++)
            {
                /*
                 * If the pixel at this index is white, add one to the white
                 * pixel counter.
                 */
                if(pixelValues[row][col] == WHITE)
                {
                    count++;
                }
            }
        }
        return count;
    }
    
    public void processImage()
    {
        /*
         * Cycle through rows
         */
        for(int row = 0; row < pixelValues.length; row++)
        {
            /*
             * Cycle through columns
             */
            for(int col = 0; col < pixelValues[row].length; col++)
            {
                /*
                 * If there exists an index at (row + 2, col + 2)...
                 */
                if((!((row + 2) > (pixelValues.length - 1))) && (!((col + 2) > (pixelValues[row].length - 1))))
                {
                    /*
                     * If the current value minus the value at (row + 2, col + 2)
                     * would be less than BLACK, set to BLACK.
                     */
                    if((pixelValues[row][col] - pixelValues[row + 2][col + 2]) < BLACK)
                    {
                        pixelValues[row][col] = BLACK;
                    }
                    /*
                     * Otherwise, subtract the value at (row + 2, col + 2) from
                     * the original value.
                     */
                    else
                    {
                        pixelValues[row][col] -= pixelValues[row + 2][col + 2];
                    }
                }
                else
                {
                    /*
                     * This is a nice piece of debugging code to see the inside
                     * of the image-processing-process.  I'm commenting it to
                     * clean up the output but you can uncomment it to see which
                     * indexes the loop ignores since they're out of bounds.
                     * 
                     * System.out.println("No index at [" + (row + 2) + "][" + (col + 2) + "]");
                     */
                }
            }
        }
    }
    
    public void printArray()
    {
        for(int row = 0; row < pixelValues.length; row++)
        {
            for(int col = 0; col < pixelValues[row].length; col++)
            {
                System.out.print("|" + pixelValues[row][col] + "|");
            }
            System.out.println();
            System.out.println("------------------------");
        }
    }
}