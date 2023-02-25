import java.util.Arrays;
import java.util.Scanner;

public class Game {
  private Bank playerBank;

  public Game(int initialBalance) {
    playerBank = new Bank(initialBalance);
    System.out.println("Current balance is " + playerBank.getBalance() + " credits.");
  }

  public void play() {
  // create deck
  Deck gameDeck = new Deck();
  gameDeck.populate();

  // shuffle deck
  gameDeck.shuffle();

  // create initial hand
  Hand playerHand = new Hand();

  // deal cards until playerHand has 5 cards
  while (playerHand.getCards().size() < 5) {
    gameDeck.dealCard(playerHand);
  }
  System.out.println("Your hand is: ");
  for (int i = 0; i < playerHand.getCards().size(); i++) {
      System.out.println((i + 1) + ": " + playerHand.getCards().get(i).toString());
    }
  
  Scanner input = new Scanner(System.in);

  // discard a card
  System.out.println("Enter the numbers of the cards you want to discard:");
  int index = input.nextInt();

  if (index == 0) {
    System.out.println("Evaluating hand.");
  }
  else if (index < 1 || index > playerHand.getCards().size()) {
    System.out.println("Invalid index!");
  }
  else {
    Card card = playerHand.getCards().get(index - 1);
    Hand discardHand = new Hand();
    boolean success = playerHand.discard(card, discardHand);

    if (success) {
      System.out.println("You discarded " + card);
      System.out.println("Your new hand is: ");

      while (playerHand.getCards().size() < 5) {
        gameDeck.dealCard(playerHand);
      }
      
      System.out.println(playerHand.showHand());
      System.out.println("Cards in discard pile: ");
      System.out.println(discardHand.showHand());
    }
    else {
      System.out.println("Could not discard selected card!");
    }
  }
}
  
  public void bet(int amount) {
      playerBank.subtractCredits(amount);
      System.out.println("Betting " + amount + " credit(s). Your bank balance is now " + playerBank.getBalance() + " credits.");
    }

  public static void main(String[] args) {
    Game game = new Game(5);
    game.bet(1);
    game.play();
  }
}