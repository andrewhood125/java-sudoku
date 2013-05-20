
/**
 * Write a description of class NormalPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.InputMismatchException;
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
        int row = 0, col = 0, data = 0;
        boolean badInput = true;
        displayBoard();
       
        do
        {
        	System.out.print("Col: ");
        	try
        	{
        		col = s.nextInt();
        		badInput = false;
        	} catch (InputMismatchException ex) {
        		System.err.println("Input Mismatch.");
        		s.nextLine();
        		badInput = true;
        	}
        } while(badInput);
        
        do
        {
        	System.out.print("Row: ");
        	try
        	{
        		row = s.nextInt();
        		badInput = false;
        	} catch (InputMismatchException ex) {
        		System.err.println("Input Mismatch.");
        		s.nextLine();
        		badInput = true;
        	}
        } while(badInput);
        
        do
        {
        	System.out.print("Number: ");
        	try
        	{
        		data = s.nextInt();
        		badInput = false;
        	} catch (InputMismatchException ex) {
        		System.err.println("Input Mismatch.");
        		s.nextLine();
        		badInput = true;
        	}
        } while(badInput);
        
        return new Move(col, row, data);
    }
    
    public void displayBoard()
    {
        System.out.println(board);
    }
}
