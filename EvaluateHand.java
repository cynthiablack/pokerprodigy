import java.util.Arrays;
import java.util.Comparator;

public class EvaluateHand {
  public static String evaluateHand(Card[] hand) {
    // sort the cards by both rank and suit
    Arrays.sort(hand, Comparator.comparing((Card c) -> c.getSuitName()).thenComparingInt((Card c) -> c.getRank().getRankValue()));

    // check for ace & king
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

    // check for 4 of a kind
    if (hand[0].getRank() == hand[3].getRank() || hand[1].getRank() == hand[4].getRank()) {
      return "Four of a Kind";
    }

    // check for full house
    if ((hand[0].getRank() == hand[1].getRank() && hand[2].getRank() == hand[4].getRank()) || (hand[0].getRank() == hand[2].getRank() && hand[3].getRank() == hand[4].getRank())) {
      return "Full House";
    }

    // check for 3 of a kind
    if (hand[0].getRank() == hand[2].getRank() || hand[1].getRank() == hand[3].getRank() || hand[2].getRank() == hand[4].getRank()) {
      return "Three of a Kind";
    }

    // check for two pair
    int pairCount = 0;
    for (int i = 0; i < hand.length - 1; i++) {
      if (hand[i].getRank() == hand[i+1].getRank()) {
        pairCount++;
        i++;
      }
    }
    if (pairCount == 2) {
      return "Two Pair";
    }

    pairCount = 1;
    Rank currentRank = hand[0].getRank();
    for (int i = 1; i < hand.length; i++) {
      if (hand[i].getRank() == currentRank) {
        pairCount++;
      } else {
        if (pairCount >= 2 && (currentRank == Rank.JACK || currentRank == Rank.QUEEN || currentRank == Rank.KING || currentRank == Rank.ACE)) {
          return "Jacks or Better";
        }
        currentRank = hand[i].getRank();
        pairCount = 1;
      }
    }
    if (pairCount >= 2 && (currentRank == Rank.JACK || currentRank == Rank.QUEEN || currentRank == Rank.KING || currentRank == Rank.ACE)) {
      return "Jacks or Better";
    }


    
  return "not a winner";
  }
}