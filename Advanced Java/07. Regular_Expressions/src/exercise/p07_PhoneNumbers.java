package exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p07_PhoneNumbers {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String regex = "([A-Z][a-zA-Z]*)[^a-zA-Z\\+]*?(?=\\+|\\d{2})([\\d\\+]{0,1}[\\d][\\d\\/(). -]*\\d)";
        Pattern pattern = Pattern.compile(regex);

        StringBuilder output = new StringBuilder("<ol>");
        String input = "";
        while (true) {
            String text = console.nextLine();
            if ("END".equals(text)) {
                break;
            }

            input += text;
        }

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            String name = String.format("<li><b>%s:</b> ", matcher.group(1));
            String number = "";
            for (int i = 0; i < matcher.group(2).length(); i++) {
                String num = matcher.group(2);
                if (Character.isDigit(num.charAt(i)) || num.charAt(i) == '+'){
                    number += num.charAt(i);
                }
            }

            number += "</li>";
            output.append(name).append(number);
        }

        if (output.length() < 5){
            System.out.println("<p>No matches!</p>");
        } else {
            output.append("</ol>");
            System.out.println(output.toString());
        }
    }
}
