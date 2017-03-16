package exercise.P04_Тelephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> numbers = Arrays.stream(console.readLine().split("\\s+")).collect(Collectors.toList());
        List<String> sites = Arrays.stream(console.readLine().split("\\s+")).collect(Collectors.toList());

        Smartphone phone = new Smartphone(numbers, sites);
        System.out.println(phone);
    }
}
