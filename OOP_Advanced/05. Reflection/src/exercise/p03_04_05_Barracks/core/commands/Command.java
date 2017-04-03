package exercise.p03_04_05_Barracks.core.commands;

import exercise.p03_04_05_Barracks.contracts.Executable;

public abstract class Command implements Executable {

    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return data;
    }
}
