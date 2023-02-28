import java.util.Arrays;
import java.util.Comparator;

public class EvaluateHand {
  public static String evaluateHand(Card[] hand) {
    // sort the cards by both rank and suit
    Arrays.sort(hand, Comparator.comparing((Card c) -> c.getSuit()).thenComparingInt((Card c) -> c.getRank().getRankValue()));

    // count frequency of each rank
    int aceCount = 0;
    int twoCount = 0;
    int threeCount = 0;
    int fourCount = 0;
    int fiveCount = 0;
    int sixCount = 0;
    int sevenCount = 0;
    int eightCount = 0;
    int nineCount = 0;
    int tenCount = 0;
    int jackCount = 0;
    int queenCount = 0;
    int kingCount = 0;

    // count the instances of each rank
    //Rank currentRank = hand[0].getRank();
    for (int i = 0; i < hand.length; i++) {
      if (hand[i].getRank() == Rank.ACE) {
        aceCount++;
      } 
      else if (hand[i].getRank() == Rank.TWO) {
        twoCount++;
      } 
      else if (hand[i].getRank() == Rank.THREE) {
        threeCount++;
      } 
      else if (hand[i].getRank() == Rank.FOUR) {
        fourCount++;
      } 
      else if (hand[i].getRank() == Rank.FIVE) {
        fiveCount++;
      } 
      else if (hand[i].getRank() == Rank.SIX) {
        sixCount++;
      }
      else if (hand[i].getRank() == Rank.SEVEN) {
        sevenCount++;
      } 
      else if (hand[i].getRank() == Rank.EIGHT) {
        eightCount++;
      } 
      else if (hand[i].getRank() == Rank.NINE) {
        nineCount++;
      } 
      else if (hand[i].getRank() == Rank.TEN) {
        tenCount++;
      } 
      else if (hand[i].getRank() == Rank.JACK) {
        jackCount++;
      } 
      else if (hand[i].getRank() == Rank.QUEEN) {
        queenCount++;
      }
      else if (hand[i].getRank() == Rank.KING) {
        kingCount++;
      }
    }
    
    // accumulators for each suit
    int clubsCount = 0;
    int diamondsCount = 0;
    int heartsCount = 0;
    int spadesCount = 0;
    
    // count the instances of each suit
    Suit currentSuit = hand[0].getSuit();
    for (int i = 1; i < hand.length; i++) {
      if (hand[i].getSuit() == Suit.CLUBS) {
        clubsCount++;
      } 
      else if (hand[i].getSuit() == Suit.DIAMONDS) {
        diamondsCount++;
      } 
      else if (hand[i].getSuit() == Suit.HEARTS) {
        heartsCount++;
      }
      else if (hand[i].getSuit() == Suit.SPADES) {
        spadesCount++;
      }
    }
    
    // check for same suit
    boolean sameSuit = false;
    if (clubsCount == 5 || 
        diamondsCount == 5 || 
        heartsCount == 5 || 
        spadesCount == 5) {
      sameSuit = true;
    }

    // check for straight
boolean straight = false;
Arrays.sort(hand, Comparator.comparing(Card::getRank));
for (int i = 0; i < hand.length - 4; i++) {
  if (hand[i].getRank().getRankValue() == hand[i+1].getRank().getRankValue() - 1 &&
      hand[i+1].getRank().getRankValue() == hand[i+2].getRank().getRankValue() - 1 &&
      hand[i+2].getRank().getRankValue() == hand[i+3].getRank().getRankValue() - 1 &&
      hand[i+3].getRank().getRankValue() == hand[i+4].getRank().getRankValue() - 1) {
    straight = true;
    break;
  }
}


    // boolean checks: three of a kind, pair
    boolean threeOfAKind = false;
    boolean pair = false;

      if (aceCount == 3 || 
        twoCount == 3 || 
        threeCount == 3 || 
        fourCount == 3 || 
        fiveCount == 3 || 
        sixCount == 3 || 
        sevenCount == 3 || 
        eightCount == 3 || 
        nineCount == 3 || 
        tenCount == 3 || 
        jackCount == 3 || 
        queenCount == 3 || 
        kingCount == 3) {
          threeOfAKind = true;
        }

      if (aceCount == 2 || 
        twoCount == 2 || 
        threeCount == 2 || 
        fourCount == 2 || 
        fiveCount == 2 || 
        sixCount == 2 || 
        sevenCount == 2 || 
        eightCount == 2 || 
        nineCount == 2 || 
        tenCount == 2 || 
        jackCount == 2 || 
        queenCount == 2 || 
        kingCount == 2) {
          pair = true;
        }

    // count number of pairs
    int pairCount = 0;
    for (int i = 0; i < hand.length; i++) {
      for (int j = i + 1; j < hand.length; j++) {
        if (hand[i].getRank() == hand[j].getRank()) {
          pairCount++;
        }
      }
    }

    // check hand for win/lose
    if (sameSuit) {
      boolean hasAce = hand[0].getRank().equals(Rank.ACE);
      boolean hasKing = hand[4].getRank().equals(Rank.KING);
    
      // treat Ace as high if hand has both Ace & King
      if (hasAce && hasKing) {
        hand[0].setRankValue(14);
      }

      // check for royal flush
      if (hand[0].getRank() == Rank.ACE &&
          hand[1].getRank() == Rank.TEN &&
          hand[2].getRank() == Rank.JACK &&
          hand[3].getRank() == Rank.QUEEN &&
          hand[4].getRank() == Rank.KING) {
            return "Royal Flush";
          }
      
      // check for straight flush
      else if (straight) {
        return "Straight Flush"; 
      }

      // check for flush
      else {
        return "Flush";
      }
    }
    else {
      // payout straight
      if (straight) {
        return "Straight";
      }

      // check for four of a kind
      else if (aceCount == 4 || 
          twoCount == 4 || 
          threeCount == 4 || 
          fourCount == 4 || 
          fiveCount == 4 || 
          sixCount == 4 || 
          sevenCount == 4 || 
          eightCount == 4 || 
          nineCount == 4 || 
          tenCount == 4 || 
          jackCount == 4 || 
          queenCount == 4 || 
          kingCount == 4) {
            return "Four of a Kind";
          }

      // check for full house
      else if (threeOfAKind && pair) {
        return "Full House";
      }
      // check for three of a kind
      else if (threeOfAKind) {
        return "Three of a Kind";
      }
  
      // check for two pair
      
      else if (pairCount == 2) {
        return "Two Pair";
      }
        
      // check for jacks or better
      else if (jackCount > 1 || queenCount > 1 || kingCount > 1 || aceCount > 1) {
        return "Jacks or Better";
      }

      // if none of the above conditons are met, not a winnner
      else {
        return "not a winner";
      }
  }
    }
}