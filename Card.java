public class Card {
  // use Suit, Rank enums
  private Suit suit;
  private Rank rank;

  // create a new card
  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Rank getRank() {
    return this.rank;
  }
  
  public String getRankLabel() {
    return rank.printRankLabel();
  }

  public Suit getSuit() {
    return this.suit;
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

  // set new card value for Ace High
  public void setRankValue(int value) {
    this.rank = Rank.values()[value - 1];
  }

}
