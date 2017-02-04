package lab;

import java.math.BigInteger;
import java.util.Scanner;

public class P07_ProductOfNumbersN_M {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int firstNum = input.nextInt();
        int secondNum = input.nextInt();
        int number = firstNum;

        BigInteger sum = BigInteger.valueOf(firstNum);

        do {
            number++;
            sum = sum.multiply(BigInteger.valueOf(number));
        } while (number != secondNum);

        System.out.printf("product[%d..%d] = %d", firstNum, secondNum, sum);
    }
}
