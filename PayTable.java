public class PayTable {
  public static int getPayout(String handResult, int betAmount) {
  int payout = 0;

  switch (handResult) {
    case "Royal Flush":
      payout = betAmount * 800;
      break;
    case "Straight Flush":
      payout = betAmount * 50;
      break;
    case "Four of a Kind":
      payout = betAmount * 25;
      break;
    case "Full House":
      payout = betAmount * 9;
      break;
    case "Flush":
      payout = betAmount * 6;
      break;
    case "Straight":
      payout = betAmount * 4;
      break;
    case "Three of a Kind":
      payout = betAmount * 3;
      break;
    case "Two Pair":
      payout = betAmount * 2;
      break;
    case "Jacks or Better":
      payout = betAmount * 1;
      break;
    default:
      payout = 0;
      break;
  }

  return payout;
}
}