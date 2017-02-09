package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class P04_AverageOfDoubles {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = Arrays.asList(console.readLine().split("\\s+"));
        OptionalDouble average = input.stream()
                .filter(s -> !s.equals(""))
                .mapToDouble(Double::parseDouble)
                .average();

        if (average.isPresent()){
            System.out.printf("%.2f", average.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
