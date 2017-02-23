package exercise.P05_Speed_Racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(console.readLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String[] split = console.readLine().split("\\s+");
            String model = split[0];
            double fuelAmount = Double.parseDouble(split[1]);
            double fuelCost = Double.parseDouble(split[2]);
            Car car = new Car(model, fuelAmount, fuelCost);
            cars.add(car);
        }
        
        while (true) {
            String input = console.readLine();
            if ("End".equals(input)) {
                break;
            }

            String[] split = input.split("\\s+");
            String model = split[1];
            int distance = Integer.parseInt(split[2]);

            for (Car car : cars) {
                if (car.getModel().equals(model)){
                    try {
                        car.drive(distance);
                    } catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }

                }
            }
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
