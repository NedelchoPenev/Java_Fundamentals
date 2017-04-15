package exercise.p02_blobs.interfaces;

public interface BlobCreator {

    Creature create(String name, int health, int damage, Behavior behavior, Attack attack);
}
