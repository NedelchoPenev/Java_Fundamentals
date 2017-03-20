package exercise.p05_06_Generic_Count_Method;

public class Box <T extends Comparable<T>> implements Comparable<Box<T>>{

    private T param;

    public Box(T param) {
        this.param = param;
    }

    @Override
    public int compareTo(Box<T> other) {
        return this.param.compareTo(other.param);
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.param.getClass().getName(), this.param);
    }
}
