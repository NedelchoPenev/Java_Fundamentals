package exercise.p02_blobs.interfaces;

public interface BehaviorCreator {

    Behavior getBehavior(String type) throws ReflectiveOperationException;
}
