public class Game {
  private Bank bank;

  public static void main(String[] args) {
    // create player bank with initial balance
    Bank playerBank = new Bank(5);
    System.out.println("Current balance is " + playerBank.getBalance() + " credits.");

      // create deck
      Deck gameDeck = new Deck();
      gameDeck.populate();
      System.out.println("Deck has following cards: " + gameDeck.showHand());

    // shuffle deck
    gameDeck.shuffle();
    System.out.println("Deck has been shuffled and has the following cards: " + gameDeck.showHand());

  }
}