import exercise.BankAccount;
import exercise.BankAccountManager;
import exercise.SaveBankAcc;
import exercise.Transaction;

public class App {
    public static void main(String[] args) {
        System.out.println("================ EXERCISE 1 ================");
        BankAccount account = new SaveBankAcc("Test0"); // Test Case 1: Create Account
        System.out.println("Account Owner: " + account.toString());

        account.deposit(1000.125); // Test Case 2: Deposit Account
        System.out.println("\n================================");

        account.deposit(0); // Test Case 3: Deposit 0 amount
        System.out.println("\n================================");

        account.withdraw(-500); // Test Case 4: Deposit negative amount 
        System.out.println("\n================================");

        account.withdraw(500); // Test Case 5: Withdraw
        System.out.println("\n================================");

        account.withdraw(1500); // Test Case 6: Withdraw
        System.out.println("\n================================");

        account.withdraw(-100); // Test Case 7: Withdraw negative amount
        System.out.println("\n================================");

        account.freezeAccount(); // Test Case 8: Freeze Account
        account.deposit(11500);
        System.out.println("\n================================");

        account.deposit(500); // Test Case 9: Deposit While Account is Frozen
        System.out.println("\n================================");

        account.unfreezeAccount(); // Test Case 10: Unfreeze Account
        account.deposit(100.00);

        System.out.println("\n================ EXERCISE 2 ================");

        System.out.println("Transaction History:"); // Test Case 1: Show Transaction History
        for (Transaction t : account.getTransactionHistory()) {
            System.out.println(t);
        }
        
        System.out.println("\n================================");

        BankAccountManager accM1 = new BankAccountManager(); // Test Case 2: Create a Bank Manager
        accM1.addAccount(account); // Test case 3: Add account under Bank Manager
        System.out.println("\n================================");

        accM1.addAccount(new SaveBankAcc("Test1")); // Test case 4: Addd another account
        System.out.println("\n================================");

        accM1.listAccounts(); // Test Case 5: List all Accounts

        System.out.println("\n================ EXERCISE 3 ================");

        account.deposit(-500); // Test Case 1: Deposit negative amount

        System.out.println("\n================================");

        account.freezeAccount();// Test Case 2: Deposit when frozen
        account.deposit(11500);

        System.out.println("\n================================");

        account.unfreezeAccount(); // Test Cases 3 & 4: Withdraw negative amount and insufficient funds
        account.withdraw(-100);

        System.out.println("\n================================");

        account.withdraw(1500);

        System.out.println("\n================================");

        account.freezeAccount(); // Test Case 5: Withdraw when frozen
        account.withdraw(500);

        account.unfreezeAccount();

        System.out.println("\n================================");

        System.out.println("Filtering transactions at or above 200..."); // Test Case 6: Filter transactions
        System.out.println(accM1.filterTransactionsAtOrAbove(200, account.getTransactionHistory()));

        System.out.println("\n================================");

        System.out.println("Sorting transactions by amount..."); // Test Case 7: Sort transactions
        System.out.println(accM1.sortTransactionsByAmount(account.getTransactionHistory()));
    }
}