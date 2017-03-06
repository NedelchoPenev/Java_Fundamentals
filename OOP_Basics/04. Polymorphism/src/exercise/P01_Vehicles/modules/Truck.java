package exercise.P01_Vehicles.modules;

public class Truck extends Vehicle {

    private final double SUMMER_CONSUMMATION = 1.6;

    public Truck(double fuelQuantity, double fuelConsummation) {
        super(fuelQuantity, fuelConsummation);
        this.setFuelConsummation(this.getFuelConsummation() + SUMMER_CONSUMMATION);
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + (liters * 0.95));
    }
}
