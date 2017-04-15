package exercise.p01_Event_Implementation.models;

import exercise.p01_Event_Implementation.contacts.NameChangeListener;
import exercise.p01_Event_Implementation.events.EventNameChange;

public class Handler implements NameChangeListener {

    @Override
    public void handleChangedName(EventNameChange event) {
        System.out.printf("Dispatcher's name changed to %s.%n", event.getNameChange());
    }
}
