package lab.p03_Coffee_Machine;

public class Coffee {

    private CoffeeType type;
    private CoffeeSize size;

    public Coffee(CoffeeSize size, CoffeeType type) {
        this.size = size;
        this.type = type;
    }

    public int getPrice() {
        return this.size.getPrice();
    }

    @Override
    public String toString() {
        return this.size + " " + this.type;
    }
}
