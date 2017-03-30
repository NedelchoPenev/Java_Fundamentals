package exercise.p06_Custom_Enum_Annotations;

@MyAnnotation(category = "Suit", description = "Provides suit constants for a Card class.")
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
