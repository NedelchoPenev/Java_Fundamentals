package exercise.p04_Card_toString;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String rank = console.nextLine();
        String suit = console.nextLine();

        Card card = new Card(Ranks.valueOf(rank), Suits.valueOf(suit));
        System.out.println(card);
    }
}
