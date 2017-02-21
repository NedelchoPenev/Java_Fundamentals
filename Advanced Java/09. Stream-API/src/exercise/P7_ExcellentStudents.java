package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class P7_ExcellentStudents {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, List<Integer>> names = new LinkedHashMap<>();

        while (true) {
            String[] input = console.readLine().split("\\s+");
            if (input[0].equals("END")) {
                break;
            }

            String name = input[0] + " " + input[1];
            names.put(name, new ArrayList<>());

            for (int i = 2; i < input.length; i++) {
                names.get(name).add(Integer.parseInt(input[i]));
            }
        }

        names.entrySet().stream()
                .filter(n -> n.getValue().contains(6))
                .forEach(p -> System.out.println(p.getKey()));
    }
}
