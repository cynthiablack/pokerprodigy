import java.util.Arrays;
import java.util.Comparator;

public class EvaluateHand {
  public static String evaluateHand(Card[] hand) {
    // sort the cards by both rank and suit
    Arrays.sort(hand, Comparator.comparing((Card c) -> c.getSuitName()).thenComparingInt((Card c) -> c.getRank().getRankValue()));

    // check for Ace
    boolean hasAce = hand[0].getRank().equals(Rank.ACE);
    boolean hasKing = hand[4].getRank().equals(Rank.KING);

    // treat Ace as high if hand has both Ace & King
    if (hasAce && hasKing) {
      hand[0].setRankValue(14);
    }

    // check for same suit
    boolean sameSuit = true;
    Suit suit = hand[0].getSuit();
    for (int i = 1; i < hand.length; i++) {
      if (!hand[i].getSuitName().equals(suit)) {
        sameSuit = false;
        break;
      }
    }

    // check for straight
    boolean straight = true;
    for (int i = 0; i < hand.length - 1; i++) {
      if (hand[i].getRank().getRankValue() != hand[i+1].getRank().getRankValue() -1) {
        straight = false;
        break;
      }
    }
    
    // check for royal flush
    if (sameSuit && straight &&
        hand[0].getRank() == Rank.ACE &&
        hand[1].getRank() == Rank.TEN &&
        hand[2].getRank() == Rank.JACK &&
        hand[3].getRank() == Rank.QUEEN &&
        hand[4].getRank() == Rank.KING) {
          return "Royal Flush";
        }

    // check for straight flush
    if (sameSuit && straight) {
      return "Straight Flush"; 
    }

    // check for flush
    if (sameSuit) {
      return "Flush";
    }

    // payout straight
    if (straight) {
      return "Straight";
    }
  return "You had another hand.";
  }
}