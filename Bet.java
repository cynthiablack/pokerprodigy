import java.util.InputMismatchException;
import java.util.Scanner;

public class Bet {
  private int betAmount;

  public int getBetAmount() {
    return betAmount;
  }

  public void setBetAmount(int betAmount) {
    this.betAmount = betAmount;
  }

  public int bet(Scanner input, Bank playerBank) {
    while (true) {
      try {
        System.out.print("\n" + "Enter a bet of 1 or more credits to start the game or type 0 to exit." + "\n");
        betAmount = input.nextInt();
  
        if (betAmount < 0) {
          System.out.println("\n" + "Invalid bet amount. Please enter a positive number or type 0 to exit." + "\n");
        }
  
        else if (betAmount == 0) {
          return 0;
        }
  
        else if (betAmount > playerBank.getBalance()) {
          System.out.println("\n" + "You don't have enough credits to make that bet.");
          System.out.println("\n" + "You can bet up to" + playerBank.getBalance() + " credits or type 0 to exit." + "\n");
        }
  
        else {
          playerBank.subtractCredits(betAmount);
          System.out.println("\n" + "Betting " + betAmount + " credit(s).");
          return betAmount;
        }
      }
      catch (InputMismatchException e) {
      System.out.println("\n" + "Invalid input.");
      input.next(); // consume invalid input
    }
        
    }
  }
}