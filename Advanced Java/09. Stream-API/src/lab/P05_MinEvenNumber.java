package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class P05_MinEvenNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        OptionalDouble min = Arrays.stream(console.readLine().split("\\s+"))
                .filter(w -> !w.isEmpty())
                .mapToDouble(Double::parseDouble)
                .filter(n -> n % 2 == 0)
                .min();

        if (min.isPresent()){
            System.out.printf("%.2f", min.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
