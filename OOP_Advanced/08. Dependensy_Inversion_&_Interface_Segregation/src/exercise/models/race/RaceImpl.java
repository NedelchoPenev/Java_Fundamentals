package exercise.models.race;

import exercise.contracts.Race;
import exercise.contracts.Sailable;
import exercise.exeptions.DuplicateModelException;
import exercise.utility.Constants;
import exercise.utility.Validator;

import java.util.*;
import java.util.stream.Collectors;

public class RaceImpl implements Race {

    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private Boolean allowsMotorBoats;
    private Map<Sailable, Double> registeredBoats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.setWindSpeed(windSpeed);
        this.setOceanCurrentSpeed(oceanCurrentSpeed);
        this.setAllowsMotorBoats(allowsMotorBoats);
        this.registeredBoats = new LinkedHashMap<>();
    }

    @Override
    public int getDistance() {
        return distance;
    }

    private void setDistance(int distance) {
        Validator.ValidatePropertyValue(distance, "Distance");
        this.distance = distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }

    private void setOceanCurrentSpeed(int oceanCurrentSpeed) {
        this.oceanCurrentSpeed = oceanCurrentSpeed;
    }

    public Boolean getAllowsMotorboats() {
        return allowsMotorBoats;
    }

    private void setAllowsMotorBoats(Boolean allowsMotorBoats) {
        this.allowsMotorBoats = allowsMotorBoats;
    }

    public void addParticipant(Sailable boat) throws DuplicateModelException {
        if (this.registeredBoats.containsKey(boat)) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }

        boat.calculateRaceSpeed(this);
        Double speed = boat.getRaceSpeed() == 0 ? -0.00001 : boat.getRaceSpeed();
        Double time = this.getDistance() / speed;
        time = time <= 0 ? Double.MAX_VALUE : time;

        this.registeredBoats.put(boat, time);

    }

    @Override
    public Map<Sailable, Double> getWinners() {
        return this.registeredBoats.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .limit(3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}