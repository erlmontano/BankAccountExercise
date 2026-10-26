package exercise;

/**
 * SaveBankAcc.
 */
public class SaveBankAcc extends BankAccount {

  private String owner;

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  @Override
    public String toString() {
    return owner;
  }

  public SaveBankAcc(String owner) {
    super();
    this.owner = owner;
  }

  /**
   * main print.
   */

  public static void main(String[] args) {
    BankAccount account = new SaveBankAcc("Test0"); // test case exercise 1
    System.out.println("Account Owner:" + account.toString());

    account.deposit(1000.125); // test case exercise 1
    System.out.println("------------------");

    account.deposit(0); // test case exercise 1
    System.out.println("------------------");

    account.withdraw(-500); // test case exercise 1
    System.out.println("------------------");

    account.withdraw(500); // test case exercise 1
    System.out.println("------------------");

    account.withdraw(1500); // test case exercise 1
    System.out.println("------------------");

    account.withdraw(-100); // test case exercise 1
    System.out.println("------------------");

    account.freezeAccount(); // test case exercise 1
    account.deposit(11500);
    System.out.println("------------------");

    account.deposit(500); // test case exercise 1
    System.out.println("------------------");

    account.unfreezeAccount(); // test case exercise 1
    account.deposit(100.00);
    System.out.println("------------------");

    System.out.println("Transaction history: " + account.getTransactionHistory());
    System.out.println("------------------");

    BankAccountManager accM1 = new BankAccountManager();
    System.out.println("------------------");

    accM1.addAccount(account);
    System.out.println("------------------");

    accM1.addAccount(new SaveBankAcc("Test1"));
    System.out.println("------------------");

    accM1.listAccounts();
    System.out.println("------------------");

    System.out.println("Transaction History:"); // display transactions
    for (Transaction t : account.getTransactionHistory()) {
      System.out.println(t);
    }
  }
}
