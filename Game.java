class Game {
  public static void main(String[] args) {

    // create deck
    Deck gameDeck = new Deck();
    gameDeck.populate();
    System.out.println("Deck has following cards: " + gameDeck.showHand());

    // shuffle deck
    gameDeck.shuffle();
    System.out.println("Deck has been shuffled and has the following cards: " + gameDeck.showHand());

  }
}