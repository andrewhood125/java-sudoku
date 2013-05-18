
/**
 * Write a description of class NormalPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;


public class NormalPlayer implements Player
{
    private Gameboard board;
    
    public NormalPlayer(Gameboard board)
    {
        this.board = board;
    }
    
    public Move nextMove()
    {
        Scanner s = new Scanner(System.in);
        int row, col, data;
        displayBoard();
        System.out.print("Row: ");
        row = s.nextInt();
        System.out.print("Col: ");
        col = s.nextInt();
        System.out.print("Number: ");
        data = s.nextInt();
        return new Move(col, row, data);
    }
    
    public void displayBoard()
    {
        System.out.println(board);
    }
}
