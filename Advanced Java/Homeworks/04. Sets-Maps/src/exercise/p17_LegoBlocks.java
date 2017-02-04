package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p17_LegoBlocks {
    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        int rows = Integer.parseInt(console.nextLine());
        List<ArrayList<Integer>> firstMatrix = new ArrayList<>();
        List<ArrayList<Integer>> secondMatrix = new ArrayList<>();

        fillMatrix(console, rows, firstMatrix);
        fillMatrix(console, rows, secondMatrix);

        mergeMatrix(firstMatrix, secondMatrix);

        boolean isRectangle = true;
        int size = firstMatrix.get(0).size();
        for (int i = 1; i < rows; i++) {
            if (size == firstMatrix.get(i).size()){
                isRectangle = true;
            }else {
                isRectangle = false;
                break;
            }
        }

        if (isRectangle){
            firstMatrix.forEach(System.out::println);
        } else {
            int counter = 0;
            for (List<Integer> num : firstMatrix) {
                counter += num.size();
            }
            System.out.printf("The total number of cells is: %d", counter);
        }
    }

    private static void mergeMatrix(List<ArrayList<Integer>> one, List<ArrayList<Integer>> two){
        for (int i = 0; i < one.size(); i++) {
            Collections.reverse(two.get(i));
            one.get(i).addAll(two.get(i));
        }
    }

    private static void fillMatrix(Scanner console, int n, List<ArrayList<Integer>> arr){
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
            String[] input = console.nextLine().trim().split("\\s+");
            for (String num : input) {
                arr.get(i).add(Integer.parseInt(num));
            }
        }
    }
}
