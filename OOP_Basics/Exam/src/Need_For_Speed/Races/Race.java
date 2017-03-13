package Need_For_Speed.Races;

import Need_For_Speed.Cars.Car;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Race {

    private String type;
    private int length;
    private String route;
    private int prizePool;
    private List<Car> cars;
    private LinkedHashMap<Car, Integer> winners;

    Race(int length, String route, int prizePool) {
        this.setType(type);
        this.setLength(length);
        this.setRoute(route);
        this.setPrizePool(prizePool);
        this.setCars(new ArrayList<>());
        this.winners = new LinkedHashMap<>();
    }

    private String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    private void setRoute(String route) {
        this.route = route;
    }

    public int getPrizePool() {
        return prizePool;
    }

    private void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    private void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car){
        car.raceParticipant(this);
        this.cars.add(car);
    }

    public void finishRace(){
        for (Car car : this.cars) {
            car.removeFromRace(this);
        }
        this.cars.clear();
        this.winners.clear();
    }

    public abstract void race();

    void addCarToTable(Car car, int points){
        this.winners.put(car, points);
    }

    public Map<Car, Integer> getRaceWinners(){
        LinkedHashMap<Car, Integer> sorted =  this.winners.entrySet()
                .stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        return Collections.unmodifiableMap(sorted);
    }
}
