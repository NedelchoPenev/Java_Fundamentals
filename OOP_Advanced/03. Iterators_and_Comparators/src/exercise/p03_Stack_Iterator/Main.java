package exercise.p03_Stack_Iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        CommandInterpreter interpreter = new CommandInterpreter();

        while (true) {
            String input = console.readLine();
            if ("END".equals(input)) {
                interpreter.getStack().forEach(System.out::println);
                interpreter.getStack().forEach(System.out::println);
                break;
            }

            interpreter.readCommands(input);

        }
    }
}
