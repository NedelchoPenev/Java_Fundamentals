package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p12_VehiclePark {

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        List<String> vehicles = Arrays.stream(input.nextLine().split("\\W+")).collect(Collectors.toList());

        int vehiclesSold = 0;
        while (true) {
            String comnd = input.nextLine();
            if (comnd.equals("End of customers!")) {
                break;
            }

            String[] split = comnd.split("\\W+");
            String firstLetter = String.valueOf(split[0].toLowerCase().charAt(0));
            int seats = Integer.parseInt(split[2]);
            String carSearched = firstLetter + seats;

            if (vehicles.contains(carSearched)){
                int price = firstLetter.codePointAt(0) * seats;
                System.out.printf("Yes, sold for %d$%n", price);
                vehiclesSold++;
                vehicles.remove(carSearched);
            } else {
                System.out.println("No");
            }
        }

        String vehicleLeft = vehicles.toString();
        System.out.printf("Vehicles left: %s", vehicleLeft.substring(1, vehicleLeft.length() - 1));
        System.out.printf("%nVehicles sold: %d", vehiclesSold);
    }
}
