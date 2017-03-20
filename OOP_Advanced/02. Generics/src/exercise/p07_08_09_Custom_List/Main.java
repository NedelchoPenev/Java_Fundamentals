package exercise.p07_08_09_Custom_List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> customList = new CustomList<>();

        while (true) {
            String[] input = console.readLine().split("\\s+");
            if ("END".equals(input[0])) {
                break;
            }

            String command = input[0];

            switch (command){
                case "Add":
                    customList.add(input[1]);
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(input[1]);
                    customList.remove(removeIndex);
                    break;
                case "Contains":
                    System.out.println(customList.contains(input[1]));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(input[1]);
                    int secondIndex = Integer.parseInt(input[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThat(input[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    for (String element : customList) {
                        System.out.println(element);
                    }
                    break;
                case "Sort":
                    Sorter.sort(customList);
            }
        }
    }
}
