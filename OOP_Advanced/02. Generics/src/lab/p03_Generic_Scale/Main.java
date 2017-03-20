package lab.p03_Generic_Scale;

public class Main {

    public static void main(String[] args) {

        Scale<Integer> scale = new Scale<>(4, 4);
        Scale<String> scale1 = new Scale<>("hahah", "hihih");
        Scale<Double> scale2 = new Scale<>(4.12, 8.321);

        System.out.println(scale.getHeavier());
        System.out.println(scale1.getHeavier());
        System.out.println(scale2.getHeavier());
    }
}
