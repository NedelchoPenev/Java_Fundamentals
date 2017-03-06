package exercise.P02_Vehicles_Extension.modules;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsummation;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsummation, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsummation(fuelConsummation);
        this.setTankCapacity(tankCapacity);
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

    private double getTankCapacity() {
        return tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
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

    public void drive(double km, boolean additionalCondition){

    }

    public void refuel(double liters){
        if (this.getTankCapacity() < 0 || this.getTankCapacity() < liters){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}

