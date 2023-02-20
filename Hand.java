import java.util.ArrayList;

public class Hand {
  private ArrayList<Card> cards;

  // construct new hand
  public Hand() {
    cards = new ArrayList<Card>();
  }

  public void clear() {
    cards.clear();
  }

  // interact with cards in hand
  public void add(Card card) {
    cards.add(card);
  }

  public String showHand() {
    String handString = "";

    for (Card c: cards) {
      handString += c.toString() + "\n";
    }
    
    return handString;
  }

  public boolean discard(Card card, Hand discardHand) {
    if (cards.contains(card)) {
      cards.remove(card);
      discardHand.add(card);
      return true;
    }
    else {
      return false;
    }
  }
} 