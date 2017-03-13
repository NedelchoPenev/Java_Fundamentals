package Need_For_Speed.Garage;

import Need_For_Speed.Cars.Car;
import Need_For_Speed.Cars.PerformanceCar;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public void addCarToGarage(Car car){
        car.park(true);
        this.parkedCars.add(car);
    }

    public void unPark(Car car){
        car.park(false);
        this.parkedCars.remove(car);
    }

    public void modify(int tuneIndex, String addOn){
        int suspensionIncrease = (tuneIndex * 50) / 100;
        for (Car parkedCar : this.parkedCars) {
            parkedCar.setHorsepower(parkedCar.getHorsepower() + tuneIndex);
            parkedCar.setSuspension(parkedCar.getSuspension() + suspensionIncrease);
            if (parkedCar instanceof PerformanceCar){
                parkedCar.addAddOns(addOn);
            } else {
                parkedCar.increaseStars(tuneIndex);
            }
        }
    }
}
