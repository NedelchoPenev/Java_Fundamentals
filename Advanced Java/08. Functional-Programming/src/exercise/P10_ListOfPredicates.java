package exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P10_ListOfPredicates {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        int range = Integer.parseInt(console.nextLine());
        int[] sequence = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .distinct()
                .toArray();
        int[] allNumbers = IntStream.rangeClosed(1, range).toArray();

        for (int num : sequence) {
            Predicate<Integer> predicate = n -> n % num == 0;
            allNumbers = Arrays.stream(allNumbers).filter(predicate::test).toArray();
        }

        Arrays.stream(allNumbers).forEach(n -> System.out.printf("%d ", n));
    }
}
