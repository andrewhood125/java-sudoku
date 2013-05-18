
/**
 * Tile is each location on the board. It can be blank or hold 0-9
 * 
 * @author Andrew Hood
 * @version 0.1
 */
import java.util.regex.Pattern;


public class Tile
{
    private String data;
    private Quadrant owningQuad;
    private Vertical owningVertical;
    private Horizontal owningHorizontal;
    
    public Tile()
    {
        data = "-";
        owningQuad = null;
        owningVertical = null;
        owningHorizontal = null;
    }
    
    public void setData(String data)
    {
        if(Pattern.matches("\\d", data))
        {
            this.data = data;
        } else {
            this.data = "-";
        }
    }
    
    public void setData(int data)
    {
        this.data = "" + data;
    }
    
    public boolean isOpen()
    {
        if(data == "-")
        {
            return true;
        } else {
            return false;
        }
    }
    
    public int getData()
    {
        if(data == "-")
        {
            return 0;
        } else {
            return Integer.parseInt(data);
        }
    }
    
    public Quadrant getQuad()
    {
        return owningQuad;
    }
    
    public Vertical getVert()
    {
        return owningVertical;
    }
    
    public Horizontal getHoriz()
    {
        return owningHorizontal;
    }
    
    public void setOwningQuadrant(Quadrant owningQuad)
    {
        this.owningQuad = owningQuad;
    }
    
    public void setOwningVertical(Vertical owningVertical)
    {
        this.owningVertical = owningVertical;
    }
    
    public void setOwningHorizontal(Horizontal owningHorizontal)
    {
        this.owningHorizontal = owningHorizontal;
    }
    
    public boolean isEmpty()
    {
        if(data == "-")
        {
            return true;
        } else {
            return false;
        }
    }
    public String toString()
    {
        return data;
    }
}
