package exercise;

import java.util.Scanner;
import java.util.Stack;

public class p2_BasicStackOperations {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        Stack<Integer> numbers = new Stack<>();

        int elements = console.nextInt();
        int pop = console.nextInt();
        int num = console.nextInt();
        console.nextLine();

        for (int i = 0; i < elements; i++) {
            numbers.push(console.nextInt());
        }
        for (int i = 0; i < pop; i++) {
            numbers.pop();
        }
        int smallest = Integer.MAX_VALUE;
        boolean present = false;
        for (Integer number : numbers) {
            if (number == num){
                present = true;
            } else {
                if (smallest > number){
                    smallest = number;
                }
            }
        }
        if (numbers.size() == 0){
            System.out.println("0");
        }else if (present){
            System.out.println("true");
        } else{
            System.out.println(smallest);
        }
    }
}

