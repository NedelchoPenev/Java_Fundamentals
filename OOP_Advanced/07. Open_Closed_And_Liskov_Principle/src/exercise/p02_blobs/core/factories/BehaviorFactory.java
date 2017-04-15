package exercise.p02_blobs.core.factories;

import exercise.p02_blobs.interfaces.Behavior;
import exercise.p02_blobs.interfaces.BehaviorCreator;

import java.lang.reflect.Constructor;

public class BehaviorFactory implements BehaviorCreator {
    private static final String BEHAVIOR_PATH = "exercise.p02_blobs.models.behavors.";

    @Override
    public Behavior getBehavior(String type) throws ReflectiveOperationException{
        Class attackClass = Class.forName(BEHAVIOR_PATH + type);
        Constructor constructor = attackClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        return (Behavior) constructor.newInstance();
    }
}
