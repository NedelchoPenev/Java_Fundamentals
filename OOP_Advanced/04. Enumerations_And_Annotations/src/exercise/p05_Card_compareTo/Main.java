package exercise.p05_Card_compareTo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String firstCardRank = console.nextLine();
        String firstCardSuit = console.nextLine();
        String secondCardRank = console.nextLine();
        String secondCardSuit = console.nextLine();

        Card firstCard = new Card(Ranks.valueOf(firstCardRank), Suits.valueOf(firstCardSuit));
        Card secondCard = new Card(Ranks.valueOf(secondCardRank), Suits.valueOf(secondCardSuit));

        Card winner = firstCard.compareTo(secondCard) > 0 ? firstCard : secondCard;
        System.out.println(winner);
    }
}
