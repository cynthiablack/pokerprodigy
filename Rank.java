public enum Rank {
  // enumerate card values
  TWO(2), 
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  SEVEN(7),
  EIGHT(8),
  NINE(9),
  TEN(10),
  JACK(11),
  QUEEN(12),
  KING(13),
  ACE(14);

  // prevent changes to Rank during runtime
  private final int rankValue;

  // assign value to members of Rank
  private Rank(int rankValue) {
    this.rankValue = rankValue;
  }

  // expose Rank as public method
  public int printRank() {
    return rankValue;
  }
}