package exercise.p01_Logger.models.appenders;

import exercise.p01_Logger.contracts.Layout;
import exercise.p01_Logger.contracts.Writable;
import exercise.p01_Logger.enums.ReportLevel;
import exercise.p01_Logger.io.Writer;

public class ConsoleAppender extends BaseAppender {

    private Writable console;

    public ConsoleAppender(Layout layout) {
        super(layout);
        this.console = new Writer();
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (super.compareReportLevels(reportLevel)) {
            super.setMessageCount(super.getMessageCount() +1);
            String result = super.getLayout().format(time, message, reportLevel);
            this.console.writeLine(result);
        }
    }

    @Override
    public String toString() {
        return "Appender type: " + this.getClass().getSimpleName()
                + super.toString();
    }
}
