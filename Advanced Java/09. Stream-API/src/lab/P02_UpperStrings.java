package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class P02_UpperStrings {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = Arrays.asList(console.readLine().split("\\s+"));

        words.stream()
                .map(String::toUpperCase)
                .forEach(w -> System.out.print(w + " "));
    }
}
