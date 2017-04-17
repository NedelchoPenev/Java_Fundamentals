package exercise.models.boats;

import exercise.contracts.Sailable;
import exercise.utility.Constants;
import exercise.utility.Validator;

public abstract class Boat implements Sailable, Comparable<Sailable>{

    private String model;
    private int weight;
    private double raceSpeed;
    private boolean isMotorBoat;

    protected Boat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    public boolean isMotorBoat() {
        return isMotorBoat;
    }

    void setMotorBoat(boolean motorBoat) {
        isMotorBoat = motorBoat;
    }

    @Override
    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatModelLength);
        this.model = model;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        Validator.ValidatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

    @Override
    public double getRaceSpeed() {
        return raceSpeed;
    }

    void setRaceSpeed(Double raceSpeed){
        this.raceSpeed = raceSpeed;
    }

    @Override
    public int compareTo(Sailable boat) {
        if (this.getRaceSpeed() > boat.getRaceSpeed()){
            return 1;
        }
        if (this.getRaceSpeed() < boat.getRaceSpeed()){
            return -1;
        }

        return 0;
    }
}
