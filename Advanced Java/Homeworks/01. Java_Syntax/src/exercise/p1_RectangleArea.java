package exercise;

import java.util.Scanner;

public class p1_RectangleArea {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double sideA = console.nextDouble();
        double sideB = console.nextDouble();
        double area = sideA * sideB;

        System.out.printf("%.2f", area);
    }
}
