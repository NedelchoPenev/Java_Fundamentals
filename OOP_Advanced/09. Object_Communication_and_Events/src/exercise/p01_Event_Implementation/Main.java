package exercise.p01_Event_Implementation;

import exercise.p01_Event_Implementation.contacts.NameChangeListener;
import exercise.p01_Event_Implementation.models.Dispatcher;
import exercise.p01_Event_Implementation.models.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Dispatcher dispatcher = new Dispatcher();
        NameChangeListener listener = new Handler();

        dispatcher.addNameChangeListener(listener);

        while (true) {
            String input = console.readLine();
            if ("End".equals(input)) {
                break;
            }

            dispatcher.setName(input);
        }
    }
}
