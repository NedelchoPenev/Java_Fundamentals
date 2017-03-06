package exercise.P02_Vehicles_Extension;

import exercise.P02_Vehicles_Extension.modules.Bus;
import exercise.P02_Vehicles_Extension.modules.Car;
import exercise.P02_Vehicles_Extension.modules.Truck;
import exercise.P02_Vehicles_Extension.modules.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] carArgs = console.readLine().split("\\s+");
        double carFuel = Double.parseDouble(carArgs[1]);
        double carConsummation = Double.parseDouble(carArgs[2]);
        double carTank = Double.parseDouble(carArgs[3]);
        Vehicle car = new Car(carFuel, carConsummation, carTank);

        String[] truckArgs = console.readLine().split("\\s+");
        double truckFuel = Double.parseDouble(truckArgs[1]);
        double truckConsummation = Double.parseDouble(truckArgs[2]);
        double truckTank = Double.parseDouble(truckArgs[3]);
        Vehicle truck = new Truck(truckFuel, truckConsummation, truckTank);

        String[] busArgs = console.readLine().split("\\s+");
        double busFuel = Double.parseDouble(busArgs[1]);
        double busConsummation = Double.parseDouble(busArgs[2]);
        double busTank = Double.parseDouble(busArgs[3]);
        Vehicle bus = new Bus(busFuel, busConsummation, busTank);

        int lines = Integer.parseInt(console.readLine());

        for (int i = 0; i < lines; i++) {
            String[] input = console.readLine().split("\\s+");
            String command = input[0];
            String vehicle = input[1];
            double kmOrLiters = Double.parseDouble(input[2]);
            DecimalFormat format = new DecimalFormat("0.######");

            try {
                switch (vehicle) {
                    case "Car":
                        if (command.equals("Refuel")) {
                            car.refuel(kmOrLiters);
                        } else if (command.equals("Drive")) {
                            car.drive(kmOrLiters);
                            System.out.printf("Car travelled %s km%n", format.format(kmOrLiters));
                        }
                        break;
                    case "Truck":
                        if (command.equals("Refuel")) {
                            truck.refuel(kmOrLiters);
                        } else if (command.equals("Drive")) {
                            truck.drive(kmOrLiters);
                            System.out.printf("Truck travelled %s km%n", format.format(kmOrLiters));
                        }
                        break;
                    case "Bus":
                        if (command.equals("Refuel")) {
                            bus.refuel(kmOrLiters);
                        } else if (command.equals("Drive")) {
                            bus.drive(kmOrLiters, false);
                            System.out.printf("Bus travelled %s km%n", format.format(kmOrLiters));
                        } else {
                            bus.drive(kmOrLiters, true);
                            System.out.printf("Bus travelled %s km%n", format.format(kmOrLiters));
                        }
                        break;
                }
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);

    }
}

