package lab;

import java.util.HashSet;
import java.util.Scanner;

public class p1_ParkingLot {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);

        HashSet<String> parking = new HashSet<>();
        while (true) {
            String input = console.nextLine();
            if (input.equals("END")) {
                break;
            }
            String[] line = input.split(", ");
            String direction = line[0];
            String plate = line[1];

            if (direction.equals("IN")){
                parking.add(plate);
            } else {
                parking.remove(plate);
            }
        }

        if (parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        for (String car : parking) {
            System.out.println(car);
        }
    }
}
