
/**
 * Support is the super class for the three types of supports
 * horizontal, vertical and quadrant. While these three child 
 * classes are all the same they are broken up due to what tiles
 * are placed into each class. Visually looking at a Sudoku board
 * each 3x3 grid is a quadrant. A vertical 1x9 is a vertical and
 * you guessed it a horizontal is a 9x1 parallel to the floor
 * unless you sleep Sudoku. 
 * 
 * @author Andrew Hood 
 * @version 0.1
 */
public class Support
{	
	private Tile[] tiles = new Tile[9];
    
    public void setTile(int i, Tile newTile)
    {
        tiles[i] = newTile;
    }
    
    public Tile[] getTiles()
    {
    	return tiles;
    }
    
    public boolean hasDuplicate()
    {
        int[] duplicates = new int[9];
        for(int i = 0; i < tiles.length; i++)
        {
            Tile tile = tiles[i];
            if(tile.getData() != 0)
            {
                int data = tile.getData();
                if(duplicates[data-1] != 0)
                {
                    return true;
                } else {
                    duplicates[data-1] = data;
                }
            }
            
        }
        return false;
    }
    
    public boolean hasDuplicate(Move tempMove)
    {
        int[] duplicates = new int[9];
        duplicates[tempMove.getData()-1] = 1;
        
        for(int i = 0; i < tiles.length; i++)
        {
            Tile tile = tiles[i];
            if(tile.getData() != 0)
            {
                int data = tile.getData();
                if(duplicates[data-1] != 0)
                {
                    return true;
                } else {
                    duplicates[data-1] = data;
                }
            }
            
        }
        return false;
    }
}
