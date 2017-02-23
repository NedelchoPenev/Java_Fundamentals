package exercise.P05_Speed_Racing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distance;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
    }

    public String getModel() {
        return model;
    }

    private double getFuelAmount() {
        return fuelAmount;
    }

    private int getDistance() {
        return distance;
    }


    public void drive(int distanceToTravel){
        if (this.fuelAmount >= distanceToTravel * this.fuelCost){
            this.fuelAmount -= distanceToTravel * this.fuelCost;
            this.distance += distanceToTravel;
        } else {
            throw new IllegalArgumentException("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",
                this.getModel(),
                this.getFuelAmount(),
                this.getDistance());
    }
}
