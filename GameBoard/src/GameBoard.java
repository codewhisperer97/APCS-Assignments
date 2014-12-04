public class GameBoard
{
    private int numRows;
    private int numCols;
    
    private String[][] board;
    
    public GameBoard(int rows, int cols)
    {
        numRows = rows;
        numCols = cols;
        board = new String[numRows][numCols];
    }
    
    public void setCell(int row, int col, String data)
    {
        board[row][col] = data;
    }
    
    public void removeValue(int row, int col)
    {
        board[row][col] = "";
    }
    
    public boolean isEmpty(int row, int col)
    {
        return board[row][col].equalsIgnoreCase("");
    }
    
    public String getCellValue(int row, int col)
    {
        return board[row][col];
    }
    
    public int getRows()
    {
        return board.length;
    }
    
    public int getCols()
    {
        return board[0].length;
    }
    
    public void printArray()
    {
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                System.out.print("[" + board[row][col] + "] ");
            }
            System.out.println();
        }
    }
}