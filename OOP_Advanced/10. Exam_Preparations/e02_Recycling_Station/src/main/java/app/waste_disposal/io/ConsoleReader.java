package app.waste_disposal.io;

import app.waste_disposal.contracts.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {

    private BufferedReader console;

    public ConsoleReader() {
        this.console = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return this.console.readLine();
    }
}
