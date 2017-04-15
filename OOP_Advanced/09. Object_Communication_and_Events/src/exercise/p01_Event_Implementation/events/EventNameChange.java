package exercise.p01_Event_Implementation.events;

import java.util.EventObject;

public class EventNameChange extends EventObject {

    private String nameChange;

    public EventNameChange(Object source, String nameChange) {
        super(source);
        this.nameChange = nameChange;
    }

    public String getNameChange() {
        return nameChange;
    }
}
