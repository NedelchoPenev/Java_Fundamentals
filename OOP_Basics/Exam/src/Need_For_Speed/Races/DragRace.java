package Need_For_Speed.Races;

import Need_For_Speed.Cars.Car;

public class DragRace extends Race {

    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public void race() {
        for (Car car : this.getCars()) {
            int points = car.getHorsepower() / car.getAcceleration();
            this.addCarToTable(car, points);
        }
    }
}
