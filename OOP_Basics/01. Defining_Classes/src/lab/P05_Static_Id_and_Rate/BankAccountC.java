package lab.P05_Static_Id_and_Rate;

public class BankAccountC {

    private static final double DEFAULT_INTEREST = 0.02;

    private static double rate = DEFAULT_INTEREST;
    private static int bankAccountsCount;

    private int id;
    private double balance;

    public BankAccountC() {
        this.id = ++bankAccountsCount;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(Double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public static void setInterest(Double interest) {
        rate = interest;
    }

    public double getInterest(Integer years) {
        return this.balance * years * rate;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("ID%d", this.id);
    }
}
