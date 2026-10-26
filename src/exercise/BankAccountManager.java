package exercise;

import java.util.HashMap;
import java.util.Map;

public class BankAccountManager implements Bank {

    private Map<Integer, BankAccount> accounts;
    private int id;
    
    public BankAccountManager() {
        this.accounts = new HashMap<>();
        this.id = 0;
    }

    public void addAccount(BankAccount account) {
        accounts.put(id, account);
        System.out.println("Account added successfully with ID: " + id);
        id++;
    }

    @Override
    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    public void listAccounts() { //display account of bank managers
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            int accId = entry.getKey();
            BankAccount accs = entry.getValue();

            String name = accs.toString();

            System.out.printf("Account ID: %d, Account Name: %s, Balance: %.2f%n",
                    accId, name, accs.getBalance());
        }
    }
}
