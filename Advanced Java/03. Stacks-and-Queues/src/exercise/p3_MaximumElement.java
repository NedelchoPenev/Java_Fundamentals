package exercise;

import java.util.*;

public class p3_MaximumElement {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        List<Integer> biggest = new ArrayList<>();
        biggest.add(0);

        int lines = console.nextInt();
        console.nextLine();
        for (int i = 0; i < lines; i++) {
            String[] input = console.nextLine().split(" ");
            switch (input[0]){
                case "1":
                    int num = Integer.parseInt(input[1]);
                    stack.push(num);
                    if (num > Collections.max(biggest)){
                        biggest.add(num);
                    }
                    break;
                case "2":
                    Collections.sort(biggest);
                    int size = biggest.size() - 1;
                    if (stack.peek() == biggest.get(size) && stack.size() > 0){
                        biggest.remove(size);
                    }
                    stack.pop();
                    break;
                case "3":
                    Collections.sort(biggest);
                    int sizew = biggest.size() - 1;
                    System.out.println(biggest.get(sizew));
                    break;
            }
        }
    }
}

