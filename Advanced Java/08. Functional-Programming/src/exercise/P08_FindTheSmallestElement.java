package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P08_FindTheSmallestElement {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> function = n -> {
            int minNum = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < n.size(); i++) {
                if (n.get(i) <= minNum){
                    minNum = n.get(i);
                    minIndex = i;
                }
            }
            return minIndex;
        };

        System.out.println(function.apply(numbers));
    }
}
