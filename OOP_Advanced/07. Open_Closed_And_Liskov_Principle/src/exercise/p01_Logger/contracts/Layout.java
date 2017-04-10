package exercise.p01_Logger.contracts;

import exercise.p01_Logger.enums.ReportLevel;

public interface Layout {

    String format(String time, String message, ReportLevel reportLevel);
}
