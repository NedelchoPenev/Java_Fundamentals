package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;

public class P13_InfernoIII {

    private static int[] numbers;
    private static HashMap<String, HashMap<Integer, Predicate<Integer>>> filters;

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        numbers = Arrays.stream(console.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        filters = new HashMap<>();

        while (true) {
            String input = console.readLine();
            if ("Forge".equals(input)) {
                break;
            }

            String[] split = input.split(";");
            String command = split[0];
            String modifier = split[1];
            Integer variable = Integer.parseInt(split[2]);

           Predicate<Integer> predicate;
           if ("Exclude".equals(command)){
               predicate = buildPredicate(modifier, variable);
               if (!filters.containsKey(modifier)){
                   filters.put(modifier, new HashMap<>());
               }

               filters.get(modifier).put(variable, predicate);
           } else if ("Reverse".equals(command)){
               if (filters.containsKey(modifier)){
                   if (filters.get(modifier).containsKey(variable)){
                       filters.get(modifier).remove(variable);
                   }
               }
           }
        }

        List<Predicate<Integer>> predicates = getPredicatesList();
        for (int i = 0; i < numbers.length; i++) {
            boolean filter = false;
            for (Predicate<Integer> predicate : predicates) {
                if (predicate.test(i)){
                    filter = true;
                }
            }

            if (!filter){
                System.out.printf("%s ", numbers[i]);
            }
        }
    }

    private static List<Predicate<Integer>> getPredicatesList() {
        List<Predicate<Integer>> predicates = new ArrayList<>();
        for (Map.Entry<String, HashMap<Integer, Predicate<Integer>>> entry : filters.entrySet()) {
            for (Map.Entry<Integer, Predicate<Integer>> innerEntry : entry.getValue().entrySet()) {
                predicates.add(innerEntry.getValue());
            }
        }

        return predicates;
    }


    private static Predicate<Integer> buildPredicate(String modifier, Integer variable) {
        switch (modifier) {
            case "Sum Left":
                return x -> (x - 1 < 0 ? 0 : numbers[x - 1]) + numbers[x] == variable;
            case "Sum Right":
                return x -> numbers[x] + (x + 1 >= numbers.length ? 0 : numbers[x + 1]) == variable;
            case "Sum Left Right":
                return x -> (x - 1 < 0 ? 0 : numbers[x - 1]) + numbers[x] + (x + 1 >= numbers.length ? 0 : numbers[x + 1]) == variable;
            default:
                return null;
        }
    }
}
