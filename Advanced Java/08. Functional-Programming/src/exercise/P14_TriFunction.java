package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@FunctionalInterface
interface TriFunction<T1, T2, T3, TR> {
    public TR apply(T1 first, T2 second, T3 third);
}

public class P14_TriFunction {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(console.readLine());
        List<String> names = Arrays.stream(console.readLine().split("\\s+")).collect(Collectors.toList());

        BiFunction<String, Integer, Boolean> checkForAscii = (name, targetAscii)  -> {
            int totalSum = 0;

            for (int i = 0; i < name.length(); i++) {
                totalSum += name.charAt(i);
            }

            if (totalSum >= targetAscii){
                return true;
            }

            return false;
        };

        TriFunction<Integer, BiFunction<String, Integer, Boolean>, List<String>, String> findFirstOccurance =
                (targetCode, biFunction, collection) -> {
                    for (String name : collection) {
                        if (biFunction.apply(name, targetCode)){
                            return name;
                        }
                    }

                    return "";
                };

        String name = findFirstOccurance.apply(target, checkForAscii, names);
        System.out.println(name);
    }
}
