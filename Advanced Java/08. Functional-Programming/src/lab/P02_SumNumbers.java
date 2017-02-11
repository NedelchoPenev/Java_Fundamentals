package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class P02_SumNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        List<String> numsAsString = Arrays.asList(console.readLine().split(", "));
        Function<String, Integer> parser = Integer::parseInt;

        List<Integer> numbers = new ArrayList<>();
        for (String number : numsAsString) {
            numbers.add(parser.apply(number));
        }

        System.out.printf("Count = %d%n", numbers.size());
        numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.printf("Sum = %d",numbers.stream().mapToInt(Integer::intValue).sum());
    }
}
