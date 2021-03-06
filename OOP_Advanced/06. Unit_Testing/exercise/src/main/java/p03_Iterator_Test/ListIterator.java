package p03_Iterator_Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.List;

public class ListIterator {

    private List<String> collection;
    private int index;

    public ListIterator(String... collection) throws OperationNotSupportedException {
        if (collection == null) {
            throw new OperationNotSupportedException();
        }
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

    public String print(){
        if (this.collection.size() > 0){
            return this.collection.get(this.index);
        } else {
            throw new IllegalStateException("Invalid Operation!");
        }
    }
}

