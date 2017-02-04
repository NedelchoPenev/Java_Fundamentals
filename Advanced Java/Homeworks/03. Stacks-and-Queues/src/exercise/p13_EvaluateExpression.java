package exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p13_EvaluateExpression {
    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String infix = console.nextLine();
        String postfix = infixToPostfix(infix);
        System.out.printf("%.2f", evaluateExpression(postfix));
    }

    private static double evaluateExpression(String postfix) {
        Deque<Double> stack = new ArrayDeque<>();

        final String operators = "-+/*^";
        for (String token : postfix.split("\\s+")) {
            if (isNumber(token)) {
                stack.push(Double.valueOf(token));
            } else if (operators.contains(token)) {
                Double second = stack.pop();
                Double first = stack.pop();
                Double result = 0d;
                switch (token) {
                    case "+":
                        result = first + second;
                        break;

                    case "-":
                        result = first - second;
                        break;

                    case "*":
                        result = first * second;
                        break;

                    case "/":
                        result = first / second;
                        break;
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }

    static String infixToPostfix(String infix) {
        final String ops = "-+/*^";
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> s = new ArrayDeque<>();

        for (String token : infix.split("\\s")) {
            if (token.isEmpty()) {
                continue;
            }
            char c = token.charAt(0);
            int idx = ops.indexOf(c);

            if (idx != -1) {
                if (s.isEmpty()) {
                    s.push(idx);
                } else {
                    while (!s.isEmpty()) {
                        int prec2 = s.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^'))
                            sb.append(ops.charAt(s.pop())).append(' ');
                        else break;
                    }
                    s.push(idx);
                }
            } else if (c == '(') {
                s.push(-2);
            } else if (c == ')') {
                while (s.peek() != -2)
                    sb.append(ops.charAt(s.pop())).append(' ');
                s.pop();
            } else {
                sb.append(token).append(' ');
            }
        }
        while (!s.isEmpty()) {
            sb.append(ops.charAt(s.pop())).append(' ');
        }
        return sb.toString();
    }

    private static boolean isNumber(String token) {
        String operators = "-+/*^";
        return !operators.contains(token) && !(token.equals("(") || token.equals(")"));
    }
}
