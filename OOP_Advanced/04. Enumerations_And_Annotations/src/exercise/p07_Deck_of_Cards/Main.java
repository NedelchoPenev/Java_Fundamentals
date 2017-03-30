package exercise.p07_Deck_of_Cards;

public class Main {

    public static void main(String[] args) {

        for (Suits suit : Suits.values()) {
            for (Ranks rank : Ranks.values()) {
                Card card = new Card(rank, suit);
                System.out.println(card);
            }
        }
    }
}
