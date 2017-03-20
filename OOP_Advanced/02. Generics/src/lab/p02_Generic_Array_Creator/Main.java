package lab.p02_Generic_Array_Creator;

public class Main {

    public static void main(String[] args) {

        Integer[] integers = ArrayCreator.create(5, 1);
        String[] strings = ArrayCreator.create(String.class, 5, "a3");

        System.out.println(integers.length);
        System.out.println(strings.length);
    }
}
