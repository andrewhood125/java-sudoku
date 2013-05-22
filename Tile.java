
/**
 * Tile is each location on the board. It can be blank or hold 0-9
 * 
 * @author Andrew Hood
 * @version 0.1
 */


public class Tile
{
    private int data;
    private Support owningQuad;
    private Support owningVertical;
    private Support owningHorizontal;
    private boolean isEditable;
    
    public Tile()
    {
        data = 0;
        owningQuad = null;
        owningVertical = null;
        owningHorizontal = null;
        isEditable = true;
    }
    
    public void setEditable(boolean isEditable)
    {
    	this.isEditable = isEditable;
    }
    
    public boolean isEditable()
    {
    	return isEditable;
    }
    
    public void setData(String dataString)
    {
    	int data = Integer.parseInt(dataString);
    	setData(data);
    }
    
    public void setData(int data)
    {
    	if(data >= 1 && data <=9 && isEditable)
    	{
    		this.data = data;
    	}
    }
    
    public boolean isOpen()
    {
        if(data == 0)
        {
            return true;
        } else {
            return false;
        }
    }
    
    public int getData()
    {
        if(data == 0)
        {
            return 0;
        } else {
            return data;
        }
    }
    
    public Support getQuad()
    {
        return owningQuad;
    }
    
    public Support getVert()
    {
        return owningVertical;
    }
    
    public Support getHoriz()
    {
        return owningHorizontal;
    }
    
    public void setOwningQuadrant(Support owningQuad)
    {
        this.owningQuad = owningQuad;
    }
    
    public void setOwningVertical(Support owningVertical)
    {
        this.owningVertical = owningVertical;
    }
    
    public void setOwningHorizontal(Support owningHorizontal)
    {
        this.owningHorizontal = owningHorizontal;
    }
    
    public boolean isEmpty()
    {
        if(data == 0)
        {
            return true;
        } else {
            return false;
        }
    }
    
    public String toString()
    {
    	if(data == 0)
    	{
    		return "-";
    	} else {
    		return "" + data;
    	}
    }
}
