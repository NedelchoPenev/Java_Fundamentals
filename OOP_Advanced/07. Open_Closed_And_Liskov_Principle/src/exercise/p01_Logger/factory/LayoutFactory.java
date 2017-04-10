package exercise.p01_Logger.factory;

import exercise.p01_Logger.contracts.Layout;
import exercise.p01_Logger.contracts.LayoutCreator;

import java.lang.reflect.Constructor;

public class LayoutFactory implements LayoutCreator {

    private final static String CLASS_PATH = "exercise.p01_Logger.models.layouts.";

    @Override
    public Layout getLayout(String type)  throws ReflectiveOperationException {
        Class aClass = Class.forName(CLASS_PATH + type);
        Constructor constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        return (Layout) constructor.newInstance();
    }
}
