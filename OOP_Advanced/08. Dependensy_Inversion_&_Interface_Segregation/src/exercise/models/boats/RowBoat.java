package exercise.models.boats;

import exercise.contracts.Race;
import exercise.utility.Validator;

public class RowBoat extends Boat {

    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
        setMotorBoat(false);
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public void calculateRaceSpeed(Race race) {
        setRaceSpeed((this.oars * 100d) - this.getWeight() + race.getOceanCurrentSpeed());
    }
}
