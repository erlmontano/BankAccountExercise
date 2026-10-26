package exercise;

import exception.AccountFrozenException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

/**
 * SaveBankAcc main class containing both Exercise 1 and Exercise 3 test cases.
 */
public class SaveBankAcc extends BankAccount {

    private String owner;

    public SaveBankAcc(String owner) {
        super();
        this.owner = owner;
    }

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

    public static void main(String[] args) {
        // System.out.println("================ EXERCISE 1 ================");
        // BankAccount account = new SaveBankAcc("Test0");
        // System.out.println("Account Owner: " + account.toString());

        // try {
        //     account.deposit(1000.125);
        //     System.out.println("------------------");

        //     account.deposit(0);
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
        // System.out.println("------------------");

        // try {
        //     account.withdraw(-500);
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
        // System.out.println("------------------");

        // try {
        //     account.withdraw(500);
        //     System.out.println("------------------");

        //     account.withdraw(1500);
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
        // System.out.println("------------------");

        // try {
        //     account.withdraw(-100);
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
        // System.out.println("------------------");

        // account.freezeAccount();
        // try {
        //     account.deposit(11500);
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
        // System.out.println("------------------");

        // try {
        //     account.deposit(500);
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
        // System.out.println("------------------");

        // account.unfreezeAccount();
        // try {
        //     account.deposit(100.00);
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
        // System.out.println("------------------");

        // BankAccountManager accM1 = new BankAccountManager();
        // accM1.addAccount(account);
        // System.out.println("------------------");

        // accM1.addAccount(new SaveBankAcc("Test1"));
        // System.out.println("------------------");

        // accM1.listAccounts();
        // System.out.println("------------------");

        // System.out.println("Transaction History:");
        // for (Transaction t : account.getTransactionHistory()) {
        //     System.out.println(t);
        // }

        BankAccount account = new SaveBankAcc("Test0");
        BankAccountManager accM1 = new BankAccountManager();

        System.out.println("\n================ EXERCISE 3 ================");
        
        try {
            account.deposit(-500);
        } catch (InvalidAmountException | AccountFrozenException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n================================");

        account.freezeAccount();
        try {
            account.deposit(11500);
        } catch (InvalidAmountException | AccountFrozenException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n================================");

        account.unfreezeAccount();
        try {
            account.withdraw(-100);
        } catch (InvalidAmountException | InsufficientFundsException | AccountFrozenException e) {
            System.out.println(e.getMessage());
        }

        try {
            account.withdraw(1500);
        } catch (InvalidAmountException | InsufficientFundsException | AccountFrozenException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n================================");

        account.freezeAccount();
        try {
            account.withdraw(500);
        } catch (InvalidAmountException | InsufficientFundsException | AccountFrozenException e) {
            System.out.println(e.getMessage());
        }

        account.unfreezeAccount();

        System.out.println("\n================================");

        System.out.println("Filtering transactions at or above 200...");
        System.out.println(accM1.filterTransactionsAtOrAbove(200, account.getTransactionHistory()));

        System.out.println("\n================================");

        System.out.println("Sorting transactions by amount...");
        System.out.println(accM1.sortTransactionsByAmount(account.getTransactionHistory()));
    }
}