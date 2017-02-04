package lab;

import java.util.Scanner;

public class P05_TransportPrice {

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        int distance = Integer.parseInt(input.nextLine());
        String timeOfTheDay = input.nextLine();

        double taxiTax = 0.79;
        if (timeOfTheDay.equals("night")) {
            taxiTax = 0.90;
        }

        if (distance < 20){
            System.out.printf("%.2f", (distance * taxiTax) + 0.7);
        } else if (distance < 100){
            System.out.printf("%.2f", distance * 0.09);
        } else {
            System.out.printf("%.2f", distance * 0.06);
        }
    }
}
