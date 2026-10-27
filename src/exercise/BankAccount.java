package exercise;

import exception.AccountFrozenException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

import java.util.ArrayList;
import java.util.List;

/**
 * BankAccount class with internal try-catch exception handling.
 */
public class BankAccount {
    private double balance;
    private boolean imfrozen;
    private List<Transaction> transactionHistory;

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

    // Silent methods for setup/pre-populating transactions
    public void depositSilent(double amount) {
        if (amount > 0 && !isFrozen()) {
            this.balance += amount;
            this.transactionHistory.add(new Transaction("Deposit", amount));
        }
    }

    public void withdrawSilent(double amount) {
        if (amount > 0 && amount <= balance && !isFrozen()) {
            this.balance -= amount;
            this.transactionHistory.add(new Transaction("Withdrawal", amount));
        }
    }

    public void deposit(double amount) {
        try {
            if (isFrozen()) {
                throw new AccountFrozenException("Account is FROZEN.\n Unable to transact.");
            }

            if (amount <= 0) {
                System.out.printf("Amount deposited: %.2f%n", amount);
                System.out.printf("Current Balance: $%.2f%n", this.balance);
                throw new InvalidAmountException("Invalid amount. Must be greater than 0");
            }

            this.balance += amount;
            this.transactionHistory.add(new Transaction("Deposit", amount));
            printTransactionDetails("deposited", amount);

        } catch (InvalidAmountException | AccountFrozenException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(double amount) {
        try {
            if (isFrozen()) {
                throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
            }

            if (amount <= 0) {
                System.out.printf("Amount withdrawn: %.2f%n", amount);
                System.out.printf("Current Balance: $%.2f%n", this.balance);
                throw new InvalidAmountException("Invalid amount. Must be greater than 0");
            }

            if (amount > balance) {
                System.out.printf("Amount withdrawn: %.2f%n", amount);
                throw new InsufficientFundsException(String.format("Insufficient balance.%nCurrent balance: %.2f", this.balance));
            }

            this.balance -= amount;
            this.transactionHistory.add(new Transaction("Withdrawal", amount));
            printTransactionDetails("withdrawn", amount);

        } catch (InvalidAmountException | InsufficientFundsException | AccountFrozenException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Transaction> getTransactionHistory() {
        return this.transactionHistory;
    }
}