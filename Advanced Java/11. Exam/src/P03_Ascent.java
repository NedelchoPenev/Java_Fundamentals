import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_Ascent {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String regex = "(,|_)([A-Za-z]+)([0-9])";
        Pattern pattern = Pattern.compile(regex);
        LinkedHashMap<String, String> memorized = new LinkedHashMap<>();
        while (true) {
            String input = console.readLine();
            if ("Ascend".equals(input)) {
                break;
            }

            for (String s : memorized.keySet()) {
                if (input.contains(s)){
                    input = input.replace(s, memorized.get(s));
                }
            }

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                String toReplace = matcher.group(0);
                String operation = matcher.group(1);
                String text = matcher.group(2);
                int operand = Integer.parseInt(matcher.group(3));

                String decoded = getDecodedText(operation, text, operand);

                input = input.replaceAll(toReplace, decoded);
                memorized.put(toReplace, decoded);
            }

            System.out.println(input);
        }
    }

    private static String getDecodedText(String operation, String text, int operand) {
        String decoded = "";
        switch (operation){
            case ",":
                for (int i = 0; i < text.length(); i++) {
                    char letter = (char) (text.charAt(i) + operand);
                    decoded +=(letter);
                }
                break;
            case "_":
                for (int i = 0; i < text.length(); i++) {
                    char letter = (char) (text.charAt(i) - operand);
                    decoded += (letter);
                }

                break;
        }
        return decoded;
    }
}