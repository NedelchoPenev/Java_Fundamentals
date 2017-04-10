package exercise.p01_Logger.io;

import exercise.p01_Logger.contracts.Writable;

public class Writer implements Writable{

    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
