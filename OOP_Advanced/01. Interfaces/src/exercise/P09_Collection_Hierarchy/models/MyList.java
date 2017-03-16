package exercise.P09_Collection_Hierarchy.models;

import exercise.P09_Collection_Hierarchy.interfaces.Usable;

import java.util.ArrayList;
import java.util.List;

public class MyList implements Usable {

    private List<String> elements;

    public MyList() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int used() {
        return this.elements.size();
    }

    @Override
    public int add(String string) {
        this.elements.add(0, string);
        return 0;
    }

    @Override
    public String remove() {
        return this.elements.remove(0);
    }
}
