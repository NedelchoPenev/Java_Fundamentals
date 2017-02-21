package lab.P01_2_3_BankAccount;

public class BankAccount {

    private int id;
    private double balance;

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(Double amount){
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(Double amount){
        if (amount > this.balance) {
            System.out.println("Insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return String.format("ID%d", this.id);
    }
}
