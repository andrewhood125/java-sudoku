
/**
 * Write a description of class Move here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Move
{
    private int row;
    private int col;
    private int data;
    
    public Move(int row, int col, int data)
    {
        this.row = row;
        this.col = col;
        this.data = data;
    }
    
    public int getData()
    {
        return data;
    }
    
    public int getCol()
    {
        return col;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public String toString()
    {
        return "row: " + row + " col: " + col + " data: " + data;
    }
}
