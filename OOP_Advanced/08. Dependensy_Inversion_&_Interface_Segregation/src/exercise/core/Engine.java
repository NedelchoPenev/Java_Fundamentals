package exercise.core;

import exercise.contracts.ICommandHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {

    private ICommandHandler commandHandler;

    public Engine(ICommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    public void run() throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        while (true) {
            String line = console.readLine();
            if (line.equals("End")) {
                break;
            }

            String[] tokens = line.split("\\\\");
            String name = tokens[0];

            try {
                String commandResult = this.commandHandler.executeCommand(name, tokens);
                result.append(commandResult).append(System.lineSeparator());
            }
            catch (Exception ex) {
                result.append(ex.getMessage()).append(System.lineSeparator());
            }
        }

        System.out.println(result.toString().trim());
    }
}
