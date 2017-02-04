import java.io.IOException;
import java.util.Scanner;

public class InputReader {

    private static final String END_COMMAND = "quit";

    public static void readCommands() throws IOException {
        OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));
        Scanner console = new Scanner(System.in);
        String input = console.nextLine().trim();

        while (!END_COMMAND.equals(input)) {
            CommandInterpreter.interpretCommand(input);
            OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));

            input = console.nextLine().trim();
        }
    }
}
