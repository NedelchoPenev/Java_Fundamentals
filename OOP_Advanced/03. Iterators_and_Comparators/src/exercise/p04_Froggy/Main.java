package exercise.p04_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> jumps = Arrays.stream(console.readLine().split("[\\s,]+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lake<Integer> lake = new Lake<>(jumps);

        List<String> output = new ArrayList<>();
        for (Integer jump : lake) {
            output.add(String.valueOf(jump));
        }

        System.out.println(String.join(", ", output));
    }
}
