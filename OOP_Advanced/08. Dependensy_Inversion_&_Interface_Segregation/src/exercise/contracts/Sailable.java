package exercise.contracts;

public interface Sailable extends Modable{

    String getModel();

    int getWeight();

    double getRaceSpeed();

    boolean isMotorBoat();

    void calculateRaceSpeed(Race race);
}
