package exercise;

import java.util.Scanner;
import java.util.Stack;

public class p1_ReverseNumbersWithAStack {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        Stack<Integer> numbers = new Stack<>();

        String[] input = console.nextLine().split(" ");
        for (String num : input) {
            numbers.add(Integer.parseInt(num));
        }

        while (numbers.size() > 0){
            System.out.print(numbers.pop()+ " ");
        }
    }
}
