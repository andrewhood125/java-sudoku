java-soduko
===========

Soduko written in Java.

This version of Soduko is console based and has two playing methods. There is a NormalPlayer class that allows play as you would expect. There is a ComputerPlayer class that automatically solves the puzzle and you get to watch as it makes each move. 

Getting Started
===============
1. javac Soduko.java
2. java Soduko


Class Descriptions
==================

Soduko.java
This class holds the main method which jump starts the game. It creates a new instance of Gameboard and Player (NormalPlayer, Computer Player) it then enters the main game loop which will continue until the gameboard is filled and it passes a few checks confirming that board is correct. 

Gameboard.java
This class allows interaction with the board a 9x9 grid of Tiles. It has a two dimensional array of Tiles that form the actual gameboard. It also uses support structures: Quadrant, Vertical and Horizontal. The support structures form the nine vertical collumns, horizontal rows and 3x3 grids in the 9x9 gameboard. It has several methods used to interact with the board.  

Player.java
This class is an interfact that NormalPlayer and ComputerPlayer implement in order to be used in the game. It forces any class that implements to override the required methods needed to play the game. 

Move.java
This class is used to hold an x, y and data. Which correspond to a row, collumn and that number 1-9 that you put at that location. The Move is passed as one object to make it simpler to validate.
