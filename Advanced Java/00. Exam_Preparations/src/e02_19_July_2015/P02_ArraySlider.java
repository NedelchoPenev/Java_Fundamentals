package e02_19_July_2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class P02_ArraySlider {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String[] array = console.readLine().trim().split("\\s+");
        BigInteger[] numbers = new BigInteger[array.length];
        for (int i = 0; i < array.length; i++) {
            numbers[i] = new BigInteger(array[i]);
        }

        int currentIndex = 0;
        while (true) {
            String[] input = console.readLine().split("\\s+");
            if ("stop".equals(input[0])) {
                break;
            }

            int offset = Integer.parseInt(input[0]) % array.length;
            String operation = input[1];
            BigInteger operand = new BigInteger(input[2]);

            if (offset < 0){
                offset += array.length;
            }

            currentIndex = (currentIndex + offset) % array.length;

            operateArray(numbers, currentIndex, operation, operand);
        }

        System.out.println(Arrays.toString(numbers));
    }

    private static void operateArray(BigInteger[] numbers, int index, String operation, BigInteger operand) {
        switch (operation){
            case "&":
                numbers[index] = numbers[index].and(operand);
                break;
            case "|":
                numbers[index] = numbers[index].or(operand);
                break;
            case "^":
                numbers[index] = numbers[index].xor(operand);
                break;
            case "+":
                numbers[index] = numbers[index].add(operand);
                break;
            case "-":
                numbers[index] = numbers[index].subtract(operand);
                break;
            case "*":
                numbers[index] = numbers[index].multiply(operand);
                break;
            case "/":
                numbers[index] = numbers[index].divide(operand);
                break;

        }

        if (numbers[index].compareTo(BigInteger.ZERO) < 0){
            numbers[index] = BigInteger.valueOf(0);
        }

    }
}
