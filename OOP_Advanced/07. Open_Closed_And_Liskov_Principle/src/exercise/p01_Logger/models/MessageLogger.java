package exercise.p01_Logger.models;

import exercise.p01_Logger.contracts.Appender;
import exercise.p01_Logger.contracts.Logger;
import exercise.p01_Logger.enums.ReportLevel;

public class MessageLogger implements Logger{

    private Appender[] appenders;

    public MessageLogger(Appender... appender) {
        this.appenders = appender;
    }

    @Override
    public Appender[] getAppenders() {
        return appenders;
    }

    @Override
    public void logInfo(String time, String message) {
        ReportLevel reportLevel = ReportLevel.INFO;
        this.appendMessage(time, message, reportLevel);
    }

    @Override
    public void logWarning(String time, String message) {
        ReportLevel reportLevel = ReportLevel.WARNING;
        this.appendMessage(time, message, reportLevel);
    }

    @Override
    public void logError(String time, String message) {
        ReportLevel reportLevel = ReportLevel.ERROR;
        this.appendMessage(time, message, reportLevel);
    }

    @Override
    public void logCritical(String time, String message) {
        ReportLevel reportLevel = ReportLevel.CRITICAL;
        this.appendMessage(time, message, reportLevel);
    }

    @Override
    public void logFatal(String time, String message) {
        ReportLevel reportLevel = ReportLevel.FATAL;
        this.appendMessage(time, message, reportLevel);
    }

    private void appendMessage(String time, String message, ReportLevel reportLevel){
        for (Appender appender : this.appenders) {
            appender.append(time, message, reportLevel);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Logger info").append(System.lineSeparator());
        for (Appender appender : appenders) {
            result.append(appender).append(System.lineSeparator());
        }

        return result.toString();
    }
}
