package exercise.p08_Card_Game;

public class Card implements Comparable<Card>{

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
        return String.format("%s of %s", rank.name(), suit.name());
    }

    @Override
    public int compareTo(Card card) {
        return this.getPower() - card.getPower();
    }
}
