package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P07_MapDistricts {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<Integer>> cities = new HashMap<>();
        String[] input = console.readLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            String[] split = input[i].split(":");
            String city = split[0];
            int population = Integer.parseInt(split[1]);

            cities.putIfAbsent(city, new ArrayList<>());
            cities.get(city).add(population);
        }

        int bound = Integer.parseInt(console.readLine());

        cities.entrySet().stream()
                .filter(getFilterByPopulationPredicate(bound))
                .sorted(getSortedByDescendingPopulationComparator())
                .forEach(getPrintMapEntryConsumer());
    }

    private static Consumer<? super Map.Entry<String,ArrayList<Integer>>> getPrintMapEntryConsumer() {
        return k -> {
            System.out.printf("%s: ", k.getKey());
            k.getValue().stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(5)
                    .forEach(v -> System.out.printf("%d ", v));
            System.out.println();
        };
    }

    private static Comparator<? super Map.Entry<String,ArrayList<Integer>>> getSortedByDescendingPopulationComparator() {
        return (v1, v2) -> Integer.compare(
                v2.getValue().stream().mapToInt(Integer::intValue).sum(),
                v1.getValue().stream().mapToInt(Integer::intValue).sum()
        );
    }

    private static Predicate<? super Map.Entry<String,ArrayList<Integer>>> getFilterByPopulationPredicate(int bound) {
        return kv -> kv.getValue().stream()
                .mapToInt(Integer::intValue)
                .sum() >= bound;
    }
}
