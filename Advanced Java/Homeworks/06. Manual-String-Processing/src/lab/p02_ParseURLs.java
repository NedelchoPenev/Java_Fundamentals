package lab;

import java.util.Scanner;

public class p02_ParseURLs {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String[] input = console.nextLine().split("://");

        if (input.length != 2){
            System.out.println("Invalid URL");
        } else {
            System.out.println("Protocol = " + input[0]);
            int index = input[1].indexOf("/");
            String server = input[1].substring(0, index);
            System.out.println("Server = " + server);
            String resources = input[1].substring(index + 1);
            System.out.println("Resources = " + resources);
        }
    }
}
