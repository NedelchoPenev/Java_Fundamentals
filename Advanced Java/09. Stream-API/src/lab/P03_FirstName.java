package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class P03_FirstName {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.asList(console.readLine().split("\\s+"));
        Set<Character> letters = Arrays.stream(console.readLine().split("\\s+"))
                .map(s -> s.toLowerCase().charAt(0))
                .collect(Collectors.toSet());

        Optional<String> first = names.stream()
                .filter(n -> letters.contains(n.toLowerCase().charAt(0)))
                .sorted()
                .findFirst();

        if (first.isPresent()){
            System.out.println(first.get());
        } else {
            System.out.println("No match");
        }
    }
}
