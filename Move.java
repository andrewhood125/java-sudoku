
/**
 * Write a description of class Move here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Move
{
	private int col;
    private int row;
    private int data;
    
    public Move(int col, int row, int data)
    {
        this.col = col;
        this.row = row;
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
