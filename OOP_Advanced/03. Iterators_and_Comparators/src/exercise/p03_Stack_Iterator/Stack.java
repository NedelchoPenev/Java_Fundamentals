package exercise.p03_Stack_Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Stack<T> implements Iterable<T> {

    private List<T> stack;

    public Stack() {
        this.stack = new ArrayList<T>();
    }

    public void push(T... elements){
        this.stack.addAll(Arrays.asList(elements));
    }

    public void pop(){
        if (this.stack.size() <= 0) {
            throw new UnsupportedOperationException("No elements");
        } else {
            this.stack.remove(this.stack.size() - 1);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new myIterator();
    }

    private final class myIterator implements Iterator<T>{

        private int index = stack.size() - 1;

        @Override
        public boolean hasNext() {
            return this.index >= 0;
        }

        @Override
        public T next() {
            return stack.get(index--);
        }
    }
}
