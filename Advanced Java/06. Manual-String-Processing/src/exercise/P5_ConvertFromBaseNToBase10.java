package exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class P5_ConvertFromBaseNToBase10 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split(" ");
        int base = Integer.parseInt(input[0]);
        BigInteger number = new BigInteger(input[1], base);
        System.out.println(number.toString(10));
    }
}