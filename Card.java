public class Card {
  // use Suit, Rank enums
  private Suit suit;
  private Rank rank;

  // create a new card
  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public String getRank() {
    return rank.printRankLabel();
  }

  public String getSuitSymbol() {
    return suit.printSuitSymbol();
  }

  public String getSuitName() {
    return suit.printSuitName();
  }

  public String toString() {
    String cardString = "";
    cardString += "  " + rank.printRankLabel() + " " + suit.printSuitSymbol() + "   (" + rank.printRankLabel() + " of " + suit.printSuitName() + ")";
    return cardString;
  }

}
