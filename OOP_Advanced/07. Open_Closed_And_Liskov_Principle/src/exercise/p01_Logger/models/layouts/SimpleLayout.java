package exercise.p01_Logger.models.layouts;

import exercise.p01_Logger.contracts.Layout;
import exercise.p01_Logger.enums.ReportLevel;

public class SimpleLayout implements Layout {

    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s", time, reportLevel, message);
    }
}
