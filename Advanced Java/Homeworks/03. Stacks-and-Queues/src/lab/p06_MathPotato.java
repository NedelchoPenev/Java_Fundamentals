package lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p06_MathPotato {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String[] input = console.nextLine().split(" ");
        int killNumber = Integer.parseInt(console.nextLine());
        ArrayDeque<String> players = new ArrayDeque<>();

        Collections.addAll(players, input);

        int cycle = 1;
        while (players.size() > 1){
            for (int i = 1; i < killNumber; i++) {
                players.offer(players.poll());
            }

            if (isPrime(cycle)){
                System.out.println("Prime " + players.peek());
            } else {
                System.out.println("Removed " + players.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + players.poll());
    }

    private static boolean isPrime(int number) {
        if (number == 1){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
