package app.waste_disposal.core;

import app.waste_disposal.contracts.CommandInterpreter;
import app.waste_disposal.contracts.Reader;
import app.waste_disposal.contracts.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
    
    private Writer writer;
    private Reader reader;
    private CommandInterpreter commandInterpreter;

    public Engine(Writer writer, Reader reader, CommandInterpreter commandInterpreter) {
        this.writer = writer;
        this.reader = reader;
        this.commandInterpreter = commandInterpreter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String[] input = this.reader.readLine().split("\\s+");
                if ("TimeToRecycle".equals(input[0])) {
                    break;
                }

                String command = input[0];

                String result = this.commandInterpreter.processCommands(command, input);
                this.writer.writeLine(result);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
