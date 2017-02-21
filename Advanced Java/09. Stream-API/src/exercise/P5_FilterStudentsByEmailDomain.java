package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class P5_FilterStudentsByEmailDomain {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, String> names = new LinkedHashMap<>();

        while (true) {
            String[] input = console.readLine().split("\\s+");
            if (input[0].equals("END")) {
                break;
            }

            String name = input[0] + " " + input[1];
            String email = input[2];

            names.put(name, email);
        }

        names.entrySet().stream()
                .filter(e -> e.getValue().endsWith("@gmail.com"))
                .forEach(p -> System.out.println(p.getKey()));
    }
}
