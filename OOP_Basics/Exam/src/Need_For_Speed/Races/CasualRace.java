package Need_For_Speed.Races;

import Need_For_Speed.Cars.Car;

public class CasualRace extends Race {

    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public void race() {
        for (Car car : this.getCars()) {
            int points = (car.getHorsepower() / car.getAcceleration()) +
                    (car.getSuspension() + car.getDurability());

            this.addCarToTable(car, points);
        }
    }
}
