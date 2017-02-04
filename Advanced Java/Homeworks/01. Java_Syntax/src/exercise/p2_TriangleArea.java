package exercise;

import java.util.Scanner;

public class p2_TriangleArea {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int aX = console.nextInt();
        int aY = console.nextInt();
        int bX = console.nextInt();
        int bY = console.nextInt();
        int cX = console.nextInt();
        int cY = console.nextInt();

        double area = (aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) / 2;

        System.out.printf("%.0f", Math.abs(area));
    }
}
