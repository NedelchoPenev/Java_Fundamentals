package exercise;

import java.util.Scanner;
import java.util.Stack;

public class p11_SimpleTextEditor {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int num = Integer.parseInt(console.nextLine());
        Stack<StringBuilder> stack = new Stack<>();

        for (int i = 0; i < num; i++) {
            String input = console.nextLine();
            String[] line = input.split("\\s+");
            String command = line[0];
            switch (command) {
                case "1":
                    StringBuilder text;
                    if (stack.size() > 0) {
                        text = new StringBuilder(stack.peek().toString());
                    } else {
                        text = new StringBuilder();
                    }
                    text.append(line[1]);
                    stack.push(text);
                    break;
                case "2":
                    String currentText = stack.peek().toString();
                    StringBuilder newText = new StringBuilder(currentText);
                    int erase = currentText.length() - Integer.parseInt(line[1]);
                    newText.delete(erase, currentText.length());
                    stack.push(newText);
                    break;
                case "3":
                    String textPrint = stack.peek().toString();
                    System.out.println(textPrint.charAt(Integer.parseInt(line[1]) - 1));
                    break;
                case "4":
                    stack.pop();
                    break;
            }
        }
    }
}

