import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
  private static Bank playerBank;
  private static Bet bet;

  public Game(int initialBalance) {
    Game.playerBank = new Bank(initialBalance);
    this.bet = new Bet();
    System.out.println("You have " + playerBank.getBalance() + " credit(s).");
  }

  public void play() {
    try {
      // get player's bet
      int betAmount = 0;

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

      // player chooses which cards to hold
      Scanner input = new Scanner(System.in);
      ArrayList<Integer> indicesToKeep = new ArrayList<Integer>();
      boolean validInput = false;

      while (!validInput) {
        System.out.println("\n" + "Choose which cards to hold. Enter:" + "\n" + "  0 to hold all cards in current hand,"
            + "\n" + "  9 to discard all, or" + "\n"
            + "  the numbers of the cards you want to hold (separated by spaces)");

        String indicesString = input.nextLine();
        String[] indicesArray = indicesString.split("\s+");
        int i = 0;

        for (i = 0; i < indicesArray.length; i++) {
          int index = Integer.parseInt(indicesArray[i]);

          if (index < 0) {
            System.out.println("Invalid input. Please try again.");
            break;
          } else if (index == 0) {
            validInput = true;
            break;
          } else if (index == 9) {
            playerHand.clear();
            System.out.println("\n" + "Discarding hand.");
            validInput = true;
            break;
          } else if (index > playerHand.getCards().size()) {
            System.out.println("No card with that number. Please try again.");
            break;
          } else {
            indicesToKeep.add(index);
          }
        }
        // If input is valid
        if (i == indicesArray.length) {
          validInput = true;
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
      int payout = PayTable.getPayout(handResult, bet);
      System.out.println("You won " + payout + " credits.");
      playerBank.addCredits(payout);
      System.out.println("\n" + "You have " + playerBank.getBalance() + " credits.");

      // clear all hands
      playerHand.clear();
      heldHand.clear();
    } catch (InputMismatchException e) {
      System.out.println("Invalid input. Please try again.");
      play();
    } catch (Exception e) {
      System.out.println("An error occurred. Please try again.");
      play();
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Game game = new Game(20);
    int betAmount;

    do {
      try {
        betAmount = bet.bet(scanner, playerBank);

        if (betAmount != 0) {
          game.play();
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid bet amount.");
        scanner.next();
        betAmount = -1;
      }
    } while (betAmount != 0);

    scanner.close();
  }
}
