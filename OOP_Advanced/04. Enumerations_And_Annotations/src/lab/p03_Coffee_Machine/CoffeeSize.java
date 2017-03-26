package lab.p03_Coffee_Machine;

public enum  CoffeeSize {

    SMALL(50, 50), NORMAL(100, 75), DOUBLE(200, 100);

    private int ml;
    private int c;

    CoffeeSize(int ml, int c) {
        this.ml = ml;
        this.c = c;
    }

    int getMl() {
        return ml;
    }

    int getPrice() {
        return c;
    }

    @Override
    public String toString() {
        String lower = super.name().substring(1).toLowerCase();
        return super.name().charAt(0) + lower;
    }
}
