package exercise.p02_blobs.core.factories;

import exercise.p02_blobs.interfaces.Attack;
import exercise.p02_blobs.interfaces.AttackCreator;

import java.lang.reflect.Constructor;

public class AttackFactory implements AttackCreator {

    private static final String ATTACK_PATH = "exercise.p02_blobs.models.attacks.";

    @Override
    public Attack getAttack(String type) throws ReflectiveOperationException{
        Class attackClass = Class.forName(ATTACK_PATH + type);
        Constructor constructor = attackClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        return (Attack) constructor.newInstance();
    }
}
