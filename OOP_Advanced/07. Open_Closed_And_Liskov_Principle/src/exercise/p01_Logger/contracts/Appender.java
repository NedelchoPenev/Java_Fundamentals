package exercise.p01_Logger.contracts;

import exercise.p01_Logger.enums.ReportLevel;

public interface Appender {

    void append(String time, String message, ReportLevel reportLevel);
    void setReportLevel(ReportLevel level);
}
