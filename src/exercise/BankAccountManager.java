package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Bank account manager.
 */
public class BankAccountManager implements Bank {

    private Map<Integer, BankAccount> accounts;
    private int id;

    public BankAccountManager() {
        this.accounts = new HashMap<>();
        this.id = 0;
    }

    @Override
    public void addAccount(BankAccount account) {
        if (accounts.size() >= 100) {
            System.out.println("Limit reached: Cannot create more than 100 accounts.");
            return;
        }
        accounts.put(id, account);
        System.out.println("Account added successfully with ID: " + id);
        id++;
    }

    @Override
    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    public void listAccounts() {
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            int accId = entry.getKey();
            BankAccount accs = entry.getValue();
            String name = accs.toString();
            System.out.printf("Account ID: %d, Account Name: %s, Balance: %.2f%n",
                    accId, name, accs.getBalance());
        }
    }

    /**
     * filters transactions above or equal to a specified amount using a lambda expression.
     */
    public List<Transaction> filterTransactionsAtOrAbove(double amount, List<Transaction> txList) {
        return txList.stream()
                .filter(t -> t.getAmount() >= amount)
                .collect(Collectors.toList());
    }

    /**
     * sorts transactions.
     */
    public List<Transaction> sortTransactionsByAmount(List<Transaction> txList) {
        return txList.stream()
                .sorted((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()))
                .collect(Collectors.toList());
    }
}