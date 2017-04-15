package exercise.p02_blobs.io;

import exercise.p01_Logger.contracts.Writable;

public class ConsoleWrite implements Writable {

    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
