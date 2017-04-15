package exercise.p02_blobs.interfaces;

import java.util.Collection;

public interface Observable {

    Collection<Listener> getListeners();

    void fireEvent(Event event);
}
