package exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class P05_AppliedArithmetics {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        int[] numbers = Arrays.stream(console.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Consumer<Integer> consumer = n -> System.out.printf("%d ", n);

        while (true) {
            String input = console.nextLine();
            if (input.equals("end")) {
                break;
            }

            switch (input){
                case "add":
                    CommandsApply(numbers, n -> n + 1);
                    break;
                case "multiply":
                    CommandsApply(numbers, n -> n * 2);
                    break;
                case "subtract":
                    CommandsApply(numbers, n -> n - 1);
                    break;
                case "print":
                    for (int number : numbers) {
                        consumer.accept(number);
                    }
                    System.out.println();
                    break;
            }
        }
    }

    private static void CommandsApply(int[] numbers, Function<Integer, Integer> function){

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = function.apply(numbers[i]);
        }
    }
}
