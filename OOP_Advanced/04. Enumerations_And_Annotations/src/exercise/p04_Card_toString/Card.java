package exercise.p04_Card_toString;

public class Card {

    private Ranks rank;
    private Suits suit;

    public Card(Ranks rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getName(){
        return String.format("%s of %s", rank.name(), suit.name());
    }

    public int getPower(){
        return rank.getValue() + suit.getValue();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s; Card power: %d", this.getName(), this.getPower());
    }
}
