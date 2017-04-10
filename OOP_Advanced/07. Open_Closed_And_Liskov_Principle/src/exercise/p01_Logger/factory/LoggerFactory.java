package exercise.p01_Logger.factory;

import exercise.p01_Logger.contracts.Appender;
import exercise.p01_Logger.contracts.Logger;
import exercise.p01_Logger.contracts.LoggerCreator;
import exercise.p01_Logger.models.MessageLogger;

public class LoggerFactory implements LoggerCreator {

    @Override
    public Logger getLogger(Appender... appenders){
        return new MessageLogger(appenders);
    }
}
