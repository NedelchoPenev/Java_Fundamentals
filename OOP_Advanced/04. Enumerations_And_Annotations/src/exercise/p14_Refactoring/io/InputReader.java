package exercise.p14_Refactoring.io;

import exercise.p14_Refactoring.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader implements Reader {

    private BufferedReader console;

    public InputReader() {
        this.console = new BufferedReader(new InputStreamReader(System.in));
    }

    public String read() throws IOException {
        return console.readLine();
    }
}
