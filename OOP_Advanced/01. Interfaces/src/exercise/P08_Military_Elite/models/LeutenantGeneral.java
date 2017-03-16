package exercise.P08_Military_Elite.models;

import exercise.P08_Military_Elite.interfaces.iLeutenantGeneral;

import java.util.LinkedList;

public class LeutenantGeneral extends Soldier implements iLeutenantGeneral {

    private LinkedList<Private> privates;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new LinkedList<>();
    }

    @Override
    public void addPrivate(Private pri) {
        this.privates.add(pri);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Privates:").append(System.lineSeparator());
        for (Private aPrivate : privates) {
            sb.append("  ").append(aPrivate);
        }

        return sb.toString();
    }
}
