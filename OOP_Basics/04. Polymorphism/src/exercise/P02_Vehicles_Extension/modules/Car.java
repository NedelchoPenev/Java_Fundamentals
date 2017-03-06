package exercise.P02_Vehicles_Extension.modules;

public class Car extends Vehicle {

    private final double SUMMER_CONSUMMATION = 0.9;

    public Car(double fuelQuantity, double fuelConsummation, double tankCapacity) {
        super(fuelQuantity, fuelConsummation, tankCapacity);
        this.setFuelConsummation(this.getFuelConsummation() + SUMMER_CONSUMMATION);
    }
}