import java.util.Random;

public class Game
{
    private static GameBoard board;
    private static Random rand;
    
    public static void main(String[] args)
    {
        rand = new Random();
        
        board = new GameBoard(10, 10);
        board.setCell(0, 0, "X");
        
        System.out.println(board.isEmpty(0, 0) ? "(0, 0) is empty." : "(0, 0) is not empty.");
        
        System.out.println("(0, 0) is " + board.getCellValue(0, 0));
        
        board.removeValue(0, 0);
        System.out.println(board.isEmpty(0, 0) ? "(0, 0) is empty." : "(0, 0) is not empty.");
        
        String icon = rand.nextBoolean() ? "X" : "O";
        for(int row = 0; row < board.getRows(); row++)
        {
            for(int col = 0; col < board.getCols(); col++)
            {
                board.setCell(row, col, icon);
            }
            icon = rand.nextBoolean() ? "X" : "O";
        }
        
        board.printArray();
    }
}