package exercise.p07_08_09_Custom_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T>{

    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<T>();
    }

    void add(T element){
        this.data.add(element);
    }

    T remove(int index){
        return this.data.remove(index);
    }

    boolean contains(T element){
        return this.data.contains(element);
    }

    void swap(int firstIndex, int secondIndex){
        Collections.swap(this.data, firstIndex, secondIndex);
    }

    long countGreaterThat(T element){
        return this.data.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    T getMax(){
        return Collections.max(this.data);
    }

    T getMin(){
        return Collections.min(this.data);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return data.size() > index;
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }

    public void customSort(){
        this.data.sort(Comparable::compareTo);
    }
}
