package exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09_CustomComparator {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Comparator<Integer> comparator = (o1, o2) -> {
            if (o1 % 2 == 0 && o2 % 2 != 0){
                return -1;
            } else if (o1 % 2 != 0 && o2 % 2 == 0){
                return 1;
            } else {
                return o1 - o2;
            }
        };

        numbers.stream().sorted(comparator).forEach(n -> System.out.printf("%d ", n));
    }
}
