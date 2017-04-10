package exercise.p01_Logger.contracts;

public interface LoggerCreator {

    Logger getLogger(Appender... appenders);
}
