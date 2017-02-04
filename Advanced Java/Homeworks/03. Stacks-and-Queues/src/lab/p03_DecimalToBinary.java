package lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p03_DecimalToBinary {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();

        if (number == 0){
            System.out.println(0);
        }

        while (number != 0){
            binary.push(number % 2);
            number /= 2;
        }

        for (Integer num : binary) {
            System.out.print(num);
        }
    }
}
