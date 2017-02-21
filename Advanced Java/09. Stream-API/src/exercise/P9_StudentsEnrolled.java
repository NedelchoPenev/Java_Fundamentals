package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class P9_StudentsEnrolled {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, List<Integer>> names = new LinkedHashMap<>();

        while (true) {
            String[] input = console.readLine().split("\\s+");
            if (input[0].equals("END")) {
                break;
            }

            String facultyNumber = input[0];
            names.put(facultyNumber, new ArrayList<>());

            for (int i = 1; i < input.length; i++) {
                names.get(facultyNumber).add(Integer.parseInt(input[i]));
            }
        }

        names.entrySet().stream()
                .filter(f -> f.getKey().endsWith("14") || f.getKey().endsWith("15"))
                .forEach(m -> {
                    m.getValue().forEach(p -> System.out.printf("%d ", p));
                    System.out.println();
                });
    }
}
