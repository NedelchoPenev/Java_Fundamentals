package exercise;

import java.util.Scanner;

public class p4_CalculateExpression {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double a = console.nextDouble();
        double b = console.nextDouble();
        double c = console.nextDouble();

        double formulaOneFirstPart = (Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2));
        double formulaOneSecondPart = (a + b + c) / Math.sqrt(c);
        double formulaOneResult = Math.pow(formulaOneFirstPart, formulaOneSecondPart);

        double formulaTwo = Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3), a - b);

        double difference = ((a + b + c) / 3) - ((formulaOneResult + formulaTwo) / 2);

        System.out.printf("F1 result: %1$.2f; F2 result: %2$.2f; Diff: %3$.2f",
                              formulaOneResult, formulaTwo, Math.abs(difference));
    }
}
