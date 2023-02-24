import java.util.ArrayList;
import java.util.Collections;

public class Deck extends Hand {
  // create deck with all cards
  public void populate() {
    for (Suit suit: Suit.values()) {
      for (Rank rank: Rank.values()) {
        Card card = new Card(rank, suit);
        this.add(card);
      }
    }
  }
// shuffle created deck
  public void shuffle() {
    ArrayList<Card> deckCards = this.getCards();
    Collections.shuffle(deckCards);
  }
 // move card from Deck player's hand
  public void dealCard(Hand hand) {
    Card card = this.getCards().remove(0);
    hand.add(card);
  }
}