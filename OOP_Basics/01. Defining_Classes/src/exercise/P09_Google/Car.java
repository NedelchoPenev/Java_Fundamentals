package exercise.P09_Google;

public class Car {

    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        StringBuilder car = new StringBuilder();
        car.append(String.format("%s %d", this.model, this.speed));
        return car.toString();
    }
}


