public class Deck extends Hand {
  public void populate() {
    for (Suit suit: Suit.values()) {
      for (Rank rank: Rank.values()) {
        Card card = new Card(rank, suit);
        this.add(card);
      }
    }
  }
}