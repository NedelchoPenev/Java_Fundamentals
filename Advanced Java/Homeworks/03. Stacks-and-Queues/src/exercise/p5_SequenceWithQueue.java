package exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p5_SequenceWithQueue {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        ArrayDeque<Long> numbers = new ArrayDeque<>();

        long num = console.nextLong();
        numbers.add(num);

        for (int i = 0; i < 50; i++) {
            long current = numbers.remove();

            System.out.printf("%d ", current);

            long s1 = current + 1;
            long s2 = 2 * current + 1;
            long s3 = current + 2;

            numbers.add(s1);
            numbers.add(s2);
            numbers.add(s3);
        }
    }
}

