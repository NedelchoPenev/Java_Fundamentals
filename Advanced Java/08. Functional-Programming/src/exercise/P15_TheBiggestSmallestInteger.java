package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P15_TheBiggestSmallestInteger {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(console.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = console.readLine();

        Function<List<Integer>, Integer> findMin = Collections::min;
        Function<List<Integer>, Integer> findMax = Collections::max;

        TriFunction<Function<List<Integer>, Integer>, List<Integer>, Integer, Integer> result =
                (function, collection, parity) -> {
                    List<Integer> buffer = new ArrayList<>();

                    for (Integer integer : collection) {
                        if (Math.abs(integer % 2) == parity){
                            buffer.add(integer);
                        }
                    }

                    if (buffer.size() > 0){
                        return function.apply(buffer);
                    }

                    return null;
                };

        Integer number = 0;
        switch (command){
            case "minEven":
                number = result.apply(findMin, numbers, 0);
                break;
            case "maxEven":
                number = result.apply(findMax, numbers, 0);
                break;
            case "minOdd":
                number = result.apply(findMin, numbers, 1);
                break;
            case "maxOdd":
                number = result.apply(findMax, numbers, 1);
                break;
        }

        System.out.println(number == null ? "" : number);
    }
}
