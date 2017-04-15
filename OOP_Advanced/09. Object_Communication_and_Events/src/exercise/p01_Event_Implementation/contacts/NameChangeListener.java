package exercise.p01_Event_Implementation.contacts;

import exercise.p01_Event_Implementation.events.EventNameChange;

public interface NameChangeListener {

    void handleChangedName(EventNameChange event);
}
