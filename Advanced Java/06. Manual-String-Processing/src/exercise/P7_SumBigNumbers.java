package exercise;

import java.util.Scanner;

public class P7_SumBigNumbers {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String firstNum = console.nextLine();
        String secondNum = console.nextLine();
        StringBuilder result = new StringBuilder();
        String longest = "";
        String shortest = "";

        if (firstNum.length() > secondNum.length()) {
            longest = firstNum;
            shortest = secondNum;
        } else {
            longest = secondNum;
            shortest = firstNum;
        }

        int difference = Math.abs(firstNum.length() - secondNum.length());
        int remainder = 0;
        for (int i = shortest.length() - 1; i >= 0; i--) {
            String fNum = String.valueOf((longest.charAt(i + difference)));
            String sNum = String.valueOf((shortest.charAt(i)));
            int addition = Integer.parseInt(fNum) + Integer.parseInt(sNum) + remainder;
            String numToApp = Integer.toString(addition);
            if (numToApp.length() > 1) {
                remainder = Integer.parseInt(String.valueOf(numToApp.charAt(0)));
                result.append(numToApp.charAt(1));
            } else {
                remainder = 0;
                result.append(numToApp);
            }
        }

        for (int i = difference - 1; i >= 0; i--) {
            String num = String.valueOf((longest.charAt(i)));
            int lastRemainder = Integer.parseInt(num) + remainder;
            String numToApp = Integer.toString(lastRemainder);
            if (numToApp.length() > 1) {
                remainder = Integer.parseInt(String.valueOf(numToApp.charAt(0)));
                result.append(numToApp.charAt(1));
            } else {
                remainder = 0;
                result.append(numToApp);
            }
        }

        if (remainder != 0){
            result.append(Integer.toString(remainder));
        }

        result.reverse();
        while (result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }
        System.out.println(result);
    }
}
