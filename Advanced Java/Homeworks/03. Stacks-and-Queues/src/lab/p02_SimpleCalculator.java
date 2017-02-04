package lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p02_SimpleCalculator {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, input);
        while (stack.size() > 1){
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if (operator.equals("+")){
                stack.push(String.valueOf(firstNum + secondNum));
            }else {
                stack.push(String.valueOf(firstNum - secondNum));
            }
        }

        System.out.println(stack.peek());
    }
}
