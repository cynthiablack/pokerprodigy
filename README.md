# Poker Prodigy video poker training app

A simple Java app that allows a user to play 9/6 Jacks or Better in the console.

**Link to project:** live demo link

![App Preview Image](preview image)

# Overview

This program allows a user to simulate a 5-card video poker hand. Users begin each game with a bank of 5 credits and a randomized array of the 52 values found in a standard deck of playing cards: 2 – 10, Jack, Queen, King, and Ace for each of the four suits (Diamonds, Hearts, Spades, Clubs). No jokers or other wildcards will be included in this version of the program.

The user will be prompted to start the game by betting 1 credit. The odds table will be printed to the console, then representative Unicode characters for the first 5 cards from the randomized deck array will be printed to the console; for example, the King of Hearts would be represented by U+004b and U+2764 (K❤). The user will choose to hold each card by entering its position. Any cards not held are considered discarded and are replaced by the next card values in the randomized array.

Next, the user’s cards will be compared to the odds table and a win or loss message will print to the console. If the user has a winning hand, the credit bank will increment by 1. If the user does not have a winning hand, the credit bank will be decremented by 1. The user’s ending credit balance will be printed to the console.

Finally, if the user has 1 or more credits, they will be prompted to play again; the program will run again until the user chooses to exit or the credit bank reaches 0.

## How to Run the Program

**Start command** java PokerProdigy.java

## Next Steps

- add GUI with card images from Deck of Cards API
- add hand analysis option
- add 8/5 and 9/6 Jacks or Better pay tables
- add login & data storage
- add custom pay tables
- add Deuces Wild
- add Bonus Poker
- add Double Double Bonus Poker
