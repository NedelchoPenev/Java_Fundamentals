package exercise.P01_Vehicles.modules;

public class Car extends Vehicle {

    private final double SUMMER_CONSUMMATION = 0.9;

    public Car(double fuelQuantity, double fuelConsummation) {
        super(fuelQuantity, fuelConsummation);
        this.setFuelConsummation(this.getFuelConsummation() + SUMMER_CONSUMMATION);
    }
}