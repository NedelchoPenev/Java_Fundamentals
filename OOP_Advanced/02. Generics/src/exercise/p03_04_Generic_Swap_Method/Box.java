package exercise.p03_04_Generic_Swap_Method;

import java.util.Collections;
import java.util.List;

public class Box<T> {

    private T param;

    public Box(T param) {
        this.param = param;
    }

    public static <T> List<T> swap(List<T> list, int firstIndex, int secondIndex){

        Collections.swap(list, firstIndex, secondIndex);
        return list;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.param.getClass().getName(), this.param);
    }
}
