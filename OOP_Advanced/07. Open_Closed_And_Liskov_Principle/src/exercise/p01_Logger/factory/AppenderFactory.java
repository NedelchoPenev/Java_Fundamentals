package exercise.p01_Logger.factory;

import exercise.p01_Logger.contracts.Appender;
import exercise.p01_Logger.contracts.AppenderCreator;
import exercise.p01_Logger.contracts.Layout;

import java.lang.reflect.Constructor;

public class AppenderFactory implements AppenderCreator {

    private final static String CLASS_PATH = "exercise.p01_Logger.models.appenders.";

    @Override
    public Appender getAppender(String type, Layout layout) throws ReflectiveOperationException {
        Class aClass = Class.forName(CLASS_PATH + type);
        Constructor constructor = aClass.getConstructor(Layout.class);
        constructor.setAccessible(true);

        return (Appender) constructor.newInstance(layout);
    }
}
