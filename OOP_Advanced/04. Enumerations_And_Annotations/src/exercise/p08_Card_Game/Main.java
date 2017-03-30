package exercise.p08_Card_Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Player firstPlayer = new Player(console.readLine());
        Player secondPlayer = new Player(console.readLine());
        Deck deck = new Deck();

        while (firstPlayer.handSize() < 5){
            try {
                Card card = deck.withdrawnCard(console.readLine());
                firstPlayer.addCard(card);
            } catch (IllegalStateException ex){
                System.out.println(ex.getMessage());
            }
        }

        while (secondPlayer.handSize() < 5){
            try {
                Card card = deck.withdrawnCard(console.readLine());
                secondPlayer.addCard(card);
            } catch (IllegalStateException ex){
                System.out.println(ex.getMessage());
            }
        }

        Player winner = firstPlayer.highestCard().compareTo(secondPlayer.highestCard()) > 0 ?
                firstPlayer :
                secondPlayer;

        System.out.println(winner);
    }
}
