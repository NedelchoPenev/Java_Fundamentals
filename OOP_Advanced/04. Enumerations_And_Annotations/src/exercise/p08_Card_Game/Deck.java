package exercise.p08_Card_Game;

import java.util.HashMap;

public class Deck {

    private HashMap<String, Card> deck;

    public Deck() {
        this.deck = new HashMap<>();
        newDeck();
    }

    private void newDeck() {
        for (Suits suit : Suits.values()) {
            for (Ranks ranks : Ranks.values()) {
                Card card = new Card(ranks, suit);
                this.deck.put(card.getName(), card);
            }
        }
    }

    public boolean cardIsInTheDeck(String card){
        return this.deck.containsKey(card);
    }

    public Card withdrawnCard(String card){
        if (!cardIsInTheDeck(card)){
            throw new IllegalStateException("No such card exists.");
        } else {
            if (this.deck.get(card) == null){
                throw new IllegalStateException("Card is not in the deck.");
            }
            Card card1 = this.deck.get(card);
            this.deck.put(card, null);

            return card1;
        }
    }
}
