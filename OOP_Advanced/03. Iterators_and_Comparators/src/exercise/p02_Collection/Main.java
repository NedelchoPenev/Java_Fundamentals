package exercise.p02_Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        CommandInterpreter commandInterpreter = new CommandInterpreter();

        while (true) {
            String input = console.readLine();
            if ("END".equals(input)) {
                break;
            }

            commandInterpreter.readCommand(input);
        }
    }
}
