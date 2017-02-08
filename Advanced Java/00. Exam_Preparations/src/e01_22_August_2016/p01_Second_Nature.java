package e01_22_August_2016;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class p01_Second_Nature {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String[] flowersStr = console.nextLine().split("\\s+");
        String[] bucketsStr = console.nextLine().split("\\s+");

        ArrayDeque<Integer> flowers = new ArrayDeque<>();
        ArrayDeque<Integer> buckets = new ArrayDeque<>();

        for (int i = 0; i < flowersStr.length; i++) {
            flowers.offer(Integer.parseInt(flowersStr[i]));
        }

        for (int i = 0; i < bucketsStr.length; i++) {
            buckets.push(Integer.parseInt(bucketsStr[i]));
        }

        ArrayList<Integer> secondNature = new ArrayList<>();

        int remainder = 0;
        while (flowers.size() > 0 && buckets.size() > 0){
            int flower = flowers.poll();
            int bucket = buckets.pop();

            if (flower > bucket){
                remainder = flower - bucket;
                flowers.push(remainder);
            }else if (flower < bucket){
                remainder = bucket - flower;
                if (buckets.size() == 0){
                    buckets.push(remainder);
                } else {
                    int reFullBucket = buckets.pop() + remainder;
                    buckets.push(reFullBucket);
                }
            }else {
                secondNature.add(flower);
            }
        }

        if (flowers.size() > 0){
            while (flowers.size() != 0){
                System.out.printf("%s ", flowers.poll());
            }
            System.out.println();
        } else {
            while (buckets.size() != 0){
                System.out.printf("%s ", buckets.pop());
            }
            System.out.println();
        }

        if (secondNature.size() > 0){
            for (Integer secNatFlowers : secondNature) {
                System.out.printf("%s ", secNatFlowers);
            }
        } else {
            System.out.println("None");
        }
    }
}
