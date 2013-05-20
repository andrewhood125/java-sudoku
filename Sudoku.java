import java.util.InputMismatchException;
import java.util.Scanner;


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
        
        System.out.println("#################################");
        System.out.println("# Sudoku   (c) 2013 Andrew Hood #");
        System.out.println("# 1) Single Player. 2) Solver   #");
        System.out.println("#################################");
        int whichType = 0;
        Scanner input = new Scanner(System.in);
        
        boolean badInput = false;
        do
        {
        	try 
        	{
        		System.out.print("~$");
        		whichType = input.nextInt();
        		badInput = false;
        	} catch (InputMismatchException ex) {
        		System.err.println("1 for Single Player, 2 for Solver.");
        		badInput = true;
        		input.nextLine();
        	}
        	
        } while(badInput || whichType < 1 || whichType > 2);
        
        Player player = null;
        if(whichType == 1)
        {
        	 player = new NormalPlayer(board);
        } else if(whichType == 2) {
        	player = new ComputerPlayer(board);
        } else {
        	System.exit(1);
        }
        
        
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
