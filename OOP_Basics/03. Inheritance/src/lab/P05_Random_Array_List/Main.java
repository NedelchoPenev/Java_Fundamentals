package lab.P05_Random_Array_List;

public class Main {

    public static void main(String[] args) {

        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add(1);
        randomArrayList.add("hi");
        randomArrayList.add('c');
        randomArrayList.add(123123);

        System.out.println(randomArrayList.getRandomElement());
    }
}
