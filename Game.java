import java.util.Arrays;
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
  System.out.println("Your hand is: ");
  for (int i = 0; i < playerHand.getCards().size(); i++) {
      System.out.println((i + 1) + ": " + playerHand.getCards().get(i).toString());
    }
  
  Scanner input = new Scanner(System.in);

  // discard a card
  System.out.println("Enter the numbers of the cards you want to discard (separated by spaces), enter -1 to discard all cards, or enter 0 to hold all cards in your current hand:");
  String indicesString = input.nextLine();
  String[] indicesArray = indicesString.split("\\s+");
  int[] indices = new int[indicesArray.length];

  for (int i = 0; i < indicesArray.length; i++) {
    indices[i] = Integer.parseInt(indicesArray[i]);
  }

  Arrays.sort(indices);
  Hand discardHand = new Hand();
  EvaluateHand evaluator = new EvaluateHand();

  for (int i = indices.length - 1; i >= 0; i--) {
    int index = indices[i];
    if (index == 0) {
      System.out.println("Evaluating hand.");
      String handResult = evaluator.evaluateHand(playerHand.getCards().toArray(new Card[playerHand.getCards().size()]));
      System.out.println("Your hand is a " + handResult + ".");
    }
    else if (index < 1 || index > playerHand.getCards().size()) {
      System.out.println("Invalid index.");
    }
    else {
      Card card = playerHand.getCards().get(index - 1);
      boolean success = playerHand.discard(card, discardHand);

      if (success) {
        System.out.println("You discarded " + card);
      }
      else {
        System.out.println("Could not discard selected card!");
      }
    }
  }

  // replace discards in playerHand
  while (playerHand.getCards().size() < 5) {
    gameDeck.dealCard(playerHand);
  }

  System.out.println("Your hand is: ");
  System.out.println(playerHand.showHand());
  System.out.println("Evaluating hand.");
      String handResult = evaluator.evaluateHand(playerHand.getCards().toArray(new Card[playerHand.getCards().size()]));
      System.out.println("Your hand is a " + handResult + ".");
}

  public void bet(int amount, Scanner input) {
      playerBank.subtractCredits(amount);
      System.out.println("Betting " + amount + " credit(s).");
    }

  public static void main(String[] args) {
    Game game = new Game(5);
      
    Scanner scanner = new Scanner(System.in);
    
    int betAmount = 0;
    do {
      System.out.print("Enter a bet of 1 or more credits to start the game or type 0 to exit.");
      betAmount = scanner.nextInt();
      if (betAmount > 0) {
        game.bet(betAmount, scanner);
        game.play();
      }
    }
    while (betAmount !=0);
  }
}