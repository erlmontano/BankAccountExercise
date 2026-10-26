package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 BankAccount.
 */

public class BankAccount {
  private double balance;
  private boolean imfrozen;
  private List<Transaction> transactionHistory;
  /**
   BankAccount.
    */

  public BankAccount() {
    this.balance = 0.0;
    this.imfrozen = false;
    this.transactionHistory = new ArrayList<>();
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public boolean isImfrozen() {
    return imfrozen;
  }

  public void setImfrozen(boolean imfrozen) {
    this.imfrozen = imfrozen;
  }

  public boolean isFrozen() {
    return this.imfrozen;
  }

  public void freezeAccount() {
    this.imfrozen = true;
    System.out.println("Account has been frozen.");
  }

  public void unfreezeAccount() {
    this.imfrozen = false;
    System.out.println("Account has been unfrozen.");
  }

  private void printTransactionDetails(String action, double amount) {
    System.out.printf("Amount %s: $%.2f%nCurrent Balance: $%.2f%n", action, amount, this.balance);
  }

  /**
 * For deposit.
 */

  public void deposit(double amount) { // to deposit from account
    if (isFrozen()) { // checks whether the account is frozen
      System.out.println("Account is Frozen");
      System.out.println("Unable to Transact");
      return;
    }
    if (amount <= 0) { // amount must be greater than 0, so this checks it.
      System.out.printf("Amount deposited: $%.2f %n", amount);
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }
    this.balance += amount;
    this.transactionHistory.add(new Transaction("Deposit", amount));
    printTransactionDetails("deposited", amount);
  }

  /**
 * For withdraw .
 */

  public void withdraw(double amount) { // to withdraw from account
    if (isFrozen()) { // checks the account if its frozen
      System.out.println("Account is Frozen");
      System.out.println("Unable to Transact");
      return;
    }
    if (amount <= 0) { // checks the withdrawn amount if its greater or equal to 0
      System.out.printf("Amount withdrawn: $%.2f %n", amount);
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }
    if (amount > balance) { // check withdrawn amount is greater than the balance of the account
      System.out.printf("Amount withdrawn: $%.2f %n", amount);
      System.out.println("Insufficient Balance.");
      System.out.printf("Current Balance: $%.2f%n", this.balance);
      return;
    }
    this.balance += amount;
    this.transactionHistory.add(new Transaction("Withdrawn", amount));
    printTransactionDetails("withdrawn", amount);
  }

  public List<Transaction> getTransactionHistory() {
    return this.transactionHistory;
  }
}