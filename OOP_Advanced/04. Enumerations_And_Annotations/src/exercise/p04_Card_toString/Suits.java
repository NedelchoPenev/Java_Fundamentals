package exercise.p04_Card_toString;

public enum  Suits {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int value;

    Suits(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}
