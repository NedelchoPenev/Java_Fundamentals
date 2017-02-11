package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05_FilterByAge {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(console.readLine());
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String[] split = console.readLine().split(", ");
            String name = split[0];
            int age = Integer.parseInt(split[1]);
            people.put(name, age);
        }

        String condition = console.readLine();
        int age = Integer.parseInt(console.readLine());
        String format = console.readLine();

        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);
        getPrintFilteredStudent(people, tester, printer);
    }

    private static void getPrintFilteredStudent(LinkedHashMap<String, Integer> people, Predicate<Integer> tester, Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey()))){
                printer.accept(person);
            }
        }
    }

    private static Consumer<Map.Entry<String,Integer>> createPrinter(String format) {
        switch (format) {
            case "name":
                return person -> System.out.printf("%s%n", person.getKey());
            case "age":
                return person -> System.out.printf("%d%n", person.getValue());
            case "name age":
                return person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
            default:
                return null;
        }
    }

    private static Predicate<Integer> createTester(String condition, int age) {
        switch (condition) {
            case "younger":
                return x -> x < age;
            case "older":
                return x -> x >= age;
            default:
                return null;
        }
    }
}
