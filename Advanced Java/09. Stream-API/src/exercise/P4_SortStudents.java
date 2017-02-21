package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P4_SortStudents {

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
        Comparator<String> byFirstName = (n1, n2) -> {
            String n1FirstName = n1.substring(0, n1.indexOf(" "));
            String n2FirstName = n2.substring(0, n2.indexOf(" "));
            return n2FirstName.compareTo(n1FirstName);
        };
        Comparator<String> byLastName = (n1, n2) -> {
            String n1LastName = n1.substring(n1.indexOf(" ") + 1);
            String n2LastName = n2.substring(n2.indexOf(" ") + 1);
            return n1LastName.compareTo(n2LastName);
        };

        names.stream()
                .sorted(byFirstName)
                .sorted(byLastName)
                .forEach(System.out::println);
    }
}
