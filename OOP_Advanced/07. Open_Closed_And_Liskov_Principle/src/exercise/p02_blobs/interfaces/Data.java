package exercise.p02_blobs.interfaces;

public interface Data {

    void addBlob(Creature blob);

    Creature getBlob(String name);

    Iterable<Creature> getBlobs();
}
