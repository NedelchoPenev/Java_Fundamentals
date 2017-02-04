package lab;

import java.util.Scanner;

public class P02_AverageOfThreeNumbers {

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        double first = input.nextDouble();
        double second = input.nextDouble();
        double third = input.nextDouble();

        double average = (first + second + third) / 3;

        System.out.printf("%.2f", average);
    }
}
