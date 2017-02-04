package lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p04_MatchingBrackets {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String input = console.nextLine();

        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                indexes.push(i);
            } else if(input.charAt(i) == ')'){
                int index = indexes.pop();
                System.out.println(input.substring(index, i + 1));
            }
        }
    }
}
