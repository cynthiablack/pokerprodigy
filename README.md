# Poker Prodigy video poker training app

A simple Java app that allows a user to play 9/6 Jacks or Better in the console.

**Link to project:** https://replit.com/@cynthiablack/PokerProdigy?v=1

![App Preview Image](https://github.com/cynthiablack/pokerprodigy/blob/main/pokerprodigy.png)

# Overview

This program allows a user to simulate a 5-card video poker hand. Users begin each game with a bank of 20 credits and a randomized array of the 52 values found in a standard deck of playing cards: 2 – 10, Jack, Queen, King, and Ace for each of the four suits (Diamonds, Hearts, Spades, Clubs). No jokers or other wildcards are included in this version of the program.

The user is prompted to start the game by betting n credits. The player's credit bank is debited the number of credits entered by the user (up to the player's credit balance), then representative Unicode characters for the first 5 cards from the randomized deck array are printed to the console. The user can choose to hold alll cards, none, or pick specific cards by entering the card's position in the console. Any cards not held are considered discarded and are replaced by the next card values in the randomized array.

Next, the user’s cards are evaluated and win or loss message prints to the console. If the user has a winning hand, the credit bank increases by a multiplier, which varies by hand and follows a 9/6 Jacks or Better pay table progression. If the user does not have a winning hand, 0 credits are added to the credit bank. The user’s ending credit balance is then printed to the console.

Finally, if the user has 1 or more credits, they are prompted to play again; the program runs until the user chooses to exit or the credit bank reaches 0.

## How to Run the Program

If running on Replit, the Run button is configured to start the game. Otherwise:
**Compile command** javac Game.java
**Start command** java Game

## Next Steps

- add GUI with card images from Deck of Cards API
- add hand analysis option
- add 8/5 and 9/6 Jacks or Better pay tables
- add login & data storage
- add custom pay tables
- add Deuces Wild
- add Bonus Poker
- add Double Double Bonus Poker
