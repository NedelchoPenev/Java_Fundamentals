package exercise.models.boats;

import exercise.contracts.Race;
import exercise.utility.Constants;

public class SailBoat extends Boat {

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
        setMotorBoat(false);
    }

    private int getSailEfficiency() {
        return sailEfficiency;
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.IncorrectSailEfficiencyMessage);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public void calculateRaceSpeed(Race race) {
        setRaceSpeed((race.getWindSpeed() * (this.getSailEfficiency() / 100d)) -
                this.getWeight() + (race.getOceanCurrentSpeed() / 2d));
    }
}
