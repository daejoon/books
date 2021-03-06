package scratch;

public class Account {
    private String name;
    private int balance = 0;

    public Account(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposit(int deposit) {
        this.balance += deposit;
    }

    public boolean hasPositiveBalance() {
        return this.balance > 0;
    }

    public int getBalance() {
        return this.balance;
    }

    public String getName() {
        return this.name;
    }

    public void withdraw(int withdraw) {
        if (this.balance - withdraw < 0) {
            throw new InsufficientFundsException("balance only 0");
        }

        this.balance -= withdraw;
    }
}
