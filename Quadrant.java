
/**
 * Quadrant holds 9 Tiles and can perform operations on 
 * those tiles.
 * 
 * @author Andrew Hood 
 * @version 0.1
 */
public class Quadrant
{
    private Tile[] tiles = new Tile[9];
    
    public void setTile(int i, Tile newTile)
    {
        tiles[i] = newTile;
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
}
