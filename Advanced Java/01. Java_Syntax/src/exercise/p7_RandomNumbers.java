package exercise;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class p7_RandomNumbers {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int firstNum = console.nextInt();
        int secondNum = console.nextInt();

        int min = Math.min(firstNum, secondNum);
        int max = Math.max(firstNum, secondNum);

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numbers.add(i);
        }

        Random rnd = new Random();
        int count = numbers.size();
        while (count > 0) {
            int randomIndex = rnd.nextInt(count);
            System.out.format("%d ", numbers.remove(randomIndex));
            count--;
        }
    }
}
