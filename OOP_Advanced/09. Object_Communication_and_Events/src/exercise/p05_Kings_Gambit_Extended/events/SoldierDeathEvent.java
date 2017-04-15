package exercise.p05_Kings_Gambit_Extended.events;

import java.util.EventObject;

public class SoldierDeathEvent extends EventObject {

    private String name;

    public SoldierDeathEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
