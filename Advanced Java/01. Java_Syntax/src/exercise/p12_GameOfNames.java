package exercise;

import java.util.Scanner;

public class p12_GameOfNames {

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        int lines = Integer.parseInt(input.nextLine());

        int totalPoints = Integer.MIN_VALUE;
        String winner = "";
        for (int i = 0; i < lines; i++) {
            String name = input.nextLine();
            int points = Integer.parseInt(input.nextLine());

            int currentPoints = 0;
            for (int j = 0; j < name.length(); j++) {
                if (name.codePointAt(j) % 2 == 0) {
                    currentPoints += name.codePointAt(j);
                } else {
                    currentPoints -= name.codePointAt(j);
                }
            }
            currentPoints += points;

            if (currentPoints > totalPoints) {
                totalPoints = currentPoints;
                winner = name;
            }
        }

        System.out.printf("The winner is %s - %s points", winner, totalPoints);
    }
}
