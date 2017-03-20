package lab.p04_05_06_07_List_Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        Collections.addAll(integers, 1, 2, 4, 56, 7, 101);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.2, 44.3);

        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged, integers, doubles);

        List<Number> dest = new ArrayList<>();
        ListUtils.addAll(dest, integers);
        ListUtils.addAll(dest, doubles);

        System.out.println(dest);
    }
}
