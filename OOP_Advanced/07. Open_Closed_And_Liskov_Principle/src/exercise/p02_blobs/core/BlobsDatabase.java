package exercise.p02_blobs.core;

import exercise.p02_blobs.interfaces.Creature;
import exercise.p02_blobs.interfaces.Data;

import java.util.List;
import java.util.Optional;

public class BlobsDatabase implements Data {

    private List<Creature> blobs;

    public BlobsDatabase(List<Creature> blobs) {
        this.blobs = blobs;
    }

    @Override
    public void addBlob(Creature blob) {
        this.blobs.add(blob);
    }

    @Override
    public Creature getBlob(String name) {
        Optional<Creature> blob = this.blobs.stream().filter(b -> b.getName().equals(name)).findFirst();

        if (!blob.isPresent()){
            return null;
        }

        return blob.get();
    }

    @Override
    public Iterable<Creature> getBlobs() {
        return this.blobs;
    }
}
