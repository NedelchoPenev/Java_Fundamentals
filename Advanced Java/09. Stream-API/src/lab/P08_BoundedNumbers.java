package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P08_BoundedNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> bounds = Arrays.stream(console.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> numbers = Arrays.stream(console.readLine().split("\\s+"))
                .filter(x -> !x.isEmpty())
                .map(Integer::parseInt)
                .filter(n -> n >= Collections.min(bounds) && n <= Collections.max(bounds))
                .collect(Collectors.toList());

        for (Integer number : numbers) {
            System.out.printf("%d ", number);
        }
    }
}
