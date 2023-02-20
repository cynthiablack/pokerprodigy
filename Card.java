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

  public String getSuit() {
    return suit.printSuit();
  }

  public String toString() {
    String cardString = "";
    cardString += rank.printRankLabel() + suit.printSuit() + "\n//" + rank.printRankLabel() + " of " + suit.printSuit();
    return cardString;
  }

}
