package exercise.p02_blobs.interfaces;

public interface Behavior {

    boolean isTriggered();

    void trigger(Creature source);

    void applyRecurrentEffect(Creature source);
}
