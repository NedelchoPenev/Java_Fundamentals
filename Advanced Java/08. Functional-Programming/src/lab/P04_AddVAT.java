package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class P04_AddVAT {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String[] numbersAsString = console.readLine().split(", ");
        UnaryOperator<Double> vat = n -> n * 1.20;

        List<Double> numbers = new ArrayList<>();
        for (String num : numbersAsString) {
            numbers.add(Double.parseDouble(num));
        }

        System.out.println("Prices with VAT:");
        for (Double number : numbers) {
            System.out.println(String.format("%.2f", vat.apply(number)).replace(".", ","));
        }
    }
}
