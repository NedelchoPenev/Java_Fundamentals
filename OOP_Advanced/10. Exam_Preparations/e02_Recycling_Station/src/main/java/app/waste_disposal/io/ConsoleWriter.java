package app.waste_disposal.io;

import app.waste_disposal.contracts.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
