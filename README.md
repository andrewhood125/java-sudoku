java-sudoku
===========

Current state: Complete. ComputerPlayer can be optimized and may not finish on hard puzzles. 

Sudoku written in Java.

This version of sudoku is console based and has two playing methods. There is a NormalPlayer class that allows play as you would expect. There is a ComputerPlayer class that automatically solves the puzzle and you get to watch as it makes each move. 

Getting Started
===============
1. ````java -jar Sudoku.jar````

or

1. ````javac Sudoku.java````
2. ````java Sudoku````


Class Descriptions
==================

Sudoku.java -- This class holds the main method which jump starts the game. It creates a new instance of Gameboard and Player (NormalPlayer, Computer Player) it then enters the main game loop which will continue until the gameboard is filled and it passes a few checks confirming that board is correct. 

Tile.java -- Is a single location on the board and holds a 1-9 or possibly empty. 

Gameboard.java -- This class allows interaction with the board a 9x9 grid of Tiles. It has a two dimensional array of Tiles that form the actual gameboard. It also uses support structures: Quadrant, Vertical and Horizontal. The support structures form the nine vertical collumns, horizontal rows and 3x3 grids in the 9x9 gameboard. It has several methods used to interact with the board.  

Player.java -- This class is abstract. NormalPlayer and ComputerPlayer extend it in order to be used in the game. It forces any class that extends it to override the required methods needed to play the game. 

ComputerPlayer.java -- Extends Player and provides its own nextMove() method that solves the puzzle.

NormalPlayer.java -- Extends the Player and provides a nextMove() methods that takes input from the command line to play the game. 

Move.java -- This class is used to hold an x, y and data. Which correspond to a row, collumn and that number 1-9 that you put at that location. The Move is passed as one object to make it simpler to validate.

Support.java -- Is a helper class that holds nine tiles and can perform checks on those tiles including checking for a duplicate. A Sudoku board must meet certain criteria and three Support objects are used to represent them Quadrant, Horizontal and Vertical.

*.su
============
These files hold the gameBoard the program loads. It is a comma delimited file where each row corresponds directly to a row on the board.

Solver Methodology
==================

The actual code can be found in ComputerPlayer::nextMove(). Here is the psuedo code. 


1. Iterate through all tiles. 
2. Check if tile is open. 
3. If open iterate 1 - 9 possible values for that tile. 
4. Check if placing that move would create a duplicate in it's quadrant, horizontal or vertical.
5. If no duplicates exist check if this tile is only location where this index can be put. 
6. Place move. 