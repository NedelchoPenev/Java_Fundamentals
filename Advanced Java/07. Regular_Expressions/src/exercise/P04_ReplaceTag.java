package exercise;

import java.util.Scanner;

public class P04_ReplaceTag {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true){
            String input = console.nextLine();
            if (input.equals("end")){
                break;
            }

            input = input.replaceAll("<a ", "[URL ");
            input = input.replaceAll("</a>", "[/URL]");
            sb.append(input);
        }

        System.out.println(sb);
    }
}
