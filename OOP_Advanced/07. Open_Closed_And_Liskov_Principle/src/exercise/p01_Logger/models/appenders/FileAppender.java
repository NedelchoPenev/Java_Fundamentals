package exercise.p01_Logger.models.appenders;

import exercise.p01_Logger.contracts.File;
import exercise.p01_Logger.contracts.Layout;
import exercise.p01_Logger.enums.ReportLevel;

public class FileAppender extends BaseAppender {

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (super.compareReportLevels(reportLevel)) {
            super.setMessageCount(super.getMessageCount() +1);
            String result = super.getLayout().format(time, message, reportLevel);
            this.file.write(result);
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Appender type: " + this.getClass().getSimpleName()
                + super.toString()
                + ", File size: " + this.file.getSize();
    }
}
