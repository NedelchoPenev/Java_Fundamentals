package exercise.p02_blobs.models;

import exercise.p01_Logger.contracts.Writable;
import exercise.p02_blobs.interfaces.Event;
import exercise.p02_blobs.interfaces.Log;
import exercise.p02_blobs.interfaces.Observable;

public class CombatLog implements Log {

    private Writable writer;

    public CombatLog(Writable writer) {
        this.writer = writer;
    }

    @Override
    public void update(Observable source, Event event) {
        String message = event.getMessage();
        this.writer.writeLine(message);
    }
}
