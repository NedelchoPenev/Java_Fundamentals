package exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;

public class P03_CustomMinFunction {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        String[] input = console.nextLine().split(" ");
        Integer[] numbers = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        Function<Integer[], Integer> function = x -> Collections.min(Arrays.asList(x));

        System.out.println(function.apply(numbers));
    }
}
