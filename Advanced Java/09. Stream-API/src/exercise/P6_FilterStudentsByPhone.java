package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class P6_FilterStudentsByPhone {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, String> names = new LinkedHashMap<>();

        while (true) {
            String[] input = console.readLine().split("\\s+");
            if (input[0].equals("END")) {
                break;
            }

            String name = input[0] + " " + input[1];
            String phone = input[2];

            names.put(name, phone);
        }

        names.entrySet().stream()
                .filter(p -> p.getValue().startsWith("02") || p.getValue().startsWith("+3592"))
                .forEach(p -> System.out.println(p.getKey()));
    }
}
