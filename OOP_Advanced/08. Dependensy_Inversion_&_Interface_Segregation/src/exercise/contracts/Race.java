package exercise.contracts;

import exercise.exeptions.DuplicateModelException;

import java.util.Map;

public interface Race {
    int getDistance();

    int getWindSpeed ();

    int getOceanCurrentSpeed();

    Boolean getAllowsMotorboats ();

    void addParticipant(Sailable boat) throws DuplicateModelException;

    Map<Sailable, Double> getWinners();
}
