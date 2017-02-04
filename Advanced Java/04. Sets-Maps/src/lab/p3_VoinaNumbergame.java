package lab;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class p3_VoinaNumbergame {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayer = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondPlayer = new LinkedHashSet<>();

        for (int i = 0; i < 20; i++) {
            int number = console.nextInt();
            firstPlayer.add(number);
        }
        console.nextLine();
        for (int i = 0; i < 20; i++) {
            int number = console.nextInt();
            secondPlayer.add(number);
        }

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()){
                break;
            }
            Iterator<Integer> itFirst = firstPlayer.iterator();
            int firstPlayerNumber = itFirst.next();
            firstPlayer.remove(firstPlayerNumber);
            Iterator<Integer> itSecond = secondPlayer.iterator();
            int secondPlayerNumber = itSecond.next();
            secondPlayer.remove(secondPlayerNumber);

            if (firstPlayerNumber > secondPlayerNumber){
                firstPlayer.add(firstPlayerNumber);
                firstPlayer.add(secondPlayerNumber);
            } else if (firstPlayerNumber < secondPlayerNumber){
                secondPlayer.add(firstPlayerNumber);
                secondPlayer.add(secondPlayerNumber);
            }
        }

        if (firstPlayer.size() < secondPlayer.size()){
            System.out.println("Second player win!");
        }else if (secondPlayer.size() < firstPlayer.size()){
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
