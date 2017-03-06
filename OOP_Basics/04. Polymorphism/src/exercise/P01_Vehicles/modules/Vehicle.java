package exercise.P01_Vehicles.modules;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsummation;

    public Vehicle(double fuelQuantity, double fuelConsummation) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsummation(fuelConsummation);
    }

    double getFuelQuantity() {
        return fuelQuantity;
    }

    void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    double getFuelConsummation() {
        return fuelConsummation;
    }

    void setFuelConsummation(double fuelConsummation) {
        this.fuelConsummation = fuelConsummation;
    }

    public void drive(double km){
        double fuelNeeded = km * this.getFuelConsummation();
        if (this.getFuelQuantity() >= fuelNeeded){
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
        } else {
            throw new IllegalArgumentException(
                    String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
    }

    public void refuel(double liters){
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}

