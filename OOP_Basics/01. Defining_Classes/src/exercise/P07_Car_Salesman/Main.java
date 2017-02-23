package exercise.P07_Car_Salesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int linesEngines = Integer.parseInt(console.readLine());

        Set<Engine> engines = new HashSet<>();
        for (int i = 0; i < linesEngines; i++) {
            String[] split = console.readLine().split("\\s+");
            String model = split[0];
            int power = Integer.parseInt(split[1]);
            int displacements;
            String efficiency;

            Engine engine = new Engine(model, power);
            if (split.length == 4) {
                displacements = Integer.parseInt(split[2]);
                engine.setDisplacement(displacements);
                efficiency = split[3];
                engine.setEfficiency(efficiency);
            } else if (split.length == 3) {
                if (isNumber(split[2])) {
                    displacements = Integer.parseInt(split[2]);
                    engine.setDisplacement(displacements);
                } else {
                    efficiency = split[2];
                    engine.setEfficiency(efficiency);
                }
            }

            engines.add(engine);
        }

        int linesCar = Integer.parseInt(console.readLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < linesCar; i++) {
            String[] input = console.readLine().split("\\s+");
            String model = input[0];
            String engine = input[1];
            int weight;
            String color;

            Engine currentEngine = engines.stream()
                    .filter(eng -> eng.getModel().equals(engine))
                    .findAny().get();
            Car car = new Car(model, currentEngine);
            if (input.length == 4) {
                weight = Integer.parseInt(input[2]);
                car.setWeight(weight);
                color = input[3];
                car.setColor(color);
            } else if (input.length == 3) {
                if (isNumber(input[2])) {
                    weight = Integer.parseInt(input[2]);
                    car.setWeight(weight);
                } else {
                    color = input[2];
                    car.setColor(color);
                }
            }

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static boolean isNumber(String split){
        try {
            Integer.parseInt(split);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }
}
