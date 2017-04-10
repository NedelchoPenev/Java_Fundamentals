package exercise.p01_Logger.core;

import exercise.p01_Logger.contracts.*;
import exercise.p01_Logger.contracts.Readable;
import exercise.p01_Logger.enums.ReportLevel;
import exercise.p01_Logger.models.LogFile;
import exercise.p01_Logger.models.appenders.FileAppender;

import java.io.IOException;
import java.lang.reflect.Method;

public class Controller {

    private Writable writer;
    private Readable reader;
    private Logger logger;
    private LoggerCreator loggerCreator;
    private AppenderCreator appenderCreator;
    private LayoutCreator layoutCreator;

    public Controller(Writable writer, Readable reader, LoggerCreator loggerCreator, AppenderCreator
            appenderCreator, LayoutCreator layoutCreator) {
        this.writer = writer;
        this.reader = reader;
        this.loggerCreator = loggerCreator;
        this.appenderCreator = appenderCreator;
        this.layoutCreator = layoutCreator;
    }

    public void initializeLogger() throws IOException, ReflectiveOperationException {
        String input = reader.readLine();
        int appendersCount = Integer.valueOf(input);
        Appender[] appenders = new Appender[appendersCount];

        for (int i = 0; i < appendersCount; i++) {
            String[] inputTokens = reader.readLine().split("\\s+");
            String appenderType = inputTokens[0];
            String layoutType = inputTokens[1];

            Layout layout = this.layoutCreator.getLayout(layoutType);
            Appender appender = this.appenderCreator.getAppender(appenderType, layout);

            if (inputTokens.length > 2){
                String level = inputTokens[2];
                ReportLevel reportLevel = ReportLevel.valueOf(level);
                appender.setReportLevel(reportLevel);
            }

            if (appenderType.equals("FileAppender")){
                File file = new LogFile();
                ((FileAppender) appender).setFile(file);
            }

            appenders[i] = appender;
        }

        this.logger = this.loggerCreator.getLogger(appenders);
    }

    public void processMessage(String input) throws ReflectiveOperationException {
        String[] inputTokens = input.split("\\|");
        String reportToken = inputTokens[0];
        String timeToken = inputTokens[1];
        String messageToken = inputTokens[2];

        String reportType = reportToken.charAt(0) + reportToken.substring(1).toLowerCase();
        String methodName = "log" + reportType;

        Method method = Logger.class.getDeclaredMethod(methodName, String.class, String.class);
        method.invoke(logger, timeToken, messageToken);
    }

    public String printStatistic(){
        return this.logger.toString();
    }
}
