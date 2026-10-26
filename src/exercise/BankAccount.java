package exercise;

import exception.AccountFrozenException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;
import java.util.ArrayList;
import java.util.List;

/**
 * bank account with deposit, withdraw, and transaction history features.
 */
public class BankAccount {
    private double balance;
    private boolean imfrozen;
    private List<Transaction> transactionHistory;

    /**
     * constructor initializing balance, frozen state, and transaction history.
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
     * Deposits money into the account.
     * InvalidAmountException if amount is <= 0
     * AccountFrozenException if account is frozen
     */
    public void deposit(double amount) throws InvalidAmountException, AccountFrozenException {
        if (isFrozen()) {
            throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
        }
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount. Must be greater than 0");
        }
        this.balance += amount;
        this.transactionHistory.add(new Transaction("Deposit", amount));
        printTransactionDetails("deposited", amount);
    }

    /**
     * Withdraws money from the account.
     * InvalidAmountException if amount is <= 0
     * InsufficientFundsException if balance is insufficient
     * AccountFrozenException if account is frozen
     */
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException, AccountFrozenException {
        if (isFrozen()) {
            throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
        }
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount. Must be greater than 0");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance.");
        }
        this.balance -= amount;
        this.transactionHistory.add(new Transaction("Withdrawal", amount));
        printTransactionDetails("withdrawn", amount);
    }

    public List<Transaction> getTransactionHistory() {
        return this.transactionHistory;
    }
}