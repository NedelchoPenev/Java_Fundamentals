package Need_For_Speed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        CarManager carManager = new CarManager();

        while (true) {
            String input = console.readLine();
            if ("Cops Are Here".equals(input)) {
                break;
            }

            String[] params = input.split("\\s+");
            String command = params[0];

            switch (command) {
                case "register":
                    int id = Integer.parseInt(params[1]);
                    String type = params[2];
                    String brand = params[3];
                    String model = params[4];
                    int year = Integer.parseInt(params[5]);
                    int horsepower = Integer.parseInt(params[6]);
                    int acceleration = Integer.parseInt(params[7]);
                    int suspension = Integer.parseInt(params[8]);
                    int durability = Integer.parseInt(params[9]);
                    carManager.register(
                            id, type, brand, model, year, horsepower, acceleration, suspension, durability);
                    break;
                case "check":
                    int idForCheck = Integer.parseInt(params[1]);
                    System.out.println(carManager.check(idForCheck));
                    break;
                case "open":
                    int idRace = Integer.parseInt(params[1]);
                    String typeR = params[2];
                    int length = Integer.parseInt(params[3]);
                    String route = params[4];
                    int prize = Integer.parseInt(params[5]);
                    carManager.open(idRace, typeR, length, route, prize);
                    break;
                case "participate":
                    int carId = Integer.parseInt(params[1]);
                    int raceId = Integer.parseInt(params[2]);
                    carManager.participate(carId, raceId);
                    break;
                case "start":
                    int raceIdS = Integer.parseInt(params[1]);
                    System.out.print(carManager.start(raceIdS));
                    break;
                case "park":
                    int carIdP = Integer.parseInt(params[1]);
                    carManager.park(carIdP);
                    break;
                case "unpark":
                    int carIdUP = Integer.parseInt(params[1]);
                    carManager.unpark(carIdUP);
                    break;
                case "tune":
                    int tuneIndex = Integer.parseInt(params[1]);
                    String tuneAddOn = params[2];
                    carManager.tune(tuneIndex, tuneAddOn);
                    break;
            }
        }
    }
}
