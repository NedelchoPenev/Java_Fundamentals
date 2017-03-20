package exercise.p07_08_09_Custom_List;

public class Sorter  {

    public static <T extends Comparable<T>> void sort(CustomList<T> list){

        list.customSort();
    }
}
