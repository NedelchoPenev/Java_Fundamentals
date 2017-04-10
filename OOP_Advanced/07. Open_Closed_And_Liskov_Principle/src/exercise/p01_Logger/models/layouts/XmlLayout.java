package exercise.p01_Logger.models.layouts;

import exercise.p01_Logger.contracts.Layout;
import exercise.p01_Logger.enums.ReportLevel;

public class XmlLayout implements Layout {

    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return "<log>" + System.lineSeparator() +
                "   <date>" + time + "</date>" + System.lineSeparator() +
                "   <level>" + reportLevel + "</level>" + System.lineSeparator() +
                "   <message>" + message + "</message>" + System.lineSeparator() +
                "</log>";
    }
}
