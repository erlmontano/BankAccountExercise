package exercise;

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
}