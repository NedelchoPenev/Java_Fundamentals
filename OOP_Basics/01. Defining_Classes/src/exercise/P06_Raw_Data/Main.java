package exercise.P06_Raw_Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(console.readLine());

        LinkedList<Car> cars = new LinkedList<>();
        for (int i = 0; i < lines; i++) {
            String[] input = console.readLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Tire> tires = new ArrayList<Tire>(){{
                add(new Tire(Double.parseDouble(input[5]), Integer.parseInt(input[6])));
                add(new Tire(Double.parseDouble(input[7]), Integer.parseInt(input[8])));
                add(new Tire(Double.parseDouble(input[9]), Integer.parseInt(input[10])));
                add(new Tire(Double.parseDouble(input[11]), Integer.parseInt(input[12])));
            }};

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = console.readLine();
        if (command.equals("fragile")){
            cars.stream()
                    .filter(c -> c.getCargo().getType().equals("fragile"))
                    .filter(car -> {
                        for (Tire tire : car.getTires()) {
                            return tire.getPressure() < 1;
                        }
                        return false;
                    })
                    .forEach(System.out::println);
        } else {
            cars.stream()
                    .filter(c -> c.getCargo().getType().equals("flamable"))
                    .filter(c -> c.getEngine().getPower() > 250)
                    .forEach(System.out::println);
        }
    }
}
