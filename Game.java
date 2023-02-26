import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
  private Bank playerBank;

  public Game(int initialBalance) {
    playerBank = new Bank(initialBalance);
    System.out.println("You have " + playerBank.getBalance() + " credit(s).");
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
  System.out.println("\n" + "Your hand is: ");
  for (int i = 0; i < playerHand.getCards().size(); i++) {
      System.out.println((i + 1) + ": " + playerHand.getCards().get(i).toString());
    }
  
  Scanner input = new Scanner(System.in);

  // player chooses which cards to hold
  System.out.println("\n" + "Enter the numbers of the cards you want to hold (separated by spaces) or enter 0 to hold all cards in your current hand:");
  String indicesString = input.nextLine();
  String[] indicesArray = indicesString.split("\s+");
  ArrayList<Integer> indicesToKeep = new ArrayList<Integer>();

  for (int i = 0; i < indicesArray.length; i++) {
    int index = Integer.parseInt(indicesArray[i]);
    
    while (index < 1 || index > playerHand.getCards().size()) {
      System.out.println("Invalid input. Please try again.");
    }
    if (index == 0) {
      // System.out.println("Evaluating hand.");
      break;
    }
    else {
      indicesToKeep.add(index);
    }
  }
    
  // create new hand with held cards
  Hand heldHand = new Hand();
  for (int i = 0; i < indicesToKeep.size(); i++) {
    int index = indicesToKeep.get(i);
    Card card = playerHand.getCards().get(index - 1);
    heldHand.add(card);
  }

  // ensure heldHand is a full hand
  while (heldHand.getCards().size() < 5) {
    gameDeck.dealCard(heldHand);
  }

  // evaluate heldHand
  EvaluateHand evaluator = new EvaluateHand();

  System.out.println("Your hand is: ");
  System.out.println(heldHand.showHand());
  System.out.println("Evaluating hand.");
      String handResult = evaluator.evaluateHand(heldHand.getCards().toArray(new Card[heldHand.getCards().size()]));
      System.out.println("Your hand is " + handResult + ".");
}

  public void bet(int amount, Scanner input) {
      playerBank.subtractCredits(amount);
      System.out.println("\n" + "Betting " + amount + " credit(s).");
    }

  public static void main(String[] args) {
    Game game = new Game(5);
      
    Scanner scanner = new Scanner(System.in);
    
    int betAmount = 0;
    do {
      System.out.print("\n" + "Enter a bet of 1 or more credits to start the game or type 0 to exit.");
      betAmount = scanner.nextInt();
      if (betAmount > 0) {
        game.bet(betAmount, scanner);
        game.play();
      }
    }
    while (betAmount !=0);
  }
}