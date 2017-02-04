package exercise;

import java.util.Scanner;
import java.util.Stack;

public class p8_BalancedParentheses {

    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        char[] parenthesis = console.nextLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean isBalanced = false;
        if (parenthesis.length % 2 != 0){
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < parenthesis.length; i++) {
            stack.push(parenthesis[i]);
            int stackChar = stack.peek();

            if (stackChar == 41) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                if (pop2 == pop1 - 1) {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            } else if (stackChar == 93 || stackChar == 125){
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                if (pop2 == pop1 - 2) {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}

