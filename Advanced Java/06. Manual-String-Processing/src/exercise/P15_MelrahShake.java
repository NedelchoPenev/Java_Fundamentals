package exercise;

import java.util.Scanner;

public class P15_MelrahShake {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        String sentence = console.nextLine();
        String shaker = console.nextLine();

        while (true){
            if (shaker.length() == 0){
                System.out.println("No shake.");
                break;
            }

            int first = sentence.indexOf(shaker);
            int last = sentence.lastIndexOf(shaker);

            if (first != last){
                sentence = sentence.substring(0, first)
                        + sentence.substring(first + shaker.length(), last)
                        + sentence.substring(last+ shaker.length());
                System.out.println("Shaked it.");
            } else {
                System.out.println("No shake.");
                break;
            }

            int indexToRemove = shaker.length() / 2;
            shaker = shaker.substring(0, indexToRemove) + shaker.substring(indexToRemove + 1);
        }

        System.out.println(sentence);
    }
}
