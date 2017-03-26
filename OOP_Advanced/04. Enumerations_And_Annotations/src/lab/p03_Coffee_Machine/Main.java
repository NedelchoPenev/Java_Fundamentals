package lab.p03_Coffee_Machine;

public class Main {

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        cm.insertCoin("TEN");
        cm.insertCoin("TEN");
        cm.buyCoffee("SMALL", "Latte");
        cm.insertCoin("FIFTY");
        cm.buyCoffee("SMALL", "Latte");

        for (Coffee c : cm.coffeesSold()) {
            System.out.println(c);
        }
    }
}
