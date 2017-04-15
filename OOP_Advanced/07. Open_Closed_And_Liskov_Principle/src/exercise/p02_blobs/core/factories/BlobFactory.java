package exercise.p02_blobs.core.factories;

import exercise.p02_blobs.interfaces.Attack;
import exercise.p02_blobs.interfaces.Behavior;
import exercise.p02_blobs.interfaces.BlobCreator;
import exercise.p02_blobs.interfaces.Creature;
import exercise.p02_blobs.models.Blob;

public class BlobFactory implements BlobCreator {

    @Override
    public Creature create(String name, int health, int damage, Behavior behavior, Attack attack) {
        return new Blob(name, health, damage, behavior, attack);
    }
}
