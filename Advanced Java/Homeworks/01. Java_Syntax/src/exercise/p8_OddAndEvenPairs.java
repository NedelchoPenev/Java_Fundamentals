package exercise;

import java.util.Scanner;

public class p8_OddAndEvenPairs {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] numbers = console.nextLine().split(" ");

        if (numbers.length % 2 != 0) {
            System.out.println("invalid length");
        } else {
            for (int i = 0; i < numbers.length - 1; i+=2) {
                int firstNum = Integer.parseInt(numbers[i]);
                int secondNum = Integer.parseInt(numbers[i + 1]);

                if (firstNum % 2 == 0 && secondNum % 2 == 0) {
                    System.out.printf("%d, %d -> both are even\n", firstNum, secondNum);
                } else if (firstNum % 2 != 0 && secondNum % 2 != 0){
                    System.out.printf("%d, %d -> both are odd\n", firstNum, secondNum);
                } else {
                    System.out.printf("%d, %d -> different\n", firstNum, secondNum);
                }
            }
        }
    }
}
