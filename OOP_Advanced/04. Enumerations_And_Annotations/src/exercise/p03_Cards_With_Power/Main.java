package exercise.p03_Cards_With_Power;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String rank = console.nextLine();
        String suit = console.nextLine();

        System.out.printf("Card name: %s of %s; Card power: %d",
                Ranks.valueOf(rank),
                Suits.valueOf(suit),
                Ranks.valueOf(rank).getValue() + Suits.valueOf(suit).getValue());
    }
}
