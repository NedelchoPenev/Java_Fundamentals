package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class P3_StudentsByAge {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Integer> names = new LinkedHashMap<>();

        while (true) {
            String[] input = console.readLine().split("\\s+");
            if (input[0].equals("END")) {
                break;
            }

            String name = input[0] + " " + input[1];
            int age = Integer.parseInt(input[2]);
            names.put(name, age);
        }
        names.entrySet().stream()
                .filter(a -> a.getValue() >= 18 && a.getValue() <= 24)
                .forEach(p -> System.out.printf("%s %d%n", p.getKey(), p.getValue()));
    }
}
