# Week 3 Assignment / Final Project

Add a simple dice game to this Casino that we've written in class.

A stub of the game can be found in the src folder under com.example.games. The file name is SimpleCraps.java.

The game should:

- Create two 6-sided dice
- The player rolls the dice as many times as they can, adding the value shown to their total each throw, until the dice roll shows a value of 7
- The dealer then does the same
  - If the player’s total is higher than the dealer’s, the player wins
  - If the player’s total is lower than the dealer’s, they lose
  - If the totals are equal, it’s a draw
  
- Return the amount won:
  - If the player wins, return the amount that was bet
  - If the player loses, return -(amount bet)
  - If there's a draw, return 0

