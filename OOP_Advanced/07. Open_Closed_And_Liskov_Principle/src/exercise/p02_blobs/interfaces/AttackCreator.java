package exercise.p02_blobs.interfaces;

public interface AttackCreator {

    Attack getAttack(String type) throws ClassNotFoundException, ReflectiveOperationException;
}
