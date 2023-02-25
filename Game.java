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