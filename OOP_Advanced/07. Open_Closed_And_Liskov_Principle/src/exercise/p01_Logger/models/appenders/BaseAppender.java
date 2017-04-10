package exercise.p01_Logger.models.appenders;

import exercise.p01_Logger.contracts.Appender;
import exercise.p01_Logger.contracts.Layout;
import exercise.p01_Logger.enums.ReportLevel;

public abstract class BaseAppender implements Appender {

    private Layout layout;
    private ReportLevel reportLevel;
    private int messageCount;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
        this.setReportLevel(ReportLevel.INFO);
    }

    protected int getMessageCount() {
        return messageCount;
    }

    protected void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setReportLevel(ReportLevel reportLevel){
        this.reportLevel = reportLevel;
    }

    boolean compareReportLevels(ReportLevel reportLevel){
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }

    @Override
    public String toString() {
        return ", Layout type: " + this.layout.getClass().getSimpleName()
                + ", Report level: " + this.reportLevel.name()
                + ", Messages appended: " + this.messageCount;
    }
}
