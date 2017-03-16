package exercise.P09_Collection_Hierarchy.models;

import exercise.P09_Collection_Hierarchy.interfaces.Removable;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollection implements Removable {

    private List<String> elements;

    public AddRemoveCollection() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int add(String string) {
        this.elements.add(0, string);
        return 0;
    }

    @Override
    public String remove() {
        return this.elements.remove(this.elements.size() - 1);
    }
}
