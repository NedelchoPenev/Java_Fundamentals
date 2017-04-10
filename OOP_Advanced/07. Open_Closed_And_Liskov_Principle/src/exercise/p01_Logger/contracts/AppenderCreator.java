package exercise.p01_Logger.contracts;

public interface AppenderCreator {

    Appender getAppender(String type, Layout layout) throws ReflectiveOperationException;
}
