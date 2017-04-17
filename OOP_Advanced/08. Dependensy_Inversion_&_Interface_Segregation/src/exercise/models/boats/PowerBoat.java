package exercise.models.boats;

import exercise.contracts.Race;
import exercise.models.engines.BaseEngine;

import java.util.Collections;
import java.util.List;

public class PowerBoat extends Boat {

    private List<BaseEngine> engines;

    public PowerBoat(String model, int weight, List<BaseEngine> engines) {
        super(model, weight);
        this.setEngines(engines);
        setMotorBoat(true);
    }

    public List<BaseEngine> getEngines() {
        return Collections.unmodifiableList(this.engines);
    }

    public void setEngines(List<BaseEngine> engines) {
        this.engines = engines;
    }

    @Override
    public void calculateRaceSpeed(Race race) {
        setRaceSpeed(this.getEngines().stream().mapToDouble(BaseEngine::getOutput).sum() -
                this.getWeight() + (race.getOceanCurrentSpeed() / 5d));
    }

}
