public class Bank {
  private int balance;

  // set initial balance
  public Bank(int initialBalance) {
    this.balance = initialBalance;
  }

  // get current balance
  public int getBalance(){
    return balance;
  }

  // add credits
  public void addCredits(int amount){
    balance += amount;
  }

  // subtract credits
  public void subtractCredits(int amount){
    balance -= amount;
  }
}