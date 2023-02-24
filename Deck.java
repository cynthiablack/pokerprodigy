import java.util.ArrayList;
import java.util.Collections;

public class Deck extends Hand {
  public void populate() {
    for (Suit suit: Suit.values()) {
      for (Rank rank: Rank.values()) {
        Card card = new Card(rank, suit);
        this.add(card);
      }
    }
  }

  public void shuffle() {
    ArrayList<Card> deckCards = this.getCards();
    Collections.shuffle(deckCards);
  }
}