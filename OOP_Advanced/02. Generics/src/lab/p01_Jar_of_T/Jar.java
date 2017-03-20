package lab.p01_Jar_of_T;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<E> {

    private Deque<E> deque;

    public Jar() {
        this.deque = new ArrayDeque<E>();
    }

    public void add(E element) {
        this.deque.push(element);
    }

    public E remove(){
        return this.deque.pop();
    }

    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();
        jar.add("hi");

        System.out.println(jar.remove());
    }
}
