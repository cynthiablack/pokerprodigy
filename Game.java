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

    // create initial hand
    Hand playerHand = new Hand();

    // deal cards until player hand has 5 cards
    while (playerHand.getCards().size() < 5) {
      gameDeck.dealCard(playerHand);
    }

    // Print playerHand
    System.out.println("Your hand is " + playerHand.showHand());
    

  }
}