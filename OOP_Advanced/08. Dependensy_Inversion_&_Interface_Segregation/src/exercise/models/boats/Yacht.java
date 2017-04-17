package exercise.models.boats;

import exercise.contracts.Race;
import exercise.models.engines.BaseEngine;
import exercise.utility.Validator;

public class Yacht extends Boat {

    private int cargoWeight;
    private BaseEngine engine;

    public Yacht(String model, int weight, int cargoWeight, BaseEngine engine) {
        super(model, weight);
        this.setCargoWeight(cargoWeight);
        this.setEngines(engine);
        setMotorBoat(true);
    }

    private int getCargoWeight() {
        return cargoWeight;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    private BaseEngine getEngine() {
        return this.engine;
    }

    private void setEngines(BaseEngine engine) {
        this.engine = engine;
    }

    @Override
    public void calculateRaceSpeed(Race race) {
        setRaceSpeed(this.getEngine().getOutput() -
                this.getWeight() - this.getCargoWeight() + (race.getOceanCurrentSpeed() / 2d));
    }
}
