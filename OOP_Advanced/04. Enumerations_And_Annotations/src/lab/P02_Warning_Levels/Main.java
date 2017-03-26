package lab.P02_Warning_Levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String importance = console.readLine();
        Logger logger = new Logger(Importance.valueOf(importance));

        while (true) {
            String[] input = console.readLine().split(": ");
            if ("END".equals(input[0])) {
                break;
            }

            String importanceLevel = input[0];
            String content = input[1];
            Message message = new Message(Importance.valueOf(importanceLevel), content);
            logger.log(message);
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}
