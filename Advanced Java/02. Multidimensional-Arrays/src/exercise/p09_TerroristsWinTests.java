package exercise;

import java.util.Scanner;

public class p09_TerroristsWinTests {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        StringBuilder input =  new StringBuilder(console.nextLine());

        int currentIndex = 0,
            bombStartIndex,
            bombEndIndex;

        while (true){
            bombStartIndex = input.indexOf("|", currentIndex);
            bombEndIndex = input.indexOf("|", bombStartIndex + 1);
            if (bombStartIndex == -1){
                break;
            }
            String bombContent = input.substring(bombStartIndex + 1, bombEndIndex);

            int bombPower = getBombPower(bombContent),
                startIndex = Math.max(0, bombStartIndex - bombPower),
                endIndex = Math.min(input.length() - 1, bombEndIndex + bombPower);

            while (startIndex <= endIndex){
                input.setCharAt(startIndex, '.');
                startIndex++;
            }

            currentIndex = bombEndIndex + 1;
        }

        System.out.println(input);
    }

    private static int getBombPower(String bombContent) {
        int bombPower = 0;
        for (char c : bombContent.toCharArray()) {
            bombPower += c;
        }

        return bombPower % 10;
    }
}
