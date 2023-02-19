public enum Suit {
  // enumerate 4 suits in standard deck of playing cards
  CLUBS("\u2663"),
  DIAMONDS("\u2666"),
  HEARTS("\u2665"),
  SPADES("\u2660");

  // prevent changes to Suit during runtime
  private final String symbol;

  // assign symbol to members of Suit
  private Suit(String symbol) {
    this.symbol = symbol;
  }

  // expose Suit as public method
  public String printSuit() {
      return symbol;
  }
}