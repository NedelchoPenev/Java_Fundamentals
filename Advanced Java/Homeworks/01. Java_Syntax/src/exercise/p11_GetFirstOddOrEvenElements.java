package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p11_GetFirstOddOrEvenElements {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] numbersAsString = console.nextLine().split(" ");
        String[] command = console.nextLine().split(" ");

        int[] numbers = new int[numbersAsString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }
        int numberOfElements = Integer.parseInt(command[1]);
        String oddOrEven = command[2];

        List<Integer> output = elementsOddOrEven(numbers, numberOfElements, oddOrEven);
        for (int item : output) {
            System.out.print(item + " ");
        }
    }
    private static List<Integer> elementsOddOrEven(int[] num, int numberOfElements, String oddOrEven){
        List<Integer> outputNumbers = new ArrayList<>();

        for (int i = 0; i < num.length; i++) {
            if (numberOfElements == 0){
                break;
            } else if (num[i] % 2 != 0 && oddOrEven.equals("odd")){
                outputNumbers.add(num[i]);
                numberOfElements --;
            } else if ((num[i] % 2 == 0 && oddOrEven.equals("even"))){
                outputNumbers.add(num[i]);
                numberOfElements --;
            }
        }
        return outputNumbers;
    }
}
