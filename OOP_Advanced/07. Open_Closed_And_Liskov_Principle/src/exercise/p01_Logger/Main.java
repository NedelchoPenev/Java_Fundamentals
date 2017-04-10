package exercise.p01_Logger;

import exercise.p01_Logger.contracts.*;
import exercise.p01_Logger.contracts.Readable;
import exercise.p01_Logger.core.Controller;
import exercise.p01_Logger.factory.AppenderFactory;
import exercise.p01_Logger.factory.LayoutFactory;
import exercise.p01_Logger.factory.LoggerFactory;
import exercise.p01_Logger.io.Reader;
import exercise.p01_Logger.io.Writer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Writable writer = new Writer();
        Readable reader = new Reader();
        LoggerCreator loggerCreator = new LoggerFactory();
        AppenderCreator appenderCreator = new AppenderFactory();
        LayoutCreator layoutCreator = new LayoutFactory();

        Controller controller = new Controller(writer, reader, loggerCreator, appenderCreator, layoutCreator);

        try {
            controller.initializeLogger();

            while (true) {
                String input = reader.readLine();
                if ("END".equals(input)) {
                    break;
                }

                controller.processMessage(input);
            }

        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(controller.printStatistic());

    }
}
