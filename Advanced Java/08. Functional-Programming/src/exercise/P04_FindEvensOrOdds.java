package exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P04_FindEvensOrOdds {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        int[] range = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] numbers = IntStream.rangeClosed(range[0], range[1]).toArray();
        String command = console.nextLine();
        if (command.equals("odd")){
            filter(numbers, x -> x % 2 != 0);
        } else {
            filter(numbers, x -> x % 2 == 0);
        }
    }

    private static void filter(int[] numbers, Predicate<Integer> predicate){
        for (int number : numbers) {
            if (predicate.test(number)){
                System.out.printf("%d ", number);
            }
        }
    }
}
