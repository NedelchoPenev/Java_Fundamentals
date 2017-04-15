package exercise.p02_blobs.models;

import exercise.p02_blobs.interfaces.Event;
import exercise.p02_blobs.interfaces.Observable;

public class BlobEvent implements Event {

    private Observable observable;
    private String message;

    public BlobEvent(Observable observable, String message) {
        this.observable = observable;
        this.message = message;
    }

    @Override
    public Observable getSource() {
        return this.observable;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
