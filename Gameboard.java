
/**
 * Write a description of class Gameboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.File;
import java.util.Scanner;

public class Gameboard
{
    private Tile[][] tileGrid = new Tile[9][9];
    private Quadrant[] quadrants = new Quadrant[9];
    private Vertical[] verticals = new Vertical[9];
    private Horizontal[] horizontals = new Horizontal[9];
    
    public Gameboard()
    {
        initializeGrid();
        initializeQuadrants();
        initializeVerticals();
        initializeHorizontals();
    }
    
    public void loadSudoku()
    {
        // fill the tile grid
        try
        {
            File board = new File("gameBoard.su");
            Scanner input = new Scanner(board);
            int i = 0;
            while(input.hasNext())
            {
                String[] col = input.nextLine().split(",");
                
                for(int j = 0; j < col.length; j++)
                {
                
                    
                    if(!col[j].equals("0"))
                    {
                    	tileGrid[i][j].setData(col[j]);
                    	tileGrid[i][j].setEditable(false);
                    }
                }
                i++;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        
        // populate the supporting architecture
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                
                tileGrid[i][j].setOwningHorizontal(horizontals[i]);
                tileGrid[i][j].setOwningVertical(verticals[j]);
                int whichTile = i%3*3 + j%3;
                horizontals[i].setTile(j, tileGrid[i][j]);
                verticals[j].setTile(i, tileGrid[i][j]);
                if(i < 3)
                {
                    if(j < 3)
                    {
                        quadrants[0].setTile(whichTile, tileGrid[i][j]);
                        tileGrid[i][j].setOwningQuadrant(quadrants[0]);
                    } else if(j < 6) {
                        quadrants[1].setTile(whichTile, tileGrid[i][j]);
                        tileGrid[i][j].setOwningQuadrant(quadrants[1]);
                    } else {
                        quadrants[2].setTile(whichTile, tileGrid[i][j]);
                        tileGrid[i][j].setOwningQuadrant(quadrants[2]);
                    }
                } else if(i < 6){
                    if(j < 3)
                    {
                        quadrants[3].setTile(whichTile, tileGrid[i][j]);
                        tileGrid[i][j].setOwningQuadrant(quadrants[3]);
                    } else if(j < 6) {
                        quadrants[4].setTile(whichTile, tileGrid[i][j]);
                        tileGrid[i][j].setOwningQuadrant(quadrants[4]);
                    } else {
                        quadrants[5].setTile(whichTile, tileGrid[i][j]);
                        tileGrid[i][j].setOwningQuadrant(quadrants[5]);
                    }
                } else {
                    if(j < 3)
                    {
                        quadrants[6].setTile(whichTile, tileGrid[i][j]);
                        tileGrid[i][j].setOwningQuadrant(quadrants[6]);
                    } else if(j < 6) {
                        quadrants[7].setTile(whichTile, tileGrid[i][j]);
                        tileGrid[i][j].setOwningQuadrant(quadrants[7]);
                    } else {
                        quadrants[8].setTile(whichTile, tileGrid[i][j]);
                        tileGrid[i][j].setOwningQuadrant(quadrants[8]);
                    }
                }
            }
        }
    }
    
    public boolean isExclusiveMove(Move m)
    {
        for(int i = 1; i <= 9; i++)
        {
            if(i != m.getData() && isMoveValid(new Move(m.getCol(), m.getRow(), i)))
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean isMoveValid(Move m)
    {
    	// Check if space is editable
    	if(!tileGrid[m.getRow()][m.getCol()].isEditable())
    	{
    		return false;
    	}
        
        return true;
    }
    
    public void initializeGrid()
    {
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                tileGrid[i][j] = new Tile();
            }
        }
    }
    
    public void placeMove(Move m)
    {
        tileGrid[m.getRow()][m.getCol()].setData(m.getData());
    }
    
    public void initializeQuadrants()
    {
        for(int i = 0; i < quadrants.length; i++)
        {
            quadrants[i] = new Quadrant();
        }
    }
    
    public void initializeVerticals()
    {
        for(int i = 0; i < verticals.length; i++)
        {
            verticals[i] = new Vertical();
        }
    }
    
    public void initializeHorizontals()
    {
        for(int i = 0; i < horizontals.length; i++)
        {
            horizontals[i] = new Horizontal();
        }
    }
        
    public String toString()
    {
        String returnString = "    [0][1][2] | [3][4][5] | [6][7][8]\n" + 
                              "    =================================\n";
        for(int i = 0; i < 9; i++)
        {
            if(i%3 == 0 && i > 1)
            {
                returnString += "-----------------------------------\n";
            }
            
            for(int j = 0; j < 9; j++)
            {
                if(j%3 == 0 && j > 1)
                {
                    returnString += " | ";
                }
                if(j == 0)
                {
                    returnString += "[" + i + "] ";
                }
                
                returnString += " " + tileGrid[i][j].toString() + " ";
   
                
            }
            returnString += "\n\n";
        }
        return returnString;
    }
    
    public boolean isComplete()
    {
        // check each support structure for duplicates
        for(int i = 0; i < 9; i++)
        {
            if(quadrants[i].hasDuplicate())
            {
            	System.err.println("Quadrant has duplicate.");
                return false;
            }
            if(verticals[i].hasDuplicate())
            {
            	System.err.println("Vertical has duplicate.");
                return false;
            }
            if(horizontals[i].hasDuplicate())
            {
            	System.err.println("Horizontal has duplicate.");
                return false;
            }
        }
        
        // check each tile to make sure there are no empty spaces
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(tileGrid[i][j].isEmpty())
                {
                	System.err.println("Tile is empty.");
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isEmpty(int i, int j)
    {
        return tileGrid[i][j].isEmpty();
    }
}
