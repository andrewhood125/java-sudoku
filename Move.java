
/**
 * A Move is a helper class that holds three pieces of data
 * The x and y of the tile and also the number to be placed 
 * at that location. 
 * 
 * @author Andrew Hood 
 * @version 0.1
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
