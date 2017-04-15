package exercise.p01_Event_Implementation.models;

import exercise.p01_Event_Implementation.contacts.NameChangeListener;
import exercise.p01_Event_Implementation.events.EventNameChange;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private String name;
    private List<NameChangeListener> nameChangeListeners;

    public Dispatcher() {
        this.nameChangeListeners = new ArrayList<>();
    }

    public void setName(String name){
        this.name = name;
        this.fireNameChangeEvent();

    }

    public void addNameChangeListener(NameChangeListener listener){
        this.nameChangeListeners.add(listener);
    }

    public void removeNameChangeListener(NameChangeListener listener){
        this.nameChangeListeners.remove(listener);
    }

    private void fireNameChangeEvent(){
        for (NameChangeListener nameChangeListener : this.nameChangeListeners) {
            EventNameChange event = new EventNameChange(this, this.name);
            nameChangeListener.handleChangedName(event);
        }
    }
}
