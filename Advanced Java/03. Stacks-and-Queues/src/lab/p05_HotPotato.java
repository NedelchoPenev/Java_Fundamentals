package lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p05_HotPotato {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String[] input = console.nextLine().split(" ");
        int killNumber = Integer.parseInt(console.nextLine());
        ArrayDeque<String> players = new ArrayDeque<>();

        Collections.addAll(players, input);

        while (players.size() > 1){
            for (int i = 1; i < killNumber; i++) {
                players.offer(players.poll());
            }

            System.out.println("Removed " + players.poll());
        }

        System.out.println("Last is " + players.poll());
    }
}
