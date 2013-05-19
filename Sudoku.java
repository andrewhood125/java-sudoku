
/**
 * Write a description of class Sudoku here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sudoku
{
    public static void main(String[] args)
    {
        Gameboard board = new Gameboard();
        board.loadSudoku();
        Player player = new NormalPlayer(board);
        while(!board.isComplete())
        {
            Move tempMove = player.nextMove();
            if(board.isMoveValid(tempMove))
            {
                board.placeMove(tempMove);
            } else {
                System.err.println("The move: " + tempMove + " is invalid.");
            }
        }
        System.out.println("You won!");
    }
    
}
