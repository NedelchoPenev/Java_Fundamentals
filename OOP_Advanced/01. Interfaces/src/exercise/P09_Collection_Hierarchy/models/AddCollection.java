package exercise.P09_Collection_Hierarchy.models;

import exercise.P09_Collection_Hierarchy.interfaces.Addable;

import java.util.ArrayList;
import java.util.List;

public class AddCollection implements Addable {

    private List<String> elements;

    public AddCollection() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int add(String string) {
        this.elements.add(string);
        return this.elements.lastIndexOf(string);
    }
}
