package exercise.p08_Card_Game;

import java.util.TreeSet;

public class Player {

    private TreeSet<Card> cards;
    private String name;

    public Player(String name) {
        this.name = name;
        this.cards = new TreeSet<>();
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public Card highestCard(){
        return this.cards.last();
    }

    public int handSize(){
        return this.cards.size();
    }

    @Override
    public String toString() {
        return String.format("%s wins with %s.", this.name, this.highestCard());
    }
}
