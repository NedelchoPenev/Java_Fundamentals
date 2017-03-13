package Need_For_Speed;

import Need_For_Speed.Cars.Car;
import Need_For_Speed.Cars.PerformanceCar;
import Need_For_Speed.Cars.ShowCar;
import Need_For_Speed.Garage.Garage;
import Need_For_Speed.Races.CasualRace;
import Need_For_Speed.Races.DragRace;
import Need_For_Speed.Races.DriftRace;
import Need_For_Speed.Races.Race;

import java.util.HashMap;
import java.util.Map;

public class CarManager {

    private HashMap<Integer, Car> cars;
    private HashMap<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new HashMap<>();
        this.races = new HashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int
            acceleration, int suspension, int durability) {

        Car car = null;
        if (type.equals("Performance")) {
            car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        } else {
            car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        }

        cars.put(id, car);
    }

    public String check(int id) {
        return this.cars.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool) {

        Race race = null;
        switch (type) {
            case "Casual":
                race = new CasualRace(length, route, prizePool);
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool);
                break;
            default:
                race = new DriftRace(length, route, prizePool);
                break;
        }

        this.races.put(id, race);
    }

    public void participate(int carId, int raceId) {
        if (!this.cars.get(carId).isInGarage() && this.races.containsKey(raceId)) {
            this.races.get(raceId).addCar(this.cars.get(carId));
        }
    }

    public String start(int id) {
        StringBuilder sb = new StringBuilder();
        if (this.races.containsKey(id)) {
            this.races.get(id).race();
            if (this.races.get(id).getCars().isEmpty()) {
                this.races.remove(id);
                sb.append("Cannot start the race with zero participants.")
                        .append(System.lineSeparator());
            } else {
                int prizeMoney;
                sb.append(String.format("%s - %d%n",
                        this.races.get(id).getRoute(),
                        this.races.get(id).getLength()));

                int place = 1;
                Map<Car, Integer> winners = this.races.get(id).getRaceWinners();
                for (Car car : winners.keySet()) {
                    if (place == 1) {
                        prizeMoney = (this.races.get(id).getPrizePool() * 50) / 100;
                    } else if (place == 2) {
                        prizeMoney = (this.races.get(id).getPrizePool() * 30) / 100;
                    } else {
                        prizeMoney = (this.races.get(id).getPrizePool() * 20) / 100;
                    }
                    sb.append(String.format("%d. %s %s %dPP - $%d%n",
                            place,
                            car.getBrand(),
                            car.getModel(),
                            winners.get(car),
                            prizeMoney));
                    place++;
                }

                this.races.get(id).finishRace();
                this.races.remove(id);
            }
        }
        return sb.toString();
    }

    public void park(int id) {
        if (this.cars.get(id).isInRaces().isEmpty()) {
            this.garage.addCarToGarage(this.cars.get(id));
        }
    }

    public void unpark(int id) {
        this.garage.unPark(this.cars.get(id));
    }

    public void tune(int tuneIndex, String addOn) {
        this.garage.modify(tuneIndex, addOn);
    }
}
