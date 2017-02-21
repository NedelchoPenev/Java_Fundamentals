package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2_StudentsByFirstAndLastName {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>();
        while (true) {
            String input = console.readLine();
            if (input.equals("END")) {
                break;
            }

            names.add(input);
        }
        names.stream().filter(fn -> {
            String firstName = fn.substring(0, fn.indexOf(" "));
            String secondName = fn.substring(fn.indexOf(" ") + 1);
            return(firstName.compareTo(secondName) < 0);
        }).forEach(System.out::println);
    }
}
