package exercise.P04_Mordors_Cruelty_Plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String[] foods = console.readLine().split("\\s+");

        Hero gandalf = new Hero();
        for (String food : foods) {
            gandalf.calculatePoints(food);
        }

        System.out.println(gandalf.getPoints());
        System.out.println(gandalf.getMood());
    }
}
