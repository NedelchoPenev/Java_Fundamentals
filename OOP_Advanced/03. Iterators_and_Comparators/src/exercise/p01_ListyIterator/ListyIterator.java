package exercise.p01_ListyIterator;

import java.util.Arrays;
import java.util.List;

public class ListyIterator <T> {

    private List<T> collection;
    private int index;

    public ListyIterator(T... collection) {
        this.collection = Arrays.asList(collection);
    }

    public boolean move(){
        if (hasNext()) {
            this.index++;
            return true;
        }

        return false;
    }

    public boolean hasNext(){
        return this.index < this.collection.size() - 1;
    }

    public void print(){
        if (this.collection.size() > 0){
            System.out.println(this.collection.get(this.index));
        } else {
            System.out.println("Invalid Operation!");
        }
    }
}
