package exercise;

import java.util.Scanner;

public class p13_ToTheStarsTests {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);

        String[] galaxies = new String[3];
        for (int i = 0; i < 3; i++) {
            galaxies[i] = console.nextLine();
        }

        String[] size = console.nextLine().split("\\s+");
        float cols = Float.parseFloat(size[0]);
        float rows = Float.parseFloat(size[1]);
        int moves = Integer.parseInt(console.nextLine());

        for (int i = 0; i <= moves; i++) {
            boolean inTheRange = false;
            for (String galaxy : galaxies) {
                String[]line = galaxy.split("\\s+");
                String galaxyName = line[0].toLowerCase();
                float galCol = Float.parseFloat(line[1]);
                float galRow = Float.parseFloat(line[2]);
                if ((rows <= galRow + 1 && rows >= galRow - 1) &&
                        (cols <= galCol + 1 && cols >= galCol - 1)){
                    System.out.println(galaxyName);
                    inTheRange = true;
                }
            }
            rows++;
            if (!inTheRange){
                System.out.println("space");
            }
        }
    }
}
