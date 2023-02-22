public enum Rank {
  // enumerate card values
  ACE(1, "Ace"),
  TWO(2, "2"),
  THREE(3, "3"),
  FOUR(4, "4"),
  FIVE(5, "5"),
  SIX(6, "6"),
  SEVEN(7, "7"),
  EIGHT(8, "8"),
  NINE(9, "9"),
  TEN(10, "10"),
  JACK(11, "Jack"),
  QUEEN(12, "Queen"),
  KING(13, "King");

  // prevent changes to Rank during runtime
  private final int rankValue;
  private final String rankLabel;

  // assign value to members of Rank
  private Rank(int rankValue, String rankLabel) {
    this.rankValue = rankValue;
    this.rankLabel = rankLabel;
  }

  // expose Rank as public method
  public int getRankValue() {
    return rankValue;
  }

  public String printRankLabel() {
    return rankLabel;
  }
}