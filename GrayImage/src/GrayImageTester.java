public class GrayImageTester
{
    public static void main(String[] args)
    {
        GrayImage image = new GrayImage();
        image.printArray();
        System.out.println("Number of white pixels: " + image.countWhitePixels());
        System.out.println();
        image.processImage();
        image.printArray();
        System.out.println("Number of white pixels: " + image.countWhitePixels());
    }
}