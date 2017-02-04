package lab;

import java.util.Scanner;

public class P09_CalculateTriangleAreaMethod {

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        double base = input.nextDouble();
        double height = input.nextDouble();

        System.out.printf("Area = %.2f", calcTriangleArea(base, height));
    }

    static double calcTriangleArea(double base, double height){
        return base * height * 0.5;
    }
}
