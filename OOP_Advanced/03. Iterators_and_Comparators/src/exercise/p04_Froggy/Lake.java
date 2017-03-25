package exercise.p04_Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {

    private List<T> jumps;

    public Lake(List<T> jumps) {
        this.jumps = jumps;
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<T>{

        private int index = -2;
        private int count;

        private int getIndex(){
            int currentIndex = this.index + 2;
            if (currentIndex >= jumps.size()){
                this.index = 1;
            } else {
                this.index += 2;
            }
            this.count++;
            return this.index;
        }

        @Override
        public boolean hasNext() {
            return this.count < jumps.size();
        }

        @Override
        public T next() {
            return jumps.get(getIndex());
        }
    }
}
