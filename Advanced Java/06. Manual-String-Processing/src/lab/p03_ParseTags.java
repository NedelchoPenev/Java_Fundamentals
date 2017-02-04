package lab;

import java.util.Scanner;

public class p03_ParseTags {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        String upcase = "<upcase>";
        String upcaseClose = "</upcase>";

        while (input.contains(upcase)){
            int indexOpen = input.indexOf(upcase);
            int indexClose = input.indexOf(upcaseClose);

            String reminder = input.substring(indexOpen + 8, indexClose);
            String reminderUp = reminder.toUpperCase();
            input = input.replaceFirst(reminder, reminderUp);
            input = input.replaceFirst(upcase, "");
            input = input.replaceFirst(upcaseClose, "");

        }
        System.out.println(input);
    }
}
