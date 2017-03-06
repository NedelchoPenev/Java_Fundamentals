package exercise.P02_Vehicles_Extension.modules;

public class Truck extends Vehicle {

    private final double SUMMER_CONSUMMATION = 1.6;

    public Truck(double fuelQuantity, double fuelConsummation, double tankCapacity) {
        super(fuelQuantity, fuelConsummation, tankCapacity);
        this.setFuelConsummation(this.getFuelConsummation() + SUMMER_CONSUMMATION);
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + (liters * 0.95));
    }
}
