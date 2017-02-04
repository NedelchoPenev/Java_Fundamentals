package exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class p4_BasicQueueOperations {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        Queue<Integer> numbers = new ArrayDeque<>();

        int elements = console.nextInt();
        int pop = console.nextInt();
        int num = console.nextInt();
        console.nextLine();

        for (int i = 0; i < elements; i++) {
            numbers.add(console.nextInt());
        }

        for (int i = 0; i < pop; i++) {
            numbers.poll();
        }

        if (numbers.size() == 0){
            System.out.println("0");
        } else if (numbers.contains(num)){
            System.out.println("true");
        } else{
            System.out.println(Collections.min(numbers));
        }
    }
}

