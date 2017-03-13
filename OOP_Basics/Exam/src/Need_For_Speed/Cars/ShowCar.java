package Need_For_Speed.Cars;

public class ShowCar extends Car{

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int
            suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%d *", this.getStars());
    }
}
