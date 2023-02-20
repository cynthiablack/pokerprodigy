public enum Suit {
  // enumerate 4 suits in standard deck of playing cards
  CLUBS("Clubs", "\u2663"),
  DIAMONDS("Diamonds", "\u2666"),
  HEARTS("Hearts", "\u2665"),
  SPADES("Spades", "\u2660");

  // prevent changes to Suit during runtime
  private final String name;
  private final String symbol;

  // assign symbol to members of Suit
  private Suit(String name, String symbol) {
    this.name = name;
    this.symbol = symbol;
  }

  // expose Suit as public method
  public String printSuitSymbol() {
    return symbol;
  }

  public String printSuitName() {
    return name;
  }
}