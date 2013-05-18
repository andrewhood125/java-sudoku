
/**
 * Write a description of class ComputerPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComputerPlayer implements Player
{
    private Gameboard board;
    
    public ComputerPlayer(Gameboard board)
    {
        this.board = board;
    }
    
    public Move nextMove()
    {
        displayBoard();
        // iterate through board. 
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                 // find empty space. 
                if(board.isEmpty(i,j))
                {
                    // starting with 1 check all supporting structures. If none of them violate then that is a valid move
                    for(int k = 1; k <= 9; j++)
                    {
                        // check if valid move
                        Move tempMove = new Move(j,i,k);
                        if(board.isMoveValid(tempMove))
                        {
                            // if that number is the only number that can go there
                            // place the piece.
                            if(board.isExclusiveMove(tempMove))
                            {
                                return tempMove;
                            }
                        }
                        
                        
                         
                    }
                }
            }
        }
       
        
        return new Move(1,1,1);
    }
    
    public void displayBoard()
    {
        System.out.println(board);
    }
}
