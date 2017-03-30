package exercise.p01_Card_Suit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Card Suits:");
        for (CardSuits cardSuits : CardSuits.values()) {
            System.out.printf("Ordinal value: %s; Name value: %s%n", cardSuits.ordinal(), cardSuits.name());
        }
    }
}
