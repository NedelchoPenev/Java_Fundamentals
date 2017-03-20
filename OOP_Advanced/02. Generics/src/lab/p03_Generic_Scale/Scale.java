package lab.p03_Generic_Scale;

public class Scale <T extends Comparable<T>> {

    private T right;
    private T left;

    public Scale(T right, T left) {
        this.right = right;
        this.left = left;
    }

    public T getHeavier(){
        if (this.left.compareTo(this.right) == 0){
            return null;
        } else if (this.left.compareTo(this.right) > 0){
            return left;
        }

        return right;
    }
}
